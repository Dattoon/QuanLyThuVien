package bookstore.model;

public class ViTriModel {
    private int maVT;
    private String khu;
    private String ke;
    private String ngan;

    // Constructor
    public ViTriModel(int maVT, String khu, String ke, String ngan) {
        this.maVT = maVT;
        this.khu = khu;
        this.ke = ke;
        this.ngan = ngan;
    }

    // Getters and setters
    public int getMaVT() {
        return maVT;
    }

    public void setMaVT(int maVT) {
        this.maVT = maVT;
    }

    public String getKhu() {
        return khu;
    }

    public void setKhu(String khu) {
        this.khu = khu;
    }

    public String getKe() {
        return ke;
    }

    public void setKe(String ke) {
        this.ke = ke;
    }

    public String getNgan() {
        return ngan;
    }

    public void setNgan(String ngan) {
        this.ngan = ngan;
    }
}
