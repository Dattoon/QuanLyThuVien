package bookstore.controller;

import bookstore.model.DocGiaModel;
import bookstore.repository.DocGiaRepository;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class DocGiaController {

    private DocGiaRepository docGiaRepository;

    public DocGiaController() {
        docGiaRepository = new DocGiaRepository();
    }

    public void registerDocGia(String ten, Date ngaySinh, String diaChi, String dienThoai) {
        String maThe = generateUniqueMaThe();
        Date ngayHetHan = calculateExpiryDate(); // Hạn thẻ là 1 năm
        DocGiaModel docGia = new DocGiaModel(0, ten, ngaySinh, diaChi, dienThoai, maThe, ngayHetHan);
        try {
            docGiaRepository.addDocGia(docGia);
            JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình đăng ký.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateDocGia(int maDG, String ten, Date ngaySinh, String diaChi, String dienThoai, String maThe) {
        Date ngayHetHan = calculateExpiryDate(); // Cập nhật hạn thẻ là 1 năm
        DocGiaModel docGia = new DocGiaModel(maDG, ten, ngaySinh, diaChi, dienThoai, maThe, ngayHetHan);
        try {
            docGiaRepository.updateDocGia(docGia);
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình cập nhật.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteDocGia(int maDG) {
        try {
            docGiaRepository.deleteDocGia(maDG);
            JOptionPane.showMessageDialog(null, "Xóa thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra trong quá trình xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<DocGiaModel> getAllDocGia() throws SQLException {
        return docGiaRepository.getAllDocGia();
    }

    public DocGiaModel getDocGiaByMaThe(String maThe) throws SQLException {
        return docGiaRepository.getDocGiaByMaThe(maThe);
    }

    private String generateUniqueMaThe() {
        String maThe;
        do {
            maThe = generateMaThe();
        } while (isMaTheExists(maThe));
        return maThe;
    }

    private String generateMaThe() {
        Random random = new Random();
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(letters.charAt(random.nextInt(letters.length())));
        }
        for (int i = 0; i < 7; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private boolean isMaTheExists(String maThe) {
        try {
            return docGiaRepository.getDocGiaByMaThe(maThe) != null;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Date calculateExpiryDate() {
        long millis = System.currentTimeMillis() + (365L * 24 * 60 * 60 * 1000); // 1 năm
        return new Date(millis);
    }
}
