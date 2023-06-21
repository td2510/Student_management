package Entity;

import java.util.List;

public class SinhVienTc extends SinhVien{
    private double cpa;
    private List<HocPhanSinhVienTc> hocPhanSinhVienTcList;
    private int tongSoTin;

    public SinhVienTc(String hoTenSv, String nganhHoc, String lopHoc, String mssv, String sdt, String danToc, String ngaySinh, String tenBo, String tenMe, String diaChi, int diemToeic, double cpa, List<HocPhanSinhVienTc> hocPhanSinhVienTcList, int tongSoTin) {
        super(hoTenSv, nganhHoc, lopHoc, mssv, sdt, danToc, ngaySinh, tenBo, tenMe, diaChi, diemToeic);
        this.cpa = cpa;
        this.hocPhanSinhVienTcList = hocPhanSinhVienTcList;
        this.tongSoTin = tongSoTin;
    }


    public SinhVienTc(){

    }

    public double getCpa() {
        return cpa;
    }

    public void setCpa(double cpa) {
        this.cpa = cpa;
    }

    public List<HocPhanSinhVienTc> getHocPhanSinhVienTcList() {
        return hocPhanSinhVienTcList;
    }

    public void setHocPhanSinhVienTcList(List<HocPhanSinhVienTc> hocPhanSinhVienTcList) {
        this.hocPhanSinhVienTcList = hocPhanSinhVienTcList;
    }

    public int getTongSoTin() {
        return tongSoTin;
    }

    public void setTongSoTin(int tongSoTin) {
        this.tongSoTin = tongSoTin;
    }
}
