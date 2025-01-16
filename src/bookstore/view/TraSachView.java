package bookstore.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import bookstore.controller.PhieuMuonController;
import bookstore.model.PhieuMuonModel;

public class TraSachView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMaThe;
    private JTable table;
    private DefaultTableModel tableModel;
    private PhieuMuonController phieuMuonController;

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
        phieuMuonController = new PhieuMuonController();

        setTitle("Trả Sách");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        // Tiêu đề "Trả Sách"
        JLabel lblTitle = new JLabel("Trả Sách", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        // Panel chứa các trường nhập liệu
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 2, 10, 10));
        contentPane.add(formPanel, BorderLayout.WEST);

        // Mã Thẻ
        JLabel lblMaThe = new JLabel("Mã Thẻ:");
        formPanel.add(lblMaThe);
        txtMaThe = new JTextField();
        formPanel.add(txtMaThe);

        // Nút Hiển Thị
        JButton btnHienThi = new JButton("Hiển Thị");
        btnHienThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayBorrowedBooks();
            }
        });
        formPanel.add(btnHienThi);

        // Nút Trả Sách
        JButton btnTraSach = new JButton("Trả Sách");
        btnTraSach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnBook();
            }
        });
        formPanel.add(btnTraSach);

        // Bảng hiển thị danh sách sách mượn
        tableModel = new DefaultTableModel(new Object[]{"Tựa Sách", "Tên Độc Giả", "Ngày Mượn", "Ngày Hết Hạn","Mã Mượn", "Mã sách"}, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);
    }

    private void displayBorrowedBooks() {
        String maThe = txtMaThe.getText();
        List<PhieuMuonModel> borrowedBooks = phieuMuonController.getPhieuMuonByMaThe(maThe);
        
        tableModel.setRowCount(0); // Clear existing rows
        for (PhieuMuonModel phieuMuon : borrowedBooks) {
            tableModel.addRow(new Object[]{
                phieuMuon.getTuaSach(),
                phieuMuon.getTenDG(),
                phieuMuon.getNgayMuon(),
                phieuMuon.getNgayHetHan(),
                phieuMuon.getMaMuon(),
                phieuMuon.getMaSach(),
            });
        }
    }

    private void returnBook() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            int maMuon = (int) tableModel.getValueAt(selectedRow, 4); // Mã Mượn nằm ở cột thứ 5 (index 4)
            int maSach = (int) tableModel.getValueAt(selectedRow, 5); // Mã Sách nằm ở cột thứ 6 (index 5)
            phieuMuonController.returnBook(maMuon, maSach);

            displayBorrowedBooks();
        }
    }


}
