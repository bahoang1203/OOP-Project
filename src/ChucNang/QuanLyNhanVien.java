package ChucNang;

import java.io.IOException;
import java.io.BufferedReader;//doc ghi file
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;//mang
import java.util.Scanner;//nhap tu ban phim
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import OP.KhachHang;
import OP.NhanVien;
import OP.NhanVienBanHang;
import OP.NhanVienThuKho;

public class QuanLyNhanVien implements ChucNang {
    Scanner sc = new Scanner(System.in);
	private String fileName="file/nhanvienData.txt";
	private NhanVien[] listnv = Main.getListnv();
	QuanLyNhanVien(){
		doc();
		System.out.println("+---------------------+");
        System.out.println("|  QUAN LY NHAN VIEN  |");
        System.out.println("+---------------------+");
	}
    public void menu() {
        boolean flag = true;
        if (listnv == null || listnv.length == 0) {
            nhap();
        }
        else {
            System.out.println("+---------------------------+\n"
                             + "|           MENU            |\n"
                             + "+---------------------------+");
            System.out.println("|1. Thêm 1 nhân viên        |\n" 
					 		 + "|2. Xóa 1 nhân viên         |\n" 
					 		 + "|3. Sửa 1 nhân viên         |\n"
					 		 + "|4. Xuất danh sách nhân viên|\n"
					 		 + "|5. Tìm kiếm theo mã        |\n"
					 		 + "|6. Tìm kiếm tên gần đúng   |\n"
					 		 + "|7. Thoát QLNV              |\n"
					 		 + "+---------------------------+");
            System.out.print("-->Chọn chức năng: ");
            int chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1 -> them();
                case 2 -> xoa();
                case 3 -> sua();
                case 4 -> xuat();
                case 5 -> timkiemtheoma();
                case 6 -> timkiemtheotengandung(); 
                default -> flag = false;
            }
        }
        Main.setListnv(listnv);;
        if (flag == true) {
            System.out.println();
            menu();
        }
        ghi();
    }

    //Nhap
    @Override
    public void nhap() {
        //Nhap so luong nhan vien
		System.out.println("Danh sách đang trống!!");
        System.out.print("-->Nhập số nhân viên muốn thêm vào: ");
        int n = Integer.parseInt(Main.sc.nextLine());
        listnv = new NhanVien[n]; //mang so luong nhan vien

        //Nhap thong tin nhan vien
        System.out.println("Enter employee information.");
        for(int i =0;i<listnv.length;i++) {
            System.out.println("Employee " + (i + 1) + ":");
            //Chọn role cho nhân viên
            System.out.print("Choose role of employee:");
            System.out.println("\n1.Sale employee\n2.Store employee");
            int maRole = Integer.parseInt(sc.nextLine());
            if (maRole == 1) {
                listnv[i] = new NhanVienBanHang();
            } else if (maRole == 2) {
                listnv[i] = new NhanVienThuKho();
            }

            listnv[i].nhapTT();
            listnv[i].tinhLuong();
        }   	
    }

    //Xuat
    @Override
	public void xuat() {
		System.out.println("+---------------------------+---------------+---------------+---------------+\n"
		                 + "|                             DANH SACH NHAN VIEN                           |\n" 
		                 + "+---------------------------+---------------+---------------+---------------+\n"
		                 + "| MANV |    TENNHANVIEN     |       SDT     |     DIA CHI   |     LUONG     |\n"
		                 + "+------+--------------------+---------------+---------------+---------------+");
		for (NhanVien ttnv : listnv) {
		    ttnv.xuatTT();
		}
		System.out.println("+---------------------------------------------------------------------------+\n");
		
	}

    private boolean ktDulieu(NhanVien nv) {
		boolean flag = true;
		for(NhanVien ttnv:listnv) {
			if(ttnv.getMaNhanVien().equalsIgnoreCase(nv.getMaNhanVien())) {
				flag = false;
				System.out.print("::Trùng mã nhân viên::");
				break;
			}
		}
		return flag;
	}

    //Them
    @Override
	public void them() {
		NhanVien nv = new NhanVien();
		System.out.println("*Them du lieu cho nhan vien moi*");
		nv.nhapTT();
		if(ktDulieu(nv)) {
			listnv = Arrays.copyOf(listnv, listnv.length+1);
			listnv[listnv.length-1]=nv;
		}
		System.out.print("**Bạn có muốn thêm tiếp (y/n)?");
        String c = sc.nextLine();
        if (c.equalsIgnoreCase("y")) {
            them();
        }
	}

    //Sua
    @Override
	public void sua() {
		// TODO Auto-generated method stub
		if(listnv.length>0) {
			int i;
			boolean flag = false;
			xuat();
			System.out.print("-->Hãy nhập mã nhân viên muốn sửa: ");
			String s = sc.nextLine();
			for(i = 0;i<listnv.length;i++) {
				if(listnv[i].getMaNhanVien().equalsIgnoreCase(s)) {
					flag = true;
					break;
				}
			}
			if(flag == true) {
				System.out.print("Nhập tên nhân viên mới: ");
				listnv[i].setHoTen(sc.nextLine());
				System.out.print("Nhập SDT mới");
				listnv[i].setSoDienThoai(sc.nextLine());
				System.out.print("Nhập địa chỉ mới");
				listnv[i].setdiaChi(sc.nextLine());
				
			}else {
				System.out.print("::Mã nhân viên không tồn tại::");
			}
			System.out.print("-->Ban co can sua them (y/n");
			String c = sc.nextLine();
			if(c.equalsIgnoreCase("y")) {
				sua();
			}
		}
	}

    //Xoa
    @Override
	public void xoa() {
		// TODO Auto-generated method stub
		if(listnv.length>0) {
            int i;
			boolean flag = false;
			xuat();
			System.out.print("-->Hãy nhập mã khách hàng muốn xóa: ");
			String s = sc.nextLine();
			for (i=0;i<listnv.length;i++) {
				if(listnv[i].getMaNhanVien().equalsIgnoreCase(s));
				flag = true;
				break;
			}
			if(flag==true) {
				for(int j = i;j<listnv.length-1;j++) {
					listnv[j]=listnv[i+1];
				}
				listnv = Arrays.copyOf(listnv, listnv.length-1);
			}else {
				System.out.print("::Mã nhân viên không tồn tại::");
			}
			System.out.println("**Bạn có muốn xóa tiếp (y/n)?");
			String c = sc.nextLine();
			if(c.equalsIgnoreCase("y")) {
				xoa();
			}
		}
	}

    //ghi
    @Override
	public void ghi() {
		// TODO Auto-generated method stub
		try {
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(listnv.length+"");
			bw.newLine();
			for(NhanVien nv:listnv) {
				bw.write(nv.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (Exception e) {
            System.out.println("Co loi xay ra: "+e);
            e.printStackTrace();
		}
		
	}

    //doc
	@Override
	public void doc() {
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			int length = Integer.parseInt(br.readLine());
			listnv = new NhanVien[length];
			String read;
			for(int i=0;i<length;i++) {
				read = br.readLine();
				if(read==null) break;
				var tmp = read.split(";");
                //lỗi ở đây (hết lỗi rồi nè :v)
				listnv[i] = new NhanVien(tmp[0],tmp[1],tmp[2],tmp[3],Float.parseFloat(tmp[4]),Float.parseFloat(tmp[5]));
			}
			fr.close();
			br.close();
		} catch (Exception e) {}
	}
	@Override
	public void timkiemtheoma() {
		// TODO Auto-generated method stub
		xuat();
		System.out.print("-->Nhập mã nhân viên cần tìm: ");
		String find = sc.nextLine();
		for(NhanVien nv: listnv) {
			if(nv.getMaNhanVien().matches(find)) {
				nv.xuatTT();
				break;
			}else {
				System.out.println("Không");
				break;
			}
		}
	}
	@Override
	public void timkiemtheotengandung() {
		// TODO Auto-generated method stub
		xuat();
		System.out.print("-->Nhập tên nhân viên cần tìm: ");
		Pattern pattern = Pattern.compile(sc.nextLine());
		for(NhanVien nv: listnv) {
			Matcher tmp = pattern.matcher(nv.getMaNhanVien());
			boolean matchfound = tmp.find();
			if(matchfound) {
				nv.xuatTT();
			}else {
				System.out.println("Không");
				break;
			}
		}
	}
}
