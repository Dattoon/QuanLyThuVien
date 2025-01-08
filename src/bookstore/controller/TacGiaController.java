package bookstore.controller;

import bookstore.model.TacGiaModel;
import bookstore.repository.TacGiaRepository;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class TacGiaController {

    private TacGiaRepository tacGiaRepository;

    public TacGiaController() {
        tacGiaRepository = new TacGiaRepository();
    }

    // Method to add a new author
    public boolean addTacGia(String tenTG, String diaChiTG) {
        TacGiaModel tacGia = new TacGiaModel(0, tenTG, diaChiTG);
        try {
            tacGiaRepository.addTacGia(tacGia);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to update an existing author
    public boolean updateTacGia(int maTG, String tenTG, String diaChiTG) {
        TacGiaModel tacGia = new TacGiaModel(maTG, tenTG, diaChiTG);
        try {
            tacGiaRepository.updateTacGia(tacGia);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to delete an author by ID
    public boolean deleteTacGia(int maTG) {
        try {
            tacGiaRepository.deleteTacGia(maTG);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to get all authors
    public List<TacGiaModel> getAllTacGia() {
        try {
            return tacGiaRepository.getAllTacGia();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to search authors by keyword
    public List<TacGiaModel> searchTacGia(String keyword) {
        try {
            return tacGiaRepository.searchTacGia(keyword);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to populate DefaultListModel with authors data
    public void populateTacGiaList(DefaultListModel<String> listModel) {
        List<TacGiaModel> tacGiaList = getAllTacGia();
        listModel.removeAllElements(); // Clear existing elements
        for (TacGiaModel tg : tacGiaList) {
            listModel.addElement(tg.getMaTG() + " - " + tg.getTenTG());
        }
    }
}
