package bookstore.controller;

import bookstore.model.SachTacGiaModel;
import bookstore.model.TacGiaModel;
import bookstore.repository.TacGiaRepository;
import bookstore.repository.SachTacGiaRepository;

import java.util.List;

public class TacGiaController {

    private TacGiaRepository tacGiaRepository;
    private SachTacGiaRepository sachTacGiaRepository;

    public TacGiaController() {
        tacGiaRepository = new TacGiaRepository();
        sachTacGiaRepository = new SachTacGiaRepository();
    }

    // Thêm tác giả mới
    public int addTacGia(String tenTG, String diaChiTG) {
        TacGiaModel tacGia = new TacGiaModel(0, tenTG, diaChiTG);
        try {
            return tacGiaRepository.addTacGia(tacGia);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Cập nhật thông tin tác giả
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

    // Xóa tác giả
    public boolean deleteTacGia(int maTacGia) {
        try {
            sachTacGiaRepository.deleteSachTacGiaByMaTacGia(maTacGia); // Xóa quan hệ
            tacGiaRepository.deleteTacGia(maTacGia); // Xóa tác giả
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
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

    // Lấy tác giả theo mã
    public TacGiaModel getTacGiaById(int maTG) {
        try {
            return tacGiaRepository.getTacGiaById(maTG);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
