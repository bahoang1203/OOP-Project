package OP;

public class LoaiHang {
	String MaLoaiHang;
	String TenLoaiHang;
	public LoaiHang(String maLoaiHang, String tenLoaiHang) {
		super();
		MaLoaiHang = maLoaiHang;
		TenLoaiHang = tenLoaiHang;
	}
	public String getMaLoaiHang() {
		return MaLoaiHang;
	}
	public void setMaLoaiHang(String maLoaiHang) {
		MaLoaiHang = maLoaiHang;
	}
	public String getTenLoaiHang() {
		return TenLoaiHang;
	}
	public void setTenLoaiHang(String tenLoaiHang) {
		TenLoaiHang = tenLoaiHang;
	}
}
