package OP;

public class LoaiHang {
	int MaLoaiHang;
	String TenLoaiHang;
	public LoaiHang(int maLoaiHang, String tenLoaiHang) {
		super();
		MaLoaiHang = maLoaiHang;
		TenLoaiHang = tenLoaiHang;
	}
	public int getMaLoaiHang() {
		return MaLoaiHang;
	}
	public void setMaLoaiHang(int maLoaiHang) {
		MaLoaiHang = maLoaiHang;
	}
	public String getTenLoaiHang() {
		return TenLoaiHang;
	}
	public void setTenLoaiHang(String tenLoaiHang) {
		TenLoaiHang = tenLoaiHang;
	}
}
