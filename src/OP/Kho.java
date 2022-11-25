package OP;

import ChucNang.Main;

public class Kho {
	private String maKho;
	private String tenKho;

	public Kho() {};
	public Kho(String maKho, String tenKho) {
		this.maKho = maKho;
		this.tenKho = tenKho;
	}

	public void setMaKho(String maKho) {
		this.maKho = maKho;
	}
	public String getMaKho() {
		return maKho;
	}
	public void setTenKho(String tenKho) {
		this.tenKho = tenKho;
	}
	public String getTenKho() {
		return tenKho;
	}


	@Override
	public String toString() {
		return maKho + ";"+ tenKho;
	}
	public void nhapTT() {
		System.out.print("Nhap ma kho: ");
		setMaKho(Main.sc.nextLine());
		System.out.print("Nhap ten kho: ");
		setTenKho(Main.sc.nextLine());
	}
	public void xuatTT() {
		System.out.println(String.format("|%-5s|%-20s|", maKho, tenKho));
	}
}
