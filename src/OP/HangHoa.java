package OP;

public class HangHoa {
	String MaHang;
	String TenHang;
	String MaLoaiHang;
	float Gia;
	
	public HangHoa(String maHang, String tenHang, String maLoaiHang, float gia) {
		super();
		MaHang = maHang;
		TenHang = tenHang;
		MaLoaiHang = maLoaiHang;
		Gia = gia;
	}
	public String getMaHang() {
		return MaHang;
	}
	public void setMaHang(String maHang) {
		MaHang = maHang;
	}
	public String getTenHang() {
		return TenHang;
	}
	public void setTenHang(String tenHang) {
		TenHang = tenHang;
	}
	public String getMaLoaiHang() {
		return MaLoaiHang;
	}
	public void setMaLoaiHang(String maLoaiHang) {
		MaLoaiHang = maLoaiHang;
	}
	public float getGia() {
		return Gia;
	}
	public void setGia(float gia) {
		Gia = gia;
	}
	
}
