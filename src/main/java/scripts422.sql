create table person (
                        id serial primary key ,
                        name varchar(225),
                        age int,
                        vehicle_owner boolean,
                        vehicle_id int references vehicle (id) );


create table vehicle (
                         id serial primary key ,
                         brand varchar(225),
                         model varchar(225),
                         cost money);

alter table person add column vehicle_id serial;

select student.name, student.age, faculty.name
from student
         inner join faculty on student.faculty_id = faculty.id;

select s.id, s.name, avtr.id
from student as s
         inner join avatar avtr on s.id = avtr.student_id;