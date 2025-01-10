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

    public void registerPhieuMuon(int maDK, Date ngayMuon) {
        Date ngayHetHan = calculateExpiryDate(ngayMuon); // Hạn là 2 tuần kể từ ngày mượn
        PhieuMuonModel phieuMuon = new PhieuMuonModel(0, ngayMuon, ngayHetHan, maDK);
        try {
            phieuMuonRepository.addPhieuMuon(phieuMuon);
            JOptionPane.showMessageDialog(null, "Đăng ký phiếu mượn thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình đăng ký phiếu mượn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePhieuMuon(int maMuon, int maDK, Date ngayMuon) {
        Date ngayHetHan = calculateExpiryDate(ngayMuon); // Hạn là 2 tuần kể từ ngày mượn
        PhieuMuonModel phieuMuon = new PhieuMuonModel(maMuon, ngayMuon, ngayHetHan, maDK);
        try {
            phieuMuonRepository.updatePhieuMuon(phieuMuon);
            JOptionPane.showMessageDialog(null, "Cập nhật phiếu mượn thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình cập nhật phiếu mượn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
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

    public List<PhieuMuonModel> getAllPhieuMuon() throws SQLException {
        return phieuMuonRepository.getAllPhieuMuon();
    }

    private Date calculateExpiryDate(Date ngayMuon) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ngayMuon);
        calendar.add(Calendar.DAY_OF_YEAR, 14); // Thêm 2 tuần
        return new Date(calendar.getTimeInMillis());
    }
}
