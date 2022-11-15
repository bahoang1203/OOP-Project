package OP;

public class HoaDon {
	int MaHoaDon;
	int MaKhachHang;
	String NgayLap;
	float ThanhTien;
	 
	public HoaDon(int maHoaDon, int maKhachHang, String ngayLap, float thanhTien) {
		super();
		MaHoaDon = maHoaDon;
		MaKhachHang = maKhachHang;
		NgayLap = ngayLap;
		ThanhTien = thanhTien;
	}
	public int getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public int getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public String getNgayLap() {
		return NgayLap;
	}
	public void setNgayLap(String ngayLap) {
		NgayLap = ngayLap;
	}
	public float getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(float thanhTien) {
		ThanhTien = thanhTien;
	}
	
}
