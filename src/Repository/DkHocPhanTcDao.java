package Repository;

import Entity.HocPhanSinhVienTc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DkHocPhanTcDao {
    public void write(List<HocPhanSinhVienTc> hocPhanSinhVienTcList) {
        FileOutputStream fos =null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File("D:\\Documents\\dkhocphantc.txt"));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(hocPhanSinhVienTcList);
        } catch (FileNotFoundException e) {
            System.out.println("file không tồn tại");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    public List<HocPhanSinhVienTc> read() {
        List<HocPhanSinhVienTc> hocPhanSinhVienTcList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File("D:\\Documents\\dkhocphantc.txt"));
            ois = new ObjectInputStream(fis);
            hocPhanSinhVienTcList = (List<HocPhanSinhVienTc>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file để đọc");
        } catch (IOException e) {
            System.out.println("Có một lỗi xảy ra");
        } catch (ClassNotFoundException e) {
            System.out.println("không tìm thấy class");
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return hocPhanSinhVienTcList;
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
