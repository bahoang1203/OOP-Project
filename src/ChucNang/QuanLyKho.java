package ChucNang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

import ChucNang.ChucNang;
import OP.Kho;

public class QuanLyKho implements ChucNang {
    private String fileName = "khoData.txt";
    private Kho[] khoList = Main.getKhoList();
    QuanLyKho() {
        doc();
        System.out.println("+---------------------+");
        System.out.println("|     QUAN LY KHO     |");
        System.out.println("+---------------------+");
    }
    public void menu() {
        boolean flag = true;
        if (khoList == null || khoList.length == 0) {
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
        Main.setKhoList(khoList);
        if (flag == true) {
            System.out.println();
            menu();
        }
        ghi();
    }   

    private boolean ktDuLieu(Kho newKho) {
        boolean flag = true;
        if (newKho.getTenKho().isEmpty()) {
            System.out.println("*Ten kho khong duoc de trong*");
            flag = false;
        }
        for (Kho kho : khoList) {
            if (kho.getMaKho().equalsIgnoreCase(newKho.getMaKho())) {
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
        khoList = new Kho[n];
        for (int i = 0; i < khoList.length; i++) {
            khoList[i] = new Kho();
            khoList[i].nhapTT();
        }
	}

	@Override
	public void xuat() {
		System.out.println("+--------------------------+\n"
                         + "|      DANH SACH KHO       |\n" 
                         + "+--------------------------+\n"
                         + "|MAKHO|       TENKHO       |\n"
                         + "+-----+--------------------+");
        for (Kho kho : khoList) {
            kho.xuatTT();
        }
		System.out.println("+-----+--------------------+");
	}

	@Override
	public void them() {
        Kho newKho = new Kho();
        System.out.println("*Nhap du lieu cho kho moi*");
        newKho.nhapTT();
   
        if (ktDuLieu(newKho)) {
            khoList = Arrays.copyOf(khoList, khoList.length + 1);
            khoList[khoList.length - 1] = newKho;
        }
        System.out.print("-->Ban co muon tiep tuc them 1 phan tu (y/n)? ");
        String c = Main.sc.nextLine();
        if (c.equalsIgnoreCase("y")) {
            them();
        }
	}

    @Override
    public void xoa() {
        if (khoList.length > 0) {
            int i;
            boolean flag = false;
            xuat();
            System.out.print("-->Nhap ma kho can xoa: ");
            String s = Main.sc.nextLine();
            for (i = 0; i < khoList.length; i++) {
                if (khoList[i].getMaKho().equalsIgnoreCase(s)) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                for (int j = i; j < khoList.length - 1; j++) {
                    khoList[j] = khoList[j+1];
                }
                khoList = Arrays.copyOf(khoList, khoList.length - 1);
            }
            else {
                System.out.println("*Ma kho khong ton tai*");
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
		if (khoList.length > 0) {
            int i;
            boolean flag = false;
            xuat();
            System.out.print("-->Nhap ma kho can xoa: ");
            String s = Main.sc.nextLine();
            for (i = 0; i < khoList.length; i++) {
                if (khoList[i].getMaKho().equalsIgnoreCase(s)) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                System.out.print("Ten kho moi: ");
                khoList[i].setTenKho(Main.sc.nextLine());
            }
            else {
                System.out.println("*Ma kho khong ton tai*");
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
            bw.write(khoList.length+"");
            bw.newLine();
            for (Kho kho : khoList) {
                bw.write(kho.toString());
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
		// TODO Auto-generated method stub
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            int len = Integer.parseInt(br.readLine());
            khoList = new Kho[len];
            String sr;
            for (int i = 0; i < len; i++) {
                sr = br.readLine();
                if(sr==null)break;
                var tmp =  sr.split(";");
                khoList[i] = new Kho(tmp[0], tmp[1]);
            } 
            br.close();
            fr.close();
        }
        catch(Exception e){}
	}

}
