package bookstore.model;


public class DocGiaModel {
    private String maDG;
    private String tenDG;
    private String dienThoai;
    private String ngayHetHan;

    // Constructor
    public DocGiaModel(String maDG, String tenDG, String dienThoai, String ngayHetHan) {
        this.maDG = maDG;
        this.tenDG = tenDG;
        this.dienThoai = dienThoai;
        this.ngayHetHan = ngayHetHan;
    }

    // Getters and setters
    public String getMaDG() {
        return maDG;
    }

    public void setMaDG(String maDG) {
        this.maDG = maDG;
    }

    public String getTenDG() {
        return tenDG;
    }

    public void setTenDG(String tenDG) {
        this.tenDG = tenDG;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }
}
