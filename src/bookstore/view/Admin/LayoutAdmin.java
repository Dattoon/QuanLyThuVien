package bookstore.view.Admin;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import bookstore.controller.LayoutAdminController;

public class LayoutAdmin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField searchField;
    private LayoutAdminController layoutAdminController;

    public LayoutAdmin() {
        layoutAdminController = new LayoutAdminController();

        setTitle("Layout Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 626, 500); 
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridBagLayout());

        JLabel lblManage = new JLabel("CHÀO MỪNG ĐẾN VỚI TRANG QUẢN LÝ");
        lblManage.setFont(new Font("Arial", Font.PLAIN, 24)); 
        lblManage.setForeground(Color.BLACK); 
        GridBagConstraints gbc_lblManage = new GridBagConstraints();
        gbc_lblManage.gridwidth = 6;
        gbc_lblManage.gridx = 0;
        gbc_lblManage.gridy = 0;
        gbc_lblManage.insets = new Insets(10, 0, 20, 0);
        contentPane.add(lblManage, gbc_lblManage);

        JLabel lblSearch = new JLabel("TÊN TÌM KIẾM");
        lblSearch.setFont(new Font("Arial", Font.PLAIN, 14));
        GridBagConstraints gbc_lblSearch = new GridBagConstraints();
        gbc_lblSearch.gridx = 0; 
        gbc_lblSearch.gridy = 1; 
        gbc_lblSearch.insets = new Insets(10, 0, 20, 5); 
        contentPane.add(lblSearch, gbc_lblSearch);

        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(300, 30));
        GridBagConstraints gbc_searchField = new GridBagConstraints();
        gbc_searchField.gridx = 1;
        gbc_searchField.gridy = 1;
        gbc_searchField.insets = new Insets(10, 0, 20, 5);
        gbc_searchField.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(searchField, gbc_searchField);

        JLabel lblBooksBorrowed = new JLabel("SỐ LƯỢNG SÁCH ĐANG MƯỢN: " + layoutAdminController.getCountBooksBorrowed());
        lblBooksBorrowed.setFont(new Font("Arial", Font.PLAIN, 14));
        GridBagConstraints gbc_lblBooksBorrowed = new GridBagConstraints();
        gbc_lblBooksBorrowed.gridx = 0;
        gbc_lblBooksBorrowed.gridy = 2;
        gbc_lblBooksBorrowed.gridwidth = 6;
        gbc_lblBooksBorrowed.insets = new Insets(10, 0, 10, 0);
        gbc_lblBooksBorrowed.anchor = GridBagConstraints.WEST; 
        contentPane.add(lblBooksBorrowed, gbc_lblBooksBorrowed);

        JLabel lblOverdueBooks = new JLabel("SỐ LƯỢNG SÁCH QUÁ HẠN: " + layoutAdminController.getCountOverdueBooks());
        lblOverdueBooks.setFont(new Font("Arial", Font.PLAIN, 14));
        GridBagConstraints gbc_lblOverdueBooks = new GridBagConstraints();
        gbc_lblOverdueBooks.gridx = 0;
        gbc_lblOverdueBooks.gridy = 3;
        gbc_lblOverdueBooks.gridwidth = 6;
        gbc_lblOverdueBooks.insets = new Insets(10, 0, 10, 0);
        gbc_lblOverdueBooks.anchor = GridBagConstraints.WEST; 
        contentPane.add(lblOverdueBooks, gbc_lblOverdueBooks);

        JLabel lblRegisteredReaders = new JLabel("SỐ ĐỘC GIẢ ĐĂNG KÝ: " + layoutAdminController.getCountRegisteredReaders());
        lblRegisteredReaders.setFont(new Font("Arial", Font.PLAIN, 14));
        GridBagConstraints gbc_lblRegisteredReaders = new GridBagConstraints();
        gbc_lblRegisteredReaders.gridx = 0;
        gbc_lblRegisteredReaders.gridy = 4;
        gbc_lblRegisteredReaders.gridwidth = 6;
        gbc_lblRegisteredReaders.insets = new Insets(10, 0, 20, 0);
        gbc_lblRegisteredReaders.anchor = GridBagConstraints.WEST; 
        contentPane.add(lblRegisteredReaders, gbc_lblRegisteredReaders);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());

        JButton btnOption1 = new JButton("ĐĂNG KÝ MƯỢN SÁCH");
        btnOption1.setPreferredSize(new Dimension(200, 60));
        GridBagConstraints gbc_btnOption1 = new GridBagConstraints();
        gbc_btnOption1.gridx = 0;
        gbc_btnOption1.gridy = 0;
        gbc_btnOption1.insets = new Insets(10, 5, 10, 5);
        buttonPanel.add(btnOption1, gbc_btnOption1);

        JButton btnOption2 = new JButton("TRẢ SÁCH");
        btnOption2.setPreferredSize(new Dimension(200, 60));
        GridBagConstraints gbc_btnOption2 = new GridBagConstraints();
        gbc_btnOption2.gridx = 1;
        gbc_btnOption2.gridy = 0;
        gbc_btnOption2.insets = new Insets(10, 5, 10, 5);
        buttonPanel.add(btnOption2, gbc_btnOption2);

        JButton btnOption3 = new JButton("ĐĂNG KÝ ĐỘC GIẢ MỚI");
        btnOption3.setPreferredSize(new Dimension(200, 60));
        GridBagConstraints gbc_btnOption3 = new GridBagConstraints();
        gbc_btnOption3.gridx = 2;
        gbc_btnOption3.gridy = 0;
        gbc_btnOption3.insets = new Insets(10, 5, 10, 5);
        buttonPanel.add(btnOption3, gbc_btnOption3);

        JButton btnOption4 = new JButton("GIA HẠN THẺ");
        btnOption4.setPreferredSize(new Dimension(200, 60));
        GridBagConstraints gbc_btnOption4 = new GridBagConstraints();
        gbc_btnOption4.gridx = 3;
        gbc_btnOption4.gridy = 0;
        gbc_btnOption4.insets = new Insets(10, 5, 10, 0);
        buttonPanel.add(btnOption4, gbc_btnOption4);

        GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
        gbc_buttonPanel.gridx = 0;
        gbc_buttonPanel.gridy = 5;
        gbc_buttonPanel.gridwidth = 6;
        gbc_buttonPanel.insets = new Insets(10, 0, 10, 0);
        contentPane.add(buttonPanel, gbc_buttonPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LayoutAdmin frame = new LayoutAdmin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
