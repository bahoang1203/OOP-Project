package OP;

public class NhanVienThuKho extends NhanVien{
	String MaRole;
	float Luong;
	
	public NhanVienThuKho(int maNV, String tenNV, String sDT, String diaChi, String maRole, float luong) {
		super(maNV, tenNV, sDT, diaChi);
		MaRole = maRole;
		Luong = luong;
	}
	
	public String getMaRole() {
		return MaRole;
	}
	public void setMaRole(String maRole) {
		MaRole = maRole;
	}
	public float getLuong() {
		return Luong;
	}
	public void setLuong(float luong) {
		Luong = luong;
	}
}
