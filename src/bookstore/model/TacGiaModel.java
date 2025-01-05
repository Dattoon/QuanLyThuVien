package bookstore.model;

public class TacGiaModel {
    private int maTG;
    private String tenTG;
    private String diaChiTG;

    // Constructor
    public TacGiaModel(int maTG, String tenTG, String diaChiTG) {
        this.maTG = maTG;
        this.tenTG = tenTG;
        this.diaChiTG = diaChiTG;
    }

    // Getters and setters
    public int getMaTG() {
        return maTG;
    }

    public void setMaTG(int maTG) {
        this.maTG = maTG;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public String getDiaChiTG() {
        return diaChiTG;
    }

    public void setDiaChiTG(String diaChiTG) {
        this.diaChiTG = diaChiTG;
    }
}




