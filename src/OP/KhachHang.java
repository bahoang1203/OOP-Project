package OP;

import java.util.Scanner;

public class KhachHang {
	Scanner sc = new Scanner(System.in);
	private String MaKhachHang;
	private String TenKhachHang;
	private String SDT;
	private String DiaChi;
	public KhachHang(String maKhachHang, String tenKhachHang, String sDT, String diaChi) {
		MaKhachHang = maKhachHang;
		TenKhachHang = tenKhachHang;
		SDT = sDT;
		DiaChi = diaChi;
	}
	public KhachHang() {
		// TODO Auto-generated constructor stub
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
	public String toString() {
		return MaKhachHang+";"+TenKhachHang+";"+SDT+";"+DiaChi;
	}
	public void nhapTT() {
		// TODO Auto-generated method stub
		
		System.out.print("Nhap Ma Khach Hang: ");
		setMaKhachHang(sc.nextLine());
		System.out.print("Nhap Ten Khach Hang: ");
		setTenKhachHang(sc.nextLine());
		System.out.print("Nhap Dia Chi: ");
		setDiaChi(sc.nextLine());
		System.out.print("Nhap SDT: ");
		setSDT(sc.nextLine());
	}
	public void xuatTT() {
		System.out.println(String.format("|%-5s|%-20s|%-15s|%-15s|",MaKhachHang,TenKhachHang,SDT,DiaChi));
	}
}
