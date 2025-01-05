package bookstore.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class DangKyDocGia extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMaThe;
    private JTextField txtTenDocGia;
    private JFormattedTextField txtNgaySinh;
    private JTextField txtSoDienThoai;
    private JTextField txtDiaChi;
    private JTextField txtNgayHetHan;

    public DangKyDocGia() {
        setTitle("Đăng Ký Độc Giả");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        // Tiêu đề "Đăng ký độc giả"
        JLabel lblTitle = new JLabel("Đăng Ký Độc Giả", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        // Panel chứa các trường nhập liệu
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(7, 2, 10, 10));
        contentPane.add(formPanel, BorderLayout.CENTER);

        // Mã thẻ (không tác động)
        JLabel lblMaThe = new JLabel("Mã Thẻ:");
        formPanel.add(lblMaThe);
        txtMaThe = new JTextField();
        txtMaThe.setEditable(false);
        txtMaThe.setText("Tự động sinh"); // Giả sử mã thẻ được tự động sinh
        formPanel.add(txtMaThe);

        // Tên độc giả
        JLabel lblTenDocGia = new JLabel("Tên Độc Giả:");
        formPanel.add(lblTenDocGia);
        txtTenDocGia = new JTextField();
        formPanel.add(txtTenDocGia);

        // Ngày sinh
        JLabel lblNgaySinh = new JLabel("Ngày Sinh:");
        formPanel.add(lblNgaySinh);
        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('_');
            txtNgaySinh = new JFormattedTextField(dateMask);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formPanel.add(txtNgaySinh);

        // Số điện thoại
        JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
        formPanel.add(lblSoDienThoai);
        txtSoDienThoai = new JTextField();
        formPanel.add(txtSoDienThoai);

        // Địa chỉ
        JLabel lblDiaChi = new JLabel("Địa Chỉ:");
        formPanel.add(lblDiaChi);
        txtDiaChi = new JTextField();
        formPanel.add(txtDiaChi);

        // Ngày hết hạn (không tác động)
        JLabel lblNgayHetHan = new JLabel("Ngày Hết Hạn:");
        formPanel.add(lblNgayHetHan);
        txtNgayHetHan = new JTextField();
        txtNgayHetHan.setEditable(false);
        txtNgayHetHan.setText("Tự động tính"); // Giả sử ngày hết hạn được tự động tính
        formPanel.add(txtNgayHetHan);

        // Nút Đăng Ký và Hủy
        JButton btnDangKy = new JButton("Đăng Ký");
        formPanel.add(btnDangKy);

        JButton btnHuy = new JButton("Hủy");
        formPanel.add(btnHuy);
    }
}
