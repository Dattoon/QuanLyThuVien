package bookstore.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhieuMuonView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtMaThe;
    private JTextField txtMaSach;
    private JTextField txtNgayMuon;
    private JTextField txtNgayHetHan;
    private JLabel lblMaDGInfo;
    private JLabel lblTenDGInfo;
    private JLabel lblDienThoaiInfo;
    private JLabel lblTuaSachInfo;
    private JLabel lblTacGiaInfo;
    private JLabel lblTomTatInfo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PhieuMuonView frame = new PhieuMuonView();
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
    public PhieuMuonView() {
        setTitle("Đăng Ký Mượn Sách");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 709, 440);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblHeader = new JLabel("Đăng Ký Mượn Sách");
        lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader.setForeground(new Color(54, 54, 54));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPane.add(lblHeader, gbc);

        // Các trường nhập liệu
        GridBagConstraints gbcMaThe = new GridBagConstraints();
        gbcMaThe.insets = new Insets(10, 10, 10, 10);
        gbcMaThe.fill = GridBagConstraints.HORIZONTAL;
        gbcMaThe.gridx = 0;
        gbcMaThe.gridy = 1;
        contentPane.add(new JLabel("Mã DK:"), gbcMaThe);

        txtMaThe = new JTextField();
        txtMaThe.setFont(new Font("Arial", Font.PLAIN, 16));
        GridBagConstraints gbcTxtMaThe = new GridBagConstraints();
        gbcTxtMaThe.insets = new Insets(10, 10, 10, 10);
        gbcTxtMaThe.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtMaThe.gridx = 1;
        gbcTxtMaThe.gridy = 1;
        contentPane.add(txtMaThe, gbcTxtMaThe);

        GridBagConstraints gbcMaSach = new GridBagConstraints();
        gbcMaSach.insets = new Insets(10, 10, 10, 10);
        gbcMaSach.fill = GridBagConstraints.HORIZONTAL;
        gbcMaSach.gridx = 0;
        gbcMaSach.gridy = 2;
        contentPane.add(new JLabel("Mã Sách:"), gbcMaSach);

        txtMaSach = new JTextField();
        txtMaSach.setFont(new Font("Arial", Font.PLAIN, 16));
        GridBagConstraints gbcTxtMaSach = new GridBagConstraints();
        gbcTxtMaSach.insets = new Insets(10, 10, 10, 10);
        gbcTxtMaSach.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtMaSach.gridx = 1;
        gbcTxtMaSach.gridy = 2;
        contentPane.add(txtMaSach, gbcTxtMaSach);

        GridBagConstraints gbcNgayMuon = new GridBagConstraints();
        gbcNgayMuon.insets = new Insets(10, 10, 10, 10);
        gbcNgayMuon.fill = GridBagConstraints.HORIZONTAL;
        gbcNgayMuon.gridx = 0;
        gbcNgayMuon.gridy = 3;
        contentPane.add(new JLabel("Ngày Mượn:"), gbcNgayMuon);

        txtNgayMuon = new JTextField();
        txtNgayMuon.setFont(new Font("Arial", Font.PLAIN, 16));
        GridBagConstraints gbcTxtNgayMuon = new GridBagConstraints();
        gbcTxtNgayMuon.insets = new Insets(10, 10, 10, 10);
        gbcTxtNgayMuon.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtNgayMuon.gridx = 1;
        gbcTxtNgayMuon.gridy = 3;
        contentPane.add(txtNgayMuon, gbcTxtNgayMuon);

        GridBagConstraints gbcNgayHetHan = new GridBagConstraints();
        gbcNgayHetHan.insets = new Insets(10, 10, 10, 10);
        gbcNgayHetHan.fill = GridBagConstraints.HORIZONTAL;
        gbcNgayHetHan.gridx = 0;
        gbcNgayHetHan.gridy = 4;
        contentPane.add(new JLabel("Ngày Hết Hạn:"), gbcNgayHetHan);

        txtNgayHetHan = new JTextField();
        txtNgayHetHan.setFont(new Font("Arial", Font.PLAIN, 16));
        GridBagConstraints gbcTxtNgayHetHan = new GridBagConstraints();
        gbcTxtNgayHetHan.insets = new Insets(10, 10, 10, 10);
        gbcTxtNgayHetHan.fill = GridBagConstraints.HORIZONTAL;
        gbcTxtNgayHetHan.gridx = 1;
        gbcTxtNgayHetHan.gridy = 4;
        contentPane.add(txtNgayHetHan, gbcTxtNgayHetHan);

        // Panel hiển thị thông tin độc giả
        JPanel panelDGInfo = new JPanel();
        panelDGInfo.setLayout(new GridBagLayout());
        GridBagConstraints gbc_panelDGInfo = new GridBagConstraints();
        gbc_panelDGInfo.gridx = 2;
        gbc_panelDGInfo.gridy = 0;
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
        
        // Panel hiển thị thông tin sách
        JPanel panelSachInfo = new JPanel();
        panelSachInfo.setLayout(new GridBagLayout());
        GridBagConstraints gbc_panelSachInfo = new GridBagConstraints();
        gbc_panelSachInfo.gridx = 2;
        gbc_panelSachInfo.gridy = 4;
        gbc_panelSachInfo.gridheight = 3;
        gbc_panelSachInfo.insets = new Insets(0, 20, 0, 0);
        contentPane.add(panelSachInfo, gbc_panelSachInfo);

        JLabel lblThongTinSach = new JLabel("Thông Tin Sách");
        lblThongTinSach.setFont(new Font("Arial", Font.BOLD, 18));
        lblThongTinSach.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_lblThongTinSach = new GridBagConstraints();
        gbc_lblThongTinSach.gridx = 0;
        gbc_lblThongTinSach.gridy = 0;
        gbc_lblThongTinSach.gridwidth = 2;
        panelSachInfo.add(lblThongTinSach, gbc_lblThongTinSach);

        lblTuaSachInfo = new JLabel("Tựa Sách: ");
        lblTuaSachInfo.setFont(new Font("Arial", Font.PLAIN, 16));
        GridBagConstraints gbc_lblTuaSachInfo = new GridBagConstraints();
        gbc_lblTuaSachInfo.gridx = 0;
        gbc_lblTuaSachInfo.gridy = 1;
        gbc_lblTuaSachInfo.gridwidth = 2;
        panelSachInfo.add(lblTuaSachInfo, gbc_lblTuaSachInfo);

        lblTacGiaInfo = new JLabel("Tác Giả: ");
        lblTacGiaInfo.setFont(new Font("Arial", Font.PLAIN, 16));
        GridBagConstraints gbc_lblTacGiaInfo = new GridBagConstraints();
        gbc_lblTacGiaInfo.gridx = 0;
        gbc_lblTacGiaInfo.gridy = 2;
        gbc_lblTacGiaInfo.gridwidth = 2;
        panelSachInfo.add(lblTacGiaInfo, gbc_lblTacGiaInfo);

        lblTomTatInfo = new JLabel("Tóm Tắt: ");
        lblTomTatInfo.setFont(new Font("Arial", Font.PLAIN, 16));
        GridBagConstraints gbc_lblTomTatInfo = new GridBagConstraints();
        gbc_lblTomTatInfo.gridx = 0;
        gbc_lblTomTatInfo.gridy = 3;
        gbc_lblTomTatInfo.gridwidth = 2;
        panelSachInfo.add(lblTomTatInfo, gbc_lblTomTatInfo);
        
        

    }
}
