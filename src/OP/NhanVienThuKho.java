package OP;

public class NhanVienThuKho extends NhanVien {
    //Số giờ tăng ca
    private int soGioTangCa;

    //tạo class nhân viên thủ kho
    public NhanVienThuKho() {
        super();
    }

    public NhanVienThuKho(int soGioTangCa) {
        super();
        this.soGioTangCa = soGioTangCa;
    }

    //Tạo getter, setter cho số giờ tăng ca
    public int getSoGioTangCa() {
        return soGioTangCa;
    }

    public void setSoGioTangCa(int soGioTangCa) {
        this.soGioTangCa = soGioTangCa;
    }

    //Nhập số giờ tăng ca
    @Override
    public void nhapTT() {
        super.nhapTT();
        System.out.print("Tổng số giờ tăng ca tháng này: ");
        soGioTangCa = scanner.nextInt();
    }

    //Tính lương của nhân viên theo số giờ tăng ca
    @Override
    public float tinhLuong() {
        this.luong = this.luongCoBan + this.soGioTangCa * 10000;
        return this.luong;
    }

    //In ra số giờ tăng ca và tiền lương của nhân viên thủ kho
    @Override
    public String toString() {
        return super.toString() + "\n, tổng số giờ tăng ca tháng này " + this.soGioTangCa + ", lương: " + this.luong;
    }
}
