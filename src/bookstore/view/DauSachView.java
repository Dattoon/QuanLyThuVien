package bookstore.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import bookstore.controller.DauSachController;
import bookstore.model.DauSachModel;
import bookstore.controller.ViTriSachController;
import bookstore.model.ViTriModel;
import bookstore.controller.NgonNguController;
import bookstore.model.NgonNguModel;
import bookstore.controller.TacGiaController;
import bookstore.model.TacGiaModel;

import java.util.ArrayList;
import java.util.List;

public class DauSachView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableDauSach;
	private JTextField txtMaSach, txtTuaSach, txtTomTat, txtSL;
	private JComboBox<String> comboBoxNgonNgu, comboBoxViTri, comboBoxTacGia;
	private DefaultTableModel tableModel;
	private DauSachController dauSachController;
	private ViTriSachController viTriController;
	private NgonNguController ngonNguController;
	private TacGiaController tacGiaController;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DauSachView frame = new DauSachView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DauSachView() {
		dauSachController = new DauSachController();
		ngonNguController = new NgonNguController();
		viTriController = new ViTriSachController();
		tacGiaController = new TacGiaController();

		setTitle("Quản Lý Sách");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// Form panel (for input fields)
		JPanel formPanel = new JPanel();
		formPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(formPanel, BorderLayout.NORTH);

		JLabel lblMaSach = new JLabel("Mã Sách:");
		txtMaSach = new JTextField();
		txtMaSach.setEditable(false);

		JLabel lblTuaSach = new JLabel("Tựa Sách:");
		txtTuaSach = new JTextField();
		txtTuaSach.setColumns(10);

		JLabel lblTomTat = new JLabel("Tóm Tắt:");
		txtTomTat = new JTextField();
		txtTomTat.setColumns(10);

		JLabel lblSL = new JLabel("Số Lượng:");
		txtSL = new JTextField();
		txtSL.setColumns(10);

		JLabel lblNgonNgu = new JLabel("Ngôn Ngữ:");
		comboBoxNgonNgu = new JComboBox<>();

		JLabel lblViTri = new JLabel("Vị Trí:");
		comboBoxViTri = new JComboBox<>();

		JLabel lblTacGia = new JLabel("Tác Giả:");
		comboBoxTacGia = new JComboBox<>();

		GroupLayout gl_formPanel = new GroupLayout(formPanel);
		gl_formPanel.setHorizontalGroup(gl_formPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(gl_formPanel.createSequentialGroup().addContainerGap().addGroup(gl_formPanel
						.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(lblMaSach, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTuaSach, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTomTat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblSL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNgonNgu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblViTri, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblTacGia, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								gl_formPanel.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(txtMaSach)
										.addComponent(txtTuaSach).addComponent(txtTomTat).addComponent(txtSL)
										.addComponent(comboBoxNgonNgu, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(comboBoxViTri, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(comboBoxTacGia, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		gl_formPanel.setVerticalGroup(gl_formPanel.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(gl_formPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_formPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblMaSach).addComponent(txtMaSach, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(gl_formPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblTuaSach).addComponent(txtTuaSach, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(gl_formPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblTomTat).addComponent(txtTomTat, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(gl_formPanel.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblSL)
								.addComponent(txtSL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(gl_formPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblNgonNgu).addComponent(comboBoxNgonNgu, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(gl_formPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblViTri).addComponent(comboBoxViTri, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(gl_formPanel.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblTacGia).addComponent(comboBoxTacGia, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		formPanel.setLayout(gl_formPanel);

		// Table Panel
		JPanel tablePanel = new JPanel();
		contentPane.add(tablePanel, BorderLayout.CENTER);

		// Create DefaultTableModel with column names for DauSach table
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã Sách");
		tableModel.addColumn("Tựa Sách");
		tableModel.addColumn("Tóm Tắt");
		tableModel.addColumn("Số Lượng");
		tableModel.addColumn("Ngôn Ngữ");
		tableModel.addColumn("Vị Trí");
		tableModel.addColumn("Tác Giả");

		tableDauSach = new JTable(tableModel);
		tableDauSach.setRowHeight(30);
		tableDauSach.setFont(new Font("Arial", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(tableDauSach);

		tablePanel.setLayout(new BorderLayout());
		tablePanel.add(scrollPane, BorderLayout.CENTER);

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

		contentPane.add(footerPanel, BorderLayout.SOUTH);

		// Action listeners for buttons
		addButton.addActionListener(e -> addRow());
		editButton.addActionListener(e -> editRow());
		deleteButton.addActionListener(e -> deleteRow());

		// Populate the table with data
		populateDauSachTable();

		// Add MouseListener to table for row selection
		tableDauSach.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				displaySelectedRow();
			}
		});

	}

	private void populateNgonNguComboBox() {
		List<NgonNguModel> ngonNguList = ngonNguController.getAllNgonNgu();
		comboBoxNgonNgu.removeAllItems();
		for (NgonNguModel nn : ngonNguList) {
			comboBoxNgonNgu.addItem(nn.getTenNN());
		}
	}

	private void populateViTriComboBox() {
		List<ViTriModel> viTriList = viTriController.getAllViTri();
		comboBoxViTri.removeAllItems();
		for (ViTriModel vt : viTriList) {
			comboBoxViTri.addItem(vt.getKhu() + " - " + vt.getKe() + " - " + vt.getNgan());
		}
	}

	private void populateTacGiaComboBox() {
		List<TacGiaModel> tacGiaList = tacGiaController.getAllTacGia();
		comboBoxTacGia.removeAllItems();
		for (TacGiaModel tg : tacGiaList) {
			comboBoxTacGia.addItem(tg.getTenTG());
		}
	}

	// Method to add a new row
	private void addRow() {
		String tuaSach = txtTuaSach.getText().trim();
		String tomTat = txtTomTat.getText().trim();
		int sl = Integer.parseInt(txtSL.getText().trim());

		if (tuaSach.isEmpty() || tomTat.isEmpty() || sl <= 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin sách.");
			return;
		}

		int maNN = comboBoxNgonNgu.getSelectedIndex() + 1; // Giá trị mặc định, thay thế theo nhu cầu
		int maVT = comboBoxViTri.getSelectedIndex() + 1; // Giá trị mặc định, thay thế theo nhu cầu
		List<Integer> maTacGiaList = new ArrayList<>(); // Cần logic thêm để lấy mã tác giả

		int maSach = dauSachController.addDauSach(tuaSach, tomTat, sl, maNN, maVT, maTacGiaList);
		if (maSach != 0) {
			JOptionPane.showMessageDialog(this, "Thêm sách thành công.");
			populateDauSachTable();
			clearTextFields();
		} else {
			JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình thêm sách.");
		}
	}

	// Method to edit a row
	private void editRow() {
		int selectedRow = tableDauSach.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để sửa.");
			return;
		}

		int maSach = Integer.parseInt(txtMaSach.getText());
		String tuaSach = txtTuaSach.getText().trim();
		String tomTat = txtTomTat.getText().trim();
		int sl = Integer.parseInt(txtSL.getText().trim());

		if (tuaSach.isEmpty() || tomTat.isEmpty() || sl <= 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin sách.");
			return;
		}

		int maNN = comboBoxNgonNgu.getSelectedIndex() + 1; // Giá trị mặc định, thay thế theo nhu cầu
		int maVT = comboBoxViTri.getSelectedIndex() + 1; // Giá trị mặc định, thay thế theo nhu cầu
		List<Integer> maTacGiaList = new ArrayList<>(); // Cần logic thêm để lấy mã tác giả

		boolean isUpdated = dauSachController.updateDauSach(maSach, tuaSach, tomTat, sl, maNN, maVT, maTacGiaList);
		if (isUpdated) {
			JOptionPane.showMessageDialog(this, "Cập nhật sách thành công.");
			populateDauSachTable();
			clearTextFields();
		} else {
			JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình cập nhật sách.");
		}
	}

	// Method to delete a row
	private void deleteRow() {
		int selectedRow = tableDauSach.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.");
			return;
		}

		int maSach = Integer.parseInt(txtMaSach.getText());

		boolean isDeleted = dauSachController.deleteDauSach(maSach);
		if (isDeleted) {
			JOptionPane.showMessageDialog(this, "Xóa sách thành công.");
			populateDauSachTable();
			clearTextFields();
		} else {
			JOptionPane.showMessageDialog(this, "Có lỗi trong quá trình xóa sách.");
		}
	}

	private void displaySelectedRow() {
		int selectedRow = tableDauSach.getSelectedRow();
		if (selectedRow != -1) {
			txtMaSach.setText(tableModel.getValueAt(selectedRow, 0).toString());
			txtTuaSach.setText(tableModel.getValueAt(selectedRow, 1).toString());
			txtTomTat.setText(tableModel.getValueAt(selectedRow, 2).toString());
			txtSL.setText(tableModel.getValueAt(selectedRow, 3).toString());

			// Logic để chọn đúng Ngôn Ngữ và Vị Trí trong ComboBox
			comboBoxNgonNgu.setSelectedIndex((int) tableModel.getValueAt(selectedRow, 4) - 1);
			comboBoxViTri.setSelectedIndex((int) tableModel.getValueAt(selectedRow, 5) - 1);

			// Logic để hiển thị danh sách tác giả trong ComboBox
			int maSach = Integer.parseInt(txtMaSach.getText());
			List<TacGiaModel> tacGiaList = dauSachController.getTacGiaByDauSachId(maSach);
			comboBoxTacGia.removeAllItems();
			for (TacGiaModel tg : tacGiaList) {
				comboBoxTacGia.addItem(tg.getTenTG());
			}
		}
	}

	// Method to clear text fields
	private void clearTextFields() {
		txtMaSach.setText("");
		txtTuaSach.setText("");
		txtTomTat.setText("");
		txtSL.setText("");
	}

	// Method to populate table with data
	private void populateDauSachTable() {
		List<DauSachModel> dauSachList = dauSachController.getAllDauSach();
		tableModel.setRowCount(0); // Clear existing rows
		for (DauSachModel ds : dauSachList) {
			tableModel.addRow(new Object[] { ds.getMaSach(), ds.getTuaSach(), ds.getTomTat(), ds.getSl(), ds.getMaNN(),
					ds.getMaVT(),
					// Logic để hiển thị tên tác giả
					String.join(", ", getTacGiaNames(ds.getMaSach())) });
		}
	}

	// Method to get Tac Gia names by Dau Sach ID
	private List<String> getTacGiaNames(int maSach) {
		List<TacGiaModel> tacGiaList = dauSachController.getTacGiaByDauSachId(maSach);
		List<String> tacGiaNames = new ArrayList<>();
		for (TacGiaModel tg : tacGiaList) {
			tacGiaNames.add(tg.getTenTG());
		}
		return tacGiaNames;
	}

}
