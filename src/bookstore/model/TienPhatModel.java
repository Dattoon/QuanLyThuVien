package bookstore.model;

public class TienPhatModel {
    private int maChiTiet;
    private float tienPhat;

    // Constructor
    public TienPhatModel(int maChiTiet, float tienPhat) {
        this.maChiTiet = maChiTiet;
        this.tienPhat = tienPhat;
    }

    // Getters and setters
    public int getMaChiTiet() {
        return maChiTiet;
    }

    public void setMaChiTiet(int maChiTiet) {
        this.maChiTiet = maChiTiet;
    }

    public float getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(float tienPhat) {
        this.tienPhat = tienPhat;
    }
}
