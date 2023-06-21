package Entity;

import java.util.List;

public class SinhVienNc extends SinhVien{
    private List<HocPhanSinhVienNc> list;

    public SinhVienNc(String hoTenSv, String nganhHoc, String lopHoc, String mssv, String sdt, String danToc, String ngaySinh, String tenBo, String tenMe, String diaChi, int diemToeic, List<HocPhanSinhVienNc> list) {
        super(hoTenSv, nganhHoc, lopHoc, mssv, sdt, danToc, ngaySinh, tenBo, tenMe, diaChi, diemToeic);
        this.list = list;
    }

    public SinhVienNc(List<HocPhanSinhVienNc> list) {
        this.list = list;
    }

    public List<HocPhanSinhVienNc> getList() {
        return list;
    }

    public void setList(List<HocPhanSinhVienNc> list) {
        this.list = list;
    }
}
