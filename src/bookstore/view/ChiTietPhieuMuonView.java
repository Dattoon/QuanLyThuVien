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
import bookstore.controller.ChiTietPhieuMuonController;
import bookstore.model.ChiTietPhieuMuonModel;

public class ChiTietPhieuMuonView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMaChiTiet;
    private JTextField txtMaMuon;
    private JTextField txtMaSach;
    private JFormattedTextField txtNgayTra;
    private JTable table;
    private DefaultTableModel tableModel;
    private ChiTietPhieuMuonController chiTietPhieuMuonController;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChiTietPhieuMuonView frame = new ChiTietPhieuMuonView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ChiTietPhieuMuonView() {
        chiTietPhieuMuonController = new ChiTietPhieuMuonController();

        setTitle("Quản Lý Chi Tiết Phiếu Mượn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        // Tiêu đề "Quản lý chi tiết phiếu mượn"
        JLabel lblTitle = new JLabel("Quản Lý Chi Tiết Phiếu Mượn", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        // Panel chứa các trường nhập liệu
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));
        contentPane.add(formPanel, BorderLayout.WEST);

        // Mã chi tiết
        JLabel lblMaChiTiet = new JLabel("Mã Chi Tiết:");
        formPanel.add(lblMaChiTiet);
        txtMaChiTiet = new JTextField();
        txtMaChiTiet.setEditable(false);
        formPanel.add(txtMaChiTiet);

        // Mã mượn
        JLabel lblMaMuon = new JLabel("Mã Mượn:");
        formPanel.add(lblMaMuon);
        txtMaMuon = new JTextField();
        formPanel.add(txtMaMuon);

        // Mã sách
        JLabel lblMaSach = new JLabel("Mã Sách:");
        formPanel.add(lblMaSach);
        txtMaSach = new JTextField();
        formPanel.add(txtMaSach);

        // Ngày trả
        JLabel lblNgayTra = new JLabel("Ngày Trả:");
        formPanel.add(lblNgayTra);
        txtNgayTra = new JFormattedTextField();
        formPanel.add(txtNgayTra);

        // Nút Thêm, Sửa, Xóa và Hiển Thị
        JButton btnThem = new JButton("Thêm");
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addChiTietPhieuMuon();
            }
        });
        formPanel.add(btnThem);

        JButton btnSua = new JButton("Sửa");
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateChiTietPhieuMuon();
            }
        });
        formPanel.add(btnSua);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteChiTietPhieuMuon();
            }
        });
        formPanel.add(btnXoa);

        JButton btnHienThi = new JButton("Hiển Thị");
        btnHienThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllChiTietPhieuMuon();
            }
        });
        formPanel.add(btnHienThi);

        // Bảng hiển thị danh sách chi tiết phiếu mượn
        tableModel = new DefaultTableModel(new Object[]{"Mã Chi Tiết", "Mã Mượn", "Mã Sách", "Ngày Trả"}, 0);
        table = new JTable(tableModel);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displaySelectedRow();
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        displayAllChiTietPhieuMuon();
    }

    private void addChiTietPhieuMuon() {
        int maMuon = Integer.parseInt(txtMaMuon.getText());
        int maSach = Integer.parseInt(txtMaSach.getText());
        Date ngayTra = Date.valueOf(txtNgayTra.getText());

        chiTietPhieuMuonController.registerChiTietPhieuMuon(maMuon, maSach, ngayTra);
        displayAllChiTietPhieuMuon();
    }

    private void updateChiTietPhieuMuon() {
        int maChiTiet = Integer.parseInt(txtMaChiTiet.getText());
        int maMuon = Integer.parseInt(txtMaMuon.getText());
        int maSach = Integer.parseInt(txtMaSach.getText());
        Date ngayTra = Date.valueOf(txtNgayTra.getText());

        chiTietPhieuMuonController.updateChiTietPhieuMuon(maChiTiet, maMuon, maSach, ngayTra);
        displayAllChiTietPhieuMuon();
    }

    private void deleteChiTietPhieuMuon() {
        int maChiTiet = Integer.parseInt(txtMaChiTiet.getText());
        chiTietPhieuMuonController.deleteChiTietPhieuMuon(maChiTiet);
        displayAllChiTietPhieuMuon();
    }

    private void displayAllChiTietPhieuMuon() {
        try {
            List<ChiTietPhieuMuonModel> chiTietPhieuMuonList = chiTietPhieuMuonController.getAllChiTietPhieuMuon();
            tableModel.setRowCount(0); // Clear existing rows
            for (ChiTietPhieuMuonModel chiTietPhieuMuon : chiTietPhieuMuonList) {
                tableModel.addRow(new Object[]{
                        chiTietPhieuMuon.getMaChiTiet(),
                        chiTietPhieuMuon.getMaMuon(),
                        chiTietPhieuMuon.getMaSach(),
                        chiTietPhieuMuon.getNgayTra()
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra trong quá trình hiển thị danh sách chi tiết phiếu mượn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displaySelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            txtMaChiTiet.setText(tableModel.getValueAt(selectedRow, 0).toString());
            txtMaMuon.setText(tableModel.getValueAt(selectedRow, 1).toString());
            txtMaSach.setText(tableModel.getValueAt(selectedRow, 2).toString());
            txtNgayTra.setText(tableModel.getValueAt(selectedRow, 3).toString());
        }
    }
}
