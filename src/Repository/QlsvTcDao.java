package Repository;

import Entity.SinhVienTc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QlsvTcDao {
    public void write(List<SinhVienTc> sinhVienTcList) {
        FileOutputStream fos =null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File("D:\\Documents\\sinhvientc.txt"));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(sinhVienTcList);
        } catch (FileNotFoundException e) {
            System.out.println("file không tồn tại");
        } catch (IOException e) {
            System.out.println("Có lỗi");
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    public List<SinhVienTc> read() {
        List<SinhVienTc> sinhVienTcList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File("D:\\Documents\\sinhvientc.txt"));
            ois = new ObjectInputStream(fis);
            sinhVienTcList = (List<SinhVienTc>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("không tìm thấy file để đọc");
        } catch (IOException e) {
            System.out.println("Có một lỗi xảy ra");
        } catch (ClassNotFoundException e) {
            System.out.println("không tìm thấy class");
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return sinhVienTcList;
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
