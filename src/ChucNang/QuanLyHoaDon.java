package ChucNang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

import OP.ChiTietHoaDon;
import OP.HangHoa;
import OP.HoaDon;

public class QuanLyHoaDon extends ChucNangHoaDon {
	private HoaDon[] dshd = Main.getListhd();
	private ChiTietHoaDon[] dscthd = Main.getListcthd();
	Scanner sc = new Scanner(System.in);
	
	public void menu() {
		loadchitiethoadon();
		loadhoadon();
		boolean flag = true;
		if (dshd == null) {
			System.out.println("Danh sách trống, xin hãy mua 1 món hàng bất kỳ");
			muahang();
			Main.setListhd(dshd);
			Main.setListcthd(dscthd);
		}
		while (flag == true) {
			System.out.println("\nChoose your answer:" + "\n1.Mua hàng." + "\n2.Xuất danh sách hóa đơn." + "\n3.Xem chi tiết hóa đơn"
					+ "\n4.Thoát");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				flag = false;
				break;
			default:
				System.out.println("\nxin hãy chọn lại!");
				break;
			}
			
		}
		Main.setListhd(dshd);
		Main.setListcthd(dscthd);
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
			br.close();
			fr.close();
		} catch (Exception e) {

		}
	}

	//danh sách hóa đơn
	@Override
	public void xuathd() {
		System.out.println("Danh sách hóa đơn");
		for (HoaDon hd : dshd) {
			hd.xuat();
		}
	}

	//danh sách chi tiết hóa đơn
	@Override
	public void xuatcthd(String mahd){
		System.out.println("Chi tiết hóa đơn");
		for (ChiTietHoaDon cthd : dscthd) {
			if(cthd.getMaHoaDon()==mahd) {
				cthd.xuat();
			}
		}
	}
	
	@Override
	public void muahang() {
		ChiTietHoaDon listcthd = new ChiTietHoaDon();
		int n = dshd.length+1;
		int m = dscthd.length+1;
		dshd[n] = new HoaDon();
		dscthd[m] = new ChiTietHoaDon();

		//tự động set
		String mahd = "HD"+n;
		dshd[n].setMaHoaDon(mahd);
		DateFormat dtf = new SimpleDateFormat("dd/mm/yyyy");
		String ngay = dtf.format(LocalDate.now());
		dshd[n].setNgayLap(ngay);

		System.out.println("Nhập mã nhân viên đang thực hiện thanh toán:");
		String manv = sc.nextLine();
		dshd[n].setMaNV(manv);
		System.out.println("Nhập mã khách hàng:");
		String makh = sc.nextLine();
		dshd[n].setMaKhachHang(makh);

		boolean flag = true;
		for(;;){
			if(flag == true){
				String matchd = "CTHD"+m;
				dscthd[m].setMaHoaDon(matchd);
				dscthd[m].setMaHoaDon(mahd);
				System.out.println("Nhập mã hàng của món hàng muốn mua:");
				dscthd[m].setMaHang(sc.nextLine());
				System.out.println("Nhập số lượng:");
				dscthd[m].setSoLuong(Integer.parseInt(sc.nextLine()));
				System.out.println("bạn muốn mua thêm món hàng nào khác không?");
				System.out.println("1.Có\t2.không");
				int choice = Integer.parseInt(sc.nextLine());
				while(choice<1 || choice >2){
					System.out.println("mời chọn lại giữa 1 và 2:");
					choice = Integer.parseInt(sc.nextLine());
				}
				if(choice == 1){
					m=+1;
				}
				if (choice == 2){
					flag=false;
				}
			}
			else{
				break;
			}
				
		}
		ghicthd();
		ghihd();
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
