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

    public void registerChiTietPhieuMuon(int maMuon, int maSach, Date ngayTra) {
        ChiTietPhieuMuonModel chiTietPhieuMuon = new ChiTietPhieuMuonModel(0, maMuon, maSach, ngayTra);
        try {
            chiTietPhieuMuonRepository.addChiTietPhieuMuon(chiTietPhieuMuon);
            JOptionPane.showMessageDialog(null, "Đăng ký chi tiết phiếu mượn thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình đăng ký chi tiết phiếu mượn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateChiTietPhieuMuon(int maChiTiet, int maMuon, int maSach, Date ngayTra) {
        ChiTietPhieuMuonModel chiTietPhieuMuon = new ChiTietPhieuMuonModel(maChiTiet, maMuon, maSach, ngayTra);
        try {
            chiTietPhieuMuonRepository.updateChiTietPhieuMuon(chiTietPhieuMuon);
            JOptionPane.showMessageDialog(null, "Cập nhật chi tiết phiếu mượn thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình cập nhật chi tiết phiếu mượn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
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

    public List<ChiTietPhieuMuonModel> getAllChiTietPhieuMuon() throws SQLException {
        return chiTietPhieuMuonRepository.getAllChiTietPhieuMuon();
    }

    public List<ChiTietPhieuMuonModel> getChiTietPhieuMuonByMaMuon(int maMuon) throws SQLException {
        return chiTietPhieuMuonRepository.getChiTietPhieuMuonByMaMuon(maMuon);
    }
}
