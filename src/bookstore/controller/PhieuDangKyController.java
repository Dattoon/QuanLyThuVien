package bookstore.controller;

import bookstore.model.PhieuDangKyModel;
import bookstore.repository.DocGiaRepository;
import bookstore.repository.PhieuDangKyRepository;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class PhieuDangKyController {

    private PhieuDangKyRepository phieuDangKyRepository;
    private DocGiaRepository docGiaRepository;

    public PhieuDangKyController() {
        phieuDangKyRepository = new PhieuDangKyRepository();
        docGiaRepository = new DocGiaRepository();
    }

    public void registerPhieuDangKy(String maThe, Date ngayDK) {
        try {
            int maDG = docGiaRepository.getMaDGByMaThe(maThe);
            PhieuDangKyModel phieuDangKy = new PhieuDangKyModel(0, maDG, ngayDK);
            phieuDangKyRepository.addPhieuDangKy(phieuDangKy);
            JOptionPane.showMessageDialog(null, "Đăng ký mượn sách thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình đăng ký mượn sách.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public PhieuDangKyModel getPhieuDangKyById(int maDK) {
        try {
            return phieuDangKyRepository.getPhieuDangKyById(maDK);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<PhieuDangKyModel> getAllPhieuDangKy() {
        try {
            return phieuDangKyRepository.getAllPhieuDangKy();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deletePhieuDangKy(int maDK) {
        try {
            phieuDangKyRepository.deletePhieuDangKy(maDK);
            JOptionPane.showMessageDialog(null, "Xóa phiếu đăng ký thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình xóa phiếu đăng ký.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
