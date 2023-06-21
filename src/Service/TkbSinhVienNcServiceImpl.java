package Service;

import Entity.HocPhan;
import Entity.HocPhanSinhVienNc;
import Repository.HocPhanDao;
import Repository.TkbSinhVienNcDao;

import java.util.List;

public class TkbSinhVienNcServiceImpl implements TkbSinhVienNcService {
    private List<HocPhanSinhVienNc> hocPhanNCList;
    private TkbSinhVienNcDao tkbSinhVienNcDao;
    private HocPhanDao hocPhanDao;
    private List<HocPhan> hocPhanList;
    public TkbSinhVienNcServiceImpl() {
        tkbSinhVienNcDao = new TkbSinhVienNcDao();
        hocPhanNCList = tkbSinhVienNcDao.read();
        hocPhanDao = new HocPhanDao();
        hocPhanList = hocPhanDao.read();
    }

    @Override
    public void themHp(HocPhanSinhVienNc hocPhanSinhVienNc){
        try{
            int x=0, y=0;
            for(HocPhanSinhVienNc a: hocPhanNCList){
                if(a.getMaHp().equals(hocPhanSinhVienNc.getMaHp())==true && a.getNganhHoc().equals(hocPhanSinhVienNc.getNganhHoc())==true){
                    System.out.println("Đã tồn tại học phần "+ hocPhanSinhVienNc.getMaHp());
                    x++;
                    break;
                }
            }
            for(HocPhan a: hocPhanList){
                if(a.getMaHp().equals(hocPhanSinhVienNc.getMaHp())==false){//kiểm tra xem mã học phần đầu vào có giống với mã học phân trong file học phần không
                    y++;
                }
            }
            if(y==hocPhanList.size()){
                System.out.format("Học phần %s không tồn tại trong danh sách học phần", hocPhanSinhVienNc.getMaHp());
            }
            if(x==0 && y!=hocPhanList.size()) {
                hocPhanNCList.add(hocPhanSinhVienNc);
                tkbSinhVienNcDao.write(hocPhanNCList);
            }
        }
        catch (Exception e){
            System.out.println("Có lỗi xảy ra");
        }
    }

    @Override
    public void xoaHp(String maHp, String nganhHoc) {
        int x=0;
        for (int i = 0; i < hocPhanNCList.size(); i++) {
            if (hocPhanNCList.get(i).getMaHp().equals(maHp) == true && hocPhanNCList.get(i).getNganhHoc().equals(nganhHoc)) {
                hocPhanNCList.remove(hocPhanNCList.get(i));
                x++;
            }
        }
        if(x!=0){
            System.out.println("Xóa thành công học phần "+maHp);
        }
        else {
            System.out.println("Không tồn tại học phần "+maHp);
        }
        tkbSinhVienNcDao.write(hocPhanNCList);
    }

    @Override
    public void showByClass(String nganhHoc) {
        String a="Mã Học Phần";
        String e="Tên Học Phần";
        String d="Kỳ học";
        System.out.format("\n\n==========================================TKB Ngành Học %s==========================================\n\n", nganhHoc);
        System.out.format("%15s |",a);
        System.out.format("%50s |", e);
        System.out.format("%15s", d);
        System.out.println("");
        int x=1;
        if(hocPhanNCList!=null){
            do{
                for (HocPhanSinhVienNc hp : hocPhanNCList) {
                    if(hp.getKyhoc()==x && hp.getNganhHoc().equals(nganhHoc)==true) {
                        System.out.format("%15s |", hp.getMaHp());
                        System.out.format("%50s |", hp.getTenHp());
                        System.out.format("%15d ", hp.getKyhoc());
                        System.out.println("");
                    }
                }
                x++;
            }while(x <9);
        }
        else{
            System.out.println("Hệ thống không có dữ liệu");
        }
        System.out.println("\n\n");
    }

    @Override
    public void xoaAll(){
        for(HocPhanSinhVienNc x :hocPhanNCList){
            hocPhanNCList.remove(x);
        }
        tkbSinhVienNcDao.write(hocPhanNCList);
        System.out.println("Xóa tất cả dữ liệu trong file thời khóa biểu sinh viên niên chế thành công");
    }
}
