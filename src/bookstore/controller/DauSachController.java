package bookstore.controller;

import bookstore.model.DauSachModel;
import bookstore.model.TacGiaModel;
import bookstore.model.ViTriModel;
import bookstore.repository.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DauSachController {

    private final DauSachRepository dauSachRepository;
    private final SachTacGiaRepository sachTacGiaRepository;
    private final TacGiaRepository tacGiaRepository;
    private final NgonNguRepository ngonNguRepository;
    private final ViTriRepository viTriRepository;

    public DauSachController() {
        this.dauSachRepository = new DauSachRepository();
        this.sachTacGiaRepository = new SachTacGiaRepository();
        this.tacGiaRepository = new TacGiaRepository();
        this.ngonNguRepository = new NgonNguRepository();
        this.viTriRepository = new ViTriRepository();
    }

    public int addDauSach(String tuaSach, String tomTat, int soLuong, int maNN, int maVT, List<Integer> maTacGiaList) {
        try {
            DauSachModel dauSach = new DauSachModel(0, tuaSach, tomTat, soLuong, maNN, maVT);
            int maSach = dauSachRepository.addDauSach(dauSach);

            // Liên kết sách với tác giả
            for (int maTacGia : maTacGiaList) {
                sachTacGiaRepository.addSachTacGia(maSach, maTacGia);
            }
            return maSach;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean updateDauSach(int maSach, String tuaSach, String tomTat, int soLuong, int maNN, int maVT, List<Integer> maTacGiaList) {
        try {
            DauSachModel dauSach = new DauSachModel(maSach, tuaSach, tomTat, soLuong, maNN, maVT);
            dauSachRepository.updateDauSach(dauSach);

            // Cập nhật liên kết sách - tác giả
            sachTacGiaRepository.deleteSachTacGiaByMaSach(maSach);
            for (int maTacGia : maTacGiaList) {
                sachTacGiaRepository.addSachTacGia(maSach, maTacGia);
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteDauSach(int maSach) {
        try {
            sachTacGiaRepository.deleteSachTacGiaByMaSach(maSach);
            dauSachRepository.deleteDauSach(maSach);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<DauSachModel> getAllDauSach() {
        try {
            return dauSachRepository.getAllDauSach();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<TacGiaModel> getTacGiaByDauSachId(int maSach) {
        try {
            return tacGiaRepository.getTacGiaByDauSachId(maSach);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<String> getAllNgonNguNames() throws SQLException {
        return ngonNguRepository.getAllNgonNguNames();
    }

    public String getTenNgonNgu(int maNN) {
        try {
            return ngonNguRepository.getTenNgonNguById(maNN);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getTenViTri(int maVT) {
        try {
            ViTriModel viTri = viTriRepository.getViTriById(maVT);
            if (viTri != null) {
                return String.format("Khu: %s, Kệ: %s, Ngăn: %s", viTri.getKhu(), viTri.getKe(), viTri.getNgan());
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getAllViTri() throws SQLException {
        List<ViTriModel> viTriModels = viTriRepository.getAllViTri();
        return viTriModels.stream()
                .map(vt -> String.format("Khu: %s, Kệ: %s, Ngăn: %s", vt.getKhu(), vt.getKe(), vt.getNgan()))
                .collect(Collectors.toList());
    }

    public List<String> getAllTacGiaNames() {
        try {
            return tacGiaRepository.getAllTacGia()
                    .stream()
                    .map(TacGiaModel::getTenTG)
                    .collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
