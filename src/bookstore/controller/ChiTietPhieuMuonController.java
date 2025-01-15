package bookstore.controller;

import bookstore.model.ChiTietPhieuMuonModel;
import bookstore.repository.ChiTietPhieuMuonRepository;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ChiTietPhieuMuonController {

    private ChiTietPhieuMuonRepository chiTietPhieuMuonRepository;

    public ChiTietPhieuMuonController() {
        chiTietPhieuMuonRepository = new ChiTietPhieuMuonRepository();
    }

    public void createChiTietPhieuMuon(int maMuon, int maSach, Date ngayTra, float tienPhat) {
        ChiTietPhieuMuonModel chiTietPhieuMuon = new ChiTietPhieuMuonModel(0, maMuon, maSach, ngayTra, tienPhat);
        try {
            chiTietPhieuMuonRepository.addChiTietPhieuMuon(chiTietPhieuMuon);
            calculateAndUpdateFine(maMuon, ngayTra); // Calculate and update fine when creating a new loan detail
            JOptionPane.showMessageDialog(null, "Tạo chi tiết phiếu mượn thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình tạo chi tiết phiếu mượn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateChiTietPhieuMuon(int maChiTiet, int maMuon, int maSach, Date ngayTra, float tienPhat) {
        ChiTietPhieuMuonModel chiTietPhieuMuon = new ChiTietPhieuMuonModel(maChiTiet, maMuon, maSach, ngayTra, tienPhat);
        try {
            chiTietPhieuMuonRepository.updateChiTietPhieuMuon(chiTietPhieuMuon);
            calculateAndUpdateFine(maMuon, ngayTra); // Calculate and update fine when updating a loan detail
            JOptionPane.showMessageDialog(null, "Cập nhật chi tiết phiếu mượn thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình cập nhật chi tiết phiếu mượn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ChiTietPhieuMuonModel getChiTietPhieuMuonById(int maChiTiet) {
        try {
            return chiTietPhieuMuonRepository.getChiTietPhieuMuonById(maChiTiet);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ChiTietPhieuMuonModel> getAllChiTietPhieuMuon() {
        try {
            return chiTietPhieuMuonRepository.getAllChiTietPhieuMuon();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ChiTietPhieuMuonModel> getChiTietPhieuMuonByMaMuon(int maMuon) {
        try {
            return chiTietPhieuMuonRepository.getChiTietPhieuMuonByMaMuon(maMuon);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteChiTietPhieuMuon(int maChiTiet) {
        try {
            chiTietPhieuMuonRepository.deleteChiTietPhieuMuon(maChiTiet);
            JOptionPane.showMessageDialog(null, "Xóa chi tiết phiếu mượn thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình xóa chi tiết phiếu mượn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculateAndUpdateFine(int maMuon, Date ngayTra) {
        try {
            // Get the due date from phieumuon table
            Date ngayHetHan = chiTietPhieuMuonRepository.getNgayHetHan(maMuon);
            if (ngayHetHan != null && ngayTra != null) {
                long daysLate = (ngayTra.getTime() - ngayHetHan.getTime()) / (1000 * 60 * 60 * 24);
                float fineAmount = 0;
                if (daysLate > 0) {
                    fineAmount = daysLate * 2000; // Fine amount: 5000 per day after the first day
                }

                chiTietPhieuMuonRepository.updateTienPhat(maMuon, fineAmount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAllFines() {
        try {
            List<ChiTietPhieuMuonModel> allChiTietPhieuMuon = getAllChiTietPhieuMuon();
            for (ChiTietPhieuMuonModel chiTietPhieuMuon : allChiTietPhieuMuon) {
                calculateAndUpdateFine(chiTietPhieuMuon.getMaMuon(), chiTietPhieuMuon.getNgayTra());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
