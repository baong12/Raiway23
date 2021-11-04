DROP DATABASE IF EXISTS car_dealer_garage_auto;
CREATE DATABASE car_dealer_garage_auto;
ALTER DATABASE car_dealer_garage_auto CHAR SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE car_dealer_garage_auto;

-- CUSTOMER:
--  CustomerID: mã khách hàng, primary key, auto increment.
--  Name: tên của khách hàng.
--  Phone: số điện thoại của khách hàng.
--  Email: địa chỉ email của khách hàng.
--  Address: địa chỉ của khách hàng.
--  Note: tóm tắt mô tả về khách hàng.
DROP TABLE IF EXISTS CUSTOMER;
CREATE TABLE CUSTOMER(
	CustomerID	INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	`Name`		VARCHAR(20) CHAR SET utf8mb4 NOT NULL UNIQUE,
	Phone		VARCHAR(20) NOT NULL UNIQUE,
	Email		VARCHAR(50) NOT NULL UNIQUE,
	Address		VARCHAR(50) CHAR SET utf8mb4,
	Note		TEXT CHAR SET utf8mb4
);

INSERT INTO CUSTOMER(`Name`, Phone, Email, Address, Note) VALUES
('Nguyễn Văn An',       '080-9876-0000', 'an.nguyen@gmail.com',     'Long Biên, Hà Nội',    'An Nguyen'),
('Nguyễn Đức Bình',     '080-9876-0001', 'binh.nguyen@gmail.com',   'Từ Sơn, Bắc Ninh',     'Binh Nguyen'),
('Nguyễn Thái Cường',   '080-9876-0002', 'cuong.nguyen@gmail.com',  'Vinh, Nghệ An',        'Cuong Nguyen'),
('Nguyễn Đăng Duy',     '080-9876-0003', 'duy.nguyen@gmail.com',    'Osaka, Japan',         'Duy Nguyen'),
('Nguyễn Văn Giang',    '080-9876-0004', 'giang.nguyen@gmail.com',  'Tokyo, Japan',         'Giang Nguyen');

-- CAR:
--  CarID: mã oto, primary key.
--  Maker: tên hãng sản xuất (chỉ có thể là 3 giá trị: ‘HONDA’, ‘TOYOTA’, ‘NISSAN’).
--  Model: tên của mẫu xe.
--  Year: năm sản xuất.
--  Color: màu của xe (black, white, yellow…).
--  Note: tóm tắt mô tả về xe.
DROP TABLE IF EXISTS CAR;
CREATE TABLE CAR(
	CarID	INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	Maker	ENUM('HONDA', 'TOYOTA','NISSAN'),
	Model	VARCHAR(20),
	`Year`	YEAR,
	Color	VARCHAR(20),
	Note	TEXT CHAR SET utf8mb4
);

INSERT INTO CAR(Maker, Model, `Year`, Color, Note) VALUES
('HONDA', 'A01', 2020, 'red', 'Best car 2020'),
('HONDA', 'A02', 2021, 'black', 'Your mom will love this one'),
('TOYOTA', 'A03', 2019, 'violet', 'Một người lái, hai người vui'),
('TOYOTA', 'A04', 2018, 'vanilla', 'Xe thứ thiệt cho người thứ thiệt'),
('NISSAN', 'A05', 2020, 'midnight blue', 'Lái là thích');

-- CAR_ORDER:
--  OrderID: mã đơn hàng, primary key, auto increment.
--  CustomerID: mã khách hàng, foreign key.
--  CarID: mã oto, foreign key.
--  Amount: số lượng oto, default value = 1.
--  SalePrice: giá bán oto.
--  OrderDate: ngày bán .
--  DeliveryDate: ngày giao hàng.
--  DeliveryAddress: địa chỉ giao hàng.
--  Staus: trạng thái của đơn hàng (0: đã đặt hàng, 1: đã giao, 2: đã hủy), mặc định
-- trạng thái là đã đặt hàng.
--  Note: tóm tắt mô tả về đơn hàng.
DROP TABLE IF EXISTS CAR_ORDER;
CREATE TABLE CAR_ORDER(
    OrderID             INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    CustomerID          INT NOT NULL,
    CarID               INT NOT NULL,
    Amount              TINYINT DEFAULT 1,
    SalePrice           INT NOT NULL,
    OrderDate           DATE,
    DeliveryDate        DATE,
    DeliveryAddress     VARCHAR(100) CHAR SET utf8mb4,
    Staus               ENUM('0', '1', '2') DEFAULT '0', -- (0: đã đặt hàng, 1: đã giao, 2: đã hủy)
    Note                TEXT CHAR SET utf8mb4,
    FOREIGN KEY (CustomerID) REFERENCES CUSTOMER(CustomerID),
    FOREIGN KEY (CarID) REFERENCES CAR(CarID)
);

INSERT INTO CAR_ORDER(CustomerID, CarID, Amount, SalePrice, OrderDate,
    DeliveryDate, DeliveryAddress, Staus, Note)
