package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static Connection connection;
    public static Statement statement;

    private static void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
            statement = connection.createStatement();
            System.out.println("Connected");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static void disconnect() {
        try {
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        connect();

        try {
            statement.execute("drop table progress;" + "drop table students;" + "drop table subjects;");

            statement.execute("create table students (" + "    id serial primary key not null," + "    name text not null," + "    seriya varchar(4) not null," + "    number varchar(6) not null);");

            statement.execute("create table subjects (" + "    id serial primary key not null," + "    name text not null);");

            statement.execute("create table progress (" + "    id serial primary key not null," + "    student_id integer not null references students (id) on delete cascade on update cascade," + "    subject_id integer not null references subjects (id)," + "    mark integer not null," + "    check (mark >= 2 and mark <= 5));");

            statement.execute("insert into students (id, name, seriya, number) values" + "(1, 'alex', '1111', '222222')," + "(2, 'oleg', '2222', '123123')," + "(3, 'kate', '3333', '123132')," + "(4, 'victor', '4444', '333222')," + "(5, 'nastya', '5555', '112233')," + "(6, 'anton', '6666', '123123')," + "(7, 'dima', '7777', '345345')," + "(8, 'elya', '8888', '666666');");

            statement.execute("insert into subjects (id, name) values" + "(1, 'russian')," + "(2, 'english')," + "(3, 'math')," + "(4, 'biology')," + "(5, 'physic');");

            statement.execute("insert into progress(id, student_id, subject_id, mark) values" + "(1, 1, 1, '2')," + "(2, 1, 2, '3')," + "(3, 2, 3, '5')," + "(4, 3, 3, '4')," + "(5, 3, 4, '5')," + "(6, 4, 5, '5');");

            var result = statement.executeQuery("select mark, st.name from progress p\n" + "    join subjects su on p.subject_id = su.id\n" + "    join students st on p.student_id = st.id\n" + "where p.mark > 3;");

            System.out.println("Оценка выше 3");
            while (result.next()) {
                System.out.println(result.getInt(1) + " " + result.getString(2));
            }
            System.out.println();

            System.out.println("студенты до удаления");
            result = statement.executeQuery("select p.id, student_id, st.name from progress p" + "    join subjects su on p.subject_id = su.id" + "    join students st on p.student_id = st.id;");

            while (result.next()) {
                System.out.println(result.getInt(1) + " " + result.getInt(2) + " " + result.getString(3));
            }
            System.out.println();
            statement.executeUpdate("delete from students where id = 2;");

            System.out.println("студенты после удаления");
            result = statement.executeQuery("select p.id, student_id, st.name from progress p" + "    join subjects su on p.subject_id = su.id" + "    join students st on p.student_id = st.id;");

            while (result.next()) {
                System.out.println(result.getInt(1) + " " + result.getInt(2) + " " + result.getString(3));
            }
            System.out.println();
            result = statement.executeQuery("select avg(mark) from progress" + "    join subjects su on su.id = progress.subject_id" + "    where su.name = 'math';");

            System.out.println("Средний балл по математике");
            while (result.next()) {
                System.out.println(result.getDouble(1));
            }
            System.out.println();
            result = statement.executeQuery("select avg(mark) from progress p\n" + "join subjects su on p.subject_id = su.id\n" + "join students st on p.student_id = st.id\n" + "where st.name = 'alex';");

            System.out.println("Средний балл alex");
            while (result.next()) {
                System.out.println(result.getDouble(1));
            }

            System.out.println();
            statement.execute("alter table students add constraint unic unique (seriya, number);");

            System.out.println("Предметы с наивысшим баллом");
            result = statement.executeQuery("select count(p.mark), su.name from progress p" + "    join subjects su on su.id = p.subject_id" + "    where p.mark > 2" + "    group by su.name" + "    order by count(*) desc limit 3;");

            while (result.next()) {
                System.out.println(result.getInt(1) + " " + result.getString(2));
            }
            System.out.println();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        disconnect();
    }
}