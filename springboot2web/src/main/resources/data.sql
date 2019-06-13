DROP TABLE IF EXISTS player;
 
CREATE TABLE player (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  position VARCHAR(250) NOT NULL,
  club VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO player (name, position, club) VALUES
  ('Aubameyang', 'Striker', 'Arsenal FC'),
  ('Lacazette', 'Striker', 'Arsenal FC'),
  ('Ozil', 'Attacking Midfield', 'Arsenal FC');
  
delete from user_role;
delete from role;
delete from user; 

insert into user (user_id,active,email,last_name,name,password) values (1,1,'admin@sb2.com','Administrator','Admin', '$2a$10$CDYCJIVlym0qebMcGUPeG.Es00ZuuicMwF8kpLbbJ3P9lcS0QpkQm');
insert into role (role_id,role) values (1,'ROLE_ADMIN');
insert into user_role (user_id,role_id) values (1,1);
