package OP;

public class KhachHangThanThiet {
	int MaKhachHang;
	String TenKhachHang;
	String SDT;
	String DiaChi;
	public KhachHangThanThiet(int maKhachHang, String tenKhachHang, String sDT, String diaChi) {
		super();
		MaKhachHang = maKhachHang;
		TenKhachHang = tenKhachHang;
		SDT = sDT;
		DiaChi = diaChi;
	}
	public int getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return TenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
}
