package bookstore.controller;

import bookstore.model.TacGia;
import bookstore.repository.TacGiaRepository;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TacGiaController {

    private TacGiaRepository tacGiaRepository;

    public TacGiaController() {
        tacGiaRepository = new TacGiaRepository();
    }

    // Method to populate the JTable with TacGia data
    public void populateTacGiaTable(JTable table) {
        List<TacGia> tacGiaList = tacGiaRepository.getAllTacGia();
        
        // Create a DefaultTableModel with column names
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Mã Tác Giả");
        tableModel.addColumn("Tên Tác Giả");
        tableModel.addColumn("Địa Chỉ Tác Giả");

        // Add data to the table model
        for (TacGia tacGia : tacGiaList) {
            Object[] row = {tacGia.getMaTG(), tacGia.getTenTG(), tacGia.getDiaChiTG()};
            tableModel.addRow(row);
        }

        // Set the model to the JTable
        table.setModel(tableModel);
    }
}
