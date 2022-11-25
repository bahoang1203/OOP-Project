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
import OP.HoaDon;

public class QuanLyHoaDon extends ChucNangHoaDon {
	int sohd;
	int socthd;
	private static HoaDon dshd[];
	private static ChiTietHoaDon dscthd[];
	Scanner sc = new Scanner(System.in);
	
	public void loadhoadon() {
		try {
			// đọc file
			FileReader fr = new FileReader("file/hoadon.txt");
			BufferedReader br = new BufferedReader(fr);
			var n = br.readLine();
			sohd = Integer.parseInt(n);
			dshd = new HoaDon[sohd];
			String str;
			for (int i = 0; i < dshd.length; i++) {
				str = br.readLine();
				if (str == null) {
					break;
				}
				var tmp = str.split(";");
				dshd[i] = new HoaDon();
				dshd[i].setMaHoaDon(tmp[0]);
				dshd[i].setMaNV((tmp[1]));
				dshd[i].setMaKhachHang(tmp[2]);
				dshd[i].setNgayLap(tmp[3]);
				dshd[i].setThanhTien(Float.parseFloat(tmp[4]));
			}
			xuatdshoadon();
			br.close();
			fr.close();
		} catch (Exception e) {
		}
	}

	public void loadchitiethoadon() {
		try {
			// đọc file
			FileReader fr = new FileReader("file/chitiethoadon.txt");
			BufferedReader br = new BufferedReader(fr);
			var n = br.readLine();
			socthd = Integer.parseInt(n);
			dscthd = new ChiTietHoaDon[socthd];
			String str;
			for(int i = 0; i < dscthd.length; i++){
				str = br.readLine();
				if(str == null){
					break;
				}
				var tmp = str.split(";");
				dscthd[i] = new ChiTietHoaDon();			
				dscthd[i].setMaChiTiet(tmp[0]);
				dscthd[i].setMaHoaDon(tmp[1]);
				dscthd[i].setMaHang(tmp[2]);
				dscthd[i].setSoLuong(Integer.parseInt(tmp[3]));
				dscthd[i].setTien(Float.parseFloat(tmp[4]));
			}
			br.close();
			fr.close();
		} catch (Exception e) {
		}
	}

	//danh sách hóa đơn
	public void xuatdshoadon() {
		System.out.println("Danh sách hóa đơn");
		for (HoaDon hd : dshd) {
			hd.xuat();
		}
	}

	//danh sách chi tiết hóa đơn
	public void xuatdschitiethoadon(String mahd) {
		System.out.println("Chi tiết hóa đơn");
		for (ChiTietHoaDon cthd : dscthd) {
			if(cthd.getMaHoaDon()==mahd) {
				cthd.xuat();
			}
		}
	}
	
	public void muahang() {
		ChiTietHoaDon cthd = new ChiTietHoaDon();
		int n = sohd;
		int m = socthd;
		dshd[n+1] = new HoaDon();
		dscthd[m+1] = new ChiTietHoaDon();

		//tự động set
		String mahd = "HD"+n;
		dshd[n].setMaHoaDon(mahd);
		String matchd = "CTHD"+m;
		dscthd[m].setMaHoaDon(matchd);
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
		try {
			FileWriter fw = new FileWriter("file/hoadon.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sohd+"");
			bw.newLine();
			
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void ghi() {
		dshd = new HoaDon[2];
		dshd[0] = new HoaDon("HD1", "NV1", "KH1", "24/11/2022", 40000f);
		dshd[1] = new HoaDon("HD2", "NV1", "KH1", "24/11/2022", 40000f);

		// ghi file
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

	public static void main(String[] args) {
		QuanLyHoaDon qlhd = new QuanLyHoaDon();
		qlhd.loadhoadon();
		qlhd.loadchitiethoadon();
	}

}
