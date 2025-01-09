package bookstore.controller;

import bookstore.model.TacGiaModel;
import bookstore.repository.TacGiaRepository;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TacGiaController {
    private TacGiaRepository tacGiaRepository;

    public TacGiaController() {
        tacGiaRepository = new TacGiaRepository();
    }

    // Thêm một tác giả mới
    public boolean addTacGia(String tenTG, String diaChiTG) {
        TacGiaModel tacGia = new TacGiaModel(0, tenTG, diaChiTG);
        try {
            tacGiaRepository.addTacGia(tacGia);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật thông tin một tác giả
    public boolean updateTacGia(int maTG, String tenTG, String diaChiTG) {
        TacGiaModel tacGia = new TacGiaModel(maTG, tenTG, diaChiTG);
        try {
            tacGiaRepository.updateTacGia(tacGia);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa một tác giả
    public boolean deleteTacGia(int maTG) {
        try {
            tacGiaRepository.deleteTacGia(maTG);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy thông tin một tác giả theo mã tác giả
    public TacGiaModel getTacGiaById(int maTG) {
        try {
            return tacGiaRepository.getTacGiaById(maTG);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Lấy danh sách tất cả tác giả
    public List<TacGiaModel> getAllTacGia() {
        try {
            return tacGiaRepository.getAllTacGia();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Tìm kiếm tác giả theo từ khóa
    public List<TacGiaModel> searchTacGia(String keyword) {
        try {
            return tacGiaRepository.searchTacGia(keyword);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Đổ dữ liệu vào JTable
    public void populateTacGiaTable(JTable tableTacGia) {
        List<TacGiaModel> tacGiaList = getAllTacGia();
        DefaultTableModel tableModel = (DefaultTableModel) tableTacGia.getModel();
        tableModel.setRowCount(0); // Xóa các dòng hiện có
        for (TacGiaModel tg : tacGiaList) {
            tableModel.addRow(new Object[]{tg.getMaTG(), tg.getTenTG(), tg.getDiaChiTG()});
        }
    }
}
