package com.onetooneandonetomany;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class MainLibrary {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Laptop laptop = new Laptop();
        laptop.setProducer("HP");
        laptop.setProcessor("Intel");
        laptop.setHdd("RAID0");
        laptop.setRam("DDR3");
        laptop.setColor("blue");
        laptop.setGuarantee(3);

        Laptop laptop1 = new Laptop();
        laptop1.setProducer("Lenovo");
        laptop1.setProcessor("AMD");
        laptop1.setHdd("NAS");
        laptop1.setRam("DDR4");
        laptop1.setColor("pink");
        laptop1.setGuarantee(2);

        Laptop laptop2 = new Laptop();
        laptop2.setProducer("Dell");
        laptop2.setProcessor("Apple");
        laptop2.setHdd("VMware");
        laptop2.setRam("DDR3");
        laptop2.setColor("red");
        laptop2.setGuarantee(1);

        Laptop laptop3 = new Laptop();
        laptop3.setProducer("Mac");
        laptop3.setProcessor("Apple");
        laptop3.setHdd("Flash Drive");
        laptop3.setRam("DDR4");
        laptop3.setColor("black");
        laptop3.setGuarantee(3);

        Laptop laptop4 = new Laptop();
        laptop4.setProducer("Asus");
        laptop4.setProcessor("Qualcomm");
        laptop4.setHdd("SAN");
        laptop4.setRam("DDR3");
        laptop4.setColor("white");
        laptop4.setGuarantee(1);


        List<Student> list1 = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();
        List<Student> list3 = new ArrayList<>();

        Student student1 = new Student();
        student1.setName("Andrei");
        student1.setSurname("Mare");
        student1.setCountry("Italy");
        student1.setCity("Bari");
        student1.setLaptop(laptop1);

        Student student2 = new Student();
        student2.setName("Matei");
        student2.setSurname("Marcu");
        student2.setCountry("Spain");
        student2.setCity("Madrid");
        student2.setLaptop(laptop2);

        Student student3 = new Student();
        student3.setName("Alex");
        student3.setSurname("Heghes");
        student3.setCountry("Romania");
        student3.setCity("ClujNapoca");
        student3.setLaptop(laptop3);

        Student student4 = new Student();
        student4.setName("Natalia");
        student4.setSurname("Heghes");
        student4.setCountry("Portugalia");
        student4.setCity("Lisabona");
        student4.setLaptop(laptop4);

        Student student5 = new Student();
        student5.setName("Mira");
        student5.setSurname("Macea");
        student5.setCountry("StLucia");
        student5.setCity("Bocage");

        Student student6 = new Student();
        student6.setName("Mara");
        student6.setSurname("Maculescu");
        student6.setCountry("StLucia");
        student6.setCity("AuTabor");


        list1.add(student1);
        list1.add(student3);
        list2.add(student2);
        list2.add(student4);
        list3.add(student5);
        list3.add(student6);

        Clas clas1 = new Clas();
        clas1.setClassName("Tango");
        clas1.setFloor(1);
        clas1.setStudents(list1);

        Clas clas2 = new Clas();
        clas2.setClassName("Salsa@Bachata");
        clas2.setFloor(2);
        clas2.setStudents(list2);

        Clas clas3 = new Clas();
        clas3.setClassName("ValsVienez");
        clas3.setFloor(4);
        clas3.setStudents(list3);

//Display for a particular student the ram memory and the processor of his laptop
        Query query1 = session.createQuery("From Student where name =:na and surname =:sur");
        query1.setParameter("na", "Natalia");
        query1.setParameter("sur", "Heghes");

        List list4 = ((org.hibernate.query.Query<?>) query1).list();
        Student s = (Student) list4.get(0);
        String ram = s.getLaptop().getRam();
        String processor = s.getLaptop().getProcessor();
        System.out.println("Natalia Heghes' laptop has ram: " + ram + " and processor " + processor);

//Display the list of laptops whose guarantee is greater than 1 year
        Query query2 = session.createQuery("From Laptop where guarantee >: value");
        query2.setParameter("value", 1);
        List list5 = ((org.hibernate.query.Query<?>) query2).list();
        System.out.println("The list of laptops whose guarantee is greater than 1 year: " + list5);

//Display the students from a class using its name
        Query query6 = session.createQuery("From Clas where className =: name");
        query6.setParameter("name", "valsvienez");

        List list9 = ((org.hibernate.query.Query<?>) query6).list();
        System.out.println("The students are: ");
        list9.forEach(System.out::println);

//Display the students from a class using its id
        Query query3 = session.createQuery("From Clas where id =: i");
        query3.setParameter("i", 1);
        List list6 = ((org.hibernate.query.Query<?>) query3).list();
        Clas c = (Clas) list6.get(0);
        System.out.println("The students are: "+ c.getStudents());

//Find out if a list of guarantees has a specific laptop
        Query query4 = session.createQuery("From Laptop where guarantee >:g");
        query4.setParameter("g", 2);
        List list7 = ((org.hibernate.query.Query<?>) query4).list();
        System.out.println("======================" + list7.contains(laptop4));

//Display the color of a student's laptop using student's city and student's surname
        Query query5 = session.createQuery("From Student where surname =: sur and city =: c");
        query5.setParameter("sur", "Heghes");
        query5.setParameter("c", "Lisabona");

        List list8 = ((org.hibernate.query.Query<?>) query5).list();
        Student co = (Student) list8.get(0);
        System.out.println("The color is: " + co.getLaptop().getColor());


//        session.persist(laptop4);
//        session.persist(laptop3);
//        session.persist(laptop1);
//        session.persist(laptop2);
//
//        session.persist(student6);
//        session.persist(student5);
//        session.persist(student4);
//        session.persist(student3);
//        session.persist(student2);
//        session.persist(student1);
//
//        session.persist(clas3);
//        session.persist(clas1);
//        session.persist(clas2);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
