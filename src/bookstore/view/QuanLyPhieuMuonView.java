package bookstore.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import bookstore.controller.PhieuMuonController;
import bookstore.model.PhieuMuonModel;

public class QuanLyPhieuMuonView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMaMuon;
    private JTextField txtMaDK;
    private JFormattedTextField txtNgayMuon;
    private JTextField txtNgayHetHan;
    private JTable table;
    private DefaultTableModel tableModel;
    private PhieuMuonController phieuMuonController;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QuanLyPhieuMuonView frame = new QuanLyPhieuMuonView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public QuanLyPhieuMuonView() {
        phieuMuonController = new PhieuMuonController();

        setTitle("Quản Lý Phiếu Mượn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        // Tiêu đề "Quản lý phiếu mượn"
        JLabel lblTitle = new JLabel("Quản Lý Phiếu Mượn", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        // Panel chứa các trường nhập liệu
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));
        contentPane.add(formPanel, BorderLayout.WEST);

        // Mã mượn
        JLabel lblMaMuon = new JLabel("Mã Mượn:");
        formPanel.add(lblMaMuon);
        txtMaMuon = new JTextField();
        txtMaMuon.setEditable(false);
        formPanel.add(txtMaMuon);

        // Mã đăng ký
        JLabel lblMaDK = new JLabel("Mã Đăng Ký:");
        formPanel.add(lblMaDK);
        txtMaDK = new JTextField();
        formPanel.add(txtMaDK);

        // Ngày mượn
        JLabel lblNgayMuon = new JLabel("Ngày Mượn:");
        formPanel.add(lblNgayMuon);
        txtNgayMuon = new JFormattedTextField();
        formPanel.add(txtNgayMuon);

        // Ngày hết hạn (không tác động)
        JLabel lblNgayHetHan = new JLabel("Ngày Hết Hạn:");
        formPanel.add(lblNgayHetHan);
        txtNgayHetHan = new JTextField();
        txtNgayHetHan.setEditable(false);
        formPanel.add(txtNgayHetHan);

        // Nút Thêm, Sửa, Xóa và Hiển Thị
        JButton btnThem = new JButton("Thêm");
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPhieuMuon();
            }
        });
        formPanel.add(btnThem);

        JButton btnSua = new JButton("Sửa");
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePhieuMuon();
            }
        });
        formPanel.add(btnSua);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePhieuMuon();
            }
        });
        formPanel.add(btnXoa);

        JButton btnHienThi = new JButton("Hiển Thị");
        btnHienThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllPhieuMuon();
            }
        });
        formPanel.add(btnHienThi);

        // Bảng hiển thị danh sách phiếu mượn
        tableModel = new DefaultTableModel(new Object[]{"Mã Mượn", "Mã Đăng Ký", "Ngày Mượn", "Ngày Hết Hạn"}, 0);
        table = new JTable(tableModel);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displaySelectedRow();
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        displayAllPhieuMuon();
    }

    private void addPhieuMuon() {
        int maDK = Integer.parseInt(txtMaDK.getText());
        Date ngayMuon = Date.valueOf(txtNgayMuon.getText());

        phieuMuonController.registerPhieuMuon(maDK, ngayMuon);
        txtNgayHetHan.setText(calculateExpiryDate(ngayMuon).toString());
        displayAllPhieuMuon();
    }

    private void updatePhieuMuon() {
        int maMuon = Integer.parseInt(txtMaMuon.getText());
        int maDK = Integer.parseInt(txtMaDK.getText());
        Date ngayMuon = Date.valueOf(txtNgayMuon.getText());

        phieuMuonController.updatePhieuMuon(maMuon, maDK, ngayMuon);
        txtNgayHetHan.setText(calculateExpiryDate(ngayMuon).toString());
        displayAllPhieuMuon();
    }

    private void deletePhieuMuon() {
        int maMuon = Integer.parseInt(txtMaMuon.getText());
        phieuMuonController.deletePhieuMuon(maMuon);
        displayAllPhieuMuon();
    }

    private void displayAllPhieuMuon() {
        try {
            List<PhieuMuonModel> phieuMuonList = phieuMuonController.getAllPhieuMuon();
            tableModel.setRowCount(0); // Clear existing rows
            for (PhieuMuonModel phieuMuon : phieuMuonList) {
                tableModel.addRow(new Object[]{
                        phieuMuon.getMaMuon(),
                        phieuMuon.getMaDK(),
                        phieuMuon.getNgayMuon(),
                        phieuMuon.getNgayHetHan()
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra trong quá trình hiển thị danh sách phiếu mượn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displaySelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            txtMaMuon.setText(tableModel.getValueAt(selectedRow, 0).toString());
            txtMaDK.setText(tableModel.getValueAt(selectedRow, 1).toString());
            txtNgayMuon.setText(tableModel.getValueAt(selectedRow, 2).toString());
            txtNgayHetHan.setText(tableModel.getValueAt(selectedRow, 3).toString());
        }
    }

    private Date calculateExpiryDate(Date ngayMuon) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ngayMuon);
        calendar.add(Calendar.DAY_OF_YEAR, 14); // Thêm 2 tuần
        return new Date(calendar.getTimeInMillis());
    }
}
