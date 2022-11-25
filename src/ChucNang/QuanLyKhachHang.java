package ChucNang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import OP.KhachHang;
public class QuanLyKhachHang implements ChucNang{
	Scanner sc = new Scanner(System.in);
	private String fileName="file/khachhangData.txt";
	private KhachHang[] listkh = Main.getListkh();
	QuanLyKhachHang(){
		doc();
		System.out.println("+---------------------+");
        System.out.println("|  QUAN LY KHACH HANG |");
        System.out.println("+---------------------+");
	}
	public void menu() {
        boolean flag = true;
        if (listkh == null || listkh.length == 0) {
            nhap();
        }
        else {
            System.out.println("+--------------------+\n"
                             + "|MENU                |\n"
                             + "+--------------------+");
            System.out.println("|1. Them 1 phan tu   |\n"
                             + "|2. Xoa 1 phan tu    |\n"
                             + "|3. Sua 1 phan tu    |\n"
                             + "|4. Xuat danh sach   |\n"
                             + "|5. Thoat QLKH       |\n"
                             + "+--------------------+");
            System.out.print("--> Moi ban chon: ");
            int chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1 -> them();
                case 2 -> xoa();
                case 3 -> sua();
                case 4 -> xuat();
                default -> flag = false;
            }
        }
        Main.setListkh(listkh);;
        if (flag == true) {
            System.out.println();
            menu();
        }
        ghi();
    }   
	@Override
	public void nhap() {
		// TODO Auto-generated method stub
		System.out.println("Danh sach trong!!");
        System.out.print("Ban muon them bao nhieu phan tu dau tien: ");
        int n = Integer.parseInt(Main.sc.nextLine());
        listkh = new KhachHang[n];
        for(int i =0;i<listkh.length;i++) {
        	listkh[i] = new KhachHang();
        	listkh[i].nhapTT();
        }
	}

	@Override
	public void xuat() {
		System.out.println("+--------------------------+---------------+---------------+\n"
		                 + "|                  DANH SACH KHACH HANG                    |\n" 
		                 + "+--------------------------+---------------+---------------+\n"
		                 + "|MAKH |    TENKHACHHANG    |       SDT     |     DIA CHI   |\n"
		                 + "+-----+--------------------+---------------+---------------+");
		for(KhachHang khtt : listkh) {
			khtt.xuatTT();
		}
		System.out.println("+----------------------------------------------------------+\n");
		
	}
	private boolean ktDulieu(KhachHang kh) {
		boolean flag = true;
		for(KhachHang khtt:listkh) {
			if(khtt.getMaKhachHang().equalsIgnoreCase(kh.getMaKhachHang())) {
				flag = false;
				System.out.print("**Trung Ma Khach Hang**");
				break;
			}
		}
		return flag;
	}
	@Override
	public void them() {
		KhachHang kh = new KhachHang();
		System.out.println("*Nhap du lieu cho khach hang moi*");
		kh.nhapTT();
		if(ktDulieu(kh)) {
			listkh = Arrays.copyOf(listkh, listkh.length+1);
			listkh[listkh.length-1]=kh;
		}
		System.out.print("-->Ban co muon tiep tuc them 1 phan tu (y/n)? ");
        String c = sc.nextLine();
        if (c.equalsIgnoreCase("y")) {
            them();
        }
	}

	@Override
	public void sua() {
		// TODO Auto-generated method stub
		if(listkh.length>0) {
			int i;
			boolean flag = false;
			xuat();
			System.out.print("-->Nhap ma khach hang can sua: ");
			String s = sc.nextLine();
			for(i = 0;i<listkh.length;i++) {
				if(listkh[i].getMaKhachHang().equalsIgnoreCase(s)) {
					flag = true;
					break;
				}
			}
			if(flag == true) {
				System.out.print("Nhap ten kh moi: ");
				listkh[i].setTenKhachHang(sc.nextLine());
				System.out.print("Nhap SDT moi");
				listkh[i].setSDT(sc.nextLine());
				System.out.print("Nhap dia chi moi");
				listkh[i].setDiaChi(sc.nextLine());
				
			}else {
				System.out.print("Ma khach hang khong ton tai");
			}
			System.out.print("-->Ban co can sua them (y/n");
			String c = sc.nextLine();
			if(c.equalsIgnoreCase("y")) {
				sua();
			}
		}
	}

	@Override
	public void xoa() {
		// TODO Auto-generated method stub
		if(listkh.length>0) {
			int i;
			boolean flag = false;
			xuat();
			System.out.print("-->Nhap ma khach hang can xoa");
			String s = sc.nextLine();
			for(i = 0;i<listkh.length;i++) {
				if(listkh[i].getMaKhachHang().equalsIgnoreCase(s));
				flag = true;
				break;
			}
			if(flag==true) {
				for(int j = i;j<listkh.length-1;j++) {
					listkh[j]=listkh[i+1];
				}
				listkh = Arrays.copyOf(listkh, listkh.length-1);
			}else {
				System.out.print("Ma khach hang khong ton tai");
			}
			System.out.print("-->Ban co can sua them (y/n)");
			String c = sc.nextLine();
			if(c.equalsIgnoreCase("y")) {
				xoa();
			}
		}
	}

	@Override
	public void ghi() {
		// TODO Auto-generated method stub
		try {
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(listkh.length+"");
			bw.newLine();
			for(KhachHang kh:listkh) {
				bw.write(kh.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
            System.out.println(e);
		}
		
	}

	@Override
	public void doc() {
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			int length = Integer.parseInt(br.readLine());
			listkh = new KhachHang[length];
			String read;
			for(int i=0;i<length;i++) {
				read = br.readLine();
				if(read==null) break;
				var tmp = read.split(";");
				listkh[i] = new KhachHang(tmp[0],tmp[1],tmp[2],tmp[3]);
			}
			fr.close();
			br.close();
		} catch (IOException e) {
		}
	}
}
