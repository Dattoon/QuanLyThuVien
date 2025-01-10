package bookstore.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import bookstore.controller.PhieuMuonController;
import bookstore.controller.PhieuDangKyController;

public class XacNhanMuonSachView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel tableModel;
    private PhieuMuonController phieuMuonController;
    private PhieuDangKyController phieuDangKyController;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    XacNhanMuonSachView frame = new XacNhanMuonSachView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public XacNhanMuonSachView() {
        phieuMuonController = new PhieuMuonController();
        phieuDangKyController = new PhieuDangKyController();

        setTitle("Xác Nhận Mượn Sách");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        // Tiêu đề "Xác Nhận Mượn Sách"
        JLabel lblTitle = new JLabel("Xác Nhận Mượn Sách", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        // Bảng hiển thị danh sách phiếu đăng ký
        tableModel = new DefaultTableModel(new Object[]{"Mã ĐK", "Mã Độc Giả", "Ngày Đăng Ký"}, 0);
        table = new JTable(tableModel);
        displayAllPhieuDangKy();

        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Nút Xác Nhận
        JButton btnXacNhan = new JButton("Xác Nhận");
        btnXacNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmPhieuMuon();
            }
        });
        contentPane.add(btnXacNhan, BorderLayout.SOUTH);
    }

    private void displayAllPhieuDangKy() {
        tableModel.setRowCount(0); // Clear existing rows
        phieuDangKyController.getAllPhieuDangKy().forEach(phieuDangKy -> {
            tableModel.addRow(new Object[]{
                phieuDangKy.getMaDK(),
                phieuDangKy.getMaDG(),
                phieuDangKy.getNgayDK()
            });
        });
    }

    private void confirmPhieuMuon() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int maDK = (int) tableModel.getValueAt(selectedRow, 0);
            phieuMuonController.createPhieuMuon(maDK);
            JOptionPane.showMessageDialog(this, "Xác nhận mượn sách thành công!");
            // Cập nhật lại danh sách phiếu đăng ký sau khi xác nhận
            displayAllPhieuDangKy();
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một phiếu đăng ký để xác nhận.");
        }
    }
}
