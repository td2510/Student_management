package Application;


import Repository.TkbSinhVienNcDao;
import Service.*;
import Entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Application {
    public static void main(String[] args){

//        //Thêm các sinh viên tín chỉ vào file dành riêng cho sinh viên tín chỉ
//        SinhVienTc sinhVien1 = new SinhVienTc("trịnh hoàng quân","it2","it2-04","20204850","0327393234","kinh","14/01/2002","trịnh văn tuấn", "nguyễn thị hằng","Hà Nội",0,0,new ArrayList<HocPhanSinhVienTc>(),0);
//        SinhVienTc sinhVien2 = new SinhVienTc("ngô công dũng","it2","it2-04","20204729","0235684759","mông","22/02/2002","ngô văn mạnh","lã thì ánh","Nghệ An",0,0,new ArrayList<HocPhanSinhVienTc>(),0);
//        SinhVienTc sinhVien3 = new SinhVienTc("đinh thanh tùng","it2","it1-08","20200570","0258965478","kinh","15/07/2002","đinh xuân hải","nguyễn hồng ngọc","Hải Dương",0,0,new ArrayList<HocPhanSinhVienTc>(),0);
//        SinhVienTc sinhVien4 = new SinhVienTc("phạm đình cường","it2","it2-04","20204818","02158963257","kinh","12/01/2002","phạm văn minh","nguyễn thị hường","Hà Nội",0,0,new ArrayList<HocPhanSinhVienTc>(),0);
//        SinhVienTc sinhVien5 = new SinhVienTc("nguyễn tấn dũng","it1","it1-08","20200103","0867523555","kinh","11/12/2002","nguyễn văn hải","đặng thị huyền diệu","Sơn Tây",0,0,new ArrayList<HocPhanSinhVienTc>(),0);
//        QlsvTcServiceImpl ql = new QlsvTcServiceImpl();
//        ql.xoaSv("20204850");
//        ql.themSv(sinhVien1);
//        ql.themSv(sinhVien2);
//        ql.themSv(sinhVien3);
//        ql.themSv(sinhVien4);
//        ql.themSv(sinhVien5);
//        ql.showAllOfSystem();



//        //Thêm các sinh viên niên chế vào file dành riêng cho sinh viên niên chế
//        SinhVienNc sv1 = new SinhVienNc("nguyễn thái bảo","me2","me2-08","20201584","0258478965","kinh","12/02/2002","nguyễn bá từ"," cù thị hậu","Hà Nam",0,new ArrayList<HocPhanSinhVienNc>());
//        SinhVienNc sv2 = new SinhVienNc("nguyễn ngọc linh","me2","me2-08","201885234","0874458789","kinh","20/06/2000","nguyễn quốc đoan","nguyễn thanh huyền","Hà Nội",0,new ArrayList<HocPhanSinhVienNc>());
//        SinhVienNc sv3 = new SinhVienNc("nguyễn thái bảo","me2","me2-08","20192548","0874785478","kinh","12/07/2001","nguyễn văn hải","nguyễn thị lan","hải phòng",0,new ArrayList<HocPhanSinhVienNc>());
//        SinhVienNc sv4 = new SinhVienNc("phạm văn dũng","ite3","ite3-05","20204758","0327325896","kinh","14/11/2002","phạm văn toàn","nguyễn lan chi","bình định",0,new ArrayList<HocPhanSinhVienNc>());
//        SinhVienNc sv5 = new SinhVienNc("lò quang hải","ite3","ite3-05","20192584","0358964785","kinh","18/12/2001","lò văn luyện","bùi thị hải hường","tây nguyên",0,new ArrayList<HocPhanSinhVienNc>());
//        QlsvNcServiceImpl ql2 = new QlsvNcServiceImpl();
//        ql2.themSv(sv1);
//        ql2.themSv(sv2);
//        ql2.themSv(sv3);
//        ql2.themSv(sv4);
//        ql2.themSv(sv5);
//        ql2.showAllOfSystem();
//        ql2.showAllOfClass("ite3-05");
//        ql2.showAllOfClass("me2-08");



//        //Thêm các học phần vào file Học Phần
//        HocPhan gt1 = new HocPhan("Giải tích 1","MI1111",4,0.7,false);
//        HocPhan gt2 = new HocPhan("Giải tích 2","MI1121",3,0.7,false);
//        HocPhan gt3 = new HocPhan("Giải tích 3","MI1131",3,0.7,false);
//        HocPhan daiSo = new HocPhan("Đại số","MI1141",4,0.7,false);
//        HocPhan ppt = new HocPhan("Phương pháp tính","MI2010",2,0.5,false);
//        HocPhan trr = new HocPhan("Toán rời rạc","IT3020",3,0.6,false);
//        HocPhan thdc = new HocPhan("Tin học đại cương","IT1110",4,0.7,false);
//        HocPhan xstk = new HocPhan("Xác suât thống kê","MI2020",3,0.7,false);
//        HocPhan vldc1 = new HocPhan("Vật lý đại cương 1","PH1110",3,0.7,false);
//        HocPhan vldc2 = new HocPhan("Vật lý đại cương 2","PH1120",3,0.7,false);
//        HocPhan vldc3 = new HocPhan("Vật lý đại cương 3","PH1130",3,0.7,false);
//        HocPhan nhapMonCntt = new HocPhan("Nhập môn CNTT","IT2000",3,0.5,false);
//        HocPhan ctdlgt = new HocPhan("Cấu trúc dữ liệu và giải thuật","IT3011",2,0.6,false);
//        HocPhan kienTrucMt = new HocPhan("Kiến trúc máy tính","IT3030",3,0.6,false);
//        HocPhan nguyenLyHdh = new HocPhan("Nguyên lý Hệ điều hành","IT3070",3,0.7,false);
//        HocPhan coSoDl = new HocPhan("Cơ sở dữ liệu","IT1110",3,0.7,false);
//        HocPhan lapTrinhHdt = new HocPhan("Lập trình hướng đối tượng","IT3100",2,0.7,false);
//        HocPhan project1 = new HocPhan("Project 1","IT3150",2,0.7,false);
//        HocPhan project2 = new HocPhan("Project 2","IT3931",2,0.7,false);
//        HocPhan project3 = new HocPhan("Project 3","IT3943",3,0.7,false);
//        HocPhan thuatToanUd = new HocPhan("Thuật toán ứng dụng","IT3170",2,0.5,false);
//        HocPhan dtcntt = new HocPhan("Điện tử cho CNTT","IT3420",2,0.6,false);
//        HocPhan lapTrinhMang = new HocPhan("Lập trình mạng","IT4060",2,0.7,false);
//        HocPhan nhapMonAttt = new HocPhan("Nhập môn An toàn thông tin","IT4015",3,0.7,false);
//        HocPhan xuLyTinhieu = new HocPhan("Xử lý tín hiệu","IT4172",2,0.7,false);
//        HocPhan kyNangMem = new HocPhan("Kỹ năng mềm","ED3220",2,0.7,false);
//        HocPhan tlhvud = new HocPhan("Tâm lý học và ứng dụng","ED3280",2,0.7,false);
//        HocPhan vhkd = new HocPhan("Văn hóa kinh doanh và khởi nghiệp","EM1180",2,0.7,false);
//        HocPhan tdcn = new HocPhan("Tư duy công nghệ và thiết kế kỹ thuật","ET3262",2,0.7,false);
//        HocPhan tkmtcn = new HocPhan("Thiết kế mỹ thuật công nghiệp","TEX3123",2,0.7,false);
//        HocPhan thucTapKt = new HocPhan("Thực tập kỹ thuật","IT4991",2,0.7,false);
//        HocPhan bongChuyen1 = new HocPhan("Bóng chuyền 1","PE2101",0,0.5,false);
//        HocPhan bongChuyen2 = new HocPhan("Bóng chuyền 2","PE2102",0,0.5,false);
//        HocPhan bongChuyen3 = new HocPhan("Bóng chuyền 3","PE2103",0,0.5,false);
//        HocPhan bongDa1 = new HocPhan("Bóng đá 1","PE2201",0,0.5,false);
//        HocPhan bongDa2 = new HocPhan("Bóng đá 2","PE2202",0,0.5,false);
//        HocPhan bongDa3 = new HocPhan("Bóng đá 3","PE2203",0,0.5,false);
//        HocPhan bongRo1 = new HocPhan("Bóng rổ 1","PE2301",0,0.5,false);
//        HocPhan bongRo2 = new HocPhan("Bóng rổ 2","PE2302",0,0.5,false);
//        HocPhan bongRo3 = new HocPhan("Bóng rổ 3","PE2303",0,0.5,false);
//        HocPhan taekwondo1 = new HocPhan("Taekwondo 1","PE2251",0,0.5,false);
//        HocPhan taekwondo2 = new HocPhan("Taekwondo 2","PE2252",0,0.5,false);
//        HocPhan taekwondo3 = new HocPhan("Taekwondo 3","PE2253",0,0.5,false);
//        HocPhan bongBan1 = new HocPhan("Bóng bàn 1","PE2401",0,0.5,false);
//        HocPhan bongBan2 = new HocPhan("Bóng bàn 2","PE2402",0,0.5,false);
//        HocPhan bongBan3 = new HocPhan("Bóng bàn 3","PE2403",0,0.5,false);
//        HocPhan chay = new HocPhan("Chạy","PE2601",0,0.5,false);
//        HocPhan nhayCao = new HocPhan("Nhảy cao","PE2701",0,0.5,false);
//        HocPhan nhayXa = new HocPhan("Nhảy xa","PE2801",0,0.5,false);
//        HocPhan cauLong1 = new HocPhan("Cầu lông 1","PE2501",0,0.5,false);
//        HocPhan cauLong2 = new HocPhan("Cầu lông 2","PE2502",0,0.5,false);
//        HocPhan cauLong3 = new HocPhan("Cầu lông 3","PE2503",0,0.5,false);
//        HocPhan lyLuanTdtt = new HocPhan("Lý luận thể dục thể thao","PE1014",0,0.5,false);
//        HocPhan boiLoi = new HocPhan("Bơi lội","PE1024",0,0.5,false);
//        HocPhan pldc = new HocPhan("Pháp luật đại cương","EM1170",2,0.7,false);
//        HocPhan trietHoc = new HocPhan("Triết học","SSH1111",2,0.7,false);
//        HocPhan ktct = new HocPhan("Kinh tế chính trị","SSH1121",2,0.7,false);
//        HocPhan cnxh = new HocPhan("Chủ nghĩa xã hội","SSH1131",2,0.7,false);
//        HocPhan lsdcsvn = new HocPhan("Lịch sử đảng cộng sản Việt Nam","SSH1141",2,0.7,false);
//        HocPhan tthcm = new HocPhan("Tư tưởng Hồ Chí Minh","SSH1151",2,0.7,false);
//        HocPhan duongLoiQs = new HocPhan("Đường lối quân sự","MIL1110",0,0.5,false);
//        HocPhan ctqpAnNinh = new HocPhan("Công tác quốc phòng - an ninh","MIL1120",0,0.5,false);
//        HocPhan qsc = new HocPhan("QS chung và KCT bắn súng AK","MIL1130",0,0.5,false);
//        HocPhan tatc = new HocPhan("Tiếng anh tăng cường","FL1128",0,0.5,false);
//        HocPhan ta1 = new HocPhan("Tiếng anh 1","FL1129",0,0.5,false);
//        HocPhan ta2 = new HocPhan("Tiếng anh 2","FL1130",0,0.5,false);
//        HocPhanServiceImpl ghiHocPhan =new HocPhanServiceImpl();
//        ghiHocPhan.themHp(gt1);
//        ghiHocPhan.themHp(gt2);
//        ghiHocPhan.themHp(gt3);
//        ghiHocPhan.themHp(daiSo);
//        ghiHocPhan.themHp(ppt);
//        ghiHocPhan.themHp(trr);
//        ghiHocPhan.themHp(thdc);
//        ghiHocPhan.themHp(xstk);
//        ghiHocPhan.themHp(vldc1);
//        ghiHocPhan.themHp(vldc2);
//        ghiHocPhan.themHp(vldc3);
//        ghiHocPhan.themHp(nhapMonCntt);
//        ghiHocPhan.themHp(ctdlgt);
//        ghiHocPhan.themHp(kienTrucMt);
//        ghiHocPhan.themHp(nguyenLyHdh);
//        ghiHocPhan.themHp(coSoDl);
//        ghiHocPhan.themHp(lapTrinhHdt);
//        ghiHocPhan.themHp(project1);
//        ghiHocPhan.themHp(project2);
//        ghiHocPhan.themHp(project3);
//        ghiHocPhan.themHp(thuatToanUd);
//        ghiHocPhan.themHp(dtcntt);
//        ghiHocPhan.themHp(lapTrinhMang);
//        ghiHocPhan.themHp(nhapMonAttt);
//        ghiHocPhan.themHp(xuLyTinhieu);
//        ghiHocPhan.themHp(kyNangMem);
//        ghiHocPhan.themHp(tlhvud);
//        ghiHocPhan.themHp(vhkd);
//        ghiHocPhan.themHp(tdcn);
//        ghiHocPhan.themHp(tkmtcn);
//        ghiHocPhan.themHp(thucTapKt);
//        ghiHocPhan.themHp(bongChuyen1);
//        ghiHocPhan.themHp(bongChuyen2);
//        ghiHocPhan.themHp(bongChuyen3);
//        ghiHocPhan.themHp(bongDa1);
//        ghiHocPhan.themHp(bongDa2);
//        ghiHocPhan.themHp(bongDa3);
//        ghiHocPhan.themHp(bongRo1);
//        ghiHocPhan.themHp(bongRo2);
//        ghiHocPhan.themHp(bongRo3);
//        ghiHocPhan.themHp(taekwondo1);
//        ghiHocPhan.themHp(taekwondo2);
//        ghiHocPhan.themHp(taekwondo3);
//        ghiHocPhan.themHp(bongBan1);
//        ghiHocPhan.themHp(bongBan2);
//        ghiHocPhan.themHp(bongBan3);
//        ghiHocPhan.themHp(chay);
//        ghiHocPhan.themHp(nhayCao);
//        ghiHocPhan.themHp(nhayXa);
//        ghiHocPhan.themHp(cauLong1);
//        ghiHocPhan.themHp(cauLong2);
//        ghiHocPhan.themHp(cauLong3);
//        ghiHocPhan.themHp(lyLuanTdtt);
//        ghiHocPhan.themHp(boiLoi);
//        ghiHocPhan.themHp(pldc);
//        ghiHocPhan.themHp(trietHoc);
//        ghiHocPhan.themHp(ktct);
//        ghiHocPhan.themHp(cnxh);
//        ghiHocPhan.themHp(lsdcsvn);
//        ghiHocPhan.themHp(tthcm);
//        ghiHocPhan.themHp(duongLoiQs);
//        ghiHocPhan.themHp(ctqpAnNinh);
//        ghiHocPhan.themHp(qsc);
//        ghiHocPhan.themHp(tatc);
//        ghiHocPhan.themHp(ta1);
//        ghiHocPhan.themHp(ta2);
//        ghiHocPhan.show();


//        //Thêm vào thời khóa biểu sinh viên niên chế
//        HocPhanSinhVienNc hpMe21 = new HocPhanSinhVienNc("Thực tập kỹ thuật","IT4991",2,0.7,false,"me2",1);
//        HocPhanSinhVienNc hpMe22 = new HocPhanSinhVienNc("Giải tích 1","MI1111",4,0.7,false,"me2",1);
//        HocPhanSinhVienNc hpMe23 = new HocPhanSinhVienNc("Phương pháp tính","MI2010",2,0.5,false,"me2",1);
//        HocPhanSinhVienNc hpMe24 = new HocPhanSinhVienNc("Vật lý đại cương 1","PH1110",3,0.7,false,"me2",1);
//        HocPhanSinhVienNc hpMe25 = new HocPhanSinhVienNc("Bóng chuyền 1","PE2101",2,0.7,false,"me2",1);
//        HocPhanSinhVienNc hpMe26 = new HocPhanSinhVienNc("Kỹ năng mềm","ED3220",2,0.7,false,"me2",1);
//        HocPhanSinhVienNc hpMe27 = new HocPhanSinhVienNc("Giải tích 2","MI1121",3,0.7,false,"me2",2);
//        HocPhanSinhVienNc hpMe28 = new HocPhanSinhVienNc("Toán rời rạc","IT3020",3,0.6,false,"me2",2);
//        HocPhanSinhVienNc hpMe29 = new HocPhanSinhVienNc("Vật lý đại cương 2","PH1120",3,0.7,false,"me2",2);
//        HocPhanSinhVienNc hpMe210 = new HocPhanSinhVienNc("Tâm lý học và ứng dụng","ED3280",2,0.7,false,"me2",2);
//        HocPhanSinhVienNc hpMe211 = new HocPhanSinhVienNc("Thiết kế mỹ thuật công nghiệp","TEX3123",2,0.7,false,"me2",2);
//        HocPhanSinhVienNc hpMe212 = new HocPhanSinhVienNc("Bóng rổ 3","PE2303",0,0.5,false,"me2",2);
//        HocPhanSinhVienNc hpMe213 = new HocPhanSinhVienNc("Giải tích 3","MI1131",3,0.7,false,"me2",3);
//        HocPhanSinhVienNc hpMe214 = new HocPhanSinhVienNc("Vật lý đại cương 3","PH1130",3,0.7,false,"me2",3);
//        HocPhanSinhVienNc hpMe215 = new HocPhanSinhVienNc("Văn hóa kinh doanh và tinh thần khởi nghiệp","EM1180",2,0.7,false,"me2",3);
//        HocPhanSinhVienNc hpMe216 = new HocPhanSinhVienNc("Bóng đá 3","PE2203",0,0.5,false,"me2",3);
//        HocPhanSinhVienNc hpMe217 = new HocPhanSinhVienNc("Triết học mác-lênin","SSH1111",2,0.7,false,"me2",3);
//        HocPhanSinhVienNc hpMe218 = new HocPhanSinhVienNc("Tiếng anh tăng cường","FL1128",0,0.5,false,"me2",3);
//        HocPhanSinhVienNc hpMe219 = new HocPhanSinhVienNc("Tin học đại cương","IT1110",4,0.7,false,"me2",4);
//        HocPhanSinhVienNc hpMe220 = new HocPhanSinhVienNc("Nhập môn CNTT và TT","IT2000",3,0.5,false,"me2",4);
//        HocPhanSinhVienNc hpMe221 = new HocPhanSinhVienNc("Cấu trúc dữ liệu và thuật toán","IT3011",2,0.6,false,"me2",4);
//        HocPhanSinhVienNc hpMe222 = new HocPhanSinhVienNc("Bóng chuyền 3","PE2103",0,0.5,false,"me2",4);
//        HocPhanSinhVienNc hpMe223 = new HocPhanSinhVienNc("Kinh tế chính trị mác-lênin","SSH1121",2,0.7,false,"me2",4);
//        HocPhanSinhVienNc hpMe224 = new HocPhanSinhVienNc("Tiếng anh cơ sở 1","FL1129",0,0.5,false,"me2",5);
//        HocPhanSinhVienNc hpMe225 = new HocPhanSinhVienNc("Đường lối quân sự","MIL1110",0,0.5,false,"me2",5);
//        HocPhanSinhVienNc hpMe226 = new HocPhanSinhVienNc("Chủ nghĩa xã hội khoa học","SSH1131",2,0.7,false,"me2",5);
//        HocPhanSinhVienNc hpMe227 = new HocPhanSinhVienNc("Pháp luật đại cương","EM1170",2,0.7,false,"me2",5);
//        HocPhanSinhVienNc hpMe228 = new HocPhanSinhVienNc("Kiến trúc máy tính","IT3030",3,0.6,false,"me2",5);
//        HocPhanSinhVienNc hpMe229 = new HocPhanSinhVienNc("Nguyên lý hệ điều hành","IT3070",3,0.7,false,"me2",6);
//        HocPhanSinhVienNc hpMe230 = new HocPhanSinhVienNc("Lập trình hướng đối tượng","IT3100",2,0.7,false,"me2",6);
//        HocPhanSinhVienNc hpMe231 = new HocPhanSinhVienNc("Project 2","IT3931",2,0.7,false,"me2",6);
//        HocPhanSinhVienNc hpMe232 = new HocPhanSinhVienNc("Thuật toán ứng dụng","IT3170",2,0.5,false,"me2",6);
//        HocPhanSinhVienNc hpMe233 = new HocPhanSinhVienNc("Bóng chuyền 1","PE2101",0,0.5,false,"me2",6);
//        HocPhanSinhVienNc hpMe234 = new HocPhanSinhVienNc("Project 1","IT3150",2,0.7,false,"me2",7);
//        HocPhanSinhVienNc hpMe235 = new HocPhanSinhVienNc("Project 3","IT3943",3,0.7,false,"me2",7);
//        HocPhanSinhVienNc hpMe236 = new HocPhanSinhVienNc("Điện tử cho CNTT","IT3420",2,0.6,false,"me2",7);
//        HocPhanSinhVienNc hpMe237 = new HocPhanSinhVienNc("Lập trình mạng","IT4060",2,0.7,false,"me2",7);
//        HocPhanSinhVienNc hpMe238 = new HocPhanSinhVienNc("Nhập môn an toàn thông tin","IT4015",3,0.7,false,"me2",7);
//        HocPhanSinhVienNc hpMe239 = new HocPhanSinhVienNc("Xử lý tín hiệu","IT4172",2,0.7,false,"me2",8);
//        HocPhanSinhVienNc hpMe240 = new HocPhanSinhVienNc("Tư duy công nghệ và thiết kế kỹ thuật","ET3262",2,0.7,false,"me2",8);
//        HocPhanSinhVienNc hpMe241 = new HocPhanSinhVienNc("Bóng chuyền 2","PE2102",0,0.5,false,"me2",8);
//        HocPhanSinhVienNc hpMe242 = new HocPhanSinhVienNc("Lịch sử đảng cộng sản việt nam","SSH1141",2,0.7,false,"me2",8);
//        HocPhanSinhVienNc hpIte31 = new HocPhanSinhVienNc("Thực tập kỹ thuật","IT4991",2,0.7,false,"ite3",1);
//        HocPhanSinhVienNc hpIte32 = new HocPhanSinhVienNc("Giải tích 1","MI1111",4,0.7,false,"ite3",1);
//        HocPhanSinhVienNc hpIte33 = new HocPhanSinhVienNc("Phương pháp tính","MI2010",2,0.5,false,"ite3",1);
//        HocPhanSinhVienNc hpIte34 = new HocPhanSinhVienNc("Vật lý đại cương 1","PH1110",3,0.7,false,"ite3",1);
//        HocPhanSinhVienNc hpIte35 = new HocPhanSinhVienNc("Bóng chuyền 1","PE2101",2,0.7,false,"ite3",1);
//        HocPhanSinhVienNc hpIte36 = new HocPhanSinhVienNc("Kỹ năng mềm","ED3220",2,0.7,false,"ite3",1);
//        HocPhanSinhVienNc hpIte37 = new HocPhanSinhVienNc("Giải tích 2","MI1121",3,0.7,false,"ite3",2);
//        HocPhanSinhVienNc hpIte38 = new HocPhanSinhVienNc("Toán rời rạc","IT3020",3,0.6,false,"ite3",2);
//        HocPhanSinhVienNc hpIte39 = new HocPhanSinhVienNc("Vật lý đại cương 2","PH1120",3,0.7,false,"ite3",2);
//        HocPhanSinhVienNc hpIte310 = new HocPhanSinhVienNc("Tâm lý học và ứng dụng","ED3280",2,0.7,false,"ite3",2);
//        HocPhanSinhVienNc hpIte311 = new HocPhanSinhVienNc("Thiết kế mỹ thuật công nghiệp","TEX3123",2,0.7,false,"ite3",2);
//        HocPhanSinhVienNc hpIte312 = new HocPhanSinhVienNc("Bóng rổ 3","PE2303",0,0.5,false,"ite3",2);
//        HocPhanSinhVienNc hpIte313 = new HocPhanSinhVienNc("Giải tích 3","MI1131",3,0.7,false,"ite3",3);
//        HocPhanSinhVienNc hpIte314 = new HocPhanSinhVienNc("Vật lý đại cương 3","PH1130",3,0.7,false,"ite3",3);
//        HocPhanSinhVienNc hpIte315 = new HocPhanSinhVienNc("Văn hóa kinh doanh và tinh thần khởi nghiệp","EM1180",2,0.7,false,"ite3",3);
//        HocPhanSinhVienNc hpIte316 = new HocPhanSinhVienNc("Bóng đá 3","PE2203",0,0.5,false,"ite3",3);
//        HocPhanSinhVienNc hpIte317 = new HocPhanSinhVienNc("Triết học mác-lênin","SSH1111",2,0.7,false,"ite3",3);
//        HocPhanSinhVienNc hpIte318 = new HocPhanSinhVienNc("Tiếng anh tăng cường","FL1128",0,0.5,false,"ite3",3);
//        HocPhanSinhVienNc hpIte319 = new HocPhanSinhVienNc("Tin học đại cương","IT1110",4,0.7,false,"ite3",4);
//        HocPhanSinhVienNc hpIte320 = new HocPhanSinhVienNc("Nhập môn CNTT và TT","IT2000",3,0.5,false,"ite3",4);
//        HocPhanSinhVienNc hpIte321 = new HocPhanSinhVienNc("Cấu trúc dữ liệu và thuật toán","IT3011",2,0.6,false,"ite3",4);
//        HocPhanSinhVienNc hpIte322 = new HocPhanSinhVienNc("Bóng chuyền 3","PE2103",0,0.5,false,"ite3",4);
//        HocPhanSinhVienNc hpIte323 = new HocPhanSinhVienNc("Kinh tế chính trị mác-lênin","SSH1121",2,0.7,false,"ite3",4);
//        HocPhanSinhVienNc hpIte324 = new HocPhanSinhVienNc("Tiếng anh cơ sở 1","FL1129",0,0.5,false,"ite3",5);
//        HocPhanSinhVienNc hpIte325 = new HocPhanSinhVienNc("Đường lối quân sự","MIL1110",0,0.5,false,"ite3",5);
//        HocPhanSinhVienNc hpIte326 = new HocPhanSinhVienNc("Chủ nghĩa xã hội khoa học","SSH1131",2,0.7,false,"ite3",5);
//        HocPhanSinhVienNc hpIte327 = new HocPhanSinhVienNc("Pháp luật đại cương","EM1170",2,0.7,false,"ite3",5);
//        HocPhanSinhVienNc hpIte328 = new HocPhanSinhVienNc("Kiến trúc máy tính","IT3030",3,0.6,false,"ite3",5);
//        HocPhanSinhVienNc hpIte329 = new HocPhanSinhVienNc("Nguyên lý hệ điều hành","IT3070",3,0.7,false,"ite3",6);
//        HocPhanSinhVienNc hpIte330 = new HocPhanSinhVienNc("Lập trình hướng đối tượng","IT3100",2,0.7,false,"ite3",6);
//        HocPhanSinhVienNc hpIte331 = new HocPhanSinhVienNc("Project 2","IT3931",2,0.7,false,"ite3",6);
//        HocPhanSinhVienNc hpIte332 = new HocPhanSinhVienNc("Thuật toán ứng dụng","IT3170",2,0.5,false,"ite3",6);
//        HocPhanSinhVienNc hpIte333 = new HocPhanSinhVienNc("Bóng chuyền 1","PE2101",0,0.5,false,"ite3",6);
//        HocPhanSinhVienNc hpIte334 = new HocPhanSinhVienNc("Project 1","IT3150",2,0.7,false,"ite3",7);
//        HocPhanSinhVienNc hpIte335 = new HocPhanSinhVienNc("Project 3","IT3943",3,0.7,false,"ite3",7);
//        HocPhanSinhVienNc hpIte336 = new HocPhanSinhVienNc("Điện tử cho CNTT","IT3420",2,0.6,false,"ite3",7);
//        HocPhanSinhVienNc hpIte337 = new HocPhanSinhVienNc("Lập trình mạng","IT4060",2,0.7,false,"ite3",7);
//        HocPhanSinhVienNc hpIte338 = new HocPhanSinhVienNc("Nhập môn an toàn thông tin","IT4015",3,0.7,false,"ite3",7);
//        HocPhanSinhVienNc hpIte339 = new HocPhanSinhVienNc("Xử lý tín hiệu","IT4172",2,0.7,false,"ite3",8);
//        HocPhanSinhVienNc hpIte340 = new HocPhanSinhVienNc("Tư duy công nghệ và thiết kế kỹ thuật","ET3262",2,0.7,false,"ite3",8);
//        HocPhanSinhVienNc hpIte341 = new HocPhanSinhVienNc("Bóng chuyền 2","PE2102",0,0.5,false,"ite3",8);
//        HocPhanSinhVienNc hpIte342 = new HocPhanSinhVienNc("Lịch sử đảng cộng sản việt nam","SSH1141",2,0.7,false,"ite3",8);
//        TkbSinhVienNcServiceImpl tkbNc = new TkbSinhVienNcServiceImpl();
//        tkbNc.themHp(hpMe21);
//        tkbNc.themHp(hpMe22);
//        tkbNc.themHp(hpMe23);
//        tkbNc.themHp(hpMe24);
//        tkbNc.themHp(hpMe25);
//        tkbNc.themHp(hpMe26);
//        tkbNc.themHp(hpMe27);
//        tkbNc.themHp(hpMe28);
//        tkbNc.themHp(hpMe29);
//        tkbNc.themHp(hpMe210);
//        tkbNc.themHp(hpMe211);
//        tkbNc.themHp(hpMe212);
//        tkbNc.themHp(hpMe213);
//        tkbNc.themHp(hpMe214);
//        tkbNc.themHp(hpMe215);
//        tkbNc.themHp(hpMe216);
//        tkbNc.themHp(hpMe217);
//        tkbNc.themHp(hpMe218);
//        tkbNc.themHp(hpMe219);
//        tkbNc.themHp(hpMe220);
//        tkbNc.themHp(hpMe221);
//        tkbNc.themHp(hpMe222);
//        tkbNc.themHp(hpMe223);
//        tkbNc.themHp(hpMe224);
//        tkbNc.themHp(hpMe225);
//        tkbNc.themHp(hpMe226);
//        tkbNc.themHp(hpMe227);
//        tkbNc.themHp(hpMe228);
//        tkbNc.themHp(hpMe229);
//        tkbNc.themHp(hpMe230);
//        tkbNc.themHp(hpMe231);
//        tkbNc.themHp(hpMe232);
//        tkbNc.themHp(hpMe233);
//        tkbNc.themHp(hpMe234);
//        tkbNc.themHp(hpMe235);
//        tkbNc.themHp(hpMe236);
//        tkbNc.themHp(hpMe237);
//        tkbNc.themHp(hpMe238);
//        tkbNc.themHp(hpMe239);
//        tkbNc.themHp(hpMe240);
//        tkbNc.themHp(hpMe241);
//        tkbNc.themHp(hpMe242);
//        tkbNc.themHp(hpIte31);
//        tkbNc.themHp(hpIte32);
//        tkbNc.themHp(hpIte33);
//        tkbNc.themHp(hpIte34);
//        tkbNc.themHp(hpIte35);
//        tkbNc.themHp(hpIte36);
//        tkbNc.themHp(hpIte37);
//        tkbNc.themHp(hpIte38);
//        tkbNc.themHp(hpIte39);
//        tkbNc.themHp(hpIte310);
//        tkbNc.themHp(hpIte311);
//        tkbNc.themHp(hpIte312);
//        tkbNc.themHp(hpIte313);
//        tkbNc.themHp(hpIte314);
//        tkbNc.themHp(hpIte315);
//        tkbNc.themHp(hpIte316);
//        tkbNc.themHp(hpIte317);
//        tkbNc.themHp(hpIte318);
//        tkbNc.themHp(hpIte319);
//        tkbNc.themHp(hpIte320);
//        tkbNc.themHp(hpIte321);
//        tkbNc.themHp(hpIte322);
//        tkbNc.themHp(hpIte323);
//        tkbNc.themHp(hpIte324);
//        tkbNc.themHp(hpIte325);
//        tkbNc.themHp(hpIte326);
//        tkbNc.themHp(hpIte327);
//        tkbNc.themHp(hpIte328);
//        tkbNc.themHp(hpIte329);
//        tkbNc.themHp(hpIte330);
//        tkbNc.themHp(hpIte331);
//        tkbNc.themHp(hpIte332);
//        tkbNc.themHp(hpIte333);
//        tkbNc.themHp(hpIte334);
//        tkbNc.themHp(hpIte335);
//        tkbNc.themHp(hpIte336);
//        tkbNc.themHp(hpIte337);
//        tkbNc.themHp(hpIte338);
//        tkbNc.themHp(hpIte339);
//        tkbNc.themHp(hpIte340);
//        tkbNc.themHp(hpIte341);
//        tkbNc.themHp(hpIte342);
//
//        tkbNc.showByClass("me2");


//        //Dành cho sinh viên tín chỉ
//        HocPhanSinhVienTc tcgt1 = new HocPhanSinhVienTc("Giải tích 1","MI1111",4,0.7,false,"",false);
//        HocPhanSinhVienTc tcgt2 = new HocPhanSinhVienTc("Giải tích 2","MI1121",3,0.7,false,"",false);
//        HocPhanSinhVienTc tcgt3 = new HocPhanSinhVienTc("Giải tích 3","MI1131",3,0.7,false,"",false);
//        HocPhanSinhVienTc tcdaiSo = new HocPhanSinhVienTc("Đại số","MI1141",4,0.7,false,"",false);
//        HocPhanSinhVienTc tcppt = new HocPhanSinhVienTc("Phương pháp tính","MI2010",2,0.5,false,"",false);
//        HocPhanSinhVienTc tctrr = new HocPhanSinhVienTc("Toán rời rạc","IT3020",3,0.6,false,"",false);
//        HocPhanSinhVienTc tcthdc = new HocPhanSinhVienTc("Tin học đại cương","IT1110",4,0.7,false,"",false);
//        HocPhanSinhVienTc tcxstk = new HocPhanSinhVienTc("Xác suât thống kê","MI2020",3,0.7,false,"",false);
//        HocPhanSinhVienTc tcvldc1 = new HocPhanSinhVienTc("Vật lý đại cương 1","PH1110",3,0.7,false,"",false);
//        HocPhanSinhVienTc tcvldc2 = new HocPhanSinhVienTc("Vật lý đại cương 2","PH1120",3,0.7,false,"",false);
//        HocPhanSinhVienTc tcvldc3 = new HocPhanSinhVienTc("Vật lý đại cương 3","PH1130",3,0.7,false,"",false);
//        HocPhanSinhVienTc tcnhapMonCntt = new HocPhanSinhVienTc("Nhập môn CNTT","IT2000",3,0.5,false,"",false);
//        HocPhanSinhVienTc tcctdlgt = new HocPhanSinhVienTc("Cấu trúc dữ liệu và giải thuật","IT3011",2,0.6,false,"",false);
//        HocPhanSinhVienTc tckienTrucMt = new HocPhanSinhVienTc("Kiến trúc máy tính","IT3030",3,0.6,false,"",false);
//        HocPhanSinhVienTc tcnguyenLyHdh = new HocPhanSinhVienTc("Nguyên lý Hệ điều hành","IT3070",3,0.7,false,"",false);
//        HocPhanSinhVienTc tccoSoDl = new HocPhanSinhVienTc("Cơ sở dữ liệu","IT1110",3,0.7,false,"",false);
//        HocPhanSinhVienTc tclapTrinhHdt = new HocPhanSinhVienTc("Lập trình hướng đối tượng","IT3100",2,0.7,false,"",false);
//        HocPhanSinhVienTc tcproject1 = new HocPhanSinhVienTc("Project 1","IT3150",2,0.7,false,"",false);
//        HocPhanSinhVienTc tcproject2 = new HocPhanSinhVienTc("Project 2","IT3931",2,0.7,false,"",false);
//        HocPhanSinhVienTc tcproject3 = new HocPhanSinhVienTc("Project 3","IT3943",3,0.7,false,"",false);
//        HocPhanSinhVienTc tcthuatToanUd = new HocPhanSinhVienTc("Thuật toán ứng dụng","IT3170",2,0.5,false,"",false);
//        HocPhanSinhVienTc tcdtcntt = new HocPhanSinhVienTc("Điện tử cho CNTT","IT3420",2,0.6,false,"",false);
//        HocPhanSinhVienTc tclapTrinhMang = new HocPhanSinhVienTc("Lập trình mạng","IT4060",2,0.7,false,"",false);
//        HocPhanSinhVienTc tcnhapMonAttt = new HocPhanSinhVienTc("Nhập môn An toàn thông tin","IT4015",3,0.7,false,"",false);
//        HocPhanSinhVienTc tcxuLyTinhieu = new HocPhanSinhVienTc("Xử lý tín hiệu","IT4172",2,0.7,false,"",false);
//        HocPhanSinhVienTc tckytNangMem = new HocPhanSinhVienTc("Kỹ năng mềm","ED3220",2,0.7,false,"",false);
//        HocPhanSinhVienTc tctlhvud = new HocPhanSinhVienTc("Tâm lý học và ứng dụng","ED3280",2,0.7,false,"",false);
//        HocPhanSinhVienTc tcvhkd = new HocPhanSinhVienTc("Văn hóa kinh doanh và khởi nghiệp","EM1180",2,0.7,false,"",false);
//        HocPhanSinhVienTc tctdcn = new HocPhanSinhVienTc("Tư duy công nghệ và thiết kế kỹ thuật","ET3262",2,0.7,false,"",false);
//        HocPhanSinhVienTc tctkmtcn = new HocPhanSinhVienTc("Thiết kế mỹ thuật công nghiệp","TEX3123",2,0.7,false,"",false);
//        HocPhanSinhVienTc tcthucTapKt = new HocPhanSinhVienTc("Thực tập kỹ thuật","IT4991",2,0.7,false,"",false);
//        HocPhanSinhVienTc tcbongChuyen1 = new HocPhanSinhVienTc("Bóng chuyền 1","PE2101",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcbongChuyen2 = new HocPhanSinhVienTc("Bóng chuyền 2","PE2102",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcbongChuyen3 = new HocPhanSinhVienTc("Bóng chuyền 3","PE2103",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcbongDa1 = new HocPhanSinhVienTc("Bóng đá 1","PE2201",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcbongDa2 = new HocPhanSinhVienTc("Bóng đá 2","PE2202",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcbongDa3 = new HocPhanSinhVienTc("Bóng đá 3","PE2203",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcbongRo1 = new HocPhanSinhVienTc("Bóng rổ 1","PE2301",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcbongRo2 = new HocPhanSinhVienTc("Bóng rổ 2","PE2302",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcbongRo3 = new HocPhanSinhVienTc("Bóng rổ 3","PE2303",0,0.5,false,"",false);
//        HocPhanSinhVienTc tctaekwondo1 = new HocPhanSinhVienTc("Taekwondo 1","PE2251",0,0.5,false,"",false);
//        HocPhanSinhVienTc tctaekwondo2 = new HocPhanSinhVienTc("Taekwondo 2","PE2252",0,0.5,false,"",false);
//        HocPhanSinhVienTc tctaekwondo3 = new HocPhanSinhVienTc("Taekwondo 3","PE2253",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcbongBan1 = new HocPhanSinhVienTc("Bóng bàn 1","PE2401",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcbongBan2 = new HocPhanSinhVienTc("Bóng bàn 2","PE2402",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcbongBan3 = new HocPhanSinhVienTc("Bóng bàn 3","PE2403",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcchay = new HocPhanSinhVienTc("Chạy","PE2601",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcnhayCao = new HocPhanSinhVienTc("Nhảy cao","PE2701",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcnhayXa = new HocPhanSinhVienTc("Nhảy xa","PE2801",0,0.5,false,"",false);
//        HocPhanSinhVienTc tccauLong1 = new HocPhanSinhVienTc("Cầu lông 1","PE2501",0,0.5,false,"",false);
//        HocPhanSinhVienTc tccauLong2 = new HocPhanSinhVienTc("Cầu lông 2","PE2502",0,0.5,false,"",false);
//        HocPhanSinhVienTc tccauLong3 = new HocPhanSinhVienTc("Cầu lông 3","PE2503",0,0.5,false,"",false);
//        HocPhanSinhVienTc tclyLuanTdtt = new HocPhanSinhVienTc("Lý luận thể dục thể thao","PE1014",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcboiLoi = new HocPhanSinhVienTc("Bơi lội","PE1024",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcpldc = new HocPhanSinhVienTc("Pháp luật đại cương","EM1170",2,0.7,false,"",false);
//        HocPhanSinhVienTc tctrietHoc = new HocPhanSinhVienTc("Triết học","SSH1111",2,0.7,false,"",false);
//        HocPhanSinhVienTc tcktct = new HocPhanSinhVienTc("Kinh tế chính trị","SSH1121",2,0.7,false,"",false);
//        HocPhanSinhVienTc tccnxh = new HocPhanSinhVienTc("Chủ nghĩa xã hội","SSH1131",2,0.7,false,"",false);
//        HocPhanSinhVienTc tclsdcsvn = new HocPhanSinhVienTc("Lịch sử đảng cộng sản Việt Nam","SSH1141",2,0.7,false,"",false);
//        HocPhanSinhVienTc tctthcm = new HocPhanSinhVienTc("Tư tưởng Hồ Chí Minh","SSH1151",2,0.7,false,"",false);
//        HocPhanSinhVienTc tcduongLoiQs = new HocPhanSinhVienTc("Đường lối quân sự","MIL1110",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcctqpAnNinh = new HocPhanSinhVienTc("Công tác quốc phòng - an ninh","MIL1120",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcqsc = new HocPhanSinhVienTc("QS chung và KCT bắn súng AK","MIL1130",0,0.5,false,"",false);
//        HocPhanSinhVienTc tctatc = new HocPhanSinhVienTc("Tiếng anh tăng cường","FL1128",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcta1 = new HocPhanSinhVienTc("Tiếng anh 1","FL1129",0,0.5,false,"",false);
//        HocPhanSinhVienTc tcta2 = new HocPhanSinhVienTc("Tiếng anh 2","FL1130",0,0.5,false,"",false);
////
//        DangKyHocPhanTcImpl dkTc = new DangKyHocPhanTcImpl();
//        dkTc.themHp(tcgt1);
//        dkTc.themHp(tcgt2);
//        dkTc.themHp(tcgt3);
//        dkTc.themHp(tcdaiSo);
//        dkTc.themHp(tcppt);
//        dkTc.themHp(tctrr);
//        dkTc.themHp(tcthdc);
//        dkTc.themHp(tcxstk);
//        dkTc.themHp(tcvldc1);
//        dkTc.themHp(tcvldc2);
//        dkTc.themHp(tcvldc3);
//        dkTc.themHp(tcnhapMonCntt);
//        dkTc.themHp(tcctdlgt);
//        dkTc.themHp(tckienTrucMt);
//        dkTc.themHp(tcnguyenLyHdh);
//        dkTc.themHp(tccoSoDl);
//        dkTc.themHp(tclapTrinhHdt);
//        dkTc.themHp(tcthuatToanUd);
//        dkTc.themHp(tcproject1);
//        dkTc.themHp(tcproject2);
//        dkTc.themHp(tcproject3);
//        dkTc.themHp(tcdtcntt);
//        dkTc.themHp(tclapTrinhMang);
//        dkTc.themHp(tcnhapMonAttt);
//        dkTc.themHp(tcxuLyTinhieu);
//        dkTc.themHp(tckytNangMem);
//        dkTc.themHp(tctlhvud);
//        dkTc.themHp(tcvhkd);
//        dkTc.themHp(tctdcn);
//        dkTc.themHp(tctkmtcn);
//        dkTc.themHp(tcthucTapKt);
//        dkTc.themHp(tcbongChuyen1);
//        dkTc.themHp(tcbongChuyen2);
//        dkTc.themHp(tcbongChuyen3);
//        dkTc.themHp(tcbongDa1);
//        dkTc.themHp(tcbongDa2);
//        dkTc.themHp(tcbongDa3);
//        dkTc.themHp(tcbongRo1);
//        dkTc.themHp(tcbongRo2);
//        dkTc.themHp(tcbongRo3);
//        dkTc.themHp(tctaekwondo1);
//        dkTc.themHp(tctaekwondo2);
//        dkTc.themHp(tctaekwondo3);
//        dkTc.themHp(tcbongBan1);
//        dkTc.themHp(tcbongBan2);
//        dkTc.themHp(tcbongBan3);
//        dkTc.themHp(tcchay);
//        dkTc.themHp(tcnhayCao);
//        dkTc.themHp(tcnhayXa);
//        dkTc.themHp(tccauLong1);
//        dkTc.themHp(tccauLong2);
//        dkTc.themHp(tccauLong3);
//        dkTc.themHp(tclyLuanTdtt);
//        dkTc.themHp(tcboiLoi);
//        dkTc.themHp(tcpldc);
//        dkTc.themHp(tctrietHoc);
//        dkTc.themHp(tcktct);
//        dkTc.themHp(tccnxh);
//        dkTc.themHp(tclsdcsvn);
//        dkTc.themHp(tctthcm);
//        dkTc.themHp(tcduongLoiQs);
//        dkTc.themHp(tcctqpAnNinh);
//        dkTc.themHp(tcqsc);
//        dkTc.themHp(tctatc);
//        dkTc.themHp(tcta1);
//        dkTc.themHp(tcta2);
//        dkTc.themSV(sinhVien1);
//        dkTc.themSV(sinhVien2);
//        dkTc.themSV(sinhVien3);
//        dkTc.dangKyHp("MI1121","20204850");
//        dkTc.dangKyHp("MI1121","20204850");
//        dkTc.dangKyHp("MI1111","20204850");
//        dkTc.tinhDiemHP("20204850");
//        dkTc.showByMssv("20204850");











        //Menu hiển thị cho người dùng
        System.out.println("======================================================MENU===================================================");
        Scanner sc = new Scanner(System.in);
        int b,c,d;
        do{
            System.out.println("\nBạn muốn làm gì (nhấn 0 để thoát)");
            System.out.println("1. Quản lý sinh viên tín chỉ");
            System.out.println("2. Quản lý sinh viên niên chế");
            System.out.println("3. Nhập điểm cho sinh viên tín chỉ");
            System.out.println("4. Nhập điểm cho sinh viên niên chế");
            System.out.println("5. Đăng ký học phần dành cho sinh viên tín chỉ");
            System.out.println("6. Xem danh sách thông tin học phần");
            System.out.print("Bạn chọn: ");
            b = sc.nextInt();
            System.out.println("");
            if (b == 1) {
                System.out.println("\nĐây là chương trình quản lý sinh viên tín chỉ. Bạn muốn làm gì (nhấn 0 để quay lại)");
                System.out.println("1. Xem tất cả sinh viên trong hệ thống sinh viên tín chỉ");
                System.out.println("2. Xem thông tin cá nhân của sinh viên");
                System.out.println("3. Xem tất cả sinh viên trong lớp học");
                System.out.println("4. Xét tốt nghiệp cho sinh viên");
                System.out.println("5. Thêm sinh viên mới");
                System.out.println("6. Thông tin học phần của sinh viên tín chỉ");
                System.out.println("7. Xóa sinh viên");
                System.out.print("Bạn chọn: ");
                c = sc.nextInt();
                System.out.println("");
                QlsvTcServiceImpl qlsvTc = new QlsvTcServiceImpl();
                switch (c){
                    case 0:
                        break;
                    case 1:
                        qlsvTc.showAllOfSystem();
                        System.out.println("\n");
                        break;
                    case 2:
                        System.out.print("Nhập mssv cần tìm: ");
                        String mssv2 = sc.next();
                        System.out.println("");
                        qlsvTc.showByMssv(mssv2);
                        System.out.println("\n");
                        break;
                    case 3:
                        System.out.print("Nhập lớp học cần tìm: ");
                        String lopHoc1 = sc.next();
                        System.out.println("");
                        qlsvTc.showAllOfClass(lopHoc1);
                        System.out.println("\n");
                        break;
                    case 4:
                        System.out.print("Nhập mssv cần tìm: ");
                        String mssv1 = sc.next();
                        System.out.println("");
                        qlsvTc.xetTotNghiep(mssv1);
                        System.out.println("\n");
                        break;
                    case 5:
                        System.out.println("Nhập dữ liệu cho sinh viên mới");
                        System.out.print("Nhập họ tên: ");
                        String c1 =sc.nextLine();
                        String hoTen = sc.nextLine();
                        System.out.print("Nhập ngành học: ");
                        String ngangHoc = sc.nextLine();
                        System.out.print("Nhập lớp học: ");
                        String lopHoc = sc.nextLine();
                        System.out.print("Nhập mssv: ");
                        String mssv = sc.nextLine();
                        System.out.print("Nhập số điện thoại: ");
                        String sdt = sc.nextLine();
                        System.out.print("Nhập dân tộc: ");
                        String danToc = sc.nextLine();
                        System.out.print("Nhập ngày sinh: ");
                        String ngaySinh = sc.nextLine();
                        System.out.print("Nhập tên bố: ");
                        String tenBo = sc.nextLine();
                        System.out.print("Nhập tên mẹ: ");
                        String tenMe = sc.nextLine();
                        System.out.print("Nhập địa chỉ: ");
                        String diaChi = sc.nextLine();
//                        sc.nextLine();
                        qlsvTc.themSv(new SinhVienTc(hoTen, ngangHoc, lopHoc, mssv, sdt, danToc, ngaySinh, tenBo, tenMe, diaChi, 0,0, new ArrayList<HocPhanSinhVienTc>(),0));
                        System.out.println("\n");
                        System.out.println("Hệ thống sinh viên tín chỉ hiện tại: ");
                        qlsvTc.showAllOfSystem();
                        break;

                    case 6:
                        DangKyHocPhanTcImpl dk = new DangKyHocPhanTcImpl();
                        System.out.print("Nhập mssv: ");
                        String mssv4=sc.next();
                        dk.showByMssv(mssv4);
                        break;
                    case 7:
                        System.out.print("Hãy nhập mssv: ");
                        String ms = sc.next();
                        qlsvTc.xoaSv(ms);
                        break;
                }
                if(c<1 && c>7){
                    System.out.println("Bạn nhập sai cú pháp.\n");
                }
            } else if(b==2){
                System.out.println("\nĐây là chương trình quản lý sinh viên niên chế. Bạn muốn làm gì (nhấn 0 để quay lại)");
                System.out.println("1. Xem tất cả sinh viên trong hệ thống sinh viên niên chế");
                System.out.println("2. Xem thông tin cá nhân của sinh viên");
                System.out.println("3. Xem tất cả sinh viên trong lớp học");
                System.out.println("4. Xét tốt nghiệp cho sinh viên");
                System.out.println("5. Thêm sinh viên mới");
                System.out.println("6. Xem thời khóa biểu");
                System.out.println("7. Xóa sinh viên");
                System.out.print("Bạn chọn: ");
                d = sc.nextInt();
                System.out.println("");
                QlsvNcServiceImpl qlsvNc = new QlsvNcServiceImpl();
                TkbSinhVienNcServiceImpl tkb = new TkbSinhVienNcServiceImpl();
                TkbSinhVienNcDao tkbSinhVienNcDao = new TkbSinhVienNcDao();
                List<HocPhanSinhVienNc> svnc= tkbSinhVienNcDao.read();
                switch (d){
                    case 0:
                        break;
                    case 1:
                        qlsvNc.showAllOfSystem();
                        break;
                    case 2:
                        System.out.print("Nhập mssv cần tìm: ");
                        String mssv2 = sc.next();
                        System.out.println("");
                        qlsvNc.showByMssv(mssv2);
                        break;
                    case 3:
                        System.out.print("Nhập lớp học cần tìm: ");
                        String lopHoc1 = sc.next();
                        System.out.println("");
                        qlsvNc.showAllOfClass(lopHoc1);
                        System.out.println("\n");
                        break;
                    case 4:
                        System.out.print("Nhập mssv cần tìm: ");
                        String mssv1 = sc.next();
                        System.out.println("");
                        qlsvNc.xetTotNghiep(mssv1);
                        System.out.println("\n");
                        break;
                    case 5:
                        System.out.println("Nhập dữ liệu cho sinh viên mới");
                        System.out.print("Nhập họ tên: ");
                        String c1 =sc.nextLine();
                        String hoTen = sc.nextLine();
                        System.out.print("Nhập ngành học: ");
                        String ngangHoc = sc.nextLine();
                        System.out.print("Nhập lớp học: ");
                        String lopHoc = sc.nextLine();
                        System.out.print("Nhập mssv: ");
                        String mssv = sc.nextLine();
                        System.out.print("Nhập số điện thoại: ");
                        String sdt = sc.nextLine();
                        System.out.print("Nhập dân tộc: ");
                        String danToc = sc.nextLine();
                        System.out.print("Nhập ngày sinh: ");
                        String ngaySinh = sc.nextLine();
                        System.out.print("Nhập tên bố: ");
                        String tenBo = sc.nextLine();
                        System.out.print("Nhập tên mẹ: ");
                        String tenMe = sc.nextLine();
                        System.out.print("Nhập địa chỉ: ");
                        String diaChi = sc.nextLine();
                        sc.nextLine();
                        List<HocPhanSinhVienNc> list = new ArrayList<HocPhanSinhVienNc>();
                        for(HocPhanSinhVienNc g : svnc){
                            if(g.getNganhHoc().equals(ngangHoc)==true){
                                list.add(g);
                            }
                        }
                        qlsvNc.themSv(new SinhVienNc(hoTen, ngangHoc, lopHoc, mssv, sdt, danToc, ngaySinh, tenBo, tenMe, diaChi, 0, list));
                        System.out.println("\n");
                        System.out.println("Hệ thống sinh viên tín chỉ hiện tại: ");
                        qlsvNc.showAllOfSystem();
                        break;
                    case 6:
                        System.out.print("Nhập tên ngành: ");
                        String tenNganh=sc.next();
                        tkb.showByClass(tenNganh);
                        break;
                    case 7:
                        System.out.print("Nhập mssv: ");
                        String ms =sc.next();
                        qlsvNc.xoaSv(ms);
                        break;
                }
                if(d<1 && d>7){
                    System.out.println("Bạn nhập sai cú pháp.\n");
                }
            } else if(b==3){
                System.out.println("\nĐây là chương trình nhập điểm cho sinh viên tín chỉ.");
                System.out.println("1. Nhập điểm toeic");
                System.out.println("2. Nhập điểm học phần");
                DangKyHocPhanTcImpl dk = new DangKyHocPhanTcImpl();
                QlsvTcServiceImpl dk1 = new QlsvTcServiceImpl();
                int t= sc.nextInt();
                switch (t){
                    case 1:
                        System.out.print("\nNhập mssv: ");
                        String mssv1 = sc.next();
                        dk1.tinhDiemToeic(mssv1);
                        break;
                    case 2:
                        System.out.print("\nNhập mssv: ");
                        String mssv = sc.next();
                        dk.tinhDiemHP(mssv);
                        break;
                }
            } else if(b==4){
                System.out.println("\nĐây là chương trình nhập điểm cho sinh viên niên chế.");
                System.out.println("1. Nhập điểm toeic");
                System.out.println("2. Xét điều kiện học phần có qua hay không");
                QlsvNcServiceImpl nc = new QlsvNcServiceImpl();
                int t= sc.nextInt();
                switch (t){
                    case 1:
                        System.out.print("\nNhập mssv: ");
                        String mssv1 = sc.next();
                        nc.tinhDiemToeic(mssv1);
                        break;
                    case 2:
                        System.out.print("\nNhập mssv: ");
                        String mssv = sc.next();
                        nc.xetDkhp(mssv);
                        break;
                }
            } else if(b==5){
                System.out.println("\nĐây là chương trình đăng ký học phần cho sinh viên tín chỉ.");
                DangKyHocPhanTcImpl dk = new DangKyHocPhanTcImpl();
                System.out.print("Nhập mssv: ");
                String mssv = sc.next();
                dk.dangKyHp(mssv);
            } else if(b==6){
                HocPhanServiceImpl hp = new HocPhanServiceImpl();
                hp.show();
            }
        } while (b!=0);
    }
}
