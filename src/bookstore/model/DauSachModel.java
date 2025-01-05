package bookstore.model;


public class DauSachModel {
    private String maSach;
    private String tuaSach;
    private String tacGia;
    private String tomTat;

    // Constructor
    public DauSachModel(String maSach, String tuaSach, String tacGia, String tomTat) {
        this.maSach = maSach;
        this.tuaSach = tuaSach;
        this.tacGia = tacGia;
        this.tomTat = tomTat;
    }

    // Getters and setters
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTuaSach() {
        return tuaSach;
    }

    public void setTuaSach(String tuaSach) {
        this.tuaSach = tuaSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTomTat() {
        return tomTat;
    }

    public void setTomTat(String tomTat) {
        this.tomTat = tomTat;
    }
}
