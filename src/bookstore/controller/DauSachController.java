package bookstore.controller;

import bookstore.model.DauSachModel;
import bookstore.model.SachTacGiaModel;
import bookstore.model.TacGiaModel;
import bookstore.repository.DauSachRepository;
import bookstore.repository.SachTacGiaRepository;
import bookstore.repository.TacGiaRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class DauSachController {

    private DauSachRepository dauSachRepository;
    private SachTacGiaRepository sachTacGiaRepository;
    private TacGiaRepository tacGiaRepository;

    public DauSachController() {
        dauSachRepository = new DauSachRepository();
        sachTacGiaRepository = new SachTacGiaRepository();
        tacGiaRepository = new TacGiaRepository();
    }

    // Method to add a new book
    public boolean addDauSach(String tuaSach, String tomTat, int sl, int maNN, int maVT, List<Integer> tacGiaIds) {
        DauSachModel dauSach = new DauSachModel(0, tuaSach, tomTat, sl, maNN, maVT);
        try {
            int maSach = dauSachRepository.addDauSach(dauSach); // Get the generated book ID
            for (int maTG : tacGiaIds) {
                sachTacGiaRepository.addSachTacGia(new SachTacGiaModel(maSach, maTG));
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to update an existing book
    public boolean updateDauSach(int maSach, String tuaSach, String tomTat, int sl, int maNN, int maVT, List<Integer> tacGiaIds) {
        DauSachModel dauSach = new DauSachModel(maSach, tuaSach, tomTat, sl, maNN, maVT);
        try {
            dauSachRepository.updateDauSach(dauSach);
            sachTacGiaRepository.deleteSachTacGiaByMaSach(maSach);
            for (int maTG : tacGiaIds) {
                sachTacGiaRepository.addSachTacGia(new SachTacGiaModel(maSach, maTG));
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete a book by MaSach
    public boolean deleteDauSach(int maSach) {
        try {
            dauSachRepository.deleteDauSach(maSach);
            sachTacGiaRepository.deleteSachTacGiaByMaSach(maSach);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to get a book by MaSach
    public DauSachModel getDauSachById(int maSach) {
        try {
            return dauSachRepository.getDauSachById(maSach);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to get all books
    public List<DauSachModel> getAllDauSach() {
        try {
            return dauSachRepository.getAllDauSach();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to populate JTable with books data
    public void populateDauSachTable(JTable tableDauSach) {
        List<DauSachModel> dauSachList = getAllDauSach();
        DefaultTableModel tableModel = (DefaultTableModel) tableDauSach.getModel();
        tableModel.setRowCount(0); // Clear existing rows
        for (DauSachModel ds : dauSachList) {
            tableModel.addRow(new Object[]{ds.getMaSach(), ds.getTuaSach(), ds.getTomTat(), ds.getSl(), ds.getMaNN(), ds.getMaVT()});
        }
    }

    // Method to get authors by book ID
    public List<TacGiaModel> getTacGiaByDauSachId(int dauSachId) {
        try {
            return tacGiaRepository.getTacGiaByDauSachId(dauSachId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
