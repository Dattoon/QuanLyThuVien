package bookstore.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import bookstore.controller.PhieuMuonController;

public class QuanLyPhieuMuonView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMaDK;
    private JTextField txtMaMuon;
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

        // Mã ĐK
        JLabel lblMaDK = new JLabel("Mã ĐK:");
        formPanel.add(lblMaDK);
        txtMaDK = new JTextField();
        formPanel.add(txtMaDK);

        // Mã mượn
        JLabel lblMaMuon = new JLabel("Mã Mượn:");
        formPanel.add(lblMaMuon);
        txtMaMuon = new JTextField();
        txtMaMuon.setEditable(false);
        formPanel.add(txtMaMuon);

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

        // Nút Thêm và Xóa
        JButton btnThem = new JButton("Thêm");
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPhieuMuon();
            }
        });
        formPanel.add(btnThem);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePhieuMuon();
            }
        });
        formPanel.add(btnXoa);

        // Bảng hiển thị danh sách phiếu mượn
        tableModel = new DefaultTableModel(new Object[]{"Mã Mượn", "Mã ĐK", "Ngày Mượn", "Ngày Hết Hạn"}, 0);
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

        phieuMuonController.createPhieuMuon(maDK);
        displayAllPhieuMuon();
    }

    private void deletePhieuMuon() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int maMuon = (int) tableModel.getValueAt(selectedRow, 0);
            phieuMuonController.deletePhieuMuon(maMuon);
            displayAllPhieuMuon();
        }
    }

    private void displayAllPhieuMuon() {
        tableModel.setRowCount(0); // Clear existing rows
        phieuMuonController.getAllPhieuMuon().forEach(phieuMuon -> {
            tableModel.addRow(new Object[]{
                phieuMuon.getMaMuon(),
                phieuMuon.getMaDK(),
                phieuMuon.getNgayMuon(),
                phieuMuon.getNgayHetHan()
            });
        });
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
}
