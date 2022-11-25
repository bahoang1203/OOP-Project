package ChucNang;

import java.util.Scanner;

import OP.KhachHang;
import OP.Kho;
import OP.PhieuNhap;

public class Main {
    public static Scanner sc;
    private static Kho[] khoList;
    private static KhachHang [] listkh;
    private static PhieuNhap[] phieuNhapList; 
    private static QuanLyKho QLK;
    private static QuanLyKhachHang CNKH;
    private static QuanLyPhieuNhap QLPN;
    private static QuanLyLoaiHang QLLH;
    private static QuanLyHangHoa QLHH;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        khoList = null;
        QLPN = null;

        mainMenu();
    }

    public static void mainMenu() {
        boolean flag = true;
        System.out.println("+--------------------------+\n"
                         + "|   MAIN MENU              |\n"
                         + "+--------------------------+");
        System.out.println("|1. Quan ly kho            |\n"
                         + "|2. Quan ly phieu nhap     |\n"
                         + "|3. Quan ly khach hang     |\n"
                         + "|4. Quan ly loai hang      |\n"
                         + "|5. Quan ly hang hoa	   |\n"
                         + "|6. Quan ly nhan vien      |\n"
                         + "|7. Mua hang		       |\n"
                         + "|8. Thoat                  |\n"
                         + "+--------------------------+");
        System.out.print("--> Moi ban chon: ");
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
            case 3 ->{
            	CNKH = new QuanLyKhachHang();
            	CNKH.menu();
            }
            case 4 ->{
            	QLLH = new QuanLyLoaiHang();
            	QLLH.menu();
            	}
            case 5 ->{
            	QLHH = new QuanLyHangHoa();
            	QLHH.menu();
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
    
}
