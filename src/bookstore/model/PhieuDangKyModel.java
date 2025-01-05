package bookstore.model;

public class PhieuDangKyModel {
    private int maDK;
    private String ngayDK;
    private int maDG;

    // Constructor
    public PhieuDangKyModel(int maDK, String ngayDK, int maDG) {
        this.maDK = maDK;
        this.ngayDK = ngayDK;
        this.maDG = maDG;
    }

    // Getters and setters
    public int getMaDK() {
        return maDK;
    }

    public void setMaDK(int maDK) {
        this.maDK = maDK;
    }

    public String getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(String ngayDK) {
        this.ngayDK = ngayDK;
    }

    public int getMaDG() {
        return maDG;
    }

    public void setMaDG(int maDG) {
        this.maDG = maDG;
    }
}
