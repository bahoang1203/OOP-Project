package ChucNang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

import OP.ChiTietHoaDon;
import OP.HangHoa;
import OP.HoaDon;

public class QuanLyHoaDon extends ChucNangHoaDon {
	private HoaDon[] dshd = Main.getListhd();
	private ChiTietHoaDon[] dscthd = Main.getListcthd();
	Scanner sc = new Scanner(System.in);
	QuanLyHangHoa qlhh = new QuanLyHangHoa();
	QuanLyPhieuNhap qlpn = new QuanLyPhieuNhap();
	
	public void menu() {
		loadchitiethoadon();
		loadhoadon();
		boolean flag = true;
		if (dshd == null) {
			System.out.println("**Danh sách trống, bạn có muốn mua 1 món hàng bất kỳ không?"
								+"\n1.Có\t2.Không"
								+"\n1.Yes\t2.No");
			int luachon = Integer.parseInt(sc.nextLine());
			while(luachon<1 || luachon>2) {
				System.out.println("Xin hãy chọn giữa 1 và 2");
				luachon = Integer.parseInt(sc.nextLine());
			}
			if(luachon==1) {
				muahang();
				Main.setListhd(dshd);
				Main.setListcthd(dscthd);
			}
		}
		else {
			while (flag == true) {
				System.out.println("+-------------------------+\n" 
								 + "|MENU                     |\n" 
								 + "+-------------------------+");
				System.out.println("|1.Mua hàng.              |\n" 
								 + "|2.Xuất danh sách hóa đơn.|\n" 
								 + "|3.Xem chi tiết hóa đơn   |\n"
								 + "|4.Thoát                  |\n"
								 + "+-------------------------+");
				System.out.print("-->Chọn chức năng: ");
				int chon = Integer.parseInt(sc.nextLine());
				switch (chon) {
				case 1:
					qlhh.xuat();
					muahang();
					break;
				case 2:
					xuathd();
					break;
				case 3:
					xuatcthd();
					break;
				case 4:
					flag = false;
					break;
				default:
					System.out.println("\nXin hãy chọn lại!");
					break;
				}
			}
		}
		Main.setListhd(dshd);
		Main.setListcthd(dscthd);
		ghicthd();
		ghihd();
	}
	
	@Override
	public void loadhoadon() {
		try {
			FileReader fr = new FileReader("file/hoadon.txt");
			BufferedReader br = new BufferedReader(fr);
			int n = Integer.parseInt(br.readLine());
			dshd = new HoaDon[n];
			String str;
			for (int i = 0; i < dshd.length; i++) {
				str = br.readLine();
				if (str == null) {
					break;
				}
				var tmp = str.split(";");
				dshd[i] = new HoaDon(tmp[0], tmp[1], tmp[2], tmp[3],Float.parseFloat(tmp[4]));
			}
			Main.setListhd(dshd);
			br.close();
			fr.close();
		} catch (Exception e) {

		}
	}
	
	@Override
	public void loadchitiethoadon() {
		try {
			FileReader fr = new FileReader("file/chitiethoadon.txt");
			BufferedReader br = new BufferedReader(fr);
			int n = Integer.parseInt(br.readLine());
			dscthd = new ChiTietHoaDon[n];
			String str;
			for (int i = 0; i < dscthd.length; i++) {
				str = br.readLine();
				if (str == null) {
					break;
				}
				var tmp = str.split(";");
				dscthd[i] = new ChiTietHoaDon(tmp[0], tmp[1], tmp[2], Integer.parseInt(tmp[3]),Float.parseFloat(tmp[4]));
			}
			Main.setListcthd(dscthd);
			br.close();
			fr.close();
		} catch (Exception e) {

		}
	}

	//danh sách hóa đơn
	@Override
	public void xuathd() {
		System.out.println("+-------------------------------------------------+\n"
						 + "|              DANH SACH HOA DON                  |\n" 
						 + "+-----+-----+-----+---------------+---------------+\n"
						 + "|MANV |MAHD |MAKH |   NGAYLAP     |   THANHTIEN   |\n"
						 + "+-----+-----+-----+---------------+---------------+");
		for (HoaDon hd : dshd) {
			hd.xuat();
		}
		System.out.println("+-------------------------------------------------+\n");
	}
	
