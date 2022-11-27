package OP;

public class NhanVienBanHang extends NhanVien {
    //tiền hoa hồng tháng này
    private int soSanPhamBanRa;

    //tạo class nhân viên bán hàng
    public NhanVienBanHang() {
        super();
    }

    public NhanVienBanHang(int soSanPhamBanRa) {
        super();
        this.soSanPhamBanRa = soSanPhamBanRa;
    }

    //Tạo getter,setter cho số sản phẩm bán ra
    public int getSoSanPhamBanRa() {
        return soSanPhamBanRa;
    }
    public void setSoSanPhamBanRa(int soSanPhamBanRa) {
        this.soSanPhamBanRa = soSanPhamBanRa;
    }

    //Nhập số sản phẩm bán ra
    @Override
    public void nhapTT() {
        super.nhapTT();
        System.out.print("Tổng số sản phẩm bán ra tháng này: ");
        soSanPhamBanRa = scanner.nextInt();
    }

    //Lương cơ bản + hoa hồng
    @Override
    public float tinhLuong() {
        this.luong = this.luongCoBan + this.soSanPhamBanRa * 5000;
        return this.luong;
    }
}
