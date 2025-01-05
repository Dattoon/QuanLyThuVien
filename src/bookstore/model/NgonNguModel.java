package bookstore.model;

public class NgonNguModel {
    private int maNN;
    private String tenNN;

    // Constructor
    public NgonNguModel(int maNN, String tenNN) {
        this.maNN = maNN;
        this.tenNN = tenNN;
    }

    // Getters and setters
    public int getMaNN() {
        return maNN;
    }

    public void setMaNN(int maNN) {
        this.maNN = maNN;
    }

    public String getTenNN() {
        return tenNN;
    }

    public void setTenNN(String tenNN) {
        this.tenNN = tenNN;
    }
}
