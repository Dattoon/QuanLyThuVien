package bookstore.model;

public class DauSachModel {
    private int maSach;
    private String tuaSach;
    private String tomTat;
    private int sl;
    private int maNN;
    private int maVT;

    // Constructor
    public DauSachModel(int maSach, String tuaSach, String tomTat, int sl, int maNN, int maVT) {
        this.maSach = maSach;
        this.tuaSach = tuaSach;
        this.tomTat = tomTat;
        this.sl = sl;
        this.maNN = maNN;
        this.maVT = maVT;
    }

    // Getters and setters
    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTuaSach() {
        return tuaSach;
    }

    public void setTuaSach(String tuaSach) {
        this.tuaSach = tuaSach;
    }

    public String getTomTat() {
        return tomTat;
    }

    public void setTomTat(String tomTat) {
        this.tomTat = tomTat;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getMaNN() {
        return maNN;
    }

    public void setMaNN(int maNN) {
        this.maNN = maNN;
    }

    public int getMaVT() {
        return maVT;
    }

    public void setMaVT(int maVT) {
        this.maVT = maVT;
    }
}
