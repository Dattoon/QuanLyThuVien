package bookstore.controller;

import bookstore.model.TacGia;
import bookstore.repository.TacGiaRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

public class TacGiaController {
    private TacGiaRepository tacGiaRepository;

    public TacGiaController() {
        tacGiaRepository = new TacGiaRepository();
    }

    // Phương thức thêm tác giả vào cơ sở dữ liệu
    public boolean addTacGia(String maTG, String tenTG, String diaChiTG) {
        try {
            TacGia newTacGia = new TacGia(maTG, tenTG, diaChiTG);
            return tacGiaRepository.addTacGia(newTacGia); // Gọi repository để thêm tác giả
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Phương thức lấy danh sách tất cả tác giả từ cơ sở dữ liệu
    public List<TacGia> getAllTacGia() {
        try {
            return tacGiaRepository.getAllTacGia();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Phương thức cập nhật bảng với danh sách tác giả
    public void populateTacGiaTable(JTable table) {
        List<TacGia> tacGiaList = getAllTacGia();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa các dòng cũ trong bảng

        for (TacGia tacGia : tacGiaList) {
            model.addRow(new Object[]{tacGia.getMaTG(), tacGia.getTenTG(), tacGia.getDiaChiTG()});
        }
    }
}
