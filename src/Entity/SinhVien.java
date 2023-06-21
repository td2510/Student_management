package Entity;

import java.io.Serializable;
//Serializable cho phép object có thể biến đổi thành một kiểu nào đó để được lưu hoặc lấy ra từ đâu đó
public class SinhVien implements Serializable {
    private String hoTenSv;
    private String nganhHoc;
    private String lopHoc;
    private String mssv;
    private String sdt;
    private String danToc;
    private String ngaySinh;
    private String tenBo;
    private String tenMe;
    private String diaChi;
    private int diemToeic;

    public SinhVien(String hoTenSv, String nganhHoc, String lopHoc, String mssv, String sdt, String danToc, String ngaySinh, String tenBo, String tenMe, String diaChi,int diemToeic) {
        this.hoTenSv = hoTenSv;
        this.nganhHoc = nganhHoc;
        this.lopHoc = lopHoc;
        this.mssv = mssv;
        this.sdt = sdt;
        this.danToc = danToc;
        this.ngaySinh = ngaySinh;
        this.tenBo = tenBo;
        this.tenMe = tenMe;
        this.diaChi = diaChi;
        this.diemToeic= diemToeic;
    }

    public SinhVien() {
    }

    public String getHoTenSv() {
        return hoTenSv;
    }

    public void setHoTenSv(String hoTenSv) {
        this.hoTenSv = hoTenSv;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public String getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(String lopHoc) {
        this.lopHoc = lopHoc;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTenBo() {
        return tenBo;
    }

    public void setTenBo(String tenBo) {
        this.tenBo = tenBo;
    }

    public String getTenMe() {
        return tenMe;
    }

    public void setTenMe(String tenMe) {
        this.tenMe = tenMe;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getDiemToeic() {
        return diemToeic;
    }

    public void setDiemToeic(int diemToeic) {
        this.diemToeic = diemToeic;
    }
}
