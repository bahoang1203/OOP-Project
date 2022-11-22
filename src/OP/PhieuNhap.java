package OP;

public class PhieuNhap {
	String MaPhieuNhap;
	String MaKho;
	String MaHang;
	String MaNV;
	String MaNCC;
	int SoLuong;
	public PhieuNhap(String maPhieuNhap, String maKho, String maHang, String maNV, String maNCC, int soLuong) {
		super();
		MaPhieuNhap = maPhieuNhap;
		MaKho = maKho;
		MaHang = maHang;
		MaNV = maNV;
		MaNCC = maNCC;
		SoLuong = soLuong;
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getMaNCC() {
		return MaNCC;
	}
	public void setMaNCC(String maNCC) {
		MaNCC = maNCC;
	}
	public String getMaPhieuNhap() {
		return MaPhieuNhap;
	}
	public void setMaPhieuNhap(String maPhieuNhap) {
		MaPhieuNhap = maPhieuNhap;
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
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
}
