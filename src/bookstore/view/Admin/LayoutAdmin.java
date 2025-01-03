package bookstore.view.Admin;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LayoutAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchField;

	public LayoutAdmin() {
		setTitle("Layout Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 500); // Tăng kích thước để chứa các nhãn và trường tìm kiếm
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());

		// Xóa phần thiết lập JMenuBar hiện tại và sử dụng MenuBarAdmin
		// MenuBarAdmin menuBar = new MenuBarAdmin(); // Sử dụng MenuBarAdmin tùy chỉnh
		// setJMenuBar(menuBar);

		// Nhãn tiêu đề (Thông điệp chào mừng)
		JLabel lblManage = new JLabel("CHÀO MỪNG ĐẾN VỚI TRANG QUẢN LÝ");
		lblManage.setFont(new Font("Arial", Font.PLAIN, 24)); // Thiết lập font là Arial, kích thước 24
		lblManage.setForeground(Color.BLACK); // Thiết lập màu chữ thành đen
		GridBagConstraints gbc_lblManage = new GridBagConstraints();
		gbc_lblManage.gridwidth = 6; // Làm cho nhãn chiếm toàn bộ 6 cột
		gbc_lblManage.gridx = 0;
		gbc_lblManage.gridy = 0;
		gbc_lblManage.insets = new Insets(10, 0, 20, 0); // Thêm khoảng đệm cho nhãn (trên, trái, dưới, phải)
		contentPane.add(lblManage, gbc_lblManage);

		// Nhãn cho trường tìm kiếm (ở bên trái của trường tìm kiếm)
		JLabel lblSearch = new JLabel("TÊN TÌM KIẾM");
		lblSearch.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSearch = new GridBagConstraints();
		gbc_lblSearch.gridx = 0; // Đặt nhãn vào cột đầu tiên
		gbc_lblSearch.gridy = 1; // Đặt nhãn vào cùng hàng với trường tìm kiếm
		gbc_lblSearch.insets = new Insets(10, 0, 20, 5); // Thêm khoảng đệm xung quanh nhãn
		contentPane.add(lblSearch, gbc_lblSearch);

		// Trường tìm kiếm (căn chỉnh ngang với nhãn)
		searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(300, 30)); // Thiết lập kích thước ưa thích cho trường tìm kiếm
		GridBagConstraints gbc_searchField = new GridBagConstraints();
		gbc_searchField.gridx = 1; // Đặt trường tìm kiếm vào cột thứ 2
		gbc_searchField.gridy = 1; // Đặt trường tìm kiếm vào cùng hàng với nhãn
		gbc_searchField.insets = new Insets(10, 0, 20, 5); // Thêm khoảng đệm xung quanh trường tìm kiếm
		gbc_searchField.fill = GridBagConstraints.HORIZONTAL; // Làm cho trường tìm kiếm kéo dài theo chiều ngang
		contentPane.add(searchField, gbc_searchField);

		// Các nhãn thống kê (căn trái)
		JLabel lblBooksBorrowed = new JLabel("SỐ LƯỢNG SÁCH ĐANG MƯỢN:");
		lblBooksBorrowed.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblBooksBorrowed = new GridBagConstraints();
		gbc_lblBooksBorrowed.gridx = 0;
		gbc_lblBooksBorrowed.gridy = 2;
		gbc_lblBooksBorrowed.gridwidth = 6; // Chiếm toàn bộ 6 cột
		gbc_lblBooksBorrowed.insets = new Insets(10, 0, 10, 0);
		gbc_lblBooksBorrowed.anchor = GridBagConstraints.WEST; // Căn trái
		contentPane.add(lblBooksBorrowed, gbc_lblBooksBorrowed);

		JLabel lblOverdueBooks = new JLabel("SỐ LƯỢNG SÁCH QUÁ HẠN:");
		lblOverdueBooks.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblOverdueBooks = new GridBagConstraints();
		gbc_lblOverdueBooks.gridx = 0;
		gbc_lblOverdueBooks.gridy = 3;
		gbc_lblOverdueBooks.gridwidth = 6; // Chiếm toàn bộ 6 cột
		gbc_lblOverdueBooks.insets = new Insets(10, 0, 10, 0);
		gbc_lblOverdueBooks.anchor = GridBagConstraints.WEST; // Căn trái
		contentPane.add(lblOverdueBooks, gbc_lblOverdueBooks);

		JLabel lblRegisteredReaders = new JLabel("SỐ ĐỘC GIẢ ĐĂNG KÝ:");
		lblRegisteredReaders.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_lblRegisteredReaders = new GridBagConstraints();
		gbc_lblRegisteredReaders.gridx = 0;
		gbc_lblRegisteredReaders.gridy = 4;
		gbc_lblRegisteredReaders.gridwidth = 6; // Chiếm toàn bộ 6 cột
		gbc_lblRegisteredReaders.insets = new Insets(10, 0, 20, 0);
		gbc_lblRegisteredReaders.anchor = GridBagConstraints.WEST; // Căn trái
		contentPane.add(lblRegisteredReaders, gbc_lblRegisteredReaders);

		// Các nút (căn đều trong một hàng)
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout()); // Sử dụng GridBagLayout để căn chỉnh các nút

		// Nút 1
		JButton btnOption1 = new JButton("ĐĂNG KÝ MƯỢN SÁCH");
		btnOption1.setPreferredSize(new Dimension(200, 60)); // Thiết lập kích thước nút
		GridBagConstraints gbc_btnOption1 = new GridBagConstraints();
		gbc_btnOption1.gridx = 0;
		gbc_btnOption1.gridy = 0;
		gbc_btnOption1.insets = new Insets(10, 5, 10, 5); // Thêm khoảng đệm cho các nút
		buttonPanel.add(btnOption1, gbc_btnOption1);

		// Nút 2
		JButton btnOption2 = new JButton("TRẢ SÁCH");
		btnOption2.setPreferredSize(new Dimension(200, 60)); // Thiết lập kích thước nút
		GridBagConstraints gbc_btnOption2 = new GridBagConstraints();
		gbc_btnOption2.gridx = 1;
		gbc_btnOption2.gridy = 0;
		gbc_btnOption2.insets = new Insets(10, 5, 10, 5); // Thêm khoảng đệm cho các nút
		buttonPanel.add(btnOption2, gbc_btnOption2);

		// Nút 3
		JButton btnOption3 = new JButton("ĐĂNG KÝ ĐỘC GIẢ MỚI");
		btnOption3.setPreferredSize(new Dimension(200, 60)); // Thiết lập kích thước nút
		GridBagConstraints gbc_btnOption3 = new GridBagConstraints();
		gbc_btnOption3.gridx = 2;
		gbc_btnOption3.gridy = 0;
		gbc_btnOption3.insets = new Insets(10, 5, 10, 5); // Thêm khoảng đệm cho các nút
		buttonPanel.add(btnOption3, gbc_btnOption3);

		// Nút 4
		JButton btnOption4 = new JButton("GIA HẠN THẺ");
		btnOption4.setPreferredSize(new Dimension(200, 60)); // Thiết lập kích thước nút
		GridBagConstraints gbc_btnOption4 = new GridBagConstraints();
		gbc_btnOption4.gridx = 3;
		gbc_btnOption4.gridy = 0;
		gbc_btnOption4.insets = new Insets(10, 5, 10, 0); // Thêm khoảng đệm cho các nút
		buttonPanel.add(btnOption4, gbc_btnOption4);

		// Thêm bảng nút vào content pane
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 5;
		gbc_buttonPanel.gridwidth = 6;
		gbc_buttonPanel.insets = new Insets(10, 0, 10, 0);
		contentPane.add(buttonPanel, gbc_buttonPanel);

		setVisible(true); // Hiển thị cửa sổ LayoutAdmin
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
