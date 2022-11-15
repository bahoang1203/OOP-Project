package OP;

public class NhaCungCap {
	int MaCC;
	String TenCC;
	String SDT;
	String DiaChi;
	public NhaCungCap(int maCC, String tenCC, String sDT, String diaChi) {
		super();
		MaCC = maCC;
		TenCC = tenCC;
		SDT = sDT;
		DiaChi = diaChi;
	}
	public int getMaCC() {
		return MaCC;
	}
	public void setMaCC(int maCC) {
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
}
