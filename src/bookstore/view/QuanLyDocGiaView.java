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
        EventQueue.invokeLater(() -> {
            try {
                QuanLyDocGiaView frame = new QuanLyDocGiaView();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public QuanLyDocGiaView() {
        docGiaController = new DocGiaController();

        setTitle("Quản Lý Độc Giả");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        // Menu bar
        MenuBarAdmin menuBarAdmin = new MenuBarAdmin();
        setJMenuBar(menuBarAdmin);

        // Title
        JLabel lblTitle = new JLabel("Quản Lý Độc Giả", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(new Color(0, 102, 204));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        contentPane.add(mainPanel, BorderLayout.CENTER);

        // Form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(8, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Thông Tin Độc Giả"));
        mainPanel.add(formPanel, BorderLayout.WEST);

        // Labels and text fields
        formPanel.add(new JLabel("Mã Độc Giả:"));
        txtMaDG = new JTextField();
        txtMaDG.setEditable(false);
        formPanel.add(txtMaDG);

        formPanel.add(new JLabel("Tên Độc Giả:"));
        txtTenDocGia = new JTextField();
        formPanel.add(txtTenDocGia);

        formPanel.add(new JLabel("Ngày Sinh:"));
        txtNgaySinh = new JFormattedTextField();
        formPanel.add(txtNgaySinh);

        formPanel.add(new JLabel("Số Điện Thoại:"));
        txtSoDienThoai = new JTextField();
        formPanel.add(txtSoDienThoai);

        formPanel.add(new JLabel("Địa Chỉ:"));
        txtDiaChi = new JTextField();
        formPanel.add(txtDiaChi);

        formPanel.add(new JLabel("Mã Thẻ:"));
        txtMaThe = new JTextField();
        formPanel.add(txtMaThe);

        formPanel.add(new JLabel("Ngày Hết Hạn:"));
        txtNgayHetHan = new JFormattedTextField();
        formPanel.add(txtNgayHetHan);

        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4, 10, 10));

        JButton btnThem = new JButton("Thêm");
        btnThem.setBackground(new Color(102, 204, 255));
        btnThem.addActionListener(e -> addDocGia());
        buttonPanel.add(btnThem);

        JButton btnSua = new JButton("Sửa");
        btnSua.setBackground(new Color(102, 255, 153));
        btnSua.addActionListener(e -> updateDocGia());
        buttonPanel.add(btnSua);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.setBackground(new Color(255, 102, 102));
        btnXoa.addActionListener(e -> deleteDocGia());
        buttonPanel.add(btnXoa);

        JButton btnHienThi = new JButton("Hiển Thị");
        btnHienThi.setBackground(new Color(204, 204, 204));
        btnHienThi.addActionListener(e -> displayAllDocGia());
        buttonPanel.add(btnHienThi);

        formPanel.add(new JLabel());
        formPanel.add(buttonPanel);

        // Table panel
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout(10, 10));
        tablePanel.setBorder(BorderFactory.createTitledBorder("Danh Sách Độc Giả"));
        mainPanel.add(tablePanel, BorderLayout.CENTER);

        tableModel = new DefaultTableModel(
                new Object[]{"Mã ĐG", "Tên Độc Giả", "Ngày Sinh", "Địa Chỉ", "Số ĐT", "Mã Thẻ", "Ngày Hết Hạn"}, 0);
        table = new JTable(tableModel);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displaySelectedRow();
            }
        });
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

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
            tableModel.setRowCount(0);
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
