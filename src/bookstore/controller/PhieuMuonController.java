package bookstore.controller;

import bookstore.model.PhieuMuonModel;
import bookstore.repository.PhieuMuonRepository;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class PhieuMuonController {

    private PhieuMuonRepository phieuMuonRepository;

    public PhieuMuonController() {
        phieuMuonRepository = new PhieuMuonRepository();
    }

    public void createPhieuMuon(int maDG, Date ngayMuon) {
        Date ngayHetHan = calculateExpiryDate(ngayMuon);
        PhieuMuonModel phieuMuon = new PhieuMuonModel(0, ngayMuon, ngayHetHan, maDG);
        try {
            phieuMuonRepository.addPhieuMuon(phieuMuon);
            JOptionPane.showMessageDialog(null, "Tạo phiếu mượn thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình tạo phiếu mượn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePhieuMuon(int maMuon, int maDG, Date ngayMuon) {
        Date ngayHetHan = calculateExpiryDate(ngayMuon);
        PhieuMuonModel phieuMuon = new PhieuMuonModel(maMuon, ngayMuon, ngayHetHan, maDG);
        try {
            phieuMuonRepository.updatePhieuMuon(phieuMuon);
            JOptionPane.showMessageDialog(null, "Cập nhật phiếu mượn thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình cập nhật phiếu mượn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public PhieuMuonModel getPhieuMuonById(int maMuon) {
        try {
            return phieuMuonRepository.getPhieuMuonById(maMuon);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<PhieuMuonModel> getAllPhieuMuon() {
        try {
            return phieuMuonRepository.getAllPhieuMuon();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deletePhieuMuon(int maMuon) {
        try {
            phieuMuonRepository.deletePhieuMuon(maMuon);
            JOptionPane.showMessageDialog(null, "Xóa phiếu mượn thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình xóa phiếu mượn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Date calculateExpiryDate(Date ngayMuon) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ngayMuon);
        calendar.add(Calendar.DAY_OF_YEAR, 14);
        return new Date(calendar.getTimeInMillis());
    }
}
