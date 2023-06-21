package Entity;

public class HocPhanSinhVienTc extends HocPhan{
    private String diemHp;
    private boolean monHocDaQua = false;// nếu môn học này đủ điểm để qua thì đánh true, ngược lại thì false

    public HocPhanSinhVienTc(String tenHp, String maHp, int soTin, double trongSo, boolean trangThai, String diemHp, boolean monHocDaQua) {
        super(tenHp, maHp, soTin, trongSo, trangThai);
        this.diemHp = diemHp;
        this.monHocDaQua = monHocDaQua;
    }

    public HocPhanSinhVienTc(String diemHp, boolean monHocDaQua) {
        this.diemHp = diemHp;
        this.monHocDaQua = monHocDaQua;
    }

    public HocPhanSinhVienTc(){

    }

    public String getDiemHp() {
        return diemHp;
    }

    public void setDiemHp(String diemHp) {
        this.diemHp = diemHp;
    }

    public boolean isMonHocDaQua() {
        return monHocDaQua;
    }

    public void setMonHocDaQua(boolean monHocDaQua) {
        this.monHocDaQua = monHocDaQua;
    }
}
