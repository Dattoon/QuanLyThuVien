package bookstore.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import bookstore.controller.DocGiaController;
import bookstore.model.DocGiaModel;
import bookstore.share.MenuBarAdmin;

public class QuanLyDocGiaView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMaDG;
    private JTextField txtTenDocGia;
    private JFormattedTextField txtNgaySinh;
    private JTextField txtSoDienThoai;
    private JTextField txtDiaChi;
    private JTextField txtMaThe;
    private JTextField txtNgayHetHan;
    private JTable table;
    private DefaultTableModel tableModel;
    private DocGiaController docGiaController;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QuanLyDocGiaView frame = new QuanLyDocGiaView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public QuanLyDocGiaView() {
        docGiaController = new DocGiaController();

        setTitle("Quản Lý Độc Giả");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);
        
     // Tích hợp MenuBarAdmin
     		MenuBarAdmin menuBarAdmin = new MenuBarAdmin();
     		setJMenuBar(menuBarAdmin);

        // Tiêu đề "Quản lý độc giả"
        JLabel lblTitle = new JLabel("Quản Lý Độc Giả", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        // Panel chứa các trường nhập liệu
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(8, 2, 10, 10));
        contentPane.add(formPanel, BorderLayout.WEST);

        // Mã độc giả
        JLabel lblMaDG = new JLabel("Mã Độc Giả:");
        formPanel.add(lblMaDG);
        txtMaDG = new JTextField();
        txtMaDG.setEditable(false);
        formPanel.add(txtMaDG);

        // Tên độc giả
        JLabel lblTenDocGia = new JLabel("Tên Độc Giả:");
        formPanel.add(lblTenDocGia);
        txtTenDocGia = new JTextField();
        formPanel.add(txtTenDocGia);

        // Ngày sinh
        JLabel lblNgaySinh = new JLabel("Ngày Sinh:");
        formPanel.add(lblNgaySinh);
        txtNgaySinh = new JFormattedTextField();
        formPanel.add(txtNgaySinh);

        // Số điện thoại
        JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
        formPanel.add(lblSoDienThoai);
        txtSoDienThoai = new JTextField();
        formPanel.add(txtSoDienThoai);

        // Địa chỉ
        JLabel lblDiaChi = new JLabel("Địa Chỉ:");
        formPanel.add(lblDiaChi);
        txtDiaChi = new JTextField();
        formPanel.add(txtDiaChi);

        // Mã thẻ
        JLabel lblMaThe = new JLabel("Mã Thẻ:");
        formPanel.add(lblMaThe);
        txtMaThe = new JTextField();
        formPanel.add(txtMaThe);

        // Ngày hết hạn
        JLabel lblNgayHetHan = new JLabel("Ngày Hết Hạn:");
        formPanel.add(lblNgayHetHan);
        txtNgayHetHan = new JFormattedTextField();
        formPanel.add(txtNgayHetHan);

        // Nút Thêm, Sửa, Xóa, và Hiển Thị
        JButton btnThem = new JButton("Thêm");
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDocGia();
            }
        });
        formPanel.add(btnThem);

        JButton btnSua = new JButton("Sửa");
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDocGia();
            }
        });
        formPanel.add(btnSua);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteDocGia();
            }
        });
        formPanel.add(btnXoa);

        JButton btnHienThi = new JButton("Hiển Thị");
        btnHienThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllDocGia();
            }
        });
        formPanel.add(btnHienThi);

        // Bảng hiển thị danh sách độc giả
        tableModel = new DefaultTableModel(new Object[]{"Mã ĐG", "Tên Độc Giả", "Ngày Sinh", "Địa Chỉ", "Số ĐT", "Mã Thẻ", "Ngày Hết Hạn"}, 0);
        table = new JTable(tableModel);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displaySelectedRow();
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        displayAllDocGia();
    }

    private void addDocGia() {
        String ten = txtTenDocGia.getText();
        Date ngaySinh = Date.valueOf(txtNgaySinh.getText());
        String diaChi = txtDiaChi.getText();
        String dienThoai = txtSoDienThoai.getText();
        Date ngayHetHan = Date.valueOf(txtNgayHetHan.getText());

        docGiaController.registerDocGia(ten, ngaySinh, diaChi, dienThoai);
        displayAllDocGia();
    }

    private void updateDocGia() {
        int maDG = Integer.parseInt(txtMaDG.getText());
        String ten = txtTenDocGia.getText();
        Date ngaySinh = Date.valueOf(txtNgaySinh.getText());
        String diaChi = txtDiaChi.getText();
        String dienThoai = txtSoDienThoai.getText();
        String maThe = txtMaThe.getText();
        Date ngayHetHan = Date.valueOf(txtNgayHetHan.getText());

        docGiaController.updateDocGia(maDG, ten, ngaySinh, diaChi, dienThoai, maThe);
        displayAllDocGia();
    }

    private void deleteDocGia() {
        int maDG = Integer.parseInt(txtMaDG.getText());
        docGiaController.deleteDocGia(maDG);
        displayAllDocGia();
    }

    private void displayAllDocGia() {
        try {
            List<DocGiaModel> docGiaList = docGiaController.getAllDocGia();
            tableModel.setRowCount(0); // Clear existing rows
            for (DocGiaModel docGia : docGiaList) {
                tableModel.addRow(new Object[]{
                        docGia.getMaDG(),
                        docGia.getTenDG(),
                        docGia.getNgaySinh(),
                        docGia.getDiaChiDG(),
                        docGia.getDienThoai(),
                        docGia.getMaThe(),
                        docGia.getNgayHetHan()
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra trong quá trình hiển thị danh sách độc giả.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displaySelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            txtMaDG.setText(tableModel.getValueAt(selectedRow, 0).toString());
            txtTenDocGia.setText(tableModel.getValueAt(selectedRow, 1).toString());
            txtNgaySinh.setText(tableModel.getValueAt(selectedRow, 2).toString());
            txtDiaChi.setText(tableModel.getValueAt(selectedRow, 3).toString());
            txtSoDienThoai.setText(tableModel.getValueAt(selectedRow, 4).toString());
            txtMaThe.setText(tableModel.getValueAt(selectedRow, 5).toString());
            txtNgayHetHan.setText(tableModel.getValueAt(selectedRow, 6).toString());
        }
    }
}
