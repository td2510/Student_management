package Service;

import Entity.SinhVienNc;

public interface QlsvNcService {
    public void xoaSv(String mssv);
    public void themSv(SinhVienNc sinhVienNc);
    public void showAllOfSystem();// show ra tất cả các thành viên trong hệ thống
    public void showByMssv(String mssv);//show ra thông tin cá nhân của sinh viên có mssv đấy
    public void showAllOfClass(String lopHoc);// show ra tất cả các thành viên trong một lớp học
    public void tinhDiemToeic(String mssv);
    public void xetTotNghiep(String mssv);
    public void xetDkhp(String mssv); // xét cho các học phần của sinh viên có đạt hay không
}
