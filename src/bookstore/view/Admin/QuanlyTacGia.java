package bookstore.view.Admin;

import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import bookstore.controller.TacGiaController;
import bookstore.model.TacGiaModel;
import bookstore.share.MenuBarAdmin;

public class QuanlyTacGia extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableTacGia;
	private JTextField txtMaTG, txtTenTG, txtDiaChiTG, textFieldSearch;
	private DefaultTableModel tableModel;
	private TacGiaController tacGiaController;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanlyTacGia frame = new QuanlyTacGia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public QuanlyTacGia() {
		tacGiaController = new TacGiaController(); // Initialize controller
		setTitle("Quản Lý Tác Giả");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		// Tích hợp MenuBarAdmin
		MenuBarAdmin menuBarAdmin = new MenuBarAdmin();
		setJMenuBar(menuBarAdmin);

		// Header panel
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new BorderLayout());
		headerPanel.setBackground(new Color(102, 153, 255));
		headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		JLabel lblTitle = new JLabel("Quản Lý Tác Giả");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(lblTitle, BorderLayout.CENTER);
		contentPane.add(headerPanel, BorderLayout.NORTH);
		// Center panel with form and table
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		contentPane.add(centerPanel, BorderLayout.CENTER);

		// Form panel (for input fields)
		JPanel formPanel = new JPanel();
		formPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		centerPanel.add(formPanel, BorderLayout.NORTH);
		JLabel lblMaTG = new JLabel("Mã Tác Giả:");
		txtMaTG = new JTextField();
		txtMaTG.setEditable(false);
		JLabel lblTenTG = new JLabel("Tên Tác Giả:");
		txtTenTG = new JTextField();
		JLabel lblDiaChiTG = new JLabel("Địa Chỉ:");
		txtDiaChiTG = new JTextField();
		GroupLayout gl_formPanel = new GroupLayout(formPanel);
		gl_formPanel.setHorizontalGroup(gl_formPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_formPanel
				.createSequentialGroup()
				.addGroup(gl_formPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblDiaChiTG, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTenTG, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(lblMaTG, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING, false).addComponent(txtDiaChiTG)
						.addComponent(txtTenTG)
						.addComponent(txtMaTG, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
				.addGap(350)));
		gl_formPanel.setVerticalGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_formPanel.createSequentialGroup()
						.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMaTG, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMaTG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTenTG, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenTG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDiaChiTG, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDiaChiTG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		formPanel.setLayout(gl_formPanel);

		// Table Panel
		JPanel tablePanel = new JPanel();
		centerPanel.add(tablePanel, BorderLayout.CENTER);
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã Tác Giả");
		tableModel.addColumn("Tên Tác Giả");
		tableModel.addColumn("Địa Chỉ");
		tableTacGia = new JTable(tableModel);
		tableTacGia.setRowHeight(30);
		tableTacGia.setFont(new Font("Arial", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(tableTacGia);
		tablePanel.setLayout(new BorderLayout());
		tablePanel.add(scrollPane, BorderLayout.CENTER);
		// Footer panel (buttons)
		JPanel footerPanel = new JPanel();
		footerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		footerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Arial", Font.BOLD, 14));
		btnThem.setBackground(new Color(34, 139, 34));
		btnThem.setForeground(Color.WHITE);
		footerPanel.add(btnThem);
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Arial", Font.BOLD, 14));
		btnSua.setBackground(new Color(255, 140, 0));
		btnSua.setForeground(Color.WHITE);
		footerPanel.add(btnSua);
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Arial", Font.BOLD, 14));
		btnXoa.setBackground(new Color(220, 20, 60));
		btnXoa.setForeground(Color.WHITE);
		
		footerPanel.add(btnXoa);

		// Back Button
		JButton btnBack = new JButton("Trở Về");
		btnBack.setFont(new Font("Arial", Font.BOLD, 14));
		btnBack.setBackground(new Color(70, 130, 180));
		btnBack.setForeground(Color.WHITE);
		footerPanel.add(btnBack);

		centerPanel.add(footerPanel, BorderLayout.SOUTH);

		// Button actions
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addRow();
			}
		});
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editRow();
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteRow();
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBack();
			}
		});
		

		// Table selection
		tableTacGia.getSelectionModel().addListSelectionListener(event -> {
			if (tableTacGia.getSelectedRow() != -1) {
				int selectedRow = tableTacGia.getSelectedRow();
				txtMaTG.setText(tableModel.getValueAt(selectedRow, 0).toString());
				txtTenTG.setText(tableModel.getValueAt(selectedRow, 1).toString());
				txtDiaChiTG.setText(tableModel.getValueAt(selectedRow, 2).toString());
			}
		});
		// Load initial data
		loadTacGiaData();
	}

	private void loadTacGiaData() {
		List<TacGiaModel> tacGiaList = tacGiaController.getAllTacGia();
		tableModel.setRowCount(0); // Clear existing rows
		if (tacGiaList != null) {
			for (TacGiaModel tacGia : tacGiaList) {
				tableModel.addRow(new Object[] { tacGia.getMaTG(), tacGia.getTenTG(), tacGia.getDiaChiTG() });
			}
		}
	}

	private void addRow() {
		// Lấy dữ liệu từ các trường nhập liệu
		String tenTG = txtTenTG.getText().trim();
		String diaChiTG = txtDiaChiTG.getText().trim();
		// Kiểm tra dữ liệu đầu vào
		if (tenTG.isEmpty() || diaChiTG.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin tác giả.");
			return;
		}
		int newId = tacGiaController.addTacGia(tenTG, diaChiTG);
		if (newId > 0) {
			JOptionPane.showMessageDialog(this, "Thêm tác giả thành công.");
			tableModel.addRow(new Object[] { newId, tenTG, diaChiTG });
			clearTextFields();
		} else {
			JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình thêm tác giả.");
		}
	}

	private void editRow() {
		int selectedRow = tableTacGia.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa.");
			return;
		}
		String maTGStr = txtMaTG.getText().trim();
		String tenTG = txtTenTG.getText().trim();
		String diaChiTG = txtDiaChiTG.getText().trim();
		if (maTGStr.isEmpty() || tenTG.isEmpty() || diaChiTG.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin tác giả.");
			return;
		}
		int maTG;
		try {
			maTG = Integer.parseInt(maTGStr);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Mã tác giả phải là số.");
			return;
		}
		boolean isUpdated = tacGiaController.updateTacGia(maTG, tenTG, diaChiTG);
		if (isUpdated) {
			JOptionPane.showMessageDialog(this, "Sửa tác giả thành công.");
			loadTacGiaData();
			clearTextFields();
		} else {
			JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình sửa tác giả.");
		}
	}

	private void deleteRow() {
		int selectedRow = tableTacGia.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa.");
			return;
		}
		int maTG = (int) tableModel.getValueAt(selectedRow, 0);
		boolean isDeleted = tacGiaController.deleteTacGia(maTG);
		if (isDeleted) {
			JOptionPane.showMessageDialog(this, "Xóa thành công.");
			loadTacGiaData();
			clearTextFields();
		} else {
			JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình xóa.");
		}
	}

	private void displaySelectedRow() {
		int selectedRow = tableTacGia.getSelectedRow();
		if (selectedRow != -1) {
			txtMaTG.setText(tableModel.getValueAt(selectedRow, 0).toString());
			txtTenTG.setText(tableModel.getValueAt(selectedRow, 1).toString());
			txtDiaChiTG.setText(tableModel.getValueAt(selectedRow, 2).toString());
		}
	}

	private void clearTextFields() {
		txtMaTG.setText("");
		txtTenTG.setText("");
		txtTenTG.setText("");
		txtDiaChiTG.setText("");
		tableTacGia.clearSelection();
	}

	// Back button functionality (close current window)
	private void goBack() {
		this.dispose();
	}
}
