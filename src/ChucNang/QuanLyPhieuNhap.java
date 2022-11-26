package ChucNang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

import ChucNang.ChucNang;
import OP.PhieuNhap;

public class QuanLyPhieuNhap implements ChucNang{
    private String fileName = "file/phieuNhapData.txt";
    private PhieuNhap[] phieuNhapList = Main.getPhieuNhapList();
    QuanLyPhieuNhap() {
        doc();
        System.out.println("+---------------------+");
        System.out.println("| QUAN LY PHIEU NHAP  |");
        System.out.println("+---------------------+");
    }
    public void menu() {
        boolean flag = true;
        if (phieuNhapList == null || phieuNhapList.length == 0) {
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
                             + "|5. Thoat QLK        |\n"
                             + "+--------------------+");
            System.out.print("--> Moi ban chon: ");
            int chon = Integer.parseInt(Main.sc.nextLine());
            switch (chon) {
                case 1 -> them();
                case 2 -> xoa();
                case 3 -> sua();
                case 4 -> xuat();
                default -> flag = false;
            }
        }
        Main.setPhieuNhapList(phieuNhapList);;
        if (flag == true) {
            System.out.println();
            menu();
        }
        ghi();
    }   

    private boolean ktDuLieu(PhieuNhap newPhieuNhap) {
        boolean flag = true;
        if (newPhieuNhap.getMaPhieuNhap().isEmpty()
            || newPhieuNhap.getMaHang().isEmpty()
            || newPhieuNhap.getMaKho().isEmpty()
            || newPhieuNhap.getMaNV().isEmpty()
            || newPhieuNhap.getMaNCC().isEmpty()) {
            System.out.println("*Khong de trong*");
            flag = false;
        }
        for (PhieuNhap phieuNhap : phieuNhapList) {
            if (phieuNhap.getMaPhieuNhap().equalsIgnoreCase(newPhieuNhap.getMaPhieuNhap())) {
                flag = false;
                System.out.println("*Trung ma kho*");
                break;
            }
        }
        return flag;
    }

    @Override
	public void nhap() {
        System.out.println("Danh sach trong!!");
        System.out.print("Ban muon them bao nhieu phan tu dau tien: ");
        int n = Integer.parseInt(Main.sc.nextLine());
        phieuNhapList = new PhieuNhap[n];
        for (int i = 0; i < phieuNhapList.length; i++) {
            phieuNhapList[i] = new PhieuNhap();
            phieuNhapList[i].nhapTT();
        }
	}

	@Override
	public void xuat() {
		System.out.println("+-------------------------------------+\n"
                         + "|          DANH SACH PHIEU NHAP       |\n" 
                         + "+-------------------------------------+\n"
                         + "|MAPN |MAKHO|MAHANG|MANV |MANCC|SLUONG|\n"
                         + "+-----+-----+------+-----+-----+------+");
        for (PhieuNhap phieuNhap : phieuNhapList) {
            phieuNhap.xuatTT();
        }
		System.out.println("+-----+-----+------+-----+-----+------+");
	}

	@Override
	public void them() {
        PhieuNhap newPhieuNhap = new PhieuNhap();
        System.out.println("*Nhap du lieu cho phieu nhap moi*");
        newPhieuNhap.nhapTT();
        if (ktDuLieu(newPhieuNhap)) {
            phieuNhapList = Arrays.copyOf(phieuNhapList, phieuNhapList.length+1);
            phieuNhapList[phieuNhapList.length - 1] = newPhieuNhap;
        }
        System.out.print("-->Ban co muon tiep tuc them 1 phan tu (y/n)? ");
        String c = Main.sc.nextLine();
        if (c.equalsIgnoreCase("y")) {
            them();
        }
	}

    @Override
    public void xoa() {
        if (phieuNhapList.length > 0) {
            int i;
            boolean flag = false;
            xuat();
            System.out.print("-->Nhap ma phieu nhap can xoa: ");
            String s = Main.sc.nextLine();
            for (i = 0; i < phieuNhapList.length; i++) {
                if (phieuNhapList[i].getMaKho().equalsIgnoreCase(s)) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                for (int j = i; j < phieuNhapList.length - 1; j++) {
                    phieuNhapList[j] = phieuNhapList[j+1];
                }
                phieuNhapList = Arrays.copyOf(phieuNhapList, phieuNhapList.length - 1);
            }
            else {
                System.out.println("*Ma phieu nhap khong ton tai*");
            }
            System.out.print("-->Ban co muon tiep tuc xoa 1 phan tu (y/n)? ");
            String c = Main.sc.nextLine();
            if (c.equalsIgnoreCase("y")) {
                xoa();
            }       
        }
    }

	@Override
	public void sua() {
		// TODO Auto-generated method stub
		if (phieuNhapList.length > 0) {
            int i;
            boolean flag = false;
            xuat();
            System.out.print("-->Nhap ma kho can xoa: ");
            String s = Main.sc.nextLine();
            for (i = 0; i < phieuNhapList.length; i++) {
                if (phieuNhapList[i].getMaKho().equalsIgnoreCase(s)) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                System.out.print("Nhap ma kho moi: ");
                phieuNhapList[i].setMaKho(Main.sc.nextLine());
                System.out.print("Nhap ma hang moi: ");
                phieuNhapList[i].setMaHang(Main.sc.nextLine());
                System.out.print("Nhap ma nhan vien moi: ");
                phieuNhapList[i].setMaNV(Main.sc.nextLine());
                System.out.print("Nhap ma nha cung cap moi: ");
                phieuNhapList[i].setMaNCC(Main.sc.nextLine());
                System.out.print("Nhap so luong moi: ");
                phieuNhapList[i].setSoLuong(Integer.parseInt(Main.sc.nextLine()));
            }
            else {
                System.out.println("*Ma phieu nhap khong ton tai*");
            }
            System.out.print("-->Ban co muon tiep tuc sua (y/n)? ");
            String c = Main.sc.nextLine();
            if (c.equalsIgnoreCase("y")) {
                sua();
            }       

        }
	}

	@Override
	public void ghi() {
        try{
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(phieuNhapList.length+"");
            bw.newLine();
            for (PhieuNhap phieuNhap : phieuNhapList) {
                bw.write(phieuNhap.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
	}

	@Override
	public void doc() {
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            int len = Integer.parseInt(br.readLine());
            phieuNhapList = new PhieuNhap[len];
            String sr;
            for (int i = 0; i < len; i++) {
                sr = br.readLine();
                if(sr==null)break;
                var tmp =  sr.split(";");
                phieuNhapList[i] = new PhieuNhap(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], Integer.parseInt(tmp[5]));
            }
            Main.setPhieuNhapList(phieuNhapList);
            br.close();
            fr.close();
        }
        catch(Exception e){}
	}
	
	boolean giamsoluong(int soluong, String mahang) {
		boolean flag = false;
		int dem = 0;
		for(PhieuNhap pn: phieuNhapList) {
			if(pn.getMaHang().equalsIgnoreCase(mahang) && pn.getSoLuong()>0) {
				int giam = pn.getSoLuong() - soluong;
				phieuNhapList[dem].setSoLuong(giam);
				flag = true;
				break;
			}
			dem++;
		}
		Main.setPhieuNhapList(phieuNhapList);
		ghi();
		return flag;
	}

}
