package bookstore.controller;

import bookstore.model.PhieuMuonModel;
import bookstore.repository.PhieuMuonRepository;
import bookstore.repository.DauSachRepository;
import bookstore.repository.DocGiaRepository;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class PhieuMuonController {
    private DauSachRepository dauSachRepository;
    private PhieuMuonRepository phieuMuonRepository;
    private DocGiaRepository docGiaRepository;

    public PhieuMuonController() {
        dauSachRepository = new DauSachRepository();
        phieuMuonRepository = new PhieuMuonRepository();
        docGiaRepository = new DocGiaRepository();
    }

    public void createPhieuMuon(String maThe, int maSach) {
        Date ngayMuon = Date.valueOf(LocalDate.now()); // Lấy ngày mượn là ngày hiện tại
        Date ngayHetHan = calculateExpiryDate(ngayMuon);
        try {
            int maDG = docGiaRepository.getMaDGByMaThe(maThe); // Lấy MaDG từ MaThe
            PhieuMuonModel phieuMuon = new PhieuMuonModel(0, ngayMuon, ngayHetHan, maDG, maSach);
            phieuMuonRepository.addPhieuMuon(phieuMuon);
            
            // Giảm số lượng sách
            dauSachRepository.decrementSL(maSach);
            
            JOptionPane.showMessageDialog(null, "Tạo phiếu mượn thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình tạo phiếu mượn.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePhieuMuon(int maMuon, String maThe, int maSach) {
        Date ngayMuon = Date.valueOf(LocalDate.now()); // Lấy ngày mượn là ngày hiện tại
        Date ngayHetHan = calculateExpiryDate(ngayMuon);
        try {
            int maDG = docGiaRepository.getMaDGByMaThe(maThe); // Lấy MaDG từ MaThe
            PhieuMuonModel phieuMuon = new PhieuMuonModel(maMuon, ngayMuon, ngayHetHan, maDG, maSach);
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

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(calendar.getTime());

        return Date.valueOf(formattedDate);
    }
    
    public String getTenDGByMaDG(int maDG) {
        try {
            return docGiaRepository.getTenDGByMaDG(maDG);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getTuaSachByMaSach(int maSach) {
        try {
            return dauSachRepository.getTuaSachByMaSach(maSach);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
