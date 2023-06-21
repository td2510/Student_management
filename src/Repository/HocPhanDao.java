package Repository;

import Entity.HocPhan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HocPhanDao {

    public void write(List<HocPhan> hocPhanList) {
        FileOutputStream fos =null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File("D:\\Documents\\dshocphan.txt"));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(hocPhanList);
        } catch (FileNotFoundException e) {
            System.out.println("file không tồn tại");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    public List<HocPhan> read() {
        List<HocPhan> hpList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File("D:\\Documents\\dshocphan.txt"));
            ois = new ObjectInputStream(fis);
            hpList = (List<HocPhan>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("không tìm thấy file để đọc");
        } catch (IOException e) {
            System.out.println("Có một lỗi xảy ra");
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy class");
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return hpList;
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
