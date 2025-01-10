package bookstore.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import bookstore.controller.PhieuDangKyController;

public class DangKyMuonSachView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMaThe;
    private JFormattedTextField txtNgayDK;
    private PhieuDangKyController phieuDangKyController;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DangKyMuonSachView frame = new DangKyMuonSachView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DangKyMuonSachView() {
        phieuDangKyController = new PhieuDangKyController();

        setTitle("Đăng Ký Mượn Sách");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        // Tiêu đề "Đăng Ký Mượn Sách"
        JLabel lblTitle = new JLabel("Đăng Ký Mượn Sách", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        // Panel chứa các trường nhập liệu
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 10, 10));
        contentPane.add(formPanel, BorderLayout.CENTER);

        // Mã thẻ độc giả
        JLabel lblMaThe = new JLabel("Mã Thẻ Độc Giả:");
        formPanel.add(lblMaThe);
        txtMaThe = new JTextField();
        formPanel.add(txtMaThe);

        // Ngày đăng ký
        JLabel lblNgayDK = new JLabel("Ngày Đăng Ký:");
        formPanel.add(lblNgayDK);
        txtNgayDK = new JFormattedTextField("10 Jan 2025"); // Định dạng ngày tháng có chữ
        formPanel.add(txtNgayDK);

        // Nút Đăng Ký
        JButton btnDangKy = new JButton("Đăng Ký");
        btnDangKy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerPhieuDangKy();
            }
        });
        contentPane.add(btnDangKy, BorderLayout.SOUTH);
    }

    private void registerPhieuDangKy() {
        String maThe = txtMaThe.getText();
        String ngayDKStr = txtNgayDK.getText();

        try {
            Date ngayDK = convertStringToDate(ngayDKStr);
            phieuDangKyController.registerPhieuDangKy(maThe, ngayDK);
            JOptionPane.showMessageDialog(this, "Đăng ký mượn sách thành công!");
            clearFields();
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Ngày đăng ký không hợp lệ. Vui lòng kiểm tra lại.");
        }
    }

    private Date convertStringToDate(String dateStr) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        return Date.valueOf(localDate);
    }

    private void clearFields() {
        txtMaThe.setText("");
        txtNgayDK.setValue("10 Jan 2025"); // Đặt lại giá trị mặc định cho ngày đăng ký
    }
}
