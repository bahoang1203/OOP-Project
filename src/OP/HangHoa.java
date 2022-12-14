package OP;

import java.util.Scanner;

import ChucNang.QuanLyLoaiHang;

public class HangHoa {
	private String MaHang;
	private String TenHang;
	private String MaLoaiHang;
	float Gia;
	public HangHoa(String maHang, String tenHang, String maLoaiHang, float gia) {
		super();
		MaHang = maHang;
		TenHang = tenHang;
		MaLoaiHang = maLoaiHang;
		Gia = gia;
	}
	public HangHoa() {
		// TODO Auto-generated constructor stub
	}
	public String getMaHang() {
		return MaHang;
	}
	public void setMaHang(String maHang) {
		MaHang = maHang;
	}
	public String getTenHang() {
		return TenHang;
	}
	public void setTenHang(String tenHang) {
		TenHang = tenHang;
	}
	public String getMaLoaiHang() {
		return MaLoaiHang;
	}
	public void setMaLoaiHang(String maLoaiHang) {
		MaLoaiHang = maLoaiHang;
	}
	public float getGia() {
		return Gia;
	}
	public void setGia(float gia) {
		Gia = gia;
	}

	public void xuat() {
		System.out.println(String.format("|%-5s|%-20s|%-15s|%-15s|",MaHang,TenHang,MaLoaiHang,Gia));
	}
	
	public void themhh() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã hàng hóa:");
		setMaHang(sc.nextLine().toUpperCase());
		System.out.println("Tên hàng hóa:");
		setTenHang(sc.nextLine());
		QuanLyLoaiHang qlLoaiHang = new QuanLyLoaiHang();
		System.out.println("--------------------------------------------");
		qlLoaiHang.xuat();
		System.out.println("--------------------------------------------");
		System.out.println("Mã loại hàng:");
		setMaLoaiHang(sc.nextLine().toUpperCase());
		System.out.println("Giá tiền:");
		String tien = sc.nextLine();
		if(tien.length()==0 || tien==null) {
			setGia(0);
		}else {
			setGia(Float.parseFloat(tien));
		}
	}
	
	@Override
	public String toString() {
		return MaHang + ";" + TenHang + ";" + MaLoaiHang + ";" + Gia;
	}
	
}
