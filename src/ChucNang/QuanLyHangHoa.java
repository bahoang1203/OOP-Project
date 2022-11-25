package ChucNang;

import java.util.Scanner;

import OP.HangHoa;

public class QuanLyHangHoa implements ChucNang {
	
	HangHoa dshh[];

	Scanner sc = new Scanner(System.in);

	public void menu() {
		doc();
		System.out.println("Choose your answer:" + "\n1.Thêm hàng hóa." + "\n2.Xóa hàng hóa." + "\n3.Sửa hàng hóa"+"\n4.Xuất danh sách loại hàng" + "\n5.Thoát");
		int chon = Integer.parseInt(sc.nextLine());
		switch (chon) {
		case 1:
			them();
			menu();
		case 2:
			xoa();
			menu();
		case 3:
			sua();
			menu();
		case 4:
			xuat();
			menu();
		case 5:
			break;
		default:
			System.out.println("xin hãy chọn lại!");
			menu();
		}
		ghi();
	}

	@Override
	public void nhap() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void xuat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void them() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sua() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void xoa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ghi() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doc() {
		// TODO Auto-generated method stub
		
	}

}
