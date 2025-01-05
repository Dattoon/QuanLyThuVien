package bookstore.view;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;  // Import for BorderLayout
import java.awt.FlowLayout;    // Import for FlowLayout
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ViTriSachView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField khuTextField;
    private JTextField keTextField;
    private JTextField nganTextField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViTriSachView frame = new ViTriSachView();
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
    public ViTriSachView() {
        setTitle("Quản Lý Vị Trí Sách");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(102, 153, 255));
        headerPanel.setLayout(new BorderLayout());
        JLabel lblTitle = new JLabel("Nhập Vị Trí Sách");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(lblTitle, BorderLayout.CENTER);
        contentPane.add(headerPanel, BorderLayout.NORTH);

        // Input Fields Panel (for "Khu", "Kệ", "Ngăn")
        JPanel inputFieldsPanel = new JPanel();
        JLabel khuLabel = new JLabel("Khu:");
        khuLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        khuTextField = new JTextField();
        khuTextField.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel keLabel = new JLabel("Kệ:");
        keLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        keTextField = new JTextField();
        keTextField.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel nganLabel = new JLabel("Ngăn:");
        nganLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        nganTextField = new JTextField();
        nganTextField.setFont(new Font("Arial", Font.PLAIN, 14));

        // GroupLayout for input fields
        GroupLayout gl_inputFieldsPanel = new GroupLayout(inputFieldsPanel);
        gl_inputFieldsPanel.setHorizontalGroup(
            gl_inputFieldsPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_inputFieldsPanel.createSequentialGroup()
                    .addGap(45)
                    .addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.TRAILING, false)
                        .addComponent(khuLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(keLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nganLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(4)
                    .addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.LEADING)
                        .addComponent(khuTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(keTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(nganTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                    .addGap(56))
        );
        gl_inputFieldsPanel.setVerticalGroup(
            gl_inputFieldsPanel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_inputFieldsPanel.createSequentialGroup()
                    .addGap(10)
                    .addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(khuLabel)
                        .addComponent(khuTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(keLabel)
                        .addComponent(keTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(gl_inputFieldsPanel.createParallelGroup(Alignment.BASELINE)
                        .addComponent(nganLabel)
                        .addComponent(nganTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(20, Short.MAX_VALUE))
        );
        inputFieldsPanel.setLayout(gl_inputFieldsPanel);
        contentPane.add(inputFieldsPanel, BorderLayout.CENTER);

        // Footer Panel (Action buttons)
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BorderLayout());
        footerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Action buttons panel
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        // Create buttons: Add, Edit, Delete, and Save
        JButton addButton = new JButton("Thêm");
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setBackground(new Color(0, 123, 255));
        addButton.setForeground(Color.WHITE);
        actionPanel.add(addButton);

        JButton editButton = new JButton("Sửa");
        editButton.setFont(new Font("Arial", Font.BOLD, 14));
        editButton.setBackground(new Color(255, 165, 0));
        editButton.setForeground(Color.WHITE);
        actionPanel.add(editButton);

        JButton deleteButton = new JButton("Xóa");
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));
        deleteButton.setBackground(new Color(220, 53, 69));
        deleteButton.setForeground(Color.WHITE);
        actionPanel.add(deleteButton);

        JButton saveButton = new JButton("Lưu");
        saveButton.setFont(new Font("Arial", Font.BOLD, 14));
        saveButton.setBackground(new Color(34, 139, 34));
        saveButton.setForeground(Color.WHITE);
        actionPanel.add(saveButton);

        footerPanel.add(actionPanel, BorderLayout.CENTER);
        contentPane.add(footerPanel, BorderLayout.SOUTH);

        // Button actions
        addButton.addActionListener(e -> {
            // Logic for adding a new location
            String khu = khuTextField.getText();
            String ke = keTextField.getText();
            String ngan = nganTextField.getText();
            System.out.println("Thêm vị trí - Khu: " + khu + ", Kệ: " + ke + ", Ngăn: " + ngan);
        });

        editButton.addActionListener(e -> {
            // Logic for editing a location
            String khu = khuTextField.getText();
            String ke = keTextField.getText();
            String ngan = nganTextField.getText();
            System.out.println("Sửa vị trí - Khu: " + khu + ", Kệ: " + ke + ", Ngăn: " + ngan);
        });

        deleteButton.addActionListener(e -> {
            // Logic for deleting a location
            String khu = khuTextField.getText();
            String ke = keTextField.getText();
            String ngan = nganTextField.getText();
            System.out.println("Xóa vị trí - Khu: " + khu + ", Kệ: " + ke + ", Ngăn: " + ngan);
        });

        saveButton.addActionListener(e -> {
            // Logic for saving the location
            String khu = khuTextField.getText();
            String ke = keTextField.getText();
            String ngan = nganTextField.getText();
            System.out.println("Lưu vị trí - Khu: " + khu + ", Kệ: " + ke + ", Ngăn: " + ngan);
        });
    }
}
