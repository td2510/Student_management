package Service;

import Entity.HocPhanSinhVienTc;

public interface DangKyHocPhanTc {
    public void tinhDiemHP(String mssv);
    public void showByMssv(String mssv);
    public void dangKyHp(String mssv);
    public void themHp(HocPhanSinhVienTc hocPhanSinhVienTc);
    public void xoaAllHp();
}
