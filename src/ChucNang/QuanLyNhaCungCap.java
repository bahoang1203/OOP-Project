package ChucNang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import OP.NhaCungCap;

public class QuanLyNhaCungCap implements ChucNang{
	public NhaCungCap listncc[] = Main.getListncc();;
	Scanner sc = new Scanner(System.in);
	QuanLyNhaCungCap(){
		System.out.println("+------------------------------+");
        System.out.println("|     QUAN LY NHA CUNG CAP     |");
        System.out.println("+------------------------------+");
	}
	public void menu() {
		doc();
		boolean flag= true;
		if(listncc ==null ||listncc.length==0) {
			nhap();
			
		}else {
			System.out.println("+--------------------+\n" 
							 + "|MENU                |\n" 
							 + "+--------------------+");
			System.out.println("|1. Thêm 1 NCC       |\n" 
							 + "|2. Xóa 1 NCC        |\n" 
							 + "|3. Sửa 1 NCC        |\n"
							 + "|4. Xuất danh sách   |\n"
							 + "|5. Thoát QLNCC      |\n"
							 + "+--------------------+");
			System.out.print("-->Chọn chức năng: ");
			int c = Integer.parseInt(sc.nextLine());
			switch (c) {
			case 1 -> them();
            case 2 -> xoa();
            case 3 -> sua();
            case 4 -> xuat();
            default -> flag = false;
				}
			}
		Main.setListncc(listncc);
		if (flag == true) {
			System.out.println();
            menu();
        }
		ghi();
		}
	@Override
	public void nhap() {
		// TODO Auto-generated method stub
		System.out.println("Danh đang sách trống");
		System.out.print("-->Nhập số phần tử muốn thêm vào: ");
		int n = sc.nextInt();
		listncc = new NhaCungCap[n];
		for(int i = 0 ;i<listncc.length;i++) {
			listncc[i] = new NhaCungCap();
			listncc[i].nhapTT();
		}
	}

	@Override
	public void xuat() {
		// TODO Auto-generated method stub
		System.out.println("+--------------------------+---------------+---------------+\n"
                		 + "|                  DANH SACH NHA CUNG CAP                  |\n" 
                		 + "+--------------------------+---------------+---------------+\n"
                		 + "|MANCC|    TENNHACUNGCAP   |       SDT     |     DIA CHI   |\n"
                		 + "+-----+--------------------+---------------+---------------+");
		for(NhaCungCap ncc: listncc) {
			ncc.xuatTT();
		}
		System.out.println("+----------------------------------------------------------+\n");
	}
	private boolean kiemtradulieu(NhaCungCap ncc) {
		boolean flag = true;
		if(ncc.getMaCC().isEmpty()||ncc.getTenCC().isEmpty()||ncc.getSDT().isEmpty()||ncc.getDiaChi().isEmpty()) {
			System.out.println("Hãy nhập đầy đủ thông tin");
			flag=false;
		}
		for(NhaCungCap nccplus:listncc) {
			if(nccplus.getMaCC().equalsIgnoreCase(ncc.getMaCC())) {
				System.out.println("::Trùng mã nhà cung cấp::");
				flag = false;
			}
		}
		return flag;
	}
	@Override
	public void them() {
		// TODO Auto-generated method stub
		NhaCungCap newNcc = new NhaCungCap();
		newNcc.nhapTT();
		if (kiemtradulieu(newNcc)) {
			listncc = Arrays.copyOf(listncc, listncc.length + 1);
			listncc[listncc.length - 1] = newNcc;
		}
		System.out.print("**Bạn có muốn thêm tiếp (y/n)?");
		
		String c = sc.nextLine();
		if(c.equalsIgnoreCase("y")) {
			them();
		}
	}

	@Override
	public void sua() {
		// TODO Auto-generated method stub
		xuat();
		System.out.print("-->Hãy chọn mã nhà cung cấp: ");
		String mancc = sc.nextLine();
		for(int i = 0 ;i<listncc.length;i++) {
			if(listncc[i].getMaCC().equalsIgnoreCase(mancc)) {
				System.out.print("Nhập tên nhà cung cấp mới: ");
				listncc[i].setTenCC(sc.nextLine());
				System.out.print("Nhập SDT mới: ");
				listncc[i].setSDT(sc.nextLine());
				System.out.print("Nhập dịa chỉ mới : ");
				listncc[i].setDiaChi(sc.nextLine());
			}
		}
		System.out.println("**Bạn có muốn sửa tiếp (y/n)?");
		String c = sc.nextLine();
		if(c.equalsIgnoreCase("y")) sua();
		xuat();
	}

	@Override
	public void xoa() {
		// TODO Auto-generated method stub
		int i ,j;
		xuat();
		System.out.print("-->Hãy nhập mã nhà cung cấp muốn xóa: ");
		String mancc = sc.nextLine();
		for(i=0;i<listncc.length;i++) {
			if(listncc[i].getMaCC().equalsIgnoreCase(mancc)) {
				for(j=i;j<listncc.length;j++) {
					listncc[j]=listncc[j+1];
				}
				listncc = Arrays.copyOf(listncc, listncc.length - 1);
			}else {
				System.out.println("::Mã không tồn tại::");
			}
		}
		System.out.println("**Bạn có muốn xóa tiếp (y/n)?");
		String c = sc.nextLine();
		if(c.equalsIgnoreCase("y")) xoa();
		xuat();
	}

	@Override
	public void ghi() {
		// TODO Auto-generated method stub
		
		try {
			FileWriter fw = new FileWriter("file/nhacungcap.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(listncc.length+"");
			bw.newLine();
			for(NhaCungCap ncc : listncc) {
				bw.write(ncc.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {}
		
	}

	@Override
	public void doc() {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader("file/nhacungcap.txt");
			BufferedReader br = new BufferedReader(fr);
			int length = Integer.parseInt(br.readLine());
			listncc = new NhaCungCap[length];
			String str;
			for(int i=0;i<listncc.length;i++) {
				str=br.readLine();
				if(str==null) break;
				var tmp = str.split(";");
				listncc[i] = new NhaCungCap(tmp[0],tmp[1],tmp[2],tmp[3]);
			}
			fr.close();
			br.close();
		} catch (IOException e) {}
	}

}
