package Service;

import Entity.HocPhanSinhVienTc;
import Entity.SinhVien;
import Entity.SinhVienNc;
import Entity.SinhVienTc;
import Repository.DkHocPhanTcDao;
import Repository.QlsvTcDao;

import java.util.List;
import java.util.Scanner;

public class QlsvTcServiceImpl implements QlsvTcService{
    private List<SinhVienTc> sinhVienTcList;
    private QlsvTcDao qlsvTcDao;

    public QlsvTcServiceImpl() {
        qlsvTcDao = new QlsvTcDao();
        sinhVienTcList = qlsvTcDao.read();
    }


    @Override
    public void themSv(SinhVienTc sinhVienTc) {
        try{
            int x=0;
            for(SinhVien a : sinhVienTcList){
                if(a.getMssv().equals(sinhVienTc.getMssv())==true) {
                    System.out.println("Đã có sinh viên có mssv "+a.getMssv());
                    x++;
                    break;
                }
            }
            if(x==0){
                sinhVienTcList.add(sinhVienTc);
                qlsvTcDao.write(sinhVienTcList);
            }
        }
        catch(Exception e){
            System.out.println("có lỗi xảy ra");
        }
    }

    @Override
    public void xoaSv(String mssv) {
        int x=0;
        for(int i=0;i<sinhVienTcList.size();i++){
            if(sinhVienTcList.get(i).getMssv().equals(mssv)==true){
                sinhVienTcList.remove(sinhVienTcList.get(i));
                x++;
            }
        }
        if(x!=0){
            System.out.println("Xóa thành công sinh viên có mssv là "+ mssv);
            System.out.println("Sinh viên tín chỉ hiện tại là: ");
            String a="Họ Tên";
            String b="Lớp Học";
            String d="MSSV";
            String e="SĐT";
            System.out.format("%20s |",a);
            System.out.format("%20s |",b);
            System.out.format("%20s |", d);
            System.out.format("%20s", e);
            System.out.println("");
            if(sinhVienTcList!=null){
                for (SinhVienTc sinhVienTc : sinhVienTcList) {
                    System.out.format("%20s |", sinhVienTc.getHoTenSv());
                    System.out.format("%20s |", sinhVienTc.getLopHoc());
                    System.out.format("%20s |", sinhVienTc.getMssv());
                    System.out.format("%20s", sinhVienTc.getSdt());
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
        qlsvTcDao.write(sinhVienTcList);
    }

    @Override
    public void showAllOfSystem() {
        String a="Họ Tên";
        String b="Lớp Học";
        String d="MSSV";
        String e="SĐT";
        System.out.println("\n\n\n======================================SINH VIÊN TÍN CHỈ===========================================\n");
        System.out.format("%20s |",a);
        System.out.format("%20s |", b);
        System.out.format("%20s", d);
        System.out.format("%20s", e);
        System.out.println("");
        if(sinhVienTcList!=null){
            for (SinhVienTc sinhVienTc : sinhVienTcList) {
                System.out.format("%20s |", sinhVienTc.getHoTenSv());
                System.out.format("%20s |", sinhVienTc.getLopHoc());
                System.out.format("%20s |", sinhVienTc.getMssv());
                System.out.format("%20s", sinhVienTc.getSdt());
                System.out.println("");
            }
        }
        else{
            System.out.println("Hệ thống rỗng dữ liệu");
        }
    }

    @Override
    public void showByMssv(String mssv){

        if(sinhVienTcList!=null){
            for (SinhVienTc sinhVienTc : sinhVienTcList) {
                if(sinhVienTc.getMssv().equals(mssv)==true){
                    System.out.format("\n\n\n===================================THÔNG TIN SINH VIÊN %s===================================\n", mssv);
                    System.out.format("Họ tên sinh viên: %s\n", sinhVienTc.getHoTenSv());
                    System.out.format("Ngành học: %s\n", sinhVienTc.getNganhHoc());
                    System.out.format("Lớp học: %s\n", sinhVienTc.getLopHoc());
                    System.out.format("Mã số sinh viên: %s\n", sinhVienTc.getMssv());
                    System.out.format("Số điện thoại: %s\n", sinhVienTc.getSdt());
                    System.out.format("Dân tộc: %s\n", sinhVienTc.getDanToc());
                    System.out.format("Ngày Sinh: %s\n", sinhVienTc.getNgaySinh());
                    System.out.format("Họ tên bố: %s\n", sinhVienTc.getTenBo());
                    System.out.format("Họ tên mẹ: %s\n", sinhVienTc.getTenMe());
                    System.out.format("Địa chỉ: %s\n", sinhVienTc.getDiaChi());
                    System.out.format("Cpa: %s\n", sinhVienTc.getCpa());
                    System.out.format("Điểm toeic: %s\n", sinhVienTc.getDiemToeic());
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
        System.out.format("\n\n\n========================================THÔNG TIN LỚP %s======================================\n\n", lopHoc);
        System.out.format("%20s |",a);
        System.out.format("%20s", d);
        System.out.format("%20s", e);
        System.out.println("");
        for(SinhVienTc sinhVienTc: sinhVienTcList){
            if(sinhVienTc.getLopHoc().equals(lopHoc)==true){
                System.out.format("%20s |", sinhVienTc.getHoTenSv());
                System.out.format("%20s |", sinhVienTc.getMssv());
                System.out.format("%20s", sinhVienTc.getSdt());
                System.out.println("");
            }
        }
        if(sinhVienTcList==null){
            System.out.println("Hệ thống rỗng dữ liệu");
        }
    }

    @Override
    public void xetTotNghiep(String mssv){
        for(SinhVienTc t: sinhVienTcList){
            if(t.getMssv().equals(mssv)==true){
                List<HocPhanSinhVienTc> hocPhanSinhVienTcs = t.getHocPhanSinhVienTcList();
                double cpa=t.getCpa();
                double g=0;
                int soTin =t.getTongSoTin();
                if(soTin==30){
                    System.out.println("\nSinh viên này đã đạt yêu cầu tốt nghiệp\n");
                    System.out.format("Cpa của sinh viên là: %.1f\n", cpa);
                    System.out.format("Điểm toeic của sinh viên là: %d\n", t.getDiemToeic());
                }
                else if(soTin<30){
                    System.out.println("\nSinh viên này chưa đủ yêu cầu tốt nghiệp vì thiếu tín chỉ\n");
                    System.out.format("Sinh viên cần thêm %d tín chỉ nữa\n", 30-soTin);
                    System.out.format("Cpa của sinh viên là: %.1f\n", cpa);
                }else if(t.getDiemToeic()<500){
                    System.out.println("\nSinh viên này chưa đủ yêu cầu tốt nghiệp vì thiếu toeic\n");
                    System.out.format("Điểm toeic của sinh viên là: %d\n", t.getDiemToeic());
                }
            }
        }
    }

    @Override
    public void tinhDiemToeic(String mssv){
        Scanner sc = new Scanner(System.in);
        int x=0;
        for(SinhVienTc g : sinhVienTcList){
            if(g.getMssv().equals(mssv)==true){
                System.out.print("Hãy nhập điểm toeic cho sinh viên: ");
                int a = sc.nextInt();
                g.setDiemToeic(a);
                qlsvTcDao.write(sinhVienTcList);
                x++;
            }
        }
        if(x==0){
            System.out.println("Bạn đã nhập sai mssv, hệ thống không tồn tại dữ liệu về mssv này");
        }
    }
}
