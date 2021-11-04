DROP DATABASE IF EXISTS quan_ly_dat_phong;
CREATE DATABASE quan_ly_dat_phong;
ALTER DATABASE quan_ly_dat_phong CHAR SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE quan_ly_dat_phong;

-- KHACH_HANG: lưu trữ thông tin của khách hàng
-- o MaKH:Mã khách hàng
-- o TenKH: Tên Khách Hàng
-- o DiaChi: Địa chỉ
-- o SoDT: Số điện thoại
DROP TABLE IF EXISTS KHACH_HANG;
CREATE TABLE KHACH_HANG(
    MaKH        INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    TenKH       VARCHAR(50) CHAR SET utf8mb4 NOT NULL,
    DiaChi      VARCHAR(100) CHAR SET utf8mb4 NOT NULL,
    SoDT        VARCHAR(20) NOT NULL UNIQUE
);

INSERT INTO KHACH_HANG(TenKH, DiaChi, SoDT) VALUES
('Nguyễn Văn An', 'Long Biên, HN', '080-9876-0001'),
('Nguyễn Văn Bình', 'Long Biên, HN', '080-9876-0002'),
('Nguyễn Khánh Linh', 'Long Biên, HN', '080-9876-0003'),
('Nguyễn Văn Cường', 'Long Biên, HN', '080-9876-0013'),
('Nguyễn Văn Duy', 'Long Biên, HN', '080-9876-0004'),
('Nguyễn Văn Giang', 'Long Biên, HN', '080-9876-0005');

-- PHONG: lưu trữ thông tin phòng karaoke
-- o MaPhong: Mã phòng
-- o LoaiPhong: Loại phòng. Ví dụ: Loại 1, Loại 2, Loại 3
-- o SoKhachToiDa: Số khách tối đa cho một phòng
-- o GiaPhong: Giá phòng, Đối với số tiền - gợi ý dùng kiểu dữ liệu DECIMAL(m,n) trong đó
--  m: số chữ số
--  n: số chữ số sau dấu phẩy(phần thập phân)
--  Ví dụ: 120,000.300; 200,000.002
-- o MoTa: Mô tả phòng
DROP TABLE IF EXISTS PHONG;
CREATE TABLE PHONG(
    MaPhong         TINYINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    LoaiPhong       VARCHAR(20) CHAR SET utf8mb4 NOT NULL UNIQUE,
    SoKhachToiDa    TINYINT DEFAULT 1,
    GiaPhong        DECIMAL(10,2) DEFAULT 0,
    MoTa            TEXT CHAR SET utf8mb4
);

INSERT INTO PHONG(LoaiPhong, SoKhachToiDa, GiaPhong, MoTa) VALUES
('Loại 1', 2, 400000, 'Phong bao đẹp, hát bao hay'),
('Loại 2', 5, 500000, 'Phong bao đẹp, hát bao hay'),
('Loại 3', 8, 600000, 'Phong bao đẹp, hát bao hay'),
('Loại 4', 10, 700000, 'Phong bao đẹp, hát bao hay'),
('Loại 5', 15, 700000, 'Phong bao đẹp, hát bao hay'),
('Loại 6', 3, 450000, 'Phong bao đẹp, hát bao hay');

