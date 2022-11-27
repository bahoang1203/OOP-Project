package OP;

import ChucNang.Main;

public class PhieuNhap {
	private String maPhieuNhap;
	private String maKho;
	private String maHang;
	private String maNV;
	private String maNCC;
	private int soLuong;

	public PhieuNhap() {};
	public PhieuNhap(String maPhieuNhap, String maKho, String maHang, String maNV, String maNCC, int soLuong) {
		this.maPhieuNhap = maPhieuNhap;
		this.maKho = maKho;
		this.maHang = maHang;
		this.maNV = maNV;
		this.maNCC = maNCC;
		this.soLuong = soLuong;
	}
	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}
	public String getMaPhieuNhap() {
		return maPhieuNhap;
	}
	public void setMaKho(String maKho) {
		this.maKho = maKho;
	}
	public String getMaKho() {
		return maKho;
	}
	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}
	public String getMaHang() {
		return maHang;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	public String getMaNCC() {
		return maNCC;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getSoLuong() {
		return soLuong;
	}
	@Override
	public String toString() {
		return maPhieuNhap + ";" + maKho + ";" + maHang + ";" + maNV + ";" + maNCC + ";" + soLuong;
	}
	public void nhapTT() {
		System.out.print("Nhap ma phieu nhap: ");
		setMaPhieuNhap(Main.sc.nextLine());
		System.out.print("Nhap ma kho: ");
		setMaKho(Main.sc.nextLine());
		System.out.print("Nhap ma hang: ");
		setMaHang(Main.sc.nextLine());
		System.out.print("Nhap ma nhan vien: ");
		setMaNV(Main.sc.nextLine());
		System.out.print("Nhap ma nha cung cap: ");
		setMaNCC(Main.sc.nextLine());
		System.out.print("Nhap so luong: ");
		setSoLuong(Integer.parseInt(Main.sc.nextLine()));
	}

	public void xuatTT() {
		System.out.println(String.format("|%-7s|%-5s|%-6s|%-5s|%-5s|%6d|", maPhieuNhap, maKho, maHang, maNV, maNCC, soLuong));	
	}
}
