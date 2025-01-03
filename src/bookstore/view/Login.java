package bookstore.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import bookstore.controller.UserController;
import bookstore.view.Admin.LayoutAdmin; // Nhập lớp LayoutAdmin

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private UserController userController;

	public Login() {
		userController = new UserController();

		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 603);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPane.setBackground(new Color(245, 245, 245));
		setContentPane(contentPane);

		JLabel lblHeader = new JLabel("ĐĂNG NHẬP");
		lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
		lblHeader.setForeground(new Color(54, 54, 54));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblUsername = new JLabel("Tên đăng nhập:");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 16));
		txtUsername = new JTextField();
		txtUsername.setPreferredSize(new Dimension(300, 35));

		JLabel lblPassword = new JLabel("Mật khẩu:");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		txtPassword = new JPasswordField();
		txtPassword.setPreferredSize(new Dimension(300, 35));

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setForeground(Color.BLUE);
		btnLogin.setFocusPainted(false);
		btnLogin.setPreferredSize(new Dimension(150, 40));

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String password = new String(txtPassword.getPassword());

				if (userController.login(username, password)) {
					JOptionPane.showMessageDialog(contentPane, "Đăng nhập thành công!");
					dispose(); // Đóng cửa sổ đăng nhập hiện tại
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								LayoutAdmin frame = new LayoutAdmin();
								frame.setVisible(true); // Hiển thị cửa sổ LayoutAdmin
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					});
				} else {
					JOptionPane.showMessageDialog(contentPane, "Tên đăng nhập hoặc mật khẩu không đúng!");
				}
			}
		});

		GroupLayout layout = new GroupLayout(contentPane);
		contentPane.setLayout(layout);

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				.addComponent(lblHeader, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup()
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE));

		layout.setVerticalGroup(layout.createSequentialGroup().addComponent(lblHeader).addGap(20)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblUsername)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblPassword)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(30).addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE));

		setVisible(true);
	}

	public static void main(String[] args) {
		new Login();
	}
}