-- DAT_PHONG: lưu trữ thông tin đặt phòng karaoke của khách hàng
-- o MaDatPhong:Mã đặt phòng
-- o MaPhong: Mã phòng
-- o MaKH: Mã khách hàng
-- o NgayDat: Ngày đặt phòng
-- o TienDatCoc: Tiền Đặt cọc
-- o GhiChu: Ghi chú
-- o TrangThaiDat: Trạng thái đặt phòng, chỉ có 2 trạng thái: đã đặt, đã hủy
DROP TABLE IF EXISTS DAT_PHONG;
CREATE TABLE DAT_PHONG(
    MaDatPhong      INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    MaPhong         TINYINT NOT NULL,
    MaKH            INT NOT NULL,
    NgayDat         DATE,
    TienDatCoc      DECIMAL(10,2) DEFAULT 0,
    GhiChu          TEXT CHAR SET utf8mb4,
    TrangThaiDat    ENUM('đã đặt', 'đã hủy'),
    FOREIGN KEY (MaPhong) REFERENCES PHONG(MaPhong) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (MaKH) REFERENCES KHACH_HANG(MaKH) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO DAT_PHONG(MaPhong, MaKH, NgayDat, TienDatCoc, GhiChu, TrangThaiDat) VALUES
(1, 1, '2020-04-11', 50000, 'Không có ghi chú', 'đã đặt'),
(2, 2, '2020-04-11', 60000, 'Không có ghi chú', 'đã đặt'),
(3, 3, '2021-04-11', 70000, 'Không có ghi chú', 'đã hủy'),
(3, 1, '2020-11-04', 53000, 'Không có ghi chú', 'đã hủy'),
(3, 3, '2021-11-04', 53000, 'Không có ghi chú', 'đã đặt'),
(4, 3, '2020-11-01', 100000, 'Không có ghi chú', 'đã hủy'),
(5, 4, '2020-04-21', 200000, 'Không có ghi chú', 'đã đặt'),
(2, 5, '2021-05-31', 30000, 'Không có ghi chú', 'đã hủy'),
(2, 5, '2019-04-21', 20000, 'Không có ghi chú', 'đã hủy'),
(4, 3, '2020-04-01', 30000, 'Không có ghi chú', 'đã đặt'),
(4, 1, '2020-04-05', 50000, 'Không có ghi chú', 'đã đặt');

-- DICH_VU_DI_KEM: lưu trữ thông tin các dịch vụ đi kèm được cung cấp tại quán Karaoke.
-- o MaDV: Mã dịch vụ
-- o TenDV: Tên dịch vụ. Ví dụ: Bia, Nước ngọt, Trái cây, Khăn ướt
-- o DonViTinh: Đơn vị tính. Ví dụ: “Lon”, “Cái”, “Đĩa”
-- o DonGia: Đơn giá,Đối với số tiền - gợi ý dùng kiểu dữ liệu DECIMAL(m,n) trong đó
--  m: số chữ số
--  n: số chữ số sau dấu phẩy(phần thập phân)
--  Ví dụ: 100,000.300; 200,000.002
DROP TABLE IF EXISTS DICH_VU_DI_KEM;
CREATE TABLE DICH_VU_DI_KEM(
    MaDV            SMALLINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    TenDV           VARCHAR(50) CHAR SET utf8mb4,
    DonViTinh       VARCHAR(10) CHAR SET utf8mb4,
    DonGia          DECIMAL(10,2) DEFAULT 0
);

INSERT INTO DICH_VU_DI_KEM(TenDV, DonViTinh, DonGia) VALUES
('Full combo hoa quả bia rượu', 'Set', 1000000),
('Combo 1', 'Set', 800000),
('Combo 2', 'Set', 500000),
('Bia HN', 'Chai', 20000),
('Lạc', 'Đĩa', 10000);

-- CHI_TIET_SU_DUNG_DV: lưu trữ thông tin chi tiết khi khách hàng sử dụng các dịch vụ đi
-- kèm.
-- o MaDatPhong:Mã đặt phòng
-- o MaDV: Mã dịch vụ
-- o SoLuong: Số lượng
DROP TABLE IF EXISTS CHI_TIET_SU_DUNG_DV;
CREATE TABLE CHI_TIET_SU_DUNG_DV(
    MaDatPhong      INT NOT NULL,
    MaDV            SMALLINT NOT NULL,
    SoLuong         INT DEFAULT 0,
    PRIMARY KEY (MaDatPhong, MaDV),
    FOREIGN KEY (MaDatPhong) REFERENCES DAT_PHONG(MaDatPhong) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (MaDV) REFERENCES DICH_VU_DI_KEM(MaDV) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO CHI_TIET_SU_DUNG_DV(MaDatPhong, MaDV, SoLuong) VALUES
(1, 1, 1),
(1, 2, 5),
(2, 3, 4),
(3, 3, 2),
(3, 4, 3),
(4, 5, 2),
(5, 5, 10),
(6, 5, 2),
(7, 2, 6),
(7, 4, 1),
(8, 1, 7),
(8, 3, 1),
(9, 1, 4),
(10, 2, 1),
(10, 1, 2);

-- 1. Tạo Bảng và thêm tối thiểu 5 bản ghi cho mỗi Bảng


-- 2. Hiển thị loại phòng đã thuê, tên dịch vụ đã sử dụng của khách hàng có tên là “Nguyễn Khánh Linh”
SELECT p.LoaiPhong, dv.TenDV
FROM KHACH_HANG kh
LEFT JOIN DAT_PHONG dp ON kh.MaKH = dp.MaKH
LEFT JOIN PHONG p ON p.MaPhong = dp.MaPhong
LEFT JOIN CHI_TIET_SU_DUNG_DV ctsd ON ctsd.MaDatPhong = dp.MaDatPhong
LEFT JOIN DICH_VU_DI_KEM dv ON dv.MaDV = ctsd.MaDV
WHERE kh.TenKH = 'Nguyễn Khánh Linh';

-- 3. Viết Function để trả về Số điện thoại của Khách hàng thuê nhiều phòng nhất trong năm 2020
DROP FUNCTION IF EXISTS f_sdt_thue_max_2020;
DELIMITER $$
CREATE FUNCTION f_sdt_thue_max_2020() RETURNS VARCHAR(20)
    BEGIN
        DECLARE phoneNo VARCHAR(20);

        SELECT SoDT INTO phoneNo
        FROM KHACH_HANG kh
        LEFT JOIN DAT_PHONG dp ON dp.MaKH = kh.MaKH
        WHERE YEAR(NgayDat) = 2020
        GROUP BY kh.MaKH
        HAVING COUNT(dp.MaDatPhong) = (
            SELECT MAX(t1.datphong_count)
            FROM (
                SELECT COUNT(MaDatPhong) AS datphong_count
                FROM DAT_PHONG
                WHERE YEAR(NgayDat) = 2020
                GROUP BY MaKH
            ) t1
        );
        
        RETURN phoneNo;
    END $$
DELIMITER ;

SELECT f_sdt_thue_max_2020();

-- 4. Viết thủ tục tăng giá phòng thêm 10,000 VNĐ so với giá phòng hiện tại cho những phòng có số khách
-- tối đa lớn hơn 5.
DROP PROCEDURE IF EXISTS sp_tang_giaphong_hon_5khach;
DELIMITER $$
CREATE PROCEDURE sp_tang_giaphong_hon_5khach()
    BEGIN
        UPDATE PHONG
        SET GiaPhong = GiaPhong + 10000
        WHERE SoKhachToiDa > 5;
    END $$
DELIMITER ;

CALL sp_tang_giaphong_hon_5khach();
SELECT * FROM PHONG;

-- 5. Viết thủ tục thống kê khách hàng và số lần thuê phòng tương ứng của từng khách hàng trong năm
-- nay.
DROP PROCEDURE IF EXISTS sp_thongke_kh_solanthue_curyear;
DELIMITER $$
CREATE PROCEDURE sp_thongke_kh_solanthue_curyear()
    BEGIN
        WITH
            dat_phong_trong_nam_nay AS (
                SELECT * FROM DAT_PHONG
                WHERE YEAR(NgayDat) = YEAR(curdate())
            )
        SELECT kh.TenKH, COUNT(dp.MaDatPhong) AS 'số lần thuê phòng'
        FROM KHACH_HANG kh
        LEFT JOIN dat_phong_trong_nam_nay dp ON dp.MaKH = kh.MaKH
        GROUP BY kh.MaKH;
    END $$
DELIMITER ;

CALL sp_thongke_kh_solanthue_curyear();

-- 6. Viết thủ tục hiển thị 5 đơn đặt phòng gần nhất bao gồm có các thông tin: Mã đặt phòng, tên khách
-- hàng, loại phòng, giá phòng.
DROP PROCEDURE IF EXISTS sp_layra_5_datphong_gannhat;
DELIMITER $$
CREATE PROCEDURE sp_layra_5_datphong_gannhat()
    BEGIN
        SELECT dp.MaDatPhong, kh.TenKH, p.LoaiPhong, p.GiaPhong
        FROM DAT_PHONG dp
        LEFT JOIN KHACH_HANG kh ON kh.MaKH = dp.MaKH
        LEFT JOIN PHONG p ON p.MaPhong = dp.MaPhong
        ORDER BY NgayDat DESC
        LIMIT 5;
    END $$
DELIMITER ;

CALL sp_layra_5_datphong_gannhat();

-- 7. Viết Trigger kiểm tra khi thêm phòng mới có Số khách tối đa vượt quá 10 người thì không cho thêm
-- mới và hiển thị thông báo “Vượt quá số người cho phép”.
DROP TRIGGER IF EXISTS trg_insert_phong_max10ng;
DELIMITER $$
CREATE TRIGGER trg_insert_phong_max10ng
BEFORE INSERT ON PHONG
FOR EACH ROW
    BEGIN
        IF NEW.SoKhachToiDa > 10 THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Vượt quá số người cho phép';
        END IF;
    END $$
DELIMITER ;

INSERT INTO PHONG(LoaiPhong, SoKhachToiDa, GiaPhong, MoTa) VALUES
('Loại VIP', 100, 1000000, 'Phòng bay của các dân chơi');