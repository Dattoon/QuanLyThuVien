package bookstore.model;

public class SachTacGiaModel {
    private int maSach;
    private int maTG;

    // Constructor
    public SachTacGiaModel(int maSach, int maTG) {
        this.maSach = maSach;
        this.maTG = maTG;
    }

    // Getters and setters
    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public int getMaTG() {
        return maTG;
    }

    public void setMaTG(int maTG) {
        this.maTG = maTG;
    }
}