VALUES
    (1, 1, 1, 2000, '2020-11-03', '2020-12-03', 'Địa chỉ nhà khách hàng', '1', 'Xe hơi bị được, rate 4/5'),
    (1, 2, 1, 2500, '2021-11-03', '2021-12-03', 'Địa chỉ nhà khách hàng', '0', 'Xe hơi bị được, rate 4/5'),
    (1, 3, 1, 50000, '2019-11-03', '2019-12-03', 'Địa chỉ nhà khách hàng', '2', 'Xe hơi bị được, rate 5/5'),
    (2, 4, 1, 20000, '2020-11-03', '2021-02-03', 'Địa chỉ nhà khách hàng', '1', 'Xe hơi bị được, rate 5/5'),
    (3, 4, 1, 20000, '2020-11-03', '2021-02-03', 'Địa chỉ nhà khách hàng', '1', 'Xe hơi bị được, rate 5/5'),
    (3, 4, 1, 20000, '2021-11-03', '2021-12-03', 'Địa chỉ nhà khách hàng', '1', 'Xe hơi bị được, rate 5/5'),
    (4, 5, 1, 6000, '2021-11-03', '2021-12-03', 'Địa chỉ nhà khách hàng', '0', 'Xe hơi bị được, rate 4.5/5'),
    (4, 3, 10, 50000, '2020-11-03', '2020-12-03', 'Địa chỉ nhà khách hàng', '2', 'Xe hơi bị được, rate 4.5/5'),
    (4, 2, 1, 2500, '2021-11-03', '2021-12-03', 'Địa chỉ nhà khách hàng', '0', 'Xe hơi bị được, rate 4.5/5'),
    (4, 3, 2, 50000, '2021-11-03', '2022-02-03', 'Địa chỉ nhà khách hàng', '0', 'Xe hơi bị được, rate 4.5/5'),
    (5, 5, 1, 6000, '2019-11-03', '2020-02-03', 'Địa chỉ nhà khách hàng', '0', 'Xe hơi bị được, rate 4.5/5');

-- 1. Tạo table với các ràng buộc và kiểu dữ liệu
-- Thêm ít nhất 5 bản ghi vào table.

-- 2. Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã
-- mua và sắp sếp tăng dần theo số lượng oto đã mua.
SELECT `name`, SUM(co.Amount) AS 'Số lượng oto đã mua'
FROM customer c
LEFT JOIN car_order co ON c.CustomerID = co.CustomerID
WHERE co.Staus IN ('0', '1')
GROUP BY c.CustomerID
ORDER BY SUM(co.Amount) ASC;

-- 3. Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều
-- oto nhất trong năm nay.
SELECT *
FROM car c
LEFT JOIN car_order co ON c.CarID = co.CarID
WHERE co.Staus NOT IN ('2')
    AND YEAR(co.OrderDate) = YEAR(curdate());

DROP FUNCTION IF EXISTS f_get_maker_most_sold_curyear;
DELIMITER $$
CREATE FUNCTION f_get_maker_most_sold_curyear() RETURNS VARCHAR(10)
    BEGIN
        DECLARE makerName VARCHAR(10);

        SELECT c.Maker INTO makerName
        FROM car c
        LEFT JOIN car_order co ON c.CarID = co.CarID
        WHERE co.Staus NOT IN ('2')
            AND YEAR(co.OrderDate) = YEAR(curdate())
        GROUP BY c.Maker
        HAVING SUM(co.Amount) = (
            SELECT MAX(amount_count)
            FROM (
                SELECT SUM(co.Amount) AS amount_count
                FROM car c
                LEFT JOIN car_order co ON c.CarID = co.CarID
                WHERE co.Staus NOT IN ('2')
                    AND YEAR(co.OrderDate) = YEAR(curdate())
                GROUP BY c.Maker
            ) AS t1
        );
        
        RETURN makerName;
    END $$
DELIMITER ;

SELECT f_get_maker_most_sold_curyear();

-- 4. Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của
-- những năm trước. In ra số lượng bản ghi đã bị xóa.
DROP PROCEDURE IF EXISTS sp_cancelled_history;
DELIMITER $$
CREATE PROCEDURE sp_cancelled_history()
    BEGIN
        SELECT COUNT(*) AS 'Số lượng bản ghi đã bị xóa'
        FROM car_order
        WHERE Staus IN ('2');
        
        DELETE FROM car_order
        WHERE Staus IN ('2');
    END $$
DELIMITER ;

CALL sp_cancelled_history();

-- 5. Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn
-- hàng đã đặt hàng bao gồm: tên của khách hàng, mã đơn hàng, số lượng oto
-- và tên hãng sản xuất.
DROP PROCEDURE IF EXISTS sp_order_list;
DELIMITER $$
CREATE PROCEDURE sp_order_list(IN in_customerid INT)
BEGIN
    SELECT cu.`Name`, o.OrderID, o.Amount, c.Maker
    FROM customer cu
    LEFT JOIN car_order o ON o.CustomerID = cu.CustomerID
    LEFT JOIN car c ON o.CarID = c.CarID
    WHERE cu.CustomerID = in_customerid;
END $$
DELIMITER ;

CALL sp_order_list(4);

-- 6. Viết trigger để tránh trường hợp người dụng nhập thông tin không hợp lệ
-- vào database (DeliveryDate < OrderDate + 15).
DROP TRIGGER IF EXISTS trg_insert_carorder_invalid_orderdate;
DELIMITER $$
CREATE TRIGGER trg_insert_carorder_invalid_orderdate
BEFORE INSERT ON car_order
FOR EACH ROW
    BEGIN
        IF NEW.DeliveryDate < DATE_ADD(NEW.OrderDate, INTERVAL 15 DAY) THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT =  'Thông tin ngày giao hàng không hợp lệ (hơn ngày giao hàng ít nhất 15 ngày)';
        END IF;
    END $$
DELIMITER ;

INSERT INTO CAR_ORDER(CustomerID, CarID, Amount, SalePrice, OrderDate,
    DeliveryDate, DeliveryAddress, Staus, Note)
VALUES
    (1, 1, 1, 2000, '2021-11-03', '2020-11-13', 'Địa chỉ nhà khách hàng', '1', 'Xe hơi bị được, rate 4/5');