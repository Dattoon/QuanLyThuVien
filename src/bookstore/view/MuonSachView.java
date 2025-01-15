package bookstore.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import bookstore.controller.PhieuMuonController;

public class MuonSachView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMaThe;
    private JTextField txtMaSach;
    private JFormattedTextField txtNgayMuon;
    private PhieuMuonController phieuMuonController;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MuonSachView frame = new MuonSachView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MuonSachView() {
        phieuMuonController = new PhieuMuonController();

        setTitle("Mượn Sách");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        // Tiêu đề "Mượn Sách"
        JLabel lblTitle = new JLabel("Mượn Sách", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        // Panel chứa các trường nhập liệu
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 10, 10));
        contentPane.add(formPanel, BorderLayout.CENTER);

        // Mã Thẻ
        JLabel lblMaThe = new JLabel("Mã Thẻ:");
        formPanel.add(lblMaThe);
        txtMaThe = new JTextField();
        formPanel.add(txtMaThe);

        // Mã Sách
        JLabel lblMaSach = new JLabel("Mã Sách:");
        formPanel.add(lblMaSach);
        txtMaSach = new JTextField();
        formPanel.add(txtMaSach);

        // Ngày Mượn (mặc định là ngày hiện tại)
        JLabel lblNgayMuon = new JLabel("Ngày Mượn:");
        formPanel.add(lblNgayMuon);
        txtNgayMuon = new JFormattedTextField(Date.valueOf(LocalDate.now()));
        txtNgayMuon.setEditable(false);
        formPanel.add(txtNgayMuon);

        // Nút Mượn Sách
        JButton btnMuonSach = new JButton("Mượn Sách");
        btnMuonSach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                muonSach();
            }
        });
        contentPane.add(btnMuonSach, BorderLayout.SOUTH);
    }

    private void muonSach() {
        String maThe = txtMaThe.getText();
        int maSach = Integer.parseInt(txtMaSach.getText());
        
        // Lấy ngày hiện tại làm ngày mượn
        LocalDate today = LocalDate.now();
        Date ngayMuon = Date.valueOf(today);

        phieuMuonController.createPhieuMuon(maThe,	 maSach);
        JOptionPane.showMessageDialog(this, "Mượn sách thành công!");
    }

}
