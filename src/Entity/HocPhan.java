package Entity;

import java.io.Serializable;
//Serializable cho phép object có thể biến đổi thành một kiểu nào đó để được lưu hoặc lấy ra từ đâu đó
public class HocPhan implements Serializable {
    private String tenHp;
    private String maHp;
    private int soTin;
    private double trongSo;
    private boolean trangThai;
//trạng thái là false tức là chưa đăng ký, true tức là đăng ký rồi ( chỉ dành cho sinh viên tín chỉ)
    // đối với sinh viên niên chế thì trạng thái này chỉ việc đã qua môn hay là chưa


    public HocPhan(String tenHp, String maHp, int soTin, double trongSo, boolean trangThai) {
        this.tenHp = tenHp;
        this.maHp = maHp;
        this.soTin = soTin;
        this.trongSo = trongSo;
        this.trangThai = trangThai;
    }

    public HocPhan() {
    }

    public String getTenHp() {
        return tenHp;
    }

    public void setTenHp(String tenHp) {
        this.tenHp = tenHp;
    }

    public String getMaHp() {
        return maHp;
    }

    public void setMaHp(String maHp) {
        this.maHp = maHp;
    }

    public int getSoTin() {
        return soTin;
    }

    public void setSoTin(int soTin) {
        this.soTin = soTin;
    }

    public double getTrongSo() {
        return trongSo;
    }

    public void setTrongSo(double trongSo) {
        this.trongSo = trongSo;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}
