package bookstore.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiaHanTheView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMaThe;
    private JTextField txtNgayHetHanHienTai;
    private JTextField txtNgayGiaHanMoi;
    private JLabel lblMaDGInfo;
    private JLabel lblTenDGInfo;
    private JLabel lblDienThoaiInfo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GiaHanTheView frame = new GiaHanTheView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public GiaHanTheView() {
        setTitle("Gia Hạn Thẻ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1103, 676);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblHeader = new JLabel("Gia Hạn Thẻ");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader.setForeground(new Color(54, 54, 54));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPane.add(lblHeader, gbc);

        txtMaThe = new JTextField();
        txtMaThe.setFont(new Font("Arial", Font.PLAIN, 16));
        txtMaThe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maThe = txtMaThe.getText();
                // Giả sử chúng ta đã có phương thức để lấy thông tin độc giả từ mã thẻ
//                String maDG = getMaDGFromMaThe(maThe);
//                String tenDG = getTenDGFromMaThe(maThe);
//                String dienThoai = getDienThoaiFromMaThe(maThe);

//                lblMaDGInfo.setText("Mã Độc Giả: " + maDG);
//                lblTenDGInfo.setText("Tên Độc Giả: " + tenDG);
//                lblDienThoaiInfo.setText("Số Điện Thoại: " + dienThoai);
            }
        });
        
                // Các trường nhập liệu
                GridBagConstraints gbcMaThe = new GridBagConstraints();
                gbcMaThe.insets = new Insets(10, 10, 10, 10);
                gbcMaThe.fill = GridBagConstraints.HORIZONTAL;
                gbcMaThe.gridx = 0;
                gbcMaThe.gridy = 1;
                JLabel label = new JLabel("Mã Thẻ:");
                contentPane.add(label, gbcMaThe);
        GridBagConstraints gbcTxtMaThe = new GridBagConstraints();
        gbcTxtMaThe.insets = new Insets(10, 10, 10, 10);
        gbcTxtMaThe.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtMaThe.gridx = 2;
        gbcTxtMaThe.gridy = 1;
        contentPane.add(txtMaThe, gbcTxtMaThe);
        
                GridBagConstraints gbcNgayHetHanHienTai = new GridBagConstraints();
                gbcNgayHetHanHienTai.insets = new Insets(10, 10, 10, 10);
                gbcNgayHetHanHienTai.fill = GridBagConstraints.HORIZONTAL;
                gbcNgayHetHanHienTai.gridx = 0;
                gbcNgayHetHanHienTai.gridy = 2;
                JLabel label_1 = new JLabel("Ngày Hết Hạn Hiện Tại:");
                contentPane.add(label_1, gbcNgayHetHanHienTai);

        txtNgayHetHanHienTai = new JTextField();
        txtNgayHetHanHienTai.setFont(new Font("Arial", Font.PLAIN, 16));
        GridBagConstraints gbcTxtNgayHetHanHienTai = new GridBagConstraints();
        gbcTxtNgayHetHanHienTai.insets = new Insets(10, 10, 10, 10);
        gbcTxtNgayHetHanHienTai.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtNgayHetHanHienTai.gridx = 2;
        gbcTxtNgayHetHanHienTai.gridy = 2;
        contentPane.add(txtNgayHetHanHienTai, gbcTxtNgayHetHanHienTai);
        
                GridBagConstraints gbcNgayGiaHanMoi = new GridBagConstraints();
                gbcNgayGiaHanMoi.insets = new Insets(10, 10, 10, 10);
                gbcNgayGiaHanMoi.fill = GridBagConstraints.HORIZONTAL;
                gbcNgayGiaHanMoi.gridx = 0;
                gbcNgayGiaHanMoi.gridy = 3;
                JLabel label_2 = new JLabel("Ngày Gia Hạn Mới:");
                contentPane.add(label_2, gbcNgayGiaHanMoi);

        txtNgayGiaHanMoi = new JTextField();
        txtNgayGiaHanMoi.setFont(new Font("Arial", Font.PLAIN, 16));
        GridBagConstraints gbcTxtNgayGiaHanMoi = new GridBagConstraints();
        gbcTxtNgayGiaHanMoi.insets = new Insets(10, 10, 10, 10);
        gbcTxtNgayGiaHanMoi.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtNgayGiaHanMoi.gridx = 2;
        gbcTxtNgayGiaHanMoi.gridy = 3;
        contentPane.add(txtNgayGiaHanMoi, gbcTxtNgayGiaHanMoi);

        // Panel hiển thị thông tin độc giả
        JPanel panelDGInfo = new JPanel();
        panelDGInfo.setLayout(new GridBagLayout());
        GridBagConstraints gbc_panelDGInfo = new GridBagConstraints();
        gbc_panelDGInfo.gridx = 3;
        gbc_panelDGInfo.gridy = 1;
        gbc_panelDGInfo.gridheight = 3;
        gbc_panelDGInfo.insets = new Insets(0, 20, 0, 0);
        contentPane.add(panelDGInfo, gbc_panelDGInfo);

        JLabel lblThongTinDG = new JLabel("Thông Tin Độc Giả");
        lblThongTinDG.setFont(new Font("Arial", Font.BOLD, 18));
        lblThongTinDG.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_lblThongTinDG = new GridBagConstraints();
        gbc_lblThongTinDG.gridx = 0;
        gbc_lblThongTinDG.gridy = 0;
        gbc_lblThongTinDG.gridwidth = 2;
        panelDGInfo.add(lblThongTinDG, gbc_lblThongTinDG);

        lblMaDGInfo = new JLabel("Mã Độc Giả: ");
        lblMaDGInfo.setFont(new Font("Arial", Font.PLAIN, 16));
        GridBagConstraints gbc_lblMaDGInfo = new GridBagConstraints();
        gbc_lblMaDGInfo.gridx = 0;
        gbc_lblMaDGInfo.gridy = 1;
        gbc_lblMaDGInfo.gridwidth = 2;
        panelDGInfo.add(lblMaDGInfo, gbc_lblMaDGInfo);

        lblTenDGInfo = new JLabel("Tên Độc Giả: ");
        lblTenDGInfo.setFont(new Font("Arial", Font.PLAIN, 16));
        GridBagConstraints gbc_lblTenDGInfo = new GridBagConstraints();
        gbc_lblTenDGInfo.gridx = 0;
        gbc_lblTenDGInfo.gridy = 2;
        gbc_lblTenDGInfo.gridwidth = 2;
        panelDGInfo.add(lblTenDGInfo, gbc_lblTenDGInfo);

        lblDienThoaiInfo = new JLabel("Số Điện Thoại: ");
        lblDienThoaiInfo.setFont(new Font("Arial", Font.PLAIN, 16));
        GridBagConstraints gbc_lblDienThoaiInfo = new GridBagConstraints();
        gbc_lblDienThoaiInfo.gridx = 0;
        gbc_lblDienThoaiInfo.gridy = 3;
        gbc_lblDienThoaiInfo.gridwidth = 2;
        panelDGInfo.add(lblDienThoaiInfo, gbc_lblDienThoaiInfo);
    }
}
