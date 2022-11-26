package ChucNang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import OP.LoaiHang;

public class QuanLyLoaiHang implements ChucNang {
	public LoaiHang dslh[] = Main.getListlh();
	Scanner sc = new Scanner(System.in);

	public void menu() {
		System.out.println("+---------------------+");
        System.out.println("| QUAN LY LOAI HANG   |");
        System.out.println("+---------------------+");
		boolean flag = true;
		doc();
		if (dslh==null) {
			System.out.println("Danh sách đang trống");
			nhap();
			Main.setLoaiHang(dslh);
		} else {
			while(flag==true) {
				System.out.println("+--------------------+\n" 
						 		 + "|MENU                |\n" 
						 		 + "+--------------------+");
				System.out.println("|1. Thêm 1 Loại Hàng |\n" 
						 		 + "|2. Xóa 1 Loại Hàng  |\n" 
						 		 + "|3. Sửa 1 Loại Hàng  |\n"
						 		 + "|4. Xuất danh sách   |\n"
						 		 + "|5. Thoát QLHH       |\n"
						 		 + "+--------------------+");
				System.out.print("-->Chọn chức năng: ");
				int chon = Integer.parseInt(sc.nextLine());
				switch (chon) {
				case 1: them(); break;
				case 2: xoa(); break;
				case 3: sua(); break;
				case 4: xuat(); break;
				case 5: flag = false; break;
				default: System.out.println("\nxin hãy chọn lại!"); break;
				}
			}
			
		}
		Main.setLoaiHang(dslh);
		ghi();
	}
	
	boolean check(LoaiHang lh) {
		boolean flag = true;
		if (lh.getMaLoaiHang().isEmpty() || lh.getTenLoaiHang().isEmpty()) {
			System.out.println("::Xin hãy nhập đủ thông tin::");
			flag = false;
		}
		for (LoaiHang lhs: dslh) {
			if (lhs.getMaLoaiHang().equalsIgnoreCase(lh.getMaLoaiHang())) {
				System.out.println("::Bị trùng mã hàng!::");
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	@Override
	public void nhap() {
		try {
			System.out.println("-->Nhập số phần tử muốn thêm vào: ");
			int n = Integer.parseInt(sc.nextLine());
			dslh = new LoaiHang[n];
			for(int i=0; i<dslh.length; i++) {
				dslh[i] = new LoaiHang();
				dslh[i].themlh();
			}
		} catch (Exception e) {
			System.out.println("::Xin hãy nhập lại::");
			nhap();
		}
	}

	@Override
	public void xuat() {
		System.out.println("+--------------------------+\n"
						 + "|      DANH SACH KHO       |\n" 
						 + "+--------------------------+\n"
						 + "|MALH |    TENLOAIHANG     |\n"
						 + "+-----+--------------------+");
		for (LoaiHang lh : dslh) {
			lh.xuat();
		}
		System.out.println("+-----+--------------------+");
	}

	@Override
	public void them() {
		LoaiHang listlh = new LoaiHang();
		listlh.themlh();
		if(check(listlh)){
			dslh = Arrays.copyOf(dslh, dslh.length + 1);
			dslh[dslh.length - 1] = listlh;
		}
		else{
			System.out.println("::Xin hãy nhập lại!::");
			them();
		}
		System.out.println("**Bạn có muốn thêm tiếp (y/n)?");
		String c = sc.nextLine();
		if(c.equalsIgnoreCase("y")) them();;
		xuat();
	}

	@Override
	public void sua() {
		xuat();
		System.out.print("-->Nhập mã loại hàng cần sửa: ");
		String maloai = sc.nextLine();
		for (int i = 0; i < dslh.length; i++) {
			if (dslh[i].getMaLoaiHang().equalsIgnoreCase(maloai)) {
				System.out.print("Tên loại hàng mới: ");
				dslh[i].setTenLoaiHang(sc.nextLine());
			}
		}
		System.out.println("**Bạn có muốn sửa tiếp (y/n)?");
		String c = sc.nextLine();
		if(c.equalsIgnoreCase("y")) sua();
		xuat();
	}

	@Override
	public void xoa() {
		int i,j;
		xuat();
		System.out.print("-->Nhập mã hàng hóa cần xóa: ");
		String maloai = sc.nextLine();
		for (i = 0; i < dslh.length; i++) {
			if (dslh[i].getMaLoaiHang().equalsIgnoreCase(maloai)) {
				for (j = i; j < dslh.length - 1; j++) {
					dslh[j] = dslh[j + 1];
				}
				dslh = Arrays.copyOf(dslh, dslh.length - 1);
			}
		}
		System.out.println("**Bạn có muốn xóa tiếp (y/n)?");
		String c = sc.nextLine();
		if(c.equalsIgnoreCase("y")) xoa();
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
			int solh = Integer.parseInt(n);
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
			Main.setLoaiHang(dslh);
			br.close();
			fr.close();
		} catch (Exception e) {
		}
	}

}
