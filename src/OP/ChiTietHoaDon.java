package OP;

public class ChiTietHoaDon {
	private String MaHoaDon;
	private String MaChiTiet;
	private String MaHang;
	private float Tien;
	private int SoLuong;

	public String getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public String getMaChiTiet() {
		return MaChiTiet;
	}
	public void setMaChiTiet(String maChiTiet) {
		MaChiTiet = maChiTiet;
	}
	public String getMaHang() {
		return MaHang;
	}
	public void setMaHang(String maHang) {
		MaHang = maHang;
	}
	public float getTien() {
		return Tien;
	}
	public void setTien(float tien) {
		Tien = tien;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public ChiTietHoaDon(String maChiTiet, String maHoaDon, String maHang, int soLuong, float tien) {
		super();
		MaHoaDon = maHoaDon;
		MaChiTiet = maChiTiet;
		MaHang = maHang;
		Tien = tien;
		SoLuong = soLuong;
	}
	public ChiTietHoaDon() {
		
	}
	
	@Override
	public String toString() {
		return MaChiTiet + ";" + MaHoaDon + ";" + MaHang + ";" + SoLuong + ";" + Tien; 
	}

	public void xuat() {
		System.out.println(String.format("|%-6s|%-5s|%-5s|%-9d|%-15f|",getMaChiTiet(),getMaHoaDon(),getMaHang(),getSoLuong(),getTien()));
	}
}
