package Service;


import Entity.HocPhan;
import Entity.HocPhanSinhVienTc;
import Entity.SinhVienTc;
import Repository.DkHocPhanTcDao;
import Repository.HocPhanDao;
import Repository.QlsvTcDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DangKyHocPhanTcImpl implements DangKyHocPhanTc{
    private List<SinhVienTc> sinhVienTcList;
    private QlsvTcDao qlsvTcDao;
    private List<HocPhanSinhVienTc> hocPhanSinhVienTcList;
    private DkHocPhanTcDao dkHocPhanTcDao;
    private List<HocPhan> hocPhanList;
    private HocPhanDao hocPhanDao;

    public DangKyHocPhanTcImpl(){
        qlsvTcDao = new QlsvTcDao();
        sinhVienTcList = qlsvTcDao.read();
        dkHocPhanTcDao = new DkHocPhanTcDao();
        hocPhanSinhVienTcList = dkHocPhanTcDao.read();
        hocPhanDao = new HocPhanDao();
        hocPhanList = hocPhanDao.read();
    }

    @Override
    public void tinhDiemHP(String mssv) {
        Scanner sc = new Scanner(System.in);
        double diemHP=0;
        int count = 0;//Tinh tong so tin chi no cua sinh vien
        int c = 0, d = 0;
        String diemChu="";
        System.out.println("Danh sách học phần có thể đăng ký của sinh viên:");
        for(SinhVienTc m :sinhVienTcList){
            if(m.getMssv().equals(mssv)==true){
                String a = "Tên học phần";
                String b = "Mã học phần";
                String q = "Số tín";
                String p = "Trọng số";
                System.out.format("%40s |", a);
                System.out.format("%20s |", b);
                System.out.format("%20s |", q);
                System.out.format("%20s |", p);
                System.out.println("");
                for(HocPhanSinhVienTc hp: hocPhanSinhVienTcList){
                    System.out.format("%40s |", hp.getTenHp());
                    System.out.format("%20s |", hp.getMaHp());
                    System.out.format("%20d |", hp.getSoTin());
                    System.out.format("%20.1f |", hp.getTrongSo());
                    System.out.println("");
                }
            }
        }
        for(SinhVienTc sv: sinhVienTcList) {
            //check mssv nhập vào có đúng không
            if(sv.getMssv().equals(mssv)==true) {
                c++;
                List<HocPhanSinhVienTc> hocPhanTCS = sv.getHocPhanSinhVienTcList();
                System.out.println("\n\nHãy nhập một học phần: ");
                String maHP = sc.nextLine();
                for(int i=0;i<hocPhanTCS.size();i++) {
                    if(hocPhanTCS.get(i).getMaHp().equals(maHP) == true) {
                        //check xem mã học phần nhập vào có tồn tại hay không, nếu tồn tại ta mới cho nhập điểm
                        d++;
                        System.out.format("Thông tin điểm học phần %s của sinh viên: ", maHP);
                        System.out.println("");
                        System.out.print("Hãy nhập điểm giữa kì: ");
                        float a = sc.nextFloat();
                        System.out.print("Hãy nhập điểm cuối kì: ");
                        float b = sc.nextFloat();
                        if (hocPhanTCS.get(i).getSoTin() == 0) {
                            if (a < 3f || b == 0) {
                                hocPhanTCS.get(i).setMonHocDaQua(false);
                                hocPhanTCS.get(i).setDiemHp("F");
                                System.out.println("Bạn đã trượt học phần này.");
                                double g=0;
                                double cpa= sv.getCpa();
                                int soTin=sv.getTongSoTin();
                                int tachMon=0;
                                if(hocPhanTCS.get(i).getDiemHp().equals("F")==true){
                                    g=0;
                                }
                                else if(hocPhanTCS.get(i).getDiemHp().equals("D")==true){
                                    g=1;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("D+")==true){
                                    g=1.5;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("C")==true){
                                    g=2;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("C+")==true){
                                    g=2.5;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("B")==true){
                                    g=3;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("B+")==true){
                                    g=3.5;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("A")==true){
                                    g=4;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("A+")==true) {
                                    g = 4;
                                }
                                if(g==0){
                                    soTin+=tachMon;
                                }
                                else{
                                    soTin+=hocPhanTCS.get(i).getSoTin();
                                }
                                cpa = (cpa*soTin+g*hocPhanTCS.get(i).getSoTin())/soTin;
                                sv.setCpa(cpa);
                                sv.setTongSoTin(soTin);
                                qlsvTcDao.write(sinhVienTcList);
                                System.out.format("\nCpa của sinh viên: %.1f", sv.getCpa());
                                break;
                            } else {
                                System.out.println("Chúc mừng. Bạn đã hoàn thành học phần này.");
                                hocPhanTCS.get(i).setMonHocDaQua(true);
                                diemHP = a * (1 - hocPhanTCS.get(i).getTrongSo()) + hocPhanTCS.get(i).getTrongSo() * b;
                                if (diemHP <= 4.9f && diemHP >= 4.0f) {
                                    System.out.format("Điểm của học phần %s là: %s", maHP, "D");
                                    diemChu = "D";
                                } else if (diemHP <= 5.4f && diemHP >= 5.0f) {
                                    System.out.format("Điểm của học phần %s là: %s", maHP, "D+");
                                    diemChu = "D+";
                                } else if (diemHP <= 6.4f && diemHP >= 5.5f) {
                                    System.out.format("Điểm của học phần %s là: %s", maHP, "C");
                                    diemChu = "C";
                                } else if (diemHP <= 6.9f && diemHP >= 6.5f) {
                                    System.out.format("Điểm của học phần %s là: %s", maHP, "C+");
                                    diemChu = "C+";
                                } else if (diemHP <= 7.9f && diemHP >= 7.0f) {
                                    System.out.format("Điểm của học phần %s là: %s", maHP, "B");
                                    diemChu = "B";
                                } else if (diemHP <= 8.4f && diemHP >= 8.0f) {
                                    System.out.format("Điểm của học phần %s là: %s", maHP, "B+");
                                    diemChu = "B+";
                                } else if (diemHP <= 9.4f && diemHP >= 8.5f) {
                                    System.out.format("Điểm của học phần %s là: %s", maHP, "A");
                                    diemChu = "A";
                                } else if (diemHP <= 10f && diemHP >= 9.5f) {
                                    System.out.format("Điểm của học phần %s là: %s", maHP, "A+");
                                    diemChu = "A+";
                                }
                                hocPhanTCS.get(i).setDiemHp(diemChu);
                                double g=0;
                                double cpa= sv.getCpa();
                                int soTin=sv.getTongSoTin();
                                int tachMon=0;
                                if(hocPhanTCS.get(i).getDiemHp().equals("F")==true){
                                    g=0;
                                }
                                else if(hocPhanTCS.get(i).getDiemHp().equals("D")==true){
                                    g=1;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("D+")==true){
                                    g=1.5;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("C")==true){
                                    g=2;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("C+")==true){
                                    g=2.5;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("B")==true){
                                    g=3;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("B+")==true){
                                    g=3.5;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("A")==true){
                                    g=4;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("A+")==true) {
                                    g = 4;
                                }
                                if(g==0){
                                    soTin+=tachMon;
                                }
                                else{
                                    soTin+=hocPhanTCS.get(i).getSoTin();
                                }
                                cpa = (cpa*soTin+g*hocPhanTCS.get(i).getSoTin())/soTin;
                                sv.setCpa(cpa);
                                sv.setTongSoTin(soTin);
                                qlsvTcDao.write(sinhVienTcList);
                                System.out.format("\nCpa của sinh viên: %.1f", sv.getCpa());
                                break;
                            }
                        } else {
                            if (a < 3.0f) {
                                hocPhanTCS.get(i).setMonHocDaQua(false);
                                hocPhanTCS.get(i).setDiemHp("F");
                                System.out.println("Bạn đã trượt học phần này.");
                                count += hocPhanTCS.get(i).getSoTin();
                                double g=0;
                                double cpa= sv.getCpa();
                                int soTin=sv.getTongSoTin();
                                int tachMon=0;
                                if(hocPhanTCS.get(i).getDiemHp().equals("F")==true){
                                    g=0;
                                }
                                else if(hocPhanTCS.get(i).getDiemHp().equals("D")==true){
                                    g=1;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("D+")==true){
                                    g=1.5;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("C")==true){
                                    g=2;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("C+")==true){
                                    g=2.5;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("B")==true){
                                    g=3;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("B+")==true){
                                    g=3.5;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("A")==true){
                                    g=4;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("A+")==true) {
                                    g = 4;
                                }
                                if(g==0){
                                    soTin+=tachMon;
                                }
                                else{
                                    soTin+=hocPhanTCS.get(i).getSoTin();
                                }
                                cpa = (cpa*soTin+g*hocPhanTCS.get(i).getSoTin())/soTin;
                                sv.setCpa(cpa);
                                sv.setTongSoTin(soTin);
                                qlsvTcDao.write(sinhVienTcList);
                                System.out.format("\nCpa của sinh viên: %.1f", sv.getCpa());
                                break;
                            } else if (a > 3.0f && b > 0) {
                                hocPhanTCS.get(i).setMonHocDaQua(true);
                                diemHP = (b * hocPhanTCS.get(i).getTrongSo() + a * (1 - hocPhanTCS.get(i).getTrongSo()));
                                if (diemHP <= 4.9f && diemHP >= 4.0f) {
                                    System.out.format("Điểm của học phần %s là: %s", maHP, "D");
                                    diemChu = "D";
                                } else if (diemHP <= 5.4f && diemHP >= 5.0f) {
                                    System.out.format("Điểm của học phần %s là: %s", maHP, "D+");
                                    diemChu = "D+";
                                } else if (diemHP <= 6.4f && diemHP >= 5.5f) {
                                    System.out.format("Điểm của học phần %s là: %s", maHP, "C");
                                    diemChu = "C";
                                } else if (diemHP <= 6.9f && diemHP >= 6.5f) {
                                    System.out.format("Điểm của học phần %s là: %s", maHP, "C+");
                                    diemChu = "C+";
                                } else if (diemHP <= 7.9f && diemHP >= 7.0f) {
                                    System.out.format("Điểm của học phần %s là: %s", maHP, "B");
                                    diemChu = "B";
                                } else if (diemHP <= 8.4f && diemHP >= 8.0f) {
                                    System.out.format("Điểm của học phần %s là: %s", maHP, "B+");
                                    diemChu = "B+";
                                } else if (diemHP <= 9.4f && diemHP >= 8.5f) {
                                    System.out.format("Điểm của học phần %s là: %s", maHP, "A");
                                    diemChu = "A";
                                } else if (diemHP <= 10f && diemHP >= 9.5f) {
                                    System.out.format("Điểm của học phần %s là: %s", maHP, "A+");
                                    diemChu = "A+";
                                }
                                hocPhanTCS.get(i).setDiemHp(diemChu);
                                double g=0;
                                double cpa= sv.getCpa();
                                int soTin=sv.getTongSoTin();
                                int tachMon=0;
                                if(hocPhanTCS.get(i).getDiemHp().equals("F")==true){
                                    g=0;
                                }
                                else if(hocPhanTCS.get(i).getDiemHp().equals("D")==true){
                                    g=1;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("D+")==true){
                                    g=1.5;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("C")==true){
                                    g=2;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("C+")==true){
                                    g=2.5;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("B")==true){
                                    g=3;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("B+")==true){
                                    g=3.5;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("A")==true){
                                    g=4;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("A+")==true) {
                                    g = 4;
                                }
                                if(g==0){
                                    soTin+=tachMon;
                                }
                                else{
                                    soTin+=hocPhanTCS.get(i).getSoTin();
                                }
                                cpa = (cpa*soTin+g*hocPhanTCS.get(i).getSoTin())/soTin;
                                sv.setCpa(cpa);
                                sv.setTongSoTin(soTin);
                                qlsvTcDao.write(sinhVienTcList);
                                System.out.format("\nCpa của sinh viên: %.1f", sv.getCpa());
                                break;
                            } else if (b == 0) {
                                hocPhanTCS.get(i).setMonHocDaQua(false);
                                System.out.format("Điểm của học phần %s là: %s", maHP, "F");
                                hocPhanTCS.get(i).setDiemHp("F");
                                double g=0;
                                double cpa= sv.getCpa();
                                int soTin=sv.getTongSoTin();
                                int tachMon=0;
                                if(hocPhanTCS.get(i).getDiemHp().equals("F")==true){
                                    g=0;
                                }
                                else if(hocPhanTCS.get(i).getDiemHp().equals("D")==true){
                                    g=1;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("D+")==true){
                                    g=1.5;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("C")==true){
                                    g=2;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("C+")==true){
                                    g=2.5;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("B")==true){
                                    g=3;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("B+")==true){
                                    g=3.5;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("A")==true){
                                    g=4;
                                } else if(hocPhanTCS.get(i).getDiemHp().equals("A+")==true) {
                                    g = 4;
                                }
                                    if(g==0){
                                        soTin+=tachMon;
                                    }
                                    else{
                                        soTin+=hocPhanTCS.get(i).getSoTin();
                                    }
                                    cpa = (cpa*soTin+g*hocPhanTCS.get(i).getSoTin())/soTin;
                                    sv.setCpa(cpa);
                                    sv.setTongSoTin(soTin);
                                    qlsvTcDao.write(sinhVienTcList);
                                    System.out.format("\nCpa của sinh viên: %.1f", sv.getCpa());
                                break;
                            }
                        }
                    }

                }
            }
        }
        if(c == 0) {
            System.out.println("Hệ thống không tồn tại sinh viên này!\n");
        }else if(c != 0 && d == 0) {
            System.out.println("Sinh viên chưa đăng ký học phần này. Hãy đăng ký để nhập điểm!\n");
        }
    }


    //in thông tin các học phần đã học của sinh viên
    @Override
    public void showByMssv(String mssv){
        System.out.println("\n");
        System.out.format("Thông tin đăng ký học phần của sinh viên có mssv %s là: \n\n", mssv);
        String a = "Tên học phần";
        String b = "Mã học phần";
        String c = "Số tín";
        String d = "Trọng số";
        String e = "Trạng thái";
        String f = "Điểm HP";
        System.out.format("%40s |", a);
        System.out.format("%20s |", b);
        System.out.format("%20s |", c);
        System.out.format("%20s |", d);
        System.out.format("%20s |", e);
        System.out.format("%20s ", f);
        System.out.println("");
        for(SinhVienTc sv: sinhVienTcList){
            if(sv.getMssv().equals(mssv)==true){
                List<HocPhanSinhVienTc> hocPhanTCS = sv.getHocPhanSinhVienTcList();
                    for(HocPhanSinhVienTc hp: hocPhanTCS){
                        if(hp.isTrangThai()==true){
                            System.out.format("%40s |", hp.getTenHp());
                            System.out.format("%20s |", hp.getMaHp());
                            System.out.format("%20d |", hp.getSoTin());
                            System.out.format("%20.1f |", hp.getTrongSo());
                            if(hp.isMonHocDaQua()==true){
                                System.out.print("              Đã qua |");
                            }
                            else{
                                System.out.print("            Chưa học |");
                            }
                            System.out.format("%20s ", hp.getDiemHp());
                            System.out.println("");
                        }
                    }
            }
        }
    }

    @Override
    public void dangKyHp(String mssv){
        int k=0;
        for(SinhVienTc f: sinhVienTcList){
            if(f.getMssv().equals(mssv)==true){
                String a = "Tên học phần";
                String b = "Mã học phần";
                String q = "Số tín";
                String p = "Trọng số";
                System.out.format("%40s |", a);
                System.out.format("%20s |", b);
                System.out.format("%20s |", q);
                System.out.format("%20s |", p);
                System.out.println("");
                for(HocPhan hp: hocPhanList){
                    System.out.format("%40s |", hp.getTenHp());
                    System.out.format("%20s |", hp.getMaHp());
                    System.out.format("%20d |", hp.getSoTin());
                    System.out.format("%20.1f |", hp.getTrongSo());
                    System.out.println("");
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Hãy nhập mã học phần: ");
        String maHp = sc.next();
        System.out.println("");
        for(SinhVienTc t : sinhVienTcList){
            if(t.getMssv().equals(mssv)==true){ //tìm kiếm sinh viên có mssv trùng với mssv đầu vào
                k++;
                int z=0;
                List<HocPhanSinhVienTc> hpList = t.getHocPhanSinhVienTcList();
                for(HocPhanSinhVienTc g : hpList){
                    if(g.getMaHp().equals(maHp)==true){
                        System.out.format("Học phần %s đã được đăng ký\n", maHp);
                        z++;
                    }
                }
                if(z!=0){
                    break;
                }
                if(z==0){
                    for(HocPhanSinhVienTc n : hocPhanSinhVienTcList){
                        if(n.getMaHp().equals(maHp)==true){
                            n.setTrangThai(true);
                            hpList.add(n);
                            t.setHocPhanSinhVienTcList(hpList);
                            qlsvTcDao.write(sinhVienTcList);
                            System.out.println("Đăng ký học phần thành công.\n");
                        }
                    }
                }
            }
        }
        if(k==0){
            System.out.format("\n Không tồn tại sinh viên có mssv %s", mssv);
        }
    }

    @Override
    public void themHp(HocPhanSinhVienTc hocPhanSinhVienTc){
        int k=0;
        for(HocPhanSinhVienTc g: hocPhanSinhVienTcList){
            if(g.getMaHp().equals(hocPhanSinhVienTc.getMaHp())){
                k++;
            }
        }
        if(k==0){
            hocPhanSinhVienTcList.add(hocPhanSinhVienTc);
            dkHocPhanTcDao.write(hocPhanSinhVienTcList);
        }
    }

    @Override
    public void xoaAllHp(){
        dkHocPhanTcDao.write(new ArrayList<HocPhanSinhVienTc>());
    }
}
