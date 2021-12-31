USE testing_system;

drop table if exists `user`;
CREATE TABLE `user` (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(40) UNIQUE,
    email VARCHAR(40) UNIQUE
);

insert into `user`(username, email) values
('a.nguyen', 'a.nguyen@gmail.com'),
('b.nguyen', 'b.nguyen@gmail.com'),
('c.nguyen', 'c.nguyen@gmail.com'),
('d.nguyen', 'd.nguyen@gmail.com');

drop procedure if exists sp_update_user_by_id;
delimiter $$
    create procedure sp_update_user_by_id(in inputUsername varchar(40), in inputEmail varchar(40), in userId int)
    begin
        update `user` set username = inputUsername, email = inputEmail where id = userId;
    end $$
delimiter ;

-- call sp_update_user_by_id('bao', 'bao@mail.com', 3);
select * from `user`;