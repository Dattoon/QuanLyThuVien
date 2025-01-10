package bookstore.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import bookstore.controller.ChiTietPhieuMuonController;
import bookstore.model.ChiTietPhieuMuonModel;

public class TraSachView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;
    private ChiTietPhieuMuonController chiTietPhieuMuonController;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TraSachView frame = new TraSachView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TraSachView() {
        chiTietPhieuMuonController = new ChiTietPhieuMuonController();

        setTitle("Trả Sách");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        // Tiêu đề "Trả Sách"
        JLabel lblTitle = new JLabel("Trả Sách", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        // Bảng hiển thị danh sách chi tiết phiếu mượn
        tableModel = new DefaultTableModel(new Object[]{"Mã Chi Tiết", "Mã ĐK", "Mã Mượn", "Mã Sách", "Ngày Trả"}, 0);
        table = new JTable(tableModel);
        displayAllChiTietPhieuMuon();

        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Nút Cập Nhật Trả Sách
        JButton btnTraSach = new JButton("Cập Nhật Trả Sách");
        btnTraSach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTraSach();
            }
        });
        contentPane.add(btnTraSach, BorderLayout.SOUTH);
    }

    private void displayAllChiTietPhieuMuon() {
        tableModel.setRowCount(0); // Clear existing rows
        chiTietPhieuMuonController.getAllChiTietPhieuMuon().forEach(chiTietPhieuMuon -> {
            tableModel.addRow(new Object[]{
                chiTietPhieuMuon.getMaChiTiet(),
                chiTietPhieuMuon.getMaDK(),
                chiTietPhieuMuon.getMaMuon(),
                chiTietPhieuMuon.getMaSach(),
                chiTietPhieuMuon.getNgayTra()
            });
        });
    }

    private void updateTraSach() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int maChiTiet = (int) tableModel.getValueAt(selectedRow, 0);
            Date ngayTra = new Date(System.currentTimeMillis());
            ChiTietPhieuMuonModel chiTietPhieuMuon = chiTietPhieuMuonController.getChiTietPhieuMuonById(maChiTiet);
            chiTietPhieuMuon.setNgayTra(ngayTra);
            chiTietPhieuMuonController.updateChiTietPhieuMuon(
                    chiTietPhieuMuon.getMaChiTiet(),
                    chiTietPhieuMuon.getMaDK(),
                    chiTietPhieuMuon.getMaMuon(),
                    chiTietPhieuMuon.getMaSach(),
                    chiTietPhieuMuon.getNgayTra()
            );
            displayAllChiTietPhieuMuon();
            JOptionPane.showMessageDialog(this, "Cập nhật trả sách thành công!");
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sách để cập nhật trả sách.");
        }
    }
}
