package OP;

public class HangHoa {
	int MaHang;
	String TenHang;
	int MaLoaiHang;
	float Gia;
	
	public HangHoa(int maHang, String tenHang, int maLoaiHang, float gia) {
		super();
		MaHang = maHang;
		TenHang = tenHang;
		MaLoaiHang = maLoaiHang;
		Gia = gia;
	}
	public int getMaHang() {
		return MaHang;
	}
	public void setMaHang(int maHang) {
		MaHang = maHang;
	}
	public String getTenHang() {
		return TenHang;
	}
	public void setTenHang(String tenHang) {
		TenHang = tenHang;
	}
	public int getMaLoaiHang() {
		return MaLoaiHang;
	}
	public void setMaLoaiHang(int maLoaiHang) {
		MaLoaiHang = maLoaiHang;
	}
	public float getGia() {
		return Gia;
	}
	public void setGia(float gia) {
		Gia = gia;
	}
	
	
}
