package Service;

import Entity.HocPhan;
import Repository.HocPhanDao;

import java.util.List;

public class HocPhanServiceImpl implements HocPhanService {
    private List<HocPhan> hocPhanList;
    private HocPhanDao hocPhanDao;

    public HocPhanServiceImpl() {
        hocPhanDao = new HocPhanDao();
        hocPhanList = hocPhanDao.read();
    }

    @Override
    public void themHp(HocPhan hocPhan){
        try{
            int y=0;
            for(HocPhan a: hocPhanList){
                if(a.getMaHp().equals(hocPhan.getMaHp())==true){
                    y++;
                }
            }
            if(y==0){
                hocPhanList.add(hocPhan);
                hocPhanDao.write(hocPhanList);
            }
        }
        catch (Exception e){
            System.out.println("Có lỗi xảy ra");
        }
    }

    @Override
    public void xoaHp(String maHp) {
        int k;
        int x=0;
        for(HocPhan t : hocPhanList){
            if(t.getMaHp().equals(maHp)==true){
                hocPhanList.remove(t);
                x++;
            }
        }
        if(x==0) {
            System.out.println("Không tồn tại học phần "+maHp);
        }
        hocPhanDao.write(hocPhanList);
    }

    @Override
    public void show() {
        String g ="STT";
        int z=1;
        String a="Mã Học Phần";
        String d = "Tên Học Phần";
        String b="Số Tín";
        String c="Trọng Số";
        System.out.println("\n");
        System.out.format("%10s |",g);
        System.out.format("%25s |",a);
        System.out.format("%38s |",d);
        System.out.format("%25s |", b);
        System.out.format("%15s |", c);
        System.out.println("");
        if(hocPhanList!=null){
            for (HocPhan hp : hocPhanList) {
                System.out.format("%10d |", z);
                z++;
                System.out.format("%25s |", hp.getMaHp());
                System.out.format("%38s |", hp.getTenHp());
                System.out.format("%25s |", hp.getSoTin());
                System.out.format("%15.1f ", hp.getTrongSo());
                System.out.println("");
            }
        }
        else{
            System.out.println("Hệ thống rỗng");
        }
    }

    @Override
    public void xoaAll(){
        for(HocPhan x : hocPhanList){
            hocPhanList.remove(x);
        }
        hocPhanDao.write(hocPhanList);
        System.out.println("Xóa tất cả dữ liệu trong file học phần thành công");
    }
}
