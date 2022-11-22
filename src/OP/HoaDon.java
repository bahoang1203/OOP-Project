package OP;

public class HoaDon {
	String MaNV;
	String MaHoaDon;
	String MaKhachHang;
	String NgayLap;
	float ThanhTien;	 
	
	public HoaDon(String maNV, String maHoaDon, String maKhachHang, String ngayLap, float thanhTien) {
		super();
		MaNV = maNV;
		MaHoaDon = maHoaDon;
		MaKhachHang = maKhachHang;
		NgayLap = ngayLap;
		ThanhTien = thanhTien;
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public String getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
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
