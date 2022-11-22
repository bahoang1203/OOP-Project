package OP;

public class ChiTietKho {
	String MaKho;
	String MaHang;
	String SoLuong;
	public ChiTietKho(String maKho, String maHang, String soLuong) {
		super();
		MaKho = maKho;
		MaHang = maHang;
		SoLuong = soLuong;
	}
	public String getMaKho() {
		return MaKho;
	}
	public void setMaKho(String maKho) {
		MaKho = maKho;
	}
	public String getMaHang() {
		return MaHang;
	}
	public void setMaHang(String maHang) {
		MaHang = maHang;
	}
	public String getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(String soLuong) {
		SoLuong = soLuong;
	}
}
