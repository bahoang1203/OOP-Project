package ChucNang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import OP.LoaiHang;

public class QuanLyLoaiHang implements ChucNang {
	private static LoaiHang dslh[];
	int solh;
	Scanner sc = new Scanner(System.in);

	public void menu() {
		boolean flag = true;
		doc();
		if (dslh.length == 0 || dslh==null) {
			nhap();
		} else {
			while(flag==true) {
				System.out.println(
						"Choose your answer:" + "\n1.Thêm loại hàng." + "\n2.Xóa loại hàng." + "\n3.Sửa loại hàng" + "\n4.Xuất danh sách loại hàng" + "\n5.Thoát");
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
					System.out.println("xin hãy chọn lại!");
					break;
				}
			}
			ghi();
		}
	}

	@Override
	public void nhap() {
		try {
			System.out.println("Nhập số phần tử muốn thêm vào:");
			int n = Integer.parseInt(sc.nextLine());
			dslh = new LoaiHang[n];
			for(int i=0; i<dslh.length; i++) {
				dslh[i] = new LoaiHang();
				dslh[i].themlh();
			}
		} catch (Exception e) {
			System.out.println("Xin hãy nhập SỐ! làm ơn!");
			nhap();
		}
	}

	@Override
	public void xuat() {
		for (LoaiHang lh : dslh) {
			lh.xuat();
		}
	}

	boolean checknhap(String maloai) {
		for (LoaiHang lh : dslh) {
			if (lh.getMaLoaiHang() == maloai) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void them() {
		LoaiHang listlh = new LoaiHang();
		listlh.themlh();
		dslh = Arrays.copyOf(dslh, dslh.length + 1);
		dslh[dslh.length - 1] = listlh;
		xuat();
	}

	@Override
	public void sua() {
		int i;
		xuat();
		System.out.print("Nhập mã loại hàng cần sửa: ");
		String maloai = sc.nextLine();
		for (i = 0; i < dslh.length; i++) {
			if (dslh[i].getMaLoaiHang().equalsIgnoreCase(maloai)) {
				System.out.print("Tên loại hàng mới: ");
				dslh[i].setTenLoaiHang(sc.nextLine());
			}
		}
		xuat();
	}

	@Override
	public void xoa() {
		int i;
		xuat();
		System.out.print("Nhập mã loại hàng cần xóa: ");
		String maloai = sc.nextLine();
		for (i = 0; i < dslh.length; i++) {
			if (dslh[i].getMaLoaiHang().equalsIgnoreCase(maloai)) {
				for (int j = i; j < dslh.length - 1; j++) {
					dslh[j] = dslh[j + 1];
				}
				dslh = Arrays.copyOf(dslh, dslh.length - 1);
			}
		}
		xuat();
	}

	@Override
	public void ghi() {
		try {
			FileWriter fw = new FileWriter("file/loaihang.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(dslh.length + "");
			bw.newLine();
			for (LoaiHang lh : dslh) {
				bw.write(lh.toString());
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
			FileReader fr = new FileReader("file/loaihang.txt");
			BufferedReader br = new BufferedReader(fr);
			var n = br.readLine();
			solh = Integer.parseInt(n);
			dslh = new LoaiHang[solh];
			String str;
			for (int i = 0; i < dslh.length; i++) {
				str = br.readLine();
				if (str == null) {
					break;
				}
				var tmp = str.split(";");
				dslh[i] = new LoaiHang();
				dslh[i].setMaLoaiHang(tmp[0]);
				dslh[i].setTenLoaiHang(tmp[1]);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		QuanLyLoaiHang lh = new QuanLyLoaiHang();
		lh.menu();
	}

}
