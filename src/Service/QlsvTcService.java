package Service;

import Entity.SinhVienTc;

public interface QlsvTcService {
    public void xoaSv(String mssv);
    public void themSv(SinhVienTc sinhVientc);
    public void showAllOfSystem();// show ra tất cả các thành viên trong hệ thống
    public void showByMssv(String mssv);//show ra thông tin cá nhân của sinh viên có mssv đấy
    public void showAllOfClass(String lopHoc);// show ra tất cả các thành viên trong một lớp học
    public void xetTotNghiep(String mssv);
    public void tinhDiemToeic(String mssv);
}
