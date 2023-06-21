package Service;


import Entity.HocPhanSinhVienNc;

public interface TkbSinhVienNcService {
    public void xoaHp(String name, String nganhHoc);
    public void themHp(HocPhanSinhVienNc hocPhanSinhVienNc);
    public void showByClass(String nganhHoc);
    public void xoaAll();
}
