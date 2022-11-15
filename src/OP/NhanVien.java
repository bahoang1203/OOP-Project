package OP;

public class NhanVien {
	int MaNV;
	String TenNV;
	String SDT;
	String DiaChi;
	public int getMaNV() {
		return MaNV;
	}
	public void setMaNV(int maNV) {
		MaNV = maNV;
	}
	public String getTenNV() {
		return TenNV;
	}
	public void setTenNV(String tenNV) {
		TenNV = tenNV;
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
	public NhanVien(int maNV, String tenNV, String sDT, String diaChi) {
		super();
		MaNV = maNV;
		TenNV = tenNV;
		SDT = sDT;
		DiaChi = diaChi;
	}
	
}
