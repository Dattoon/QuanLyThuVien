package bookstore.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import bookstore.controller.ChiTietPhieuMuonController;

public class QuanLyChiTietPhieuMuonView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMaChiTiet;
    private JTextField txtMaMuon;
    private JTextField txtMaSach;
    private JFormattedTextField txtNgayTra;
    private JTextField txtTienPhat;
    private JTable table;
    private DefaultTableModel tableModel;
    private ChiTietPhieuMuonController chiTietPhieuMuonController;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QuanLyChiTietPhieuMuonView frame = new QuanLyChiTietPhieuMuonView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public QuanLyChiTietPhieuMuonView() {
        chiTietPhieuMuonController = new ChiTietPhieuMuonController();

        setTitle("Quản Lý Chi Tiết Phiếu Mượn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 700);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        // Tiêu đề "Quản lý chi tiết phiếu mượn"
        JLabel lblTitle = new JLabel("Quản Lý Chi Tiết Phiếu Mượn", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitle.setForeground(new Color(0, 102, 204));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        // Panel chứa các trường nhập liệu
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(new TitledBorder("Thông tin chi tiết"));
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

        // Tiền phạt
        JLabel lblTienPhat = new JLabel("Tiền Phạt:");
        formPanel.add(lblTienPhat);
        txtTienPhat = new JTextField();
        formPanel.add(txtTienPhat);

        // Nút Thêm và Xóa
        JButton btnThem = new JButton("Thêm");
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addChiTietPhieuMuon();
            }
        });
        formPanel.add(btnThem);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteChiTietPhieuMuon();
            }
        });
        formPanel.add(btnXoa);

        // Bảng hiển thị danh sách chi tiết phiếu mượn
        tableModel = new DefaultTableModel(new Object[]{"Mã Chi Tiết", "Mã Mượn", "Mã Sách", "Ngày Trả", "Tiền Phạt"}, 0);
        table = new JTable(tableModel);
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        table.getTableHeader().setBackground(new Color(0, 102, 204));
        table.getTableHeader().setForeground(Color.WHITE);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displaySelectedRow();
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new TitledBorder("Danh sách chi tiết phiếu mượn"));
        contentPane.add(scrollPane, BorderLayout.CENTER);

        displayAllChiTietPhieuMuon();
    }

    private void addChiTietPhieuMuon() {
        int maMuon = Integer.parseInt(txtMaMuon.getText());
        int maSach = Integer.parseInt(txtMaSach.getText());
        Date ngayTra = Date.valueOf(txtNgayTra.getText());
        float tienPhat = Float.parseFloat(txtTienPhat.getText());

        chiTietPhieuMuonController.createChiTietPhieuMuon(maMuon, maSach, ngayTra, tienPhat);
        displayAllChiTietPhieuMuon();
    }

    private void deleteChiTietPhieuMuon() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int maChiTiet = (int) tableModel.getValueAt(selectedRow, 0);
            chiTietPhieuMuonController.deleteChiTietPhieuMuon(maChiTiet);
            displayAllChiTietPhieuMuon();
        }
    }

    private void displayAllChiTietPhieuMuon() {
        tableModel.setRowCount(0); // Clear existing rows
        chiTietPhieuMuonController.getAllChiTietPhieuMuon().forEach(chiTietPhieuMuon -> {
            tableModel.addRow(new Object[]{
                chiTietPhieuMuon.getMaChiTiet(),
                chiTietPhieuMuon.getMaMuon(),
                chiTietPhieuMuon.getMaSach(),
                chiTietPhieuMuon.getNgayTra(),
                chiTietPhieuMuon.getTienPhat()
            });
        });
    }

    private void displaySelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            txtMaChiTiet.setText(tableModel.getValueAt(selectedRow, 0).toString());
            txtMaMuon.setText(tableModel.getValueAt(selectedRow, 1).toString());
            txtMaSach.setText(tableModel.getValueAt(selectedRow, 2).toString());
            txtNgayTra.setText(tableModel.getValueAt(selectedRow, 3).toString());
            txtTienPhat.setText(tableModel.getValueAt(selectedRow, 4).toString());
        }
    }
}
