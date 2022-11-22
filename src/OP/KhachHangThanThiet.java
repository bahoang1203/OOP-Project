package OP;

public class KhachHangThanThiet {
	String MaKhachHang;
	String TenKhachHang;
	String SDT;
	String DiaChi;
	public KhachHangThanThiet(String maKhachHang, String tenKhachHang, String sDT, String diaChi) {
		super();
		MaKhachHang = maKhachHang;
		TenKhachHang = tenKhachHang;
		SDT = sDT;
		DiaChi = diaChi;
	}
	public String getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
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
