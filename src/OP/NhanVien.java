package OP;

import java.util.Scanner;

public class NhanVien {
    String maNhanVien, hoTen, soDienThoai, diaChi;
    float luong;
    protected float luongCoBan;
    Scanner scanner = new Scanner(System.in);

    public NhanVien() {
        super();
    }
	public NhanVien(String maNhanVien, String hoTen, String soDienThoai, String diaChi, float luong, float luongCoBan) {
        super();
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.luong = luong;
        this.luongCoBan = luongCoBan;
    }

    //getter, setter cho Mã nhân viên
    public String getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    ////getter, setter cho Họ tên
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    ////getter, setter cho Số điện thoại
    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    ////getter, setter cho Địa chỉ
    public String getdiaChi() {
        return diaChi;
    }
    public void setdiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    ////getter, setter cho Lương
    public float getLuong() {
        return luong;
    }
    public void setLuong(float luong) {
        this.luong = luong;
    }

    ////getter, setter cho Lương cơ bản
    public float getLuongCoBan() {
        return luongCoBan;
    }
    public void setLuongCoBan(float luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

	public String toString() {
		return maNhanVien+";"+hoTen+";"+soDienThoai+";"+diaChi+";"+luong+";"+luongCoBan;
	}

    //Tạo hàm nhập dữ liệu nhân viên
    public void nhapTT() {
        System.out.print("Nhập mã nhân viên: ");
        maNhanVien = scanner.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        hoTen = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        soDienThoai = scanner.nextLine();
        System.out.print("Nhập địa chỉ nhân viên: ");
        diaChi = scanner.nextLine();
        System.out.print("Nhập lương cơ bản: ");
        luongCoBan = scanner.nextFloat();
    }

    //Tạo hàm tính lương
    public float tinhLuong() {
        return 0;
    }

	public void xuatTT() {
		System.out.println(String.format("|%-6s|%-20s|%-15s|%-15s|%-15s|",maNhanVien,hoTen,soDienThoai,diaChi,luong));
	}
}