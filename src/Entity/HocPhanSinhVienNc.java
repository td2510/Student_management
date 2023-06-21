package Entity;

public class HocPhanSinhVienNc extends HocPhan{
    private String nganhHoc;
    private int kyhoc;

    public HocPhanSinhVienNc(String tenHp, String maHp, int soTin, double trongSo, boolean trangThai, String nganhHoc, int kyhoc) {
        super(tenHp, maHp, soTin, trongSo, trangThai);
        this.nganhHoc = nganhHoc;
        this.kyhoc = kyhoc;
    }

    public HocPhanSinhVienNc(String nganhHoc, int kyhoc) {
        this.nganhHoc = nganhHoc;
        this.kyhoc = kyhoc;
    }

    public HocPhanSinhVienNc(){

    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public int getKyhoc() {
        return kyhoc;
    }

    public void setKyhoc(int kyhoc) {
        this.kyhoc = kyhoc;
    }
}
