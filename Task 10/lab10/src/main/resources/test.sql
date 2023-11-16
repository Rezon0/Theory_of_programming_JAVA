--create database javatestdb;
\c postgres
--create table table_name(id serial primary key, name text);

--insert into table_name (id, name) values
--(1, 'alex'), (2, 'oleg');

--select * from table_name;

drop table progress;
drop table students;
drop table subjects;

create table students (
    id serial primary key not null,
    name text not null,
    seriya varchar(4) not null,
    number varchar(6) not null);

create table subjects (
    id serial primary key not null,
    name text not null);

create table progress (
    id serial primary key not null,
    student_id integer not null references students (id) on delete cascade on update cascade,
    subject_id integer not null references subjects (id),
    mark integer not null,
    check (mark >= 2 and mark <= 5));

insert into students (id, name, seriya, number) values
(1, 'alex', '1111', '222222'),
(2, 'oleg', '2222', '123123'),
(3, 'kate', '3333', '123132'),
(4, 'victor', '4444', '333222'),
(5, 'nastya', '5555', '112233'),
(6, 'anton', '6666', '123123'),
(7, 'dima', '7777', '345345'),
(8, 'elya', '8888', '666666');

insert into subjects (id, name) values
(1, 'russian'),
(2, 'english'),
(3, 'math'),
(4, 'biology'),
(5, 'physic');

insert into progress(id, student_id, subject_id, mark) values
(1, 1, 1, '2'),
(2, 1, 2, '3'),
(3, 2, 3, '5'),
(4, 3, 3, '4'),
(5, 3, 4, '5'),
(6, 4, 5, '5'),
(7, 3, 4, '2');

select * from progress p
    join subjects su on p.subject_id = su.id
    join students st on p.student_id = st.id
where p.mark > 3;

select * from progress p
                  join subjects su on p.subject_id = su.id
                  join students st on p.student_id = st.id;
delete from students where id = 2;
select * from progress p
    join subjects su on p.subject_id = su.id
    join students st on p.student_id = st.id;


select avg(mark) from progress
    join subjects su on su.id = progress.subject_id
    where su.name = 'math';


select avg(mark) from progress p
join subjects su on p.subject_id = su.id
join students st on p.student_id = st.id
where st.name = 'alex';


alter table students add constraint unic unique (seriya, number);


select count(p.mark), su.name from progress p
    join subjects su on su.id = p.subject_id
    where p.mark > 2
    group by su.name
    order by count(*) desc limit 3;


-- вывести всех должников (у кого 2 или неявка)
SELECT st.name, sb.name
FROM students st, subjects sb
WHERE NOT exists(SELECT *
                 FROM progress p
                 WHERE p.student_id = st.id AND p.subject_id = sb.id AND p.mark != 2)
ORDER BY st.name, sb.name;


