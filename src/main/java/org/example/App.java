package org.example;

import org.example.config.HibernateConfig;
import org.example.entity.Apartment;
import org.example.entity.Bill;
import org.example.entity.Customer;
import org.example.entity.Employee;
import org.example.main.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static org.example.utils.LocalDateUtil.stringToLocalDate;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
//        if (!initializeData()) return;
        if (HibernateConfig.getSessionFactory() == null) {
            System.out.println("Can't initialize SessionFactory, exit program.");
            return;
        }
        Main main = new Main();
        main.start();
    }


//    public static boolean initializeData() {
//        if (HibernateConfig.getSessionFactory() == null) {
//            System.out.println("Can't initialize SessionFactory, exit program.");
//            return false;
//        }
//
//        Transaction transaction = null;
//        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            /**
//             * Tạo Employee
//             */
//            Employee employee1 = new Employee("Employee 1", "QL");
//            Employee employee2 = new Employee("Employee 2", "NV");
//            Employee employee3 = new Employee("Employee 3", "NV");
//            Employee employee4 = new Employee("Employee 4", "NV");
//
//            session.save(employee1);
//            session.save(employee2);
//            session.save(employee3);
//            session.save(employee4);
//
//            /**
//             * tạo customer
//             */
//            Customer customer1 = new Customer("Customer 1",
//                                              "0123456789",
//                                              stringToLocalDate("22/12/1999"),
//                                              "123 abc");
//            Customer customer2 = new Customer("Customer 2",
//                                              "0123456789",
//                                              stringToLocalDate("22/12/1999"),
//                                              "123 abc");
//            Customer customer3 = new Customer("Customer 3",
//                                              "0123456789",
//                                              stringToLocalDate("22/12/1999"),
//                                              "123 abc");
//            Customer customer4 = new Customer("Customer 4",
//                                              "0123456789",
//                                              stringToLocalDate("22/12/1999"),
//                                              "123 abc");
//            Customer customer5 = new Customer("Customer 5",
//                                              "0123456789",
//                                              stringToLocalDate("22/12/1999"),
//                                              "123 abc");
//
//            session.save(customer1);
//            session.save(customer2);
//            session.save(customer3);
//            session.save(customer4);
//            session.save(customer5);
//
//            /**
//             * tạo apartment
//             */
//            Apartment apartment1 = new Apartment("APT01", 1, "Dong", 10000, "sold");
//            Apartment apartment2 = new Apartment("APT02", 1, "Tay", 10000, "sold");
//            Apartment apartment3 = new Apartment("APT03", 1, "Nam", 10000, "sold");
//            Apartment apartment4 = new Apartment("APT04", 2, "Bac", 10000, "sold");
//            Apartment apartment5 = new Apartment("APT05", 2, "Dong", 10000, "sold");
//            Apartment apartment6 = new Apartment("APT06", 2, "Tay", 10000, "not sold");
//            Apartment apartment7 = new Apartment("APT07", 2, "Nam", 10000, "not sold");
//            Apartment apartment8 = new Apartment("APT08", 2, "Bac", 10000, "not sold");
//            Apartment apartment9 = new Apartment("APT09", 3, "Dong", 10000, "sold");
//            Apartment apartment10 = new Apartment("APT10", 3, "Tay", 10000, "not sold");
//
//            session.save(apartment1);
//            session.save(apartment2);
//            session.save(apartment3);
//            session.save(apartment4);
//            session.save(apartment5);
//            session.save(apartment6);
//            session.save(apartment7);
//            session.save(apartment8);
//            session.save(apartment9);
//            session.save(apartment10);
//
//            /**
//             * tạo bill
//             */
//            Bill bill1 = new Bill(10000);
//            bill1.setEmployee(employee1);
//            bill1.setCustomer(customer1);
//            bill1.setApartment(apartment1);
//            Bill bill2 = new Bill(10000);
//            bill2.setEmployee(employee1);
//            bill2.setCustomer(customer1);
//            bill2.setApartment(apartment2);
//            Bill bill3 = new Bill(10000);
//            bill3.setEmployee(employee1);
//            bill3.setCustomer(customer2);
//            bill3.setApartment(apartment3);
//            Bill bill4 = new Bill(10000);
//            bill4.setEmployee(employee2);
//            bill4.setCustomer(customer3);
//            bill4.setApartment(apartment4);
//            Bill bill5 = new Bill(10000);
//            bill5.setEmployee(employee2);
//            bill5.setCustomer(customer4);
//            bill5.setApartment(apartment5);
//            Bill bill6 = new Bill(10000);
//            bill6.setEmployee(employee3);
//            bill6.setCustomer(customer5);
//            bill6.setApartment(apartment9);
//
//            session.save(bill1);
//            session.save(bill2);
//            session.save(bill3);
//            session.save(bill4);
//            session.save(bill5);
//            session.save(bill6);
//
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//            return false;
//        }
//    }

}
