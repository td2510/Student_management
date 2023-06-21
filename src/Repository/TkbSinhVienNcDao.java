package Repository;

import Entity.HocPhanSinhVienNc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TkbSinhVienNcDao {
    public void write(List<HocPhanSinhVienNc> hocPhanSinhVienNcList) {
        FileOutputStream fos =null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File("D:\\Documents\\tkbsinhviennc.txt"));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(hocPhanSinhVienNcList);
        } catch (FileNotFoundException e) {
            System.out.println("file không tồn tại");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    public List<HocPhanSinhVienNc> read() {
        List<HocPhanSinhVienNc> hocPhanSinhVienNcList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File("D:\\Documents\\tkbsinhviennc.txt"));
            ois = new ObjectInputStream(fis);
            hocPhanSinhVienNcList = (List<HocPhanSinhVienNc>) ois.readObject();
        } catch (IOException e) {
            System.out.println("Có một lỗi xảy ra");
        } catch (ClassNotFoundException e) {
            System.out.println("không tìm thấy class");
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return hocPhanSinhVienNcList;
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
