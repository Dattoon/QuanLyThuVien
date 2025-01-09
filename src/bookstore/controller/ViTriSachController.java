package bookstore.controller;

import bookstore.model.ViTriModel;
import bookstore.repository.ViTriRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class ViTriSachController {

	private ViTriRepository viTriRepository;

	public ViTriSachController() {
		viTriRepository = new ViTriRepository();
	}

	// Method to add a new location
	public boolean addViTri(String khu, String ke, String ngan) {
		ViTriModel viTri = new ViTriModel(0, khu, ke, ngan); // MaVT is set to 0 as it will be auto-incremented by DB
		try {
			viTriRepository.addViTri(viTri);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Method to update an existing location
	public boolean updateViTri(int maVT, String khu, String ke, String ngan) {
		ViTriModel viTri = new ViTriModel(maVT, khu, ke, ngan);
		try {
			viTriRepository.updateViTri(viTri);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Method to delete a location by MaVT
	public boolean deleteViTri(int maVT) {
		try {
			viTriRepository.deleteViTri(maVT);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Method to get a location by MaVT
	public ViTriModel getViTriById(int maVT) {
		try {
			return viTriRepository.getViTriById(maVT);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Method to get all locations
	public List<ViTriModel> getAllViTri() {
		return viTriRepository.getAllViTri();
	}

	// Method to populate JTable with locations data
	public void populateViTriTable(JTable tableViTriSach) {
		List<ViTriModel> viTriList = getAllViTri();
		DefaultTableModel tableModel = (DefaultTableModel) tableViTriSach.getModel();
		tableModel.setRowCount(0); // Clear existing rows
		for (ViTriModel vt : viTriList) {
			tableModel.addRow(new Object[] { vt.getMaVT(), vt.getKhu(), vt.getKe(), vt.getNgan() });
		}
	}
	// Lấy danh sách vị trí từ repository và thêm vào comboBox
	public void populateViTriComboBox(JComboBox<String> comboBox) {
		List<ViTriModel> viTriList = getAllViTri();
		comboBox.removeAllItems();
		for (ViTriModel vt : viTriList) {
			comboBox.addItem(vt.getKhu() + " - " + vt.getKe() + " - " + vt.getNgan());
		}
	}
}
