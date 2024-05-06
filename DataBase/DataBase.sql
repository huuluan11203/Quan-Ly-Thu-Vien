/*Database: `qltv`*/


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


CREATE Database qltv;
USE qltv;



CREATE TABLE `accounts` (
  `MaTaiKhoan` int NOT NULL,
  `TenDN` varchar(255) NOT NULL UNIQUE,
  `MatKhau` varchar(255) DEFAULT '123456',
  `Access` int NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `accounts` (`MaTaiKhoan`, `TenDN`, `MatKhau`, `Access`) VALUES 
(997,"1234","1234",0),
(998,"becutenhatthegian","2010",0),
(999,"admin","admin",0);





CREATE TABLE `nhanvien` (
  `MaNV` int NOT NULL,
  `TenNV` varchar(255) NOT NULL UNIQUE,
  `Namsinh` DATE NOT NULL ,
  `GioiTinh` varchar(10) NOT NULL,
  `Sdt` varchar(20) NOT NULL UNIQUE,
  `DiaChi` varchar(255) NOT NULL,
  `NgayBatDau` DATE NOT NULL,
  `HinhAnh` text,
  `Luong` int 

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `nhanvien` (`MaNV`, `TenNV`, `NamSinh`, `GioiTinh`, `Sdt`, `DiaChi`, `NgayBatDau`, `HinhAnh`, `Luong`) VALUES 
(997, "Mai Lê Mỹ Linh", "2004-01-22", "Nữ", "0878678691", "An GIang", "2024-01-01", "shiba.jpg", 50000),
(998, "Nguyễn Thị Xuân Mai", "2004-04-23", "Nữ", "0363645182", "TP HCM", "2024-01-01", "bo.jpg", 50000),
(999, "Bùi Hữu Luân", "2003-10-14", "Nam", "0878678692", "Bến Tre", "2024-01-01", "default.svg", 50000);





CREATE TABLE `phieunhap` (
    `MaPN` int NOT NULL,
    `MaNCC` int NOT NULL,
    `MaNV` int NOT NULL,
    `NgayNhap` DATE NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `phieunhap` (`MaPN`, `MaNCC`, `MaNV`, `NgayNhap`) VALUES
(1, 1, 997, "2024-01-01"),
(2, 5, 998, "2024-02-05"),
(3, 5, 998, "2024-02-05"),
(4, 5, 998, "2024-02-05"),
(5, 5, 998, "2024-02-05"),
(6, 5, 998, "2024-02-05"),
(7, 5, 998, "2024-02-05"),
(8, 5, 998, "2024-02-05"),
(9, 5, 998, "2024-02-05"),
(10, 5, 998, "2024-02-05"),
(11, 5, 998, "2024-02-05"),
(12, 6, 999, "2024-06-15"),
(13, 5, 998, "2024-02-05"),
(14, 5, 998, "2024-02-05"),
(15, 5, 998, "2024-02-05"),
(16, 5, 998, "2024-02-05"),
(17, 5, 998, "2024-02-05"),
(18, 5, 998, "2024-02-05"),
(19, 5, 998, "2024-02-05"),
(20, 5, 998, "2024-02-05");



CREATE TABLE `chitietphieunhap` (
    `MaCTPN` int NOT NULL,
    `MaPN` int NOT NULL,
    `MaSach` int NOT NULL,
    `Gia` int NOT NULL,
    `SoLuong` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `chitietphieunhap` (`MaCTPN`, `MaPN`, `MaSach`, `Gia`, `SoLuong`) VALUES
(1, 1, 6, 30000, 5000),
(2, 5, 1, 40000, 5000),
(3, 2, 2, 40000, 5000),
(4, 3, 5, 40000, 5000),
(5, 4, 3, 40000, 5000),
(6, 7, 4, 40000, 5000),
(7, 8, 8, 40000, 5000),
(8, 6, 7, 40000, 5000),
(9, 9, 9, 40000, 5000),
(10, 12, 11, 40000, 5000),
(11, 11, 10, 40000, 5000),
(12, 13, 13, 40000, 5000),
(13, 19, 12, 40000, 5000),
(14, 14, 14, 40000, 5000),
(15, 16, 19, 40000, 5000),
(16, 15, 18, 40000, 5000),
(17, 18, 16, 40000, 5000),
(18, 17, 17, 40000, 5000),
(19, 20, 20, 40000, 5000),
(20, 10, 15, 50000, 5000);



CREATE TABLE `phieumuon` (
    `MaPhieuMuon` int NOT NULL,
    `MaNV` int NOT NULL,
    `MaDocGia` int NOT NULL,
    `NgayMuon` DATE NOT NULL,
    `TinhTrang` varchar(255)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `phieumuon` (`MaPhieuMuon`, `MaNV`, `MaDocGia`, `NgayMuon`, `TinhTrang`) VALUES
(1, 997, 1, "2023-04-29", "ĐANG MƯỢN"),
(2, 997, 2, "2024-02-29", "ĐÃ TRẢ"),
(3, 998, 3, "2024-01-29", "ĐANG MƯỢN"),
(4, 997, 4, "2023-09-29", "QUÁ HẠN"),
(5, 999, 5, "2023-11-29", "QUÁ HẠN"),
(6, 999, 6, "2023-12-29", "ĐANG MƯỢN"),
(7, 998, 7, "2024-03-29", "QUÁ HẠN"),
(8, 998, 8, "2023-6-29", "ĐÃ TRẢ");

CREATE TABLE `chitietphieumuon` (
    `MaCTPM` int NOT NULL,
    `MaPhieuMuon` int NOT NULL UNIQUE,
    `MaSach` int  NOT NULL,
    `NgayTra` DATE NOT NULL,
    `GhiChu` varchar(255)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `chitietphieumuon` (`MaCTPM`, `MaPhieuMuon`, `MaSach`, `NgayTra`, `GhiChu`) VALUES
(1, 1, 12, "2024-05-26", "Sách mới"),
(2, 3, 15, "2024-05-11", "Sách mới"),
(3, 2, 9, "2024-01-19", "Sách mới"),
(4, 8, 4, "2024-02-01", "Đã qua sử dụng"),
(5, 4, 8, "2024-03-01", "Bìa sách bị bẩn"),
(6, 7, 13, "2024-04-01", "Sách mới"),
(7, 5, 5, "2024-03-05", "Sách mới"),
(8, 6, 2, "2024-07-01", "Sách mới");


CREATE TABLE `phieuphat` (
    `MaPP` int NOT NULL,
    `MaPM` int NOT NULL UNIQUE,
    `NgayTra` DATE NOT NULL,
    `LyDo` varchar(255) NOT NULL,
    `SoTien` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `phieuphat` (`MaPP`, `MaPM`, `NgayTra`, `LyDo`, `SoTien`) VALUES
(1, 4, "2024-05-01", "Quán hạn trả sách", "100000"),
(2, 7, "2024-05-03", "Quán hạn trả sách", "100000"),
(3, 5, "2024-04-29", "Quán hạn trả sách", "100000");




CREATE TABLE `docgia` (
    `MaDocGia` int NOT NULL,
    `TenDG` varchar(255) NOT NULL,
    `NamSinh` DATE NOT NULL,
    `GioiTinh` varchar(10) NOT NULL,
    `Sdt` varchar(10) NOT NULL UNIQUE,
    `HinhAnh` text,
    `MaThe` int NOT NULL UNIQUE

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `docgia` (`MaDocGia`, `TenDG`, `NamSinh`, `GioiTinh`, `Sdt`, `HinhAnh`, `MaThe`) VALUES
(1, "Hà Trần Duy Phát", "2004-04-20", "Nam", "0337733373", "default.svg", 20241),
(2, "Võ Thế Lực", "2000-09-01", "Nam", "0398456219", "default.svg", 20242),
(3, "Nguyễn Phú Vinh", "2004-08-22", "Nam", "0395218462", "default.svg", 20243),
(4, "Võ Thành An", "2004-05-26", "Nam", "0354821657", "default.svg", 20244),
(5, "Trần Thị Hồng", "2001-01-21", "Nữ", "0320456987", "default.svg",20245),
(6, "Bùi Hữu Luân", "2003-10-14", "Nam", "0395784856", "default.svg",20246),
(7, "Trần Phước Thiện", "2009-05-05", "Nam", "0325981814", "default.svg",20247),
(8, "Nguyễn Hoàng Tuấn Kiệt", "2004-12-01", "Nam", "0399282456", "default.svg",20248);






CREATE TABLE `thethuvien` (
    `MaThe` int NOT NULL,
    `NgayBatDau` DATE NOT NULL,
    `NgayKetThuc` DATE NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `thethuvien` (`MaThe`, `NgayBatDau`, `NgayKetThuc`) VALUES
(20241, "2024-02-02", "2025-02-02"),
(20242, "2024-02-02", "2025-02-02"),
(20243, "2024-02-02", "2025-02-02"),
(20244, "2024-02-02", "2025-02-02"),
(20245, "2024-02-02", "2025-02-02"),
(20246, "2024-02-02", "2025-02-02"),
(20247, "2024-02-02", "2025-02-02"),
(20248, "2024-02-02", "2025-02-02");


CREATE TABLE `nhacungcap` (
    `MaNCC` int NOT NULL,
    `TenNCC` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`) VALUES
(1, "Trí Tuệ - Công Ty Cổ Phần Sách & Thiết Bị Giáo Dục Trí Tuệ"),
(2, "Công Ty Cổ Phần Sách Giáo Dục Tại Thành Phố Hà Nội"),
(3, "Nhà Sách Trực Tuyến BOOKBUY.VN"),
(4, "Công Ty CP Sách Và Thiết Bị Trường Học Đà Nẵng"),
(5, "Công Ty Cổ Phần Văn Hóa Nhân Văn"),
(6, "Công Ty Cổ Phần Sách & Thiết Bị Trường Học Kiên Giang");



CREATE TABLE `sach` (
    `MaSach` int NOT NULL,
    `TenSach` varchar(255) NOT NULL,
    `MaLoaiSach` int NOT NULL,
    `MaNXB` int NOT NULL,
    `MaTacGia` int NOT NULL,
    `NamXuatBan` DATE NOT NULL,
    `SoLuong` int NOT NULL,
    `HinhAnh` text,
    `GhiChu` varchar(255) DEFAULT ""
 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `sach` (`MaSach`, `TenSach`, `MaLoaiSach`, `MaNXB`, `MaTacGia`, `NamXuatBan`, `SoLuong`, `HinhAnh`, `GhiChu`) VALUES
(1, "Cho tôi xin một vé đi tuổi thơ", "6", "3", "1", "2008-01-01", "1000", "cho-toi-mot-ve-di-tuoi-tho.jpg", ""),
(2, "Đêm hội Long Trì", "3", "1","2","1942-01-01","1500", "demhoilongtri.jpg", ""),
(3, "Nước chảy mây trôi", "7", "5", "3", "2003-01-01", "1700", "nuochaymaytroi.jpg", ""),
(4, "Việt Bắc", "4", "2", "4", "1954-01-01", "2000", "vietbacjpg.jpg", ""),
(5, "Đất rừng phương nam", "7", "4", "5", "2010-01-01", "2500", "datrungphuongnam.jpg", ""),
(6, "Mắt biếc", "7", "2", "1", "1990-01-01", "8420", "matbiec.jpg", ""),
(7, "Sống mãi với thủ đô", "3", "2", "2", "1961-01-01", "2090", "song-mai-voi-thu-do.jpg", ""),
(8, "Cánh đồng bất tận", "4" , "1", "3", "2005-01-01", "5020", "", ""),
(9, "Gió lộng", "3", "2", "4", "1961-01-01", "4320", "giolong.jpg", ""),
(10, "Cá bống mú", "7", "3", "5", "1952-10-01", "6700", "cabongmu.jpg", ""),
(11, "Tôi thấy hoa vàng trên cỏ xanh", "7", "4", "1", "2010-12-09", "7920", "toithayhoavangtrencoxanh.jpg", ""),
(12, "Vũ như tô", "3", "5", "2", "1946-01-01", "3200", "vunhuto.jpg", ""),
(13, "Đong tấm lòng", "4", "2", "3", "2015-01-01", "4020", "dongtamlong.jpg", ""),
(14, "Từ ấy", "7", "5", "4", "1946-01-01", "1850", "tuay.jpg", ""),
(15, "Hoa hướng dương", "2", "1", "5", "1960-01-01", "2940", "hoahuongduong.jpg", ""),
(16, "Cô gái đến từ hôm qua", "5", "2", "1", "1990-01-01", "4500", "co-gai-den-tu-hom-qua.jpg", ""),
(17, "Tìm mẹ", "6", "3", "2", "1950-01-01", "2300", "timme.jpg", ""),
(18, "Hành lý hư vô", "4", "1", "3", "2019-01-01", "4670", "hanhlyhuvo.jpg", ""),
(19, "Ra trận", "3", "4", "4", "1972-01-01", "2150", "ratran.jpg", ""),
(20, "Rừng đêm xào xạc", "6", "5", "5", "2016-10-01", "3710", "rungdemxaoxac.jpg", "");







CREATE TABLE `loaisach` (
    `MaLoaiSach` int NOT NULL,
    `TenLoaiSach` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `loaisach` (`MaLoaiSach`, `TenLoaiSach`) VALUES 
(1, "Sách chính trị - pháp luật"),
(2, "Khoa học công nghệ Kinh tế"),
(3, "Văn hóa xã hội Lịch sử"),
(4, "Văn học nghệ thuật"),
(5, "Giáo trình"),
(6, "Sách thiếu nhi"),
(7, "Truyện, tiểu thuyết");



CREATE TABLE `tacgia` (
    `MaTacGia` int NOT NULL,
    `TenTacGia` varchar(255) NOT NULL,
    `NamSinh` DATE NOT NULL,
    `DiaChi` varchar(255),
    `HinhAnh` text,
    `GioiThieu` text 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `tacgia` (`MaTacGia`, `TenTacGia`, `NamSinh`, `DiaChi`, `HinhAnh`, `GioiThieu`) VALUES
(1, "Nguyễn Nhật Ánh", "1955-05-07", "Quảng Nam","NguyenNhatAnh.jpg","Nguyễn Nhật Ánh sinh ngày 07 tháng 05 năm 1955.
Sinh ra và lớn lên tại làng Đo Đo, xã Bình Quế, huyện Thăng Bình, tỉnh Quảng Nam.
Là một nhà văn người Việt Nam, nổi tiếng nhờ các tác phẩm về đề tài tuổi mới lớn, các tác phẩm của ông được nhiều người yêu thích và nhiều tác phẩm được chuyển thành thể phim."),
(2, "Nguyễn Huy Tưởng", "1912-05-06", "Hà Nội","NguyenHuyTuong.jpg",""),
(3, "Nguyễn Ngọc Tư", "1976-01-01", "Cà Mau","NguyenNgocTu.jpg",""),
(4, "Tố Hữu", "1920-10-04", "Thừa Thiên Huế","ToHuu.jpg",""),
(5, "Đoàn Giỏi", "1925-05-17", "Mỹ Tho","DoanGioi.jpg","");






CREATE TABLE `nhaxuatban` (
    `MaNXB` int NOT NULL,
    `TenNXB` varchar(255),
    `DiaChi` varchar(255),
    `Sdt` varchar(20) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO `nhaxuatban` (`MaNXB`, `TenNXB`, `Diachi`, `Sdt`) VALUES
(1, "NXB Giáo dục Việt Nam", "Số 81 Trần Hưng Đạo, Hoàn Kiếm, Hà Nội", "02438220801"),
(2, "NXB Kim Đồng", "55 Quang Trung, Hai Bà Trưng, Hà Nội", "1900571595"),
(3, "NXB Tổng hợp thành phố Hồ Chí Minh", "62 Nguyễn Thị Minh Khai, Phường Đa Kao, Quận 1, TP HCM", "02838256804"),
(4, "NXB Trẻ", "161B Lý Chính Thắng, Phường Võ Thị Sáu, Quận 3 , TP. Hồ Chí Minh", "02839316289"),
(5, "NXB Hội Nhà văn", "65 Nguyễn Du, Hà Nội", "024 38222135");






ALTER TABLE `accounts`
ADD PRIMARY KEY (`MaTaiKhoan`);

ALTER TABLE `nhanvien`
ADD PRIMARY KEY (`MaNV`);

ALTER TABLE `phieunhap`
ADD PRIMARY KEY (`MaPN`);

ALTER TABLE `chitietphieunhap`
ADD PRIMARY KEY (`MaCTPN`);

ALTER TABLE `phieumuon`
ADD PRIMARY KEY (`MaPhieuMuon`);

ALTER TABLE `chitietphieumuon`
ADD PRIMARY KEY (`MaCTPM`);

ALTER TABLE `phieuphat`
ADD PRIMARY KEY (`MaPP`);

ALTER TABLE `docgia`
ADD PRIMARY KEY (`MaDocGia`);

ALTER TABLE `thethuvien`
ADD PRIMARY KEY (`MaThe`);

ALTER TABLE `nhacungcap`
ADD PRIMARY KEY (`MaNCC`);

ALTER TABLE `sach`
ADD PRIMARY KEY (`MaSach`);

ALTER TABLE `loaisach`
ADD PRIMARY KEY (`MaLoaiSach`);

ALTER TABLE `tacgia`
ADD PRIMARY KEY (`MaTacGia`);

ALTER TABLE `nhaxuatban`
ADD PRIMARY KEY (`MaNXB`);



ALTER TABLE `sach`
ADD CONSTRAINT `fk_MaLoaiSach` FOREIGN KEY (`MaLoaiSach`) REFERENCES `loaisach` (`MaLoaiSach`) ON UPDATE CASCADE ON DELETE CASCADE,
ADD CONSTRAINT `fk_MaNXB` FOREIGN KEY (`MaNXB`) REFERENCES `nhaxuatban` (`MaNXB`) ON UPDATE CASCADE,
ADD CONSTRAINT `fk_MaTacGia` FOREIGN KEY (`MaTacGia`) REFERENCES `tacgia` (`MaTacGia`) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE `chitietphieunhap`
ADD CONSTRAINT `fk_MaPN` FOREIGN KEY(`MaPN`) REFERENCES `phieunhap` (`MaPN`) ON UPDATE CASCADE ON DELETE CASCADE;


ALTER TABLE `chitietphieumuon`
ADD CONSTRAINT `fk_MaPM` FOREIGN KEY(`MaPhieuMuon`) REFERENCES `phieumuon` (`MaPhieuMuon`) ON UPDATE CASCADE ON DELETE CASCADE;





