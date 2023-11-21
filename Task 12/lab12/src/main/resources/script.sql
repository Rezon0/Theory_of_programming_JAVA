create table item(id serial primary key, value integer not null, version integer null);

insert into item values
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0),
                            (default, 0, 0);

select sum(i.value) from item i;
-- TRUNCATE item;
-- DELETE FROM item;

drop table item;
