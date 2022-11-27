package ChucNang;

import java.util.Scanner;

import OP.ChiTietHoaDon;
import OP.HangHoa;
import OP.HoaDon;
import OP.KhachHang;
import OP.Kho;
import OP.PhieuNhap;
import OP.LoaiHang;
import OP.NhaCungCap;
import OP.NhanVien;

public class Main {
    public static Scanner sc;
    private static Kho[] khoList;
    private static KhachHang [] listkh;
    private static PhieuNhap[] phieuNhapList;
    private static HangHoa[] listhh;
    private static LoaiHang[] listlh;
    private static HoaDon[] listhd;
    private static ChiTietHoaDon[] listcthd;
    private static NhaCungCap[] listncc;
    private static NhanVien[] listnv;

	private static QuanLyKho QLK;
    private static QuanLyKhachHang CNKH;
    private static QuanLyPhieuNhap QLPN;
    private static QuanLyLoaiHang QLLH;
    private static QuanLyHangHoa QLHH;
    private static QuanLyHoaDon QLHD;
    private static QuanLyNhaCungCap QLNCC;
    private static QuanLyNhanVien QLNV;
    
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        khoList = null;
        QLPN = null;
        listhh = null;
        listlh = null;
        listhd = null;
        listcthd = null;
        mainMenu();
    }

    public static void mainMenu() {
        boolean flag = true;
        System.out.println("+--------------------------+\n"
                         + "|   MAIN MENU              |\n"
                         + "+--------------------------+");
        System.out.println("|1. Quản lý kho            |\n"
                         + "|2. Quản lý phiếu nhập     |\n"
                         + "|3. Quản lý nhân viên      |\n"
                         + "|4. Quản lý khách hàng     |\n"
                         + "|5. Quản lý nhà cung cấp   |\n"
                         + "|6. Quản lý loại hàng      |\n"
                         + "|7. Quản lý hàng hóa	   |\n"
                         + "|8. Quản lý hóa đơn        |\n"
                         + "|   và mua hàng            |\n"
                         + "|9. Thoát                  |\n"
                         + "+--------------------------+");
        System.out.print("--> Mời bạn chọn: ");
        int c = Integer.parseInt(sc.nextLine());
        switch (c) {
            case 1 -> {
                QLK = new QuanLyKho();
                QLK.menu();
            }
            case 2 -> {
                QLPN = new QuanLyPhieuNhap();
                QLPN.menu();
            }
            case 3 -> {
            	QLNV = new QuanLyNhanVien();
            	QLNV.menu();
            }
            case 4 ->{
            	CNKH = new QuanLyKhachHang();
            	CNKH.menu();
            }
            case 5 ->{
            	QLNCC = new QuanLyNhaCungCap();
            	QLNCC.menu();
            }
            case 6 ->{
            	QLLH = new QuanLyLoaiHang();
            	QLLH.menu();
            	}
            case 7 ->{
            	QLLH = new QuanLyLoaiHang();
                QLLH.doc();
            	QLHH = new QuanLyHangHoa();
            	QLHH.menu();
            	}
            case 8->{
            	QLHH = new QuanLyHangHoa();
            	QLHH.doc();
            	QLLH = new QuanLyLoaiHang();
                QLLH.doc();
                QLPN = new QuanLyPhieuNhap();
                QLPN.doc();
            	QLHD = new QuanLyHoaDon();
            	QLHD.menu();
            	}

            default -> flag = false;
        }
        if (flag == true) {
            mainMenu();
        }
    }

    public static void setKhoList(Kho[] khoList) {
        Main.khoList = khoList;
    }
    public static Kho[] getKhoList() {
        return khoList;
    }
    public static void setPhieuNhapList(PhieuNhap[] phieuNhapList) {
        Main.phieuNhapList = phieuNhapList;
    }
    public static PhieuNhap[] getPhieuNhapList() {
        return phieuNhapList;
    }

	public static KhachHang[] getListkh() {
		return listkh;
	}

	public static void setListkh(KhachHang[] listkh) {
		Main.listkh = listkh;
	}
	
	public static void setHangHoaList(HangHoa[] hangHoa) {
		Main.listhh = hangHoa;
	}
	
	public static HangHoa[] getListhh() {
		return listhh;
	}
	
	public static void setLoaiHang(LoaiHang[] loaiHang) {
	    Main.listlh = loaiHang;
	}

    public static LoaiHang[] getListlh(){
        return listlh;
    }
    
    public static void setListhd(HoaDon[] hoaDon) {
    	Main.listhd = hoaDon;
    }
    
    public static HoaDon[] getListhd() {
    	return listhd;
    }
    
    public static void setListcthd(ChiTietHoaDon[] cthoaDon) {
    	Main.listcthd = cthoaDon;
    }
    
    public static ChiTietHoaDon[] getListcthd() {
    	return listcthd;
    }

	public static NhaCungCap[] getListncc() {
		return listncc;
	}

	public static void setListncc(NhaCungCap[] listncc) {
		Main.listncc = listncc;
	}
	public static NhanVien[] getListnv() {
		return listnv;
	}

	public static void setListnv(NhanVien[] listnv) {
		Main.listnv = listnv;
	}
}
