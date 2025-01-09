package bookstore.controller;

import bookstore.model.DauSachModel;
import bookstore.model.TacGiaModel;
import bookstore.repository.DauSachRepository;
import bookstore.repository.SachTacGiaRepository;
import bookstore.repository.TacGiaRepository;
import java.util.List;

public class DauSachController {

    private DauSachRepository dauSachRepository;
    private SachTacGiaRepository dauSachTacGiaRepository;
    private TacGiaRepository tacGiaRepository;

    public DauSachController() {
        dauSachRepository = new DauSachRepository();
        dauSachTacGiaRepository = new SachTacGiaRepository();
        tacGiaRepository = new TacGiaRepository();
    }

    // Thêm đầu sách mới
    public int addDauSach(String tuaSach, String tomTat, int sl, int maNN, int maVT, List<Integer> maTacGiaList) {
        DauSachModel dauSach = new DauSachModel(0, tuaSach, tomTat, sl, maNN, maVT);
        try {
            int maSach = dauSachRepository.addDauSach(dauSach);
            for (int maTacGia : maTacGiaList) {
                dauSachTacGiaRepository.addSachTacGia(maSach, maTacGia);
            }
            return maSach;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Cập nhật đầu sách
    public boolean updateDauSach(int maSach, String tuaSach, String tomTat, int sl, int maNN, int maVT, List<Integer> maTacGiaList) {
        DauSachModel dauSach = new DauSachModel(maSach, tuaSach, tomTat, sl, maNN, maVT);
        try {
            dauSachRepository.updateDauSach(dauSach);
            dauSachTacGiaRepository.deleteSachTacGiaByMaSach(maSach);
            for (int maTacGia : maTacGiaList) {
                dauSachTacGiaRepository.addSachTacGia(maSach, maTacGia);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa đầu sách
    public boolean deleteDauSach(int maSach) {
        try {
            dauSachRepository.deleteDauSach(maSach);
            dauSachTacGiaRepository.deleteSachTacGiaByMaSach(maSach);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy đầu sách theo mã
    public DauSachModel getDauSachById(int maSach) {
        try {
            return dauSachRepository.getDauSachById(maSach);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Lấy tất cả đầu sách
    public List<DauSachModel> getAllDauSach() {
        try {
            return dauSachRepository.getAllDauSach();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Lấy tác giả theo đầu sách
    public List<TacGiaModel> getTacGiaByDauSachId(int maSach) {
        try {
            return tacGiaRepository.getTacGiaByDauSachId(maSach);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