	//xem chi tiết hóa đơn
	public void xemcthd(String mahd) {
		System.out.println("+--------------------------------------------+\n"
						 + "|         DANH SACH CHI TIET HOA DON         |\n" 
						 + "+------+-----+-----+---------+---------------+\n"
						 + "|MACTHD|MAHD |MAHD | SOLUONG |   THANHTIEN   |\n"
						 + "+------+-----+-----+---------+---------------+");
		for (ChiTietHoaDon cthd : dscthd) {
			if(cthd.getMaHoaDon().equalsIgnoreCase(mahd)) {
				cthd.xuat();
			}
		}
		System.out.println("+--------------------------------------------+\n");
	}
	
	//danh sách chi tiết hóa đơn
	@Override
	public void xuatcthd(){
		System.out.println("---------------------------------------------------");
		xuathd();
		System.out.println("---------------------------------------------------");
		System.out.print("Hãy nhập mã hóa đơn muốn xem chi tiết: ");
		String mahd = sc.nextLine().toUpperCase();
		xemcthd(mahd);
	}
	
	public float tinhtien(int sl, float tien) {
		return sl*tien;
	}
	
	@Override
	public void muahang() {
		int n = 1;
		int m = 1;
		
		if(dshd!=null) {
			n = dshd.length+1;
			
		}
		if(dscthd!=null) {
			m = dscthd.length+1;
		}
		
		HoaDon listhd = new HoaDon();
		//tự động set
		String mahd = "HD"+n;
		listhd.setMaHoaDon(mahd);
		String ngay = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		listhd.setNgayLap(ngay);

		System.out.print("Nhập mã nhân viên đang thực hiện thanh toán: ");
		String manv = sc.nextLine();
		listhd.setMaNV(manv);
		System.out.print("Nhập mã khách hàng: ");
		String makh = sc.nextLine();
		listhd.setMaKhachHang(makh);
		float tongtien=0;
		
		boolean flag = true;
		for(;;){
			if(flag == true){
				ChiTietHoaDon listcthd = new ChiTietHoaDon();
				String macthd = "CTHD"+m;
				System.out.print("Nhập mã hàng của món hàng muốn mua: ");
				String mahang = sc.nextLine();	
				System.out.print("Nhập số lượng: ");
				int soluong = Integer.parseInt(sc.nextLine());
				float tien = tinhtien(soluong, qlhh.timgiatien(mahang));
				
				listcthd.setMaChiTiet(macthd);
				listcthd.setMaHoaDon(mahd);
				listcthd.setMaHang(mahang);
				boolean fg = true;
				while(fg) {
					if(qlpn.giamsoluong(soluong, mahang)) {
						listcthd.setSoLuong(soluong);
						fg = false;
						break;
					}
					else {
						System.out.println("::Số lượng hàng không đủ, xin hãy giảm số lượng cần mua xuống!::");
						System.out.println("Nhập lại số lượng:");
						soluong = Integer.parseInt(sc.nextLine());
					}
					
				}
					
				listcthd.setTien(tien);
				if(dscthd==null) {
					dscthd = new ChiTietHoaDon[m];
					dscthd[0] = listcthd;
				}
				else {
					dscthd = Arrays.copyOf(dscthd, dscthd.length + 1);
					dscthd[dscthd.length - 1] = listcthd;
				}
				
				
				tongtien+=tien;
				System.out.println("**Bạn muốn mua thêm món hàng nào khác không?");
				System.out.println("1.Có\t2.không"+"\n1.Yes\t2.No");
				int choice = Integer.parseInt(sc.nextLine());
				while(choice<1 || choice >2){
					System.out.println("Mời chọn lại giữa 1 và 2:");
					choice = Integer.parseInt(sc.nextLine());
				}
				if(choice == 1){
					m++;
				}
				if (choice == 2){
					listhd.setThanhTien(tongtien);
					flag=false;
				}
			}
			else{
				break;
			}		
		}
		if(dshd==null) {
			dshd = new HoaDon[n];
			dshd[0] = listhd;
		}
		else {
			dshd = Arrays.copyOf(dshd, dshd.length + 1);
			dshd[dshd.length - 1] = listhd;
		}
		
		xuathd();
	}
	
	@Override
	public void ghihd() {
		try {
			FileWriter fw = new FileWriter("file/hoadon.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(dshd.length + "");
			bw.newLine();
			for (HoaDon hd : dshd) {
				bw.write(hd.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void ghicthd() {
		try {
			FileWriter fw = new FileWriter("file/chitiethoadon.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(dscthd.length + "");
			bw.newLine();
			for (ChiTietHoaDon cthd : dscthd) {
				bw.write(cthd.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
}
