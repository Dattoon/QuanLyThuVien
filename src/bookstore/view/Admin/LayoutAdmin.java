package bookstore.view.Admin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import bookstore.controller.LayoutAdminController;
import bookstore.share.MenuBarAdmin; // Import lớp MenuBarAdmin
import bookstore.view.DangKyDocGia;
import bookstore.view.GiaHanTheView;
import bookstore.view.MuonSachView;
import bookstore.view.TraSachView;

public class LayoutAdmin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField searchField;
    private LayoutAdminController layoutAdminController;

    public LayoutAdmin() {
        layoutAdminController = new LayoutAdminController();
        // Thiết lập JFrame
        setTitle("Layout Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(10, 10));

        // Tích hợp MenuBarAdmin
        MenuBarAdmin menuBarAdmin = new MenuBarAdmin();
        setJMenuBar(menuBarAdmin);

        // Header
        JLabel lblManage = new JLabel("CHÀO MỪNG ĐẾN VỚI TRANG QUẢN LÝ", JLabel.CENTER);
        lblManage.setFont(new Font("Arial", Font.BOLD, 28));
        lblManage.setForeground(new Color(0, 102, 204));
        contentPane.add(lblManage, BorderLayout.NORTH);

        // Số liệu quản lý
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(3, 1, 10, 10));
        statsPanel.setBorder(BorderFactory.createTitledBorder("Số liệu quản lý"));

        JLabel lblBooksBorrowed = new JLabel("SỐ LƯỢNG SÁCH ĐANG MƯỢN: " + layoutAdminController.getCountBooksBorrowed());
        lblBooksBorrowed.setFont(new Font("Arial", Font.PLAIN, 18));
        statsPanel.add(lblBooksBorrowed);

        JLabel lblOverdueBooks = new JLabel("SỐ LƯỢNG SÁCH QUÁ HẠN: " + layoutAdminController.getCountOverdueBooks());
        lblOverdueBooks.setFont(new Font("Arial", Font.PLAIN, 18));
        statsPanel.add(lblOverdueBooks);

        JLabel lblRegisteredReaders = new JLabel("SỐ ĐỘC GIẢ ĐĂNG KÝ: " + layoutAdminController.getCountRegisteredReaders());
        lblRegisteredReaders.setFont(new Font("Arial", Font.PLAIN, 18));
        statsPanel.add(lblRegisteredReaders);

        contentPane.add(statsPanel, BorderLayout.CENTER);

        // Panel cho các nút hành động
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Chức năng"));

        JButton btnOption1 = new JButton("ĐĂNG KÝ MƯỢN SÁCH");
        btnOption1.setPreferredSize(new Dimension(200, 60));
        GridBagConstraints gbc_btnOption1 = new GridBagConstraints();
        gbc_btnOption1.gridx = 0;
        gbc_btnOption1.gridy = 0;
        gbc_btnOption1.insets = new Insets(10, 5, 10, 5);
        buttonPanel.add(btnOption1, gbc_btnOption1);
        btnOption1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MuonSachView().setVisible(true);
            }
        });

        JButton btnOption2 = new JButton("TRẢ SÁCH");
        btnOption2.setPreferredSize(new Dimension(200, 60));
        GridBagConstraints gbc_btnOption2 = new GridBagConstraints();
        gbc_btnOption2.gridx = 1;
        gbc_btnOption2.gridy = 0;
        gbc_btnOption2.insets = new Insets(10, 5, 10, 5);
        buttonPanel.add(btnOption2, gbc_btnOption2);
        btnOption2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TraSachView().setVisible(true);
            }
        });

        JButton btnOption3 = new JButton("ĐĂNG KÝ ĐỘC GIẢ MỚI");
        btnOption3.setPreferredSize(new Dimension(200, 60));
        GridBagConstraints gbc_btnOption3 = new GridBagConstraints();
        gbc_btnOption3.gridx = 2;
        gbc_btnOption3.gridy = 0;
        gbc_btnOption3.insets = new Insets(10, 5, 10, 5);
        buttonPanel.add(btnOption3, gbc_btnOption3);
        btnOption3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DangKyDocGia().setVisible(true);
            }
        });

        JButton btnOption4 = new JButton("GIA HẠN THẺ");
        btnOption4.setPreferredSize(new Dimension(200, 60));
        GridBagConstraints gbc_btnOption4 = new GridBagConstraints();
        gbc_btnOption4.gridx = 3;
        gbc_btnOption4.gridy = 0;
        gbc_btnOption4.insets = new Insets(10, 5, 10, 5);
        buttonPanel.add(btnOption4, gbc_btnOption4);
        btnOption4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GiaHanTheView().setVisible(true);
            }
        });

        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LayoutAdmin frame = new LayoutAdmin();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
