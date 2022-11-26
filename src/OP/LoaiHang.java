package OP;

import java.util.Scanner;

import ChucNang.Main;

public class LoaiHang {
	String MaLoaiHang;
	String TenLoaiHang;
	public LoaiHang(String maLoaiHang, String tenLoaiHang) {
		super();
		MaLoaiHang = maLoaiHang;
		TenLoaiHang = tenLoaiHang;
	}
	public LoaiHang() {

	}

	public String getMaLoaiHang() {
		return MaLoaiHang;
	}
	public void setMaLoaiHang(String maLoaiHang) {
		MaLoaiHang = maLoaiHang;
	}
	public String getTenLoaiHang() {
		return TenLoaiHang;
	}
	public void setTenLoaiHang(String tenLoaiHang) {
		TenLoaiHang = tenLoaiHang;
	}
	
	@Override
	public String toString() {
		return MaLoaiHang + ";" + TenLoaiHang;
	}
	
	public void themlh() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã loại:");
		setMaLoaiHang(sc.nextLine().toUpperCase());
		System.out.println("Tên loại hàng:");
		setTenLoaiHang(sc.nextLine());
	}
	
	public void xuat() {
		System.out.println(String.format("|%-5s|%-20s|", MaLoaiHang, TenLoaiHang));
	}
	
}
