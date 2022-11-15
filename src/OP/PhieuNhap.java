package OP;

public class PhieuNhap {
	int MaPhieuNhap;
	int MaKho;
	int MaHang;
	int SoLuong;
	public PhieuNhap(int maPhieuNhap, int maKho, int maHang, int soLuong) {
		super();
		MaPhieuNhap = maPhieuNhap;
		MaKho = maKho;
		MaHang = maHang;
		SoLuong = soLuong;
	}
	public int getMaPhieuNhap() {
		return MaPhieuNhap;
	}
	public void setMaPhieuNhap(int maPhieuNhap) {
		MaPhieuNhap = maPhieuNhap;
	}
	public int getMaKho() {
		return MaKho;
	}
	public void setMaKho(int maKho) {
		MaKho = maKho;
	}
	public int getMaHang() {
		return MaHang;
	}
	public void setMaHang(int maHang) {
		MaHang = maHang;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
}
