package Service;

import Entity.HocPhan;

public interface HocPhanService {
    public void xoaHp(String name);
    public void themHp(HocPhan hocPhan);
    public void show();
    public void xoaAll();
}
