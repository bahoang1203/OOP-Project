package OP;

public class ChiTietHoaDon {
	String MaHoaDon;
	String MaChiTiet;
	String MaHang;
	float Tien;
	int SoLuong;

	public String getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public String getMaChiTiet() {
		return MaChiTiet;
	}
	public void setMaChiTiet(String maChiTiet) {
		MaChiTiet = maChiTiet;
	}
	public String getMaHang() {
		return MaHang;
	}
	public void setMaHang(String maHang) {
		MaHang = maHang;
	}
	public float getTien() {
		return Tien;
	}
	public void setTien(float tien) {
		Tien = tien;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public ChiTietHoaDon(String maChiTiet, String maHoaDon, String maHang, int soLuong, float tien) {
		super();
		MaHoaDon = maHoaDon;
		MaChiTiet = maChiTiet;
		MaHang = maHang;
		Tien = tien;
		SoLuong = soLuong;
	}
	public ChiTietHoaDon() {
		
	}

	public void xuat() {
		System.out.println("Mã chi tiết hóa đơn: "+getMaChiTiet()
		+"\tMã hóa đơn:"+getMaHoaDon()
		+"\tMã hàng: "+getMaHang()
		+"\tSố lượng: "+getSoLuong()
		+"\tTổng tiền: "+getTien());
	}
}
