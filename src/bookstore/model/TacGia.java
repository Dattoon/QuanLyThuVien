package bookstore.model;

public class TacGia {
	private String maTG;
	private String tenTG;
	private String diaChiTG;

	// Constructor
	public TacGia(String maTG, String tenTG, String diaChiTG) {
		this.maTG = maTG;
		this.tenTG = tenTG;
		this.diaChiTG = diaChiTG;
	}

	// Getters and Setters
	public String getMaTG() {
		return maTG;
	}

	public void setMaTG(String maTG) {
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
