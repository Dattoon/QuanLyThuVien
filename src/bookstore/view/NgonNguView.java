package bookstore.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import bookstore.controller.NgonNguController;
import bookstore.model.NgonNguModel;

public class NgonNguView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableNgonNgu;
	private JTextField txtMaNN, txtTenNN, textFieldSearch;
	private DefaultTableModel tableModel;
	private NgonNguController ngonNguController;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NgonNguView frame = new NgonNguView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NgonNguView() {
		ngonNguController = new NgonNguController(); // Initialize controller

		setTitle("Quản Lý Ngôn Ngữ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Header panel
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new BorderLayout());
		headerPanel.setBackground(new Color(102, 153, 255));
		headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		JLabel lblTitle = new JLabel("Quản Lý Ngôn Ngữ");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		headerPanel.add(lblTitle, BorderLayout.CENTER);
		contentPane.add(headerPanel, BorderLayout.NORTH); // Center panel with form and table
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		contentPane.add(centerPanel, BorderLayout.CENTER);

		// Form panel (for input fields)
		JPanel formPanel = new JPanel();
		formPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		centerPanel.add(formPanel, BorderLayout.NORTH);

		JLabel lblMaNN = new JLabel("Mã Ngôn Ngữ:");
		txtMaNN = new JTextField();
		txtMaNN.setEditable(false); // Disable editing for MaNN field since it will be auto-incremented by DB

		JLabel lblTenNN = new JLabel("Tên Ngôn Ngữ:");
		txtTenNN = new JTextField();
		GroupLayout gl_formPanel = new GroupLayout(formPanel);
		gl_formPanel.setHorizontalGroup(gl_formPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_formPanel
				.createSequentialGroup()
				.addGroup(gl_formPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblTenNN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING,
								gl_formPanel.createParallelGroup(Alignment.TRAILING, false).addComponent(lblMaNN,
										Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_formPanel.createParallelGroup(Alignment.LEADING, false).addComponent(txtTenNN)
						.addComponent(txtMaNN, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
				.addGap(350)));
		gl_formPanel.setVerticalGroup(gl_formPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_formPanel.createSequentialGroup()
						.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMaNN, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMaNN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(gl_formPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTenNN, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenNN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		formPanel.setLayout(gl_formPanel);
		// Table Panel
		JPanel tablePanel = new JPanel();
		centerPanel.add(tablePanel, BorderLayout.CENTER);

		// Create DefaultTableModel with column names for NgonNgu table
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã Ngôn Ngữ");
		tableModel.addColumn("Tên Ngôn Ngữ");

		tableNgonNgu = new JTable(tableModel);
		tableNgonNgu.setRowHeight(30);
		tableNgonNgu.setFont(new Font("Arial", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(tableNgonNgu);

		// Footer panel (buttons)
		JPanel footerPanel = new JPanel();
		footerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		footerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		JButton addButton = new JButton("Thêm");
		addButton.setFont(new Font("Arial", Font.BOLD, 14));
		addButton.setBackground(new Color(0, 123, 255));
		addButton.setForeground(Color.WHITE);
		footerPanel.add(addButton);

		JButton editButton = new JButton("Sửa");
		editButton.setFont(new Font("Arial", Font.BOLD, 14));
		editButton.setBackground(new Color(255, 165, 0));
		editButton.setForeground(Color.WHITE);
		footerPanel.add(editButton);

		JButton deleteButton = new JButton("Xóa");
		deleteButton.setFont(new Font("Arial", Font.BOLD, 14));
		deleteButton.setBackground(new Color(220, 53, 69));
		deleteButton.setForeground(Color.WHITE);
		footerPanel.add(deleteButton);

		JButton saveButton = new JButton("Lưu");
		saveButton.setFont(new Font("Arial", Font.BOLD, 14));
		saveButton.setBackground(new Color(34, 139, 34));
		saveButton.setForeground(Color.WHITE);
		footerPanel.add(saveButton);

		// Add Action Listeners for buttons
		addButton.addActionListener(e -> addRow());
		editButton.addActionListener(e -> editRow());
		deleteButton.addActionListener(e -> deleteRow());
		saveButton.addActionListener(e -> saveData());

		// Add MouseListener to table for row selection
		tableNgonNgu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				displaySelectedRow();
			}
		});

		tablePanel.setLayout(new BorderLayout());
		tablePanel.add(scrollPane, BorderLayout.CENTER);
		contentPane.add(footerPanel, BorderLayout.SOUTH);

		// Populate the table with data
		populateNgonNguTable();
	}

	// Populate JTable with data from the database
	private void populateNgonNguTable() {
		ngonNguController.populateNgonNguTable(tableNgonNgu);
	}

	// Method to add a row
	private void addRow() {
		// Lấy dữ liệu từ các trường nhập liệu
		String tenNN = txtTenNN.getText().trim();

		// Kiểm tra dữ liệu đầu vào
		if (tenNN.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin ngôn ngữ.");
			return;
		}

		boolean isAdded = ngonNguController.addNgonNgu(tenNN);
		if (isAdded) {
			JOptionPane.showMessageDialog(this, "Thêm ngôn ngữ thành công.");
			populateNgonNguTable();
			clearTextFields();
		} else {
			JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình thêm ngôn ngữ.");
		}
	}

	// Method to edit a selected row
	private void editRow() {
		int selectedRow = tableNgonNgu.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa.");
			return;
		}

		String maNNStr = tableModel.getValueAt(selectedRow, 0).toString();
		int maNN = Integer.parseInt(maNNStr);
		String tenNN = txtTenNN.getText().trim();

		if (tenNN.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin ngôn ngữ.");
			return;
		}

		boolean isUpdated = ngonNguController.updateNgonNgu(maNN, tenNN);
		if (isUpdated) {
			JOptionPane.showMessageDialog(this, "Sửa ngôn ngữ thành công.");
			populateNgonNguTable();
			clearTextFields();
		} else {
			JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình sửa ngôn ngữ.");
		}
	}

	// Method to delete a selected row
	private void deleteRow() {
		int selectedRow = tableNgonNgu.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa.");
			return;
		}

		String maNNStr = tableModel.getValueAt(selectedRow, 0).toString();
		int maNN = Integer.parseInt(maNNStr);

		boolean isDeleted = ngonNguController.deleteNgonNgu(maNN);
		if (isDeleted) {
			JOptionPane.showMessageDialog(this, "Xóa ngôn ngữ thành công.");
			populateNgonNguTable();
			clearTextFields();
		} else {
			JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình xóa.");
		}
	}

	// Method to display selected row's data in text fields
	private void displaySelectedRow() {
		int selectedRow = tableNgonNgu.getSelectedRow();
		if (selectedRow != -1) {
			txtMaNN.setText(tableModel.getValueAt(selectedRow, 0).toString());
			txtTenNN.setText(tableModel.getValueAt(selectedRow, 1).toString());
		}
	}

	// Method to clear text fields
	private void clearTextFields() {
		txtMaNN.setText("");
		txtTenNN.setText("");
	}

	// Method to save data (if needed, this is just a placeholder)
	private void saveData() {
		// Logic for saving the language data
		JOptionPane.showMessageDialog(this, "Lưu dữ liệu thành công.");
	}
}
