package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void insertStudent(Session session, String name, String lastName, Date birthday, Date DateOfIssue)
    {
        Student student = new Student();
        student.setLastName(lastName);
        student.setName(name);
        student.setDateOfBirth(birthday);
        session.save(student);

        insertVaccinationCertificate(session, student, DateOfIssue);
    }
    public static void insertVaccination(Session session, String name, int interval)
    {
        Vaccination vaccination = new Vaccination();
        vaccination.setVaccinationName(name);
        vaccination.setInterval(interval);
        session.save(vaccination);
    }

    public static void insertVaccinationCertificate(Session session, Student student, Date DateOfIssue)
    {
        if(student != null){
            VaccinationCertificate vaccinationCertificate = new VaccinationCertificate();
            vaccinationCertificate.setDateOfIssue(DateOfIssue);
            vaccinationCertificate.setStudent(student);
            student.setVaccinationCertificate(vaccinationCertificate);

            session.save(vaccinationCertificate);
        }else
            System.out.println("Такого студента не существует!");
    }

    public static void insertVaccinationToStudent(Session session, Student student, Vaccination vaccination)
    {
        if (student == null)
        {
            System.out.println("Такого студента не существует!");
            return;
        }

        if(vaccination == null)
        {
            System.out.println("Такой прививки не существует!");
            return;
        }

        student.getVaccinationCertificate().setVaccinations(vaccination);

        session.save(student.getVaccinationCertificate());
    }

    public static void insertAllergy (Session session,Student student, String nameAllrgy, int ageOnSet){
        if (student != null) {
            Allergy allergy = new Allergy();
            allergy.setAllergyName(nameAllrgy);
            allergy.setAgeOfOnset(ageOnSet);
            allergy.setStudent(student);
            student.getAllergies().add(allergy);
            session.save(allergy);
        } else
            System.out.println("Такого студента не существует!");
    }

    public static void updateStudent (Session session, Student student, String newLastname, String newName, Date newBirthday){
        if (student == null)
        {
            System.out.println("Такого студента не существует!");
            return;
        }

            student.setLastName(newLastname);
            student.setName(newName);
            student.setDateOfBirth(newBirthday);
            session.update(student);
    }

    public static void deleteStudent (Session session, Student student){
        if (student == null)
        {
            System.out.println("Такого студента не существует!");
            return;
        }

        session.delete(student);
    }

    public static void selectVaccinationAndStudent (Session session, Vaccination vaccination){
        if (vaccination == null)
        {
            System.out.println("Такой прививки не существует!");
            return;
        }

        String vaccinationName = vaccination.getVaccinationName();
        List<Student> studentsWithVaccination = session.createQuery(
                        "SELECT s FROM Student s " +
                                "JOIN s.vaccinationCertificate c " +
                                "JOIN c.vaccinations v " +
                                "WHERE v.vaccinationName = :vaccinationName", Student.class)
                .setParameter("vaccinationName", vaccinationName)
                .getResultList();


        if(!studentsWithVaccination.isEmpty()){
            System.out.println("Students with vaccination " + vaccinationName + ":");
            for (Student student : studentsWithVaccination) {
                System.out.println(student.getName());
            }
        } else
            System.out.println("Таких студентов нет!");

    }

    public static Student selectStudent (Session session, String lastName, String name, Date birthday){
        String hql = "SELECT s FROM Student s " +
                "WHERE s.lastName = :lastName and s.name = :name and s.dateOfBirth = :birthday";

        List<Student> students = session.createQuery(hql, Student.class)
                .setParameter("lastName", lastName)
                .setParameter("name", name)
                .setParameter("birthday", birthday)
                .getResultList();

        if(!students.isEmpty())
            return  students.get(0);
        else
        {
            System.out.println("Таких студентов нет!");
            return null;
        }
    }

    public static Vaccination selectVaccination (Session session, String name){
        String hql = "SELECT v FROM Vaccination v " +
                "WHERE v.vaccinationName = :name";

        List<Vaccination> vaccinations = session.createQuery(hql, Vaccination.class)
                .setParameter("name", name)
                .getResultList();

        if(!vaccinations.isEmpty())
            return  vaccinations.get(0);
        else
        {
            System.out.println("Таких прививок нет!");
            return null;
        }
    }

    public static void selectStudentAllergy (Student student){
        if (student == null)
        {
            System.out.println("Такого студента не существует!");
            return;
        }

        Set<Allergy> allergies = student.getAllergies();

        if(!allergies.isEmpty()){
            for (Allergy allergy : allergies) {
                System.out.println(allergy.getAllergyName() + " " + allergy.getAgeOfOnset());
            }
        }else{
            System.out.println("Таких аллергий нет!");
        }
    }

    public static void selectLastVaccine (Session session, Student student){
        List<Vaccination> vaccinations = session.createQuery(
                        "SELECT v FROM Student s " +
                                "JOIN s.vaccinationCertificate c " +
                                "JOIN c.vaccinations v " +
                                "WHERE s.id = :studentId", Vaccination.class)
                .setParameter("studentId", student.getId())
                .getResultList();

        if (vaccinations != null)
            System.out.println(student.toString() + vaccinations.get(vaccinations.size() - 1).getVaccinationName());
        else {
            System.out.println("У данного школьника не сделано ни одной прививки!");
            return;
        }

    }


    private static final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Allergy.class)
            .addAnnotatedClass(Student.class)
            .addAnnotatedClass(Vaccination.class)
            .addAnnotatedClass(VaccinationCertificate.class)
            .buildSessionFactory();

    public static void main(String[] args){

        final String selectVaccinationToStudentCommand = "/selectVaccinationToStudent";
        final String selectStudentAllergyCommand = "/selectStudentAllergy";
        final String updateStudentCommand = "/updateStudent";
        final String deleteStudentCommand = "/deleteStudent";
        final String exitCommand = "/exit";
        final String helpCommand = "/help";
        final String insertStudentCommand = "/insertStudent";
        final String insertVaccinationCommand = "/insertVaccination";
        final String insertVaccinationToStudentCommand = "/insertVaccinationToStudent";
        final String insertAllergyCommand = "/insertAllergy";
        final String selectLastVaccineToStudentCommand = "/selectLastVaccineToStudent";



        Scanner scanner = new Scanner(System.in);

        boolean toBeContinued = true;

        System.out.print("Для вывода списка команд используйте /help");


            while (toBeContinued)
            {
                try {
                System.out.println("\nEnter command");
                String input = scanner.nextLine();

                String[] arguments = Arrays.stream(input.split(" ")).map(String::trim).filter(s -> !s.isEmpty()).toArray(
                        String[]::new);

                if (arguments.length < 1)
                {
                    System.out.println("Command not entered");
                    continue;
                }
                String command = arguments[0];

                switch (command)
                {
                    case (selectStudentAllergyCommand) ->
                    {
                        Session session = sessionFactory.openSession();
                        Transaction tx = session.beginTransaction();
                        String lastname = arguments[1];
                        String name = arguments[2];
                        Date birthDate = Date.valueOf(arguments[3]);
                        selectStudentAllergy(selectStudent(session, lastname, name, birthDate));
                        tx.commit();
                        session.close();
                    }
                    case (selectVaccinationToStudentCommand) ->
                    {
                        Session session = sessionFactory.openSession();
                        Transaction tx = session.beginTransaction();
                        String nameVaccination = arguments[1];
                        selectVaccinationAndStudent(session, selectVaccination(session, nameVaccination));
                        tx.commit();
                        session.close();
                    }
                    case (updateStudentCommand) ->
                    {
                        Session session = sessionFactory.openSession();
                        Transaction tx = session.beginTransaction();
                        String oldLastname = arguments[1];
                        String oldName = arguments[2];
                        Date oldBirthday = Date.valueOf(arguments[3]);
                        String newLastname = arguments[4];
                        String newName = arguments[5];
                        Date newBirthday = Date.valueOf(arguments[6]);
                        updateStudent(session, selectStudent(session, oldLastname, oldName, oldBirthday), newName, newLastname, newBirthday);
                        tx.commit();
                        session.close();
                    }
                    case (insertStudentCommand) ->
                    {
                        Session session = sessionFactory.openSession();
                        Transaction tx = session.beginTransaction();
                        String lastname = arguments[1];
                        String name = arguments[2];
                        Date birthDate = Date.valueOf(arguments[3]);
                        Date dateOfIssue = Date.valueOf(arguments[4]);
                        insertStudent(session, name, lastname, birthDate, dateOfIssue);
                        tx.commit();
                        session.close();
                    }
                    case (insertAllergyCommand) ->
                    {
                        Session session = sessionFactory.openSession();
                        Transaction tx = session.beginTransaction();
                        String lastname = arguments[1];
                        String name = arguments[2];
                        Date birthDate = Date.valueOf(arguments[3]);
                        String nameAllergen = arguments[4];
                        int ageOnSet = Integer.parseInt(arguments[5]);
                        insertAllergy(session, selectStudent(session, lastname, name, birthDate), nameAllergen, ageOnSet);
                        tx.commit();
                        session.close();
                    }
                    case (insertVaccinationCommand) ->
                    {
                        Session session = sessionFactory.openSession();
                        Transaction tx = session.beginTransaction();
                        String name = arguments[1];
                        String interval = arguments[2];
                        insertVaccination(session, name, Integer.parseInt(interval));
                        tx.commit();
                        session.close();
                    }
                    case (insertVaccinationToStudentCommand) ->
                    {
                        Session session = sessionFactory.openSession();
                        Transaction tx = session.beginTransaction();
                        String lastnameStudent = arguments[1];
                        String nameStudent = arguments[2];
                        Date birthday = Date.valueOf(arguments[3]);
                        String nameVaccination = arguments[4];

                        insertVaccinationToStudent(session, selectStudent(session, lastnameStudent, nameStudent, birthday), selectVaccination(session, nameVaccination));

                        selectLastVaccine (session, selectStudent(session, lastnameStudent, nameStudent, birthday));
                        tx.commit();
                        session.close();
                    }
                    case (selectLastVaccineToStudentCommand) ->
                    {
                        Session session = sessionFactory.openSession();
                        Transaction tx = session.beginTransaction();
                        String lastnameStudent = arguments[1];
                        String nameStudent = arguments[2];
                        Date birthday = Date.valueOf(arguments[3]);

                        selectLastVaccine (session, selectStudent(session, lastnameStudent, nameStudent, birthday));
                        tx.commit();
                        session.close();
                    }
                    case (deleteStudentCommand) ->
                    {
                        Session session = sessionFactory.openSession();
                        Transaction tx = session.beginTransaction();
                        String lastname = arguments[1];
                        String name = arguments[2];
                        Date birthday = Date.valueOf(arguments[3]);
                        deleteStudent(session, selectStudent(session, lastname, name, birthday));
                        tx.commit();
                        session.close();
                    }
                    case (helpCommand) ->
                    {
                        System.out.println(selectVaccinationToStudentCommand + " [nameVaccination]");
                        System.out.println(selectStudentAllergyCommand + " [lastname] [name] [birthday в формате yyyy-mm-dd]");
                        System.out.println(insertVaccinationToStudentCommand + " [lastname] [name] [birthday в формате yyyy-mm-dd] [nameVaccination]");
                        System.out.println(insertVaccinationCommand + " [name] [interval в формате целого числа]");
                        System.out.println(insertAllergyCommand + " [lastname] [name] [birthday в формате yyyy-mm-dd] [nameAllergen] [ageOnSet в формате целого числа]");
                        System.out.println(insertStudentCommand + " [lastname] [name] [birthday в формате yyyy-mm-dd] [dateOfIssue в формате yyyy-mm-dd]");
                        System.out.println(updateStudentCommand + " [lastname] [name] [birthday в формате yyyy-mm-dd] [newLastname] [newName] [newBirthday в формате yyyy-mm-dd]");
                        System.out.println(deleteStudentCommand + " [lastname] [name] [birthday в формате yyyy-mm-dd]");
                        System.out.println(helpCommand);
                        System.out.println(exitCommand);
                        System.out.println(selectLastVaccineToStudentCommand + " [lastname] [name] [birthday в формате yyyy-mm-dd]");

                    }
                    case (exitCommand) ->
                    {
                        toBeContinued = false;
                    }
                    default -> System.out.println("Неизвестная команда");
                }
            }
        catch(Exception e)
            {
                // IllegalAccessException | ArrayIndexOutOfBoundsException | NumberFormatException e
                // ругается на IllegalAccessException
                System.out.println("Некорректный ввод данных");
            }
            }

    }
}