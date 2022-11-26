package OP;

import java.util.Scanner;

public class NhaCungCap {
	Scanner sc = new Scanner(System.in);
	String MaCC;
	String TenCC;
	String SDT;
	String DiaChi;
	public NhaCungCap(String maCC, String tenCC, String sDT, String diaChi) {
		super();
		MaCC = maCC;
		TenCC = tenCC;
		SDT = sDT;
		DiaChi = diaChi;
	}
	public NhaCungCap() {
		// TODO Auto-generated constructor stub
	}
	public String getMaCC() {
		return MaCC;
	}
	public void setMaCC(String maCC) {
		MaCC = maCC;
	}
	public String getTenCC() {
		return TenCC;
	}
	public void setTenCC(String tenCC) {
		TenCC = tenCC;
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
		return MaCC+";"+TenCC+";"+SDT+";"+DiaChi;
	}
	public void nhapTT() {
		System.out.print("Nhap ma nha cung cap: ");
		setMaCC(sc.nextLine());
		System.out.print("Nhap ten nha cung cap: ");
		setTenCC(sc.nextLine());
		System.out.print("Nhap SDT: ");
		setSDT(sc.nextLine());
		System.out.print("Nhap DiaChi: ");
		setDiaChi(sc.nextLine());
	}
	public void xuatTT() {
		System.out.println(String.format("|%-5s|%-20s|%-15s|%-15s|",MaCC,TenCC,SDT,DiaChi));
	}
}
