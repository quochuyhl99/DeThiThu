package org.example.main;

import java.util.List;
import java.util.Scanner;
import javax.persistence.Query;
import org.example.config.HibernateConfig;
import org.example.entity.Apartment;
import org.example.entity.Bill;
import org.example.entity.Customer;
import org.example.entity.Employee;
import org.example.utils.ConsoleCleaner;
import org.example.utils.GlobalScanner;
import org.example.utils.ValidatorUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    private Scanner scanner = GlobalScanner.SCANNER;


    public void start() {
        int choice = 0;
        do {
            choice = mainMenu();
            switch (choice) {
                case 1:
                    enterBillData();
                    break;
                case 2:
                    break;
            }
        } while (choice != 2);
    }

    public int mainMenu() {
        ConsoleCleaner.clear();
        System.out.println("\nMenu nhập Bill");
        System.out.println("1. Nhập Bill data");
        System.out.println("2. Thoát");

        while (true) {
            try {
                System.out.print("Nhập lựa chọn: ");
                String input = scanner.nextLine();
                return ValidatorUtils.validateInteger(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void enterBillData() {
        int customerId = 0;
        Customer customer = null;
        int employeeId = 0;
        Employee employee = null;
        int numBedRoom = 0;
        Apartment apartment = null;

        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            /**
             * nhập id khách hàng rồi get từ DB về
             */
            System.out.println("Nhập x để return");
            while (true) {
                try {
                    System.out.print("Nhập Id khách hàng: ");
                    String input = scanner.nextLine();
                    if ("x".equals(input) || "X".equals(input)) {
                        return;
                    }
                    customerId = ValidatorUtils.validateInteger(input);
                    customer = session.get(Customer.class, customerId);
                    if (customer == null) {
                        throw new Exception("Không tìm thấy id khách hàng");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            /**
             * nhập id nhân viên rồi get từ DB về
             */
            while (true) {
                try {
                    System.out.print("Nhập Id nhân viên: ");
                    String input = scanner.nextLine();
                    if ("x".equals(input) || "X".equals(input)) {
                        return;
                    }
                    employeeId = ValidatorUtils.validateInteger(input);
                    employee = session.get(Employee.class, employeeId);
                    if (employee == null) {
                        throw new Exception("Không tìm thấy id nhân viên");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            /**
             * nhập số phòng ngủ rồi get phòng thích hợp chưa bán từ DB về
             */
            while (true) {
                try {
                    System.out.print("Nhập số phòng ngủ: ");
                    String input = scanner.nextLine();
                    if ("x".equals(input) || "X".equals(input)) {
                        return;
                    }
                    numBedRoom = ValidatorUtils.validateInteger(input);
                    String hql = "SELECT A FROM Apartment A WHERE A.numBedroom = :numBedroom "
                                + "AND A.status = :status";
                    Query query = session.createQuery(hql);
                    query.setParameter("numBedroom", numBedRoom);
                    query.setParameter("status", "not sold");
                    List<Apartment> apartments = query.getResultList();
                    if (apartments != null && !apartments.isEmpty()) {
                        apartment = apartments.get(0);
                    }
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            if (apartment == null) {
                System.out.println("\nHiện tại đã hết căn hộ phù hợp với khách hàng.");
                return;
            }

            System.out.println("\nCác Thông tin lấy được từ DB");
            System.out.println(customer);
            System.out.println(employee);
            System.out.println(apartment);

            Bill bill = new Bill();
            bill.setEmployee(employee);
            bill.setCustomer(customer);
            bill.setApartment(apartment);

            employee.getBills().add(bill);
            customer.getBills().add(bill);

            boolean check = true;
            System.out.println("\nKiểm tra thông tin để tạo bill");
            check = ValidatorUtils.validateEntity(customer);
            check = ValidatorUtils.validateEntity(employee);
            if (check) {
                int soldPrice = 0;
                while (true) {
                    try {
                        System.out.print("Nhập giá mua: ");
                        String input = scanner.nextLine();
                        if ("x".equals(input) || "X".equals(input)) {
                            return;
                        }
                        soldPrice = ValidatorUtils.validateInteger(input);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                bill.setSoldPrice(soldPrice);

                apartment.setBill(bill);
                apartment.setStatus("sold");

                session.save(bill);
                System.out.println("Tạo Bill thành công");
            } else {
                transaction.rollback();
                return;
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }
}
