package Service;

import Entity.HocPhanSinhVienNc;
import Entity.SinhVien;
import Entity.SinhVienNc;
import Repository.QlsvNcDao;
import Repository.TkbSinhVienNcDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QlsvNcServiceImpl implements QlsvNcService{
    private List<SinhVienNc> sinhVienNcList;
    private QlsvNcDao qlsvNcDao;
    private List<HocPhanSinhVienNc> hocPhanSinhVienNcs;
    private TkbSinhVienNcDao tkbSinhVienNcDao;

    public QlsvNcServiceImpl() {
        qlsvNcDao = new QlsvNcDao();
        sinhVienNcList = qlsvNcDao.read();
        tkbSinhVienNcDao = new TkbSinhVienNcDao();
        hocPhanSinhVienNcs = tkbSinhVienNcDao.read();
    }

    @Override
    public void themSv(SinhVienNc sinhVienNc) {
        try{
            int x=0;
            for(SinhVien a : sinhVienNcList){
                if(a.getMssv().equals(sinhVienNc.getMssv())==true) {
                    System.out.println("Đã có sinh viên có mssv "+a.getMssv());
                    x++;
                    break;
                }
            }
            List<HocPhanSinhVienNc> f = new ArrayList<HocPhanSinhVienNc>();
            for(HocPhanSinhVienNc hp: hocPhanSinhVienNcs){
                if(hp.getNganhHoc().equals(sinhVienNc.getNganhHoc())==true){
                    f.add(hp);
                }
            }
            sinhVienNc.setList(f);
            if(x==0){
                sinhVienNcList.add(sinhVienNc);
                qlsvNcDao.write(sinhVienNcList);
            }
        }
        catch(Exception e){
            System.out.println("có lỗi xảy ra");
        }
    }

    @Override
    public void xoaSv(String mssv) {
        int x=0;
        for (int i = 0; i < sinhVienNcList.size(); i++) {
            if (sinhVienNcList.get(i).getMssv().equals(mssv) == true) {
                sinhVienNcList.remove(sinhVienNcList.get(i));
                x++;
            }
        }
        if(x!=0){
            System.out.println("Xóa thành công sinh viên có mssv là "+ mssv);
            System.out.println("Sinh viên niên chế hiện tại là: ");
            String a="Họ Tên";
            String b="Lớp Học";
            String d="MSSV";
            String e="SĐT";
            System.out.format("%20s |",a);
            System.out.format("%20s |",b);
            System.out.format("%20s |", d);
            System.out.format("%20s", e);
            System.out.println("");
            if(sinhVienNcList!=null){
                for (SinhVienNc sinhVienNc : sinhVienNcList) {
                    System.out.format("%20s |", sinhVienNc.getHoTenSv());
                    System.out.format("%20s |", sinhVienNc.getLopHoc());
                    System.out.format("%20s |", sinhVienNc.getMssv());
                    System.out.format("%20s", sinhVienNc.getSdt());
                    System.out.println("");
                }
            }
            else{
                System.out.println("Hệ thống rỗng dữ liệu");
            }
            System.out.println("");
        }
        else {
            System.out.println("Không xóa được sinh viên có mssv là "+ mssv);
        }
        qlsvNcDao.write(sinhVienNcList);
    }

    @Override
    public void showAllOfSystem() {
        String a="Họ Tên";
        String b="Lớp Học";
        String d="MSSV";
        String e="SĐT";
        System.out.println("\n\n\n======================================SINH VIÊN NIÊN CHẾ=======================================\n");
        System.out.format("%20s |",a);
        System.out.format("%20s |",b);
        System.out.format("%20s |", d);
        System.out.format("%20s", e);
        System.out.println("");
        if(sinhVienNcList!=null){
            for (SinhVienNc sinhVienNc : sinhVienNcList) {
                System.out.format("%20s |", sinhVienNc.getHoTenSv());
                System.out.format("%20s |", sinhVienNc.getLopHoc());
                System.out.format("%20s |", sinhVienNc.getMssv());
                System.out.format("%20s", sinhVienNc.getSdt());
                System.out.println("");
            }
        }
        else{
            System.out.println("Hệ thống rỗng dữ liệu");
        }
    }

    @Override
    public void showByMssv(String mssv){
        if(sinhVienNcList!=null){
            for (SinhVienNc sinhVienNc : sinhVienNcList) {
                if(sinhVienNc.getMssv().equals(mssv)==true){
                    System.out.format("\n\n\n===============================THÔNG TIN SINH VIÊN %s==================================\n", mssv);
                    System.out.format("Họ tên sinh viên: %s\n", sinhVienNc.getHoTenSv());
                    System.out.format("Ngành học: %s\n", sinhVienNc.getNganhHoc());
                    System.out.format("Lớp học: %s\n", sinhVienNc.getLopHoc());
                    System.out.format("Mã số sinh viên: %s\n", sinhVienNc.getMssv());
                    System.out.format("Số điện thoại: %s\n", sinhVienNc.getSdt());
                    System.out.format("Dân tộc: %s\n", sinhVienNc.getDanToc());
                    System.out.format("Ngày Sinh: %s\n", sinhVienNc.getNgaySinh());
                    System.out.format("Họ tên bố: %s\n", sinhVienNc.getTenBo());
                    System.out.format("Họ tên mẹ: %s\n", sinhVienNc.getTenMe());
                    System.out.format("Địa chỉ: %s\n", sinhVienNc.getDiaChi());
                    System.out.format("Điểm toeic: %s\n", sinhVienNc.getDiemToeic());
                }
            }
        }
        else{
            System.out.println("Hệ thống rỗng dữ liệu");
        }
    }
    @Override
    public void showAllOfClass(String lopHoc) {
        String a="Họ Tên";
        String d="MSSV";
        String e="SĐT";
        System.out.format("\n\n\n=====================================THÔNG TIN LỚP %s===================================\n\n", lopHoc);
        System.out.format("%20s |",a);
        System.out.format("%20s", d);
        System.out.format("%20s", e);
        System.out.println("");
        for(SinhVienNc sinhVienNc: sinhVienNcList){
            if(sinhVienNc.getLopHoc().equals(lopHoc)==true){
                System.out.format("%20s |", sinhVienNc.getHoTenSv());
                System.out.format("%20s |", sinhVienNc.getMssv());
                System.out.format("%20s", sinhVienNc.getSdt());
                System.out.println("");
            }
        }
        if(sinhVienNcList==null){
            System.out.println("Hệ thống rỗng dữ liệu");
        }
    }

    @Override
    public void tinhDiemToeic(String mssv){
        Scanner sc = new Scanner(System.in);
        int x=0;
        for(SinhVienNc g : sinhVienNcList){
            if(g.getMssv().equals(mssv)==true){
                System.out.print("Hãy nhập điểm toeic cho sinh viên: ");
                int a = sc.nextInt();
                g.setDiemToeic(a);
                qlsvNcDao.write(sinhVienNcList);
                x++;
            }
        }
        if(x==0){
            System.out.println("Bạn đã nhập sai mssv, hệ thống không tồn tại dữ liệu về mssv này");
        }
    }

    @Override
    public void xetTotNghiep(String mssv){
        int g=0,m=0, l=0;
        for(SinhVienNc t: sinhVienNcList){
            if(t.getMssv().equals(mssv)==true){
                m++;
                List<HocPhanSinhVienNc> s = t.getList();
                for(HocPhanSinhVienNc a: s){
                    if(a.isTrangThai()==true){
                        g++;
                    }
                }
                for(HocPhanSinhVienNc j: hocPhanSinhVienNcs){
                    if(j.getNganhHoc().equals(t.getNganhHoc())==true){
                        l++;
                    }
                }
                if(g==hocPhanSinhVienNcs.size() && t.getDiemToeic()>=500){
                    System.out.format("\nSinh viên %s đã đạt yêu cầu tốt nghiệp\n", mssv);
                    System.out.format("Điểm toeic: %d", t.getDiemToeic());
                } else{
                    if(g<l){
                        System.out.format("\nSinh viên %s chưa đủ điều kiện yêu cầu tốt nghiệp vì chưa hoàn thành hết các học phần\n", mssv);
                        System.out.println("Những môn chưa đạt:");
                        String a="Mã Học Phần";
                        String e="Tên Học Phần";
                        String d="Kỳ học";
                        System.out.format("%15s |",a);
                        System.out.format("%50s |", e);
                        System.out.format("%15s", d);
                        System.out.println("");
                        for(HocPhanSinhVienNc hp : s){
                            if(hp.isTrangThai()==false){
                                System.out.format("%15s |", hp.getMaHp());
                                System.out.format("%50s |", hp.getTenHp());
                                System.out.format("%15d ", hp.getKyhoc());
                                System.out.println("");
                            }
                        }
                    }
                    else if(t.getDiemToeic()<500){
                        System.out.format("\nSinh viên %s chưa đủ điều kiện yêu cầu tốt nghiệp vì chưa đạt điều kiện chứng chỉ toeic (cần lớn hơn hoặc bằng 500)\n", mssv);
                        System.out.format("Điểm toeic hiện tại của sinh viên: %d", t.getDiemToeic());
                    }
                }
            }
        }
        if(m==0){
            System.out.format("Hệ thống sinh viên niên chế không tồn tại sinh viên %s", mssv);
        }
    }

    @Override
    public void xetDkhp(String mssv){
        Scanner sc = new Scanner(System.in);
        int b;
        for(SinhVienNc t :sinhVienNcList){
            if(t.getMssv().equals(mssv)==true){
                System.out.print("Nhập mã học phần môn học muốn xét: ");
                String a = sc.next();
                List<HocPhanSinhVienNc> list = t.getList();
                for(HocPhanSinhVienNc g: list){
                    if(a.equals(g.getMaHp())==true && t.getNganhHoc().equals(g.getNganhHoc())==true){
                            System.out.print("Môn học này qua hay không (Nhập 1 để qua và 2 để đánh giá trượt): ");
                            b = sc.nextInt();
                            System.out.println("");
                            if(b==1){
                                g.setTrangThai(true);
                            }
                            else if(b==2){
                                g.setTrangThai(false);
                            }
                            else{
                                System.out.println("Yêu cầu nhập 1 hoặc 2");
                            }
                    }
                    qlsvNcDao.write(sinhVienNcList);
                }
            }
        }

    }
}
