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
import bookstore.controller.PhieuDangKyController;
import bookstore.model.PhieuDangKyModel;

public class QuanLyPhieuDangKyView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMaDK;
    private JTextField txtMaDocGia;
    private JFormattedTextField txtNgayDK;
    private JTable table;
    private DefaultTableModel tableModel;
    private PhieuDangKyController phieuDangKyController;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QuanLyPhieuDangKyView frame = new QuanLyPhieuDangKyView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public QuanLyPhieuDangKyView() {
        phieuDangKyController = new PhieuDangKyController();

        setTitle("Quản Lý Phiếu Đăng Ký");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        // Tiêu đề "Quản lý phiếu đăng ký"
        JLabel lblTitle = new JLabel("Quản Lý Phiếu Đăng Ký", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        // Panel chứa các trường nhập liệu
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));
        contentPane.add(formPanel, BorderLayout.WEST);

        // Mã đăng ký
        JLabel lblMaDK = new JLabel("Mã Đăng Ký:");
        formPanel.add(lblMaDK);
        txtMaDK = new JTextField();
        txtMaDK.setEditable(false);
        formPanel.add(txtMaDK);

        // Mã độc giả
        JLabel lblMaDocGia = new JLabel("Mã Độc Giả:");
        formPanel.add(lblMaDocGia);
        txtMaDocGia = new JTextField();
        formPanel.add(txtMaDocGia);

        // Ngày đăng ký
        JLabel lblNgayDK = new JLabel("Ngày Đăng Ký:");
        formPanel.add(lblNgayDK);
        txtNgayDK = new JFormattedTextField();
        formPanel.add(txtNgayDK);

        // Nút Thêm, Sửa, Xóa và Hiển Thị
        JButton btnThem = new JButton("Thêm");
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPhieuDangKy();
            }
        });
        formPanel.add(btnThem);

        JButton btnSua = new JButton("Sửa");
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePhieuDangKy();
            }
        });
        formPanel.add(btnSua);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePhieuDangKy();
            }
        });
        formPanel.add(btnXoa);

        JButton btnHienThi = new JButton("Hiển Thị");
        btnHienThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllPhieuDangKy();
            }
        });
        formPanel.add(btnHienThi);

        // Bảng hiển thị danh sách phiếu đăng ký
        tableModel = new DefaultTableModel(new Object[]{"Mã ĐK", "Mã Độc Giả", "Ngày Đăng Ký"}, 0);
        table = new JTable(tableModel);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displaySelectedRow();
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        displayAllPhieuDangKy();
    }

    private void addPhieuDangKy() {
        int maDocGia = Integer.parseInt(txtMaDocGia.getText());
        Date ngayDK = Date.valueOf(txtNgayDK.getText());

        phieuDangKyController.registerPhieuDangKy(maDocGia, ngayDK);
        displayAllPhieuDangKy();
    }

    private void updatePhieuDangKy() {
        int maDK = Integer.parseInt(txtMaDK.getText());
        int maDocGia = Integer.parseInt(txtMaDocGia.getText());
        Date ngayDK = Date.valueOf(txtNgayDK.getText());

        phieuDangKyController.updatePhieuDangKy(maDK, maDocGia, ngayDK);
        displayAllPhieuDangKy();
    }

    private void deletePhieuDangKy() {
        int maDK = Integer.parseInt(txtMaDK.getText());
        phieuDangKyController.deletePhieuDangKy(maDK);
        displayAllPhieuDangKy();
    }

    private void displayAllPhieuDangKy() {
        try {
            List<PhieuDangKyModel> phieuDangKyList = phieuDangKyController.getAllPhieuDangKy();
            tableModel.setRowCount(0); // Clear existing rows
            for (PhieuDangKyModel phieuDangKy : phieuDangKyList) {
                tableModel.addRow(new Object[]{
                        phieuDangKy.getMaDK(),
                        phieuDangKy.getMaDG(),
                        phieuDangKy.getNgayDK()
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra trong quá trình hiển thị danh sách phiếu đăng ký.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displaySelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            txtMaDK.setText(tableModel.getValueAt(selectedRow, 0).toString());
            txtMaDocGia.setText(tableModel.getValueAt(selectedRow, 1).toString());
            txtNgayDK.setText(tableModel.getValueAt(selectedRow, 2).toString());
        }
    }
}
