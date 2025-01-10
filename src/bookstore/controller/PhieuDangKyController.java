package bookstore.controller;

import bookstore.model.PhieuDangKyModel;
import bookstore.repository.PhieuDangKyRepository;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class PhieuDangKyController {

    private PhieuDangKyRepository phieuDangKyRepository;

    public PhieuDangKyController() {
        phieuDangKyRepository = new PhieuDangKyRepository();
    }

    public void registerPhieuDangKy(int maDocGia, Date ngayDK) {
        PhieuDangKyModel phieuDangKy = new PhieuDangKyModel(0, maDocGia, ngayDK);
        try {
            phieuDangKyRepository.addPhieuDangKy(phieuDangKy);
            JOptionPane.showMessageDialog(null, "Đăng ký phiếu thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình đăng ký phiếu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePhieuDangKy(int maDK, int maDocGia, Date ngayDK) {
        PhieuDangKyModel phieuDangKy = new PhieuDangKyModel(maDK, maDocGia, ngayDK);
        try {
            phieuDangKyRepository.updatePhieuDangKy(phieuDangKy);
            JOptionPane.showMessageDialog(null, "Cập nhật phiếu thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình cập nhật phiếu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deletePhieuDangKy(int maDK) {
        try {
            phieuDangKyRepository.deletePhieuDangKy(maDK);
            JOptionPane.showMessageDialog(null, "Xóa phiếu thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình xóa phiếu.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<PhieuDangKyModel> getAllPhieuDangKy() throws SQLException {
        return phieuDangKyRepository.getAllPhieuDangKy();
    }
}
