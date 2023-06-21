package Repository;

import Entity.SinhVienNc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QlsvNcDao {
    public void write(List<SinhVienNc> sinhVienNcList) {
        FileOutputStream fos =null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File("D:\\Documents\\sinhviennc.txt"));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(sinhVienNcList);
        } catch (FileNotFoundException e) {
            System.out.println("file không tồn tại");
        } catch (IOException e) {
            System.out.println("có lỗi");
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    public List<SinhVienNc> read() {
        List<SinhVienNc> sinhVienNcList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File("D:\\Documents\\sinhviennc.txt"));
            ois = new ObjectInputStream(fis);
            sinhVienNcList = (List<SinhVienNc>) ois.readObject();
        } catch (IOException e) {
            System.out.println("Có một lỗi xảy ra");
        } catch (ClassNotFoundException e) {
            System.out.println("không tìm thấy class");
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return sinhVienNcList;
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
