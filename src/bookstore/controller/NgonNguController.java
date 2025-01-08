package bookstore.controller;

import bookstore.model.NgonNguModel;
import bookstore.repository.NgonNguRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class NgonNguController {

	private NgonNguRepository ngonNguRepository;

	public NgonNguController() {
		ngonNguRepository = new NgonNguRepository();
	}

	// Method to add a new language
	public boolean addNgonNgu(String tenNN) {
		NgonNguModel ngonNgu = new NgonNguModel(0, tenNN); // MaNN is set to 0 as it will be auto-incremented by DB
		try {
			ngonNguRepository.addNgonNgu(ngonNgu);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Method to update an existing language
	public boolean updateNgonNgu(int maNN, String tenNN) {
		NgonNguModel ngonNgu = new NgonNguModel(maNN, tenNN);
		try {
			ngonNguRepository.updateNgonNgu(ngonNgu);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Method to delete a language by MaNN
	public boolean deleteNgonNgu(int maNN) {
		try {
			ngonNguRepository.deleteNgonNgu(maNN);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Method to get a language by MaNN
	public NgonNguModel getNgonNguById(int maNN) {
		try {
			return ngonNguRepository.getNgonNguById(maNN);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Method to get all languages
	public List<NgonNguModel> getAllNgonNgu() {
		try {
			return ngonNguRepository.getAllNgonNgu();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Method to populate JTable with language data
	public void populateNgonNguTable(JTable tableNgonNgu) {
		List<NgonNguModel> ngonNguList = getAllNgonNgu();
		DefaultTableModel tableModel = (DefaultTableModel) tableNgonNgu.getModel();
		tableModel.setRowCount(0); // Clear existing rows
		for (NgonNguModel nn : ngonNguList) {
			tableModel.addRow(new Object[] { nn.getMaNN(), nn.getTenNN() });
		}
	}

	// Lấy danh sách ngôn ngữ từ repository và thêm vào comboBox
	public void populateNgonNguComboBox(JComboBox<String> comboBox) {
		List<NgonNguModel> ngonNguList = getAllNgonNgu();
		comboBox.removeAllItems();
		for (NgonNguModel nn : ngonNguList) {
			comboBox.addItem(nn.getTenNN());
		}
	}
}
