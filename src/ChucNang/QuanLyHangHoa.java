package ChucNang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import OP.HangHoa;
import OP.LoaiHang;

public class QuanLyHangHoa implements ChucNang {
	private static HangHoa[] dshh = Main.getListhh();
	Scanner sc = new Scanner(System.in);
	QuanLyLoaiHang qllh = new QuanLyLoaiHang();

	public void menu() {
		doc();
		boolean flag = true;
		if (dshh == null) {
			System.out.println("Danh sách trống, xin hãy nhập ít nhất 1 phần tử");
			nhap();
			Main.setHangHoaList(dshh);
		}
		while (flag == true) {
			System.out.println("\nChoose your answer:" + "\n1.Thêm hàng hóa." + "\n2.Xóa hàng hóa." + "\n3.Sửa hàng hóa"
					+ "\n4.Xuất danh sách hàng hóa" + "\n5.Thoát");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				them();
				break;
			case 2:
				xoa();
				break;
			case 3:
				sua();
				break;
			case 4:
				xuat();
				break;
			case 5:
				flag = false;
				break;
			default:
				System.out.println("\nxin hãy chọn lại!");
				break;
			}
			
		}
		Main.setHangHoaList(dshh);
		ghi();
	}

	boolean check(HangHoa hh) {
		boolean flag = true;
		if (hh.getMaLoaiHang().isEmpty() || hh.getTenHang().isEmpty() || hh.getMaLoaiHang().isEmpty()) {
			System.out.println("Xin hãy nhập đủ thông tin");
			flag = false;
		}
		
		for (HangHoa hhs : dshh) {
			if (hhs.getMaHang().equalsIgnoreCase(hh.getMaHang())) {
				System.out.println("Bị trùng mã hàng!");
				flag = false;
				break;
			}
		}
		
		if(qllh.dslh!=null) {
			for (LoaiHang lh : qllh.dslh) {
				if (lh.getMaLoaiHang().equalsIgnoreCase(hh.getMaLoaiHang())) {
					break;
				}
				else {
					System.out.println("Không có mã loại hàng này, xin hãy thêm vào hoặc nhập mã loại hàng khác!");
					flag = false;
				}
			}
		}	
		return flag;
	}

	@Override
	public void nhap() {
		try {
			System.out.println("Nhập số phần tử muốn thêm vào:");
			int n = Integer.parseInt(sc.nextLine());
			dshh = new HangHoa[n];
			for (int i = 0; i < dshh.length; i++) {
				dshh[i] = new HangHoa();
				dshh[i].themhh();
			}
		} catch (Exception e) {
			System.out.println("Xin hãy nhập lại!");
			nhap();
		}
	}

	@Override
	public void xuat() {
		for (HangHoa hh : dshh) {
			hh.xuat();
		}
	}

	@Override
	public void them() {
		HangHoa listhh = new HangHoa();
		listhh.themhh();
		if(check(listhh)==true) {
			dshh = Arrays.copyOf(dshh, dshh.length + 1);
			dshh[dshh.length - 1] = listhh;
		}else {
			System.out.println("Xin hãy nhập lại!");
			them();
		}
		xuat();
	}

	@Override
	public void sua() {
		xuat();
		System.out.print("Nhập mã loại hàng cần sửa: ");
		String mahang = sc.nextLine();
		for (int i = 0; i < dshh.length; i++) {
			if (dshh[i].getMaHang().equalsIgnoreCase(mahang)) {
				System.out.print("Tên hàng hóa mới: ");
				dshh[i].setTenHang(sc.nextLine());
				System.out.print("Mã loại hàng mới: ");
				dshh[i].setMaLoaiHang(sc.nextLine());
				System.out.print("Giá tiền mới: ");
				dshh[i].setGia(Float.parseFloat(sc.nextLine()));
			}
		}
		xuat();
	}

	@Override
	public void xoa() {
		int i, j;
		xuat();
		System.out.print("Nhập mã hàng hóa cần xóa: ");
		String mahang = sc.nextLine();
		for (i = 0; i < dshh.length; i++) {
			if (dshh[i].getMaLoaiHang().equalsIgnoreCase(mahang)) {
				for (j = i; j < dshh.length - 1; j++) {
					dshh[j] = dshh[j + 1];
				}
				dshh = Arrays.copyOf(dshh, dshh.length - 1);
			}
		}
		xuat();

	}

	@Override
	public void ghi() {
		try {
			FileWriter fw = new FileWriter("file/hanghoa.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(dshh.length + "");
			bw.newLine();
			for (HangHoa hh : dshh) {
				bw.write(hh.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void doc() {
		try {
			FileReader fr = new FileReader("file/hanghoa.txt");
			BufferedReader br = new BufferedReader(fr);
			int n = Integer.parseInt(br.readLine());
			dshh = new HangHoa[n];
			String str;
			for (int i = 0; i < dshh.length; i++) {
				str = br.readLine();
				if (str == null) {
					break;
				}
				var tmp = str.split(";");
				dshh[i] = new HangHoa(tmp[0], tmp[1], tmp[2], Float.parseFloat(tmp[3]));
			}
			br.close();
			fr.close();
		} catch (Exception e) {

		}
	}

}
