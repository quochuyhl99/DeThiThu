package org.example.utils;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.apache.commons.validator.routines.DoubleValidator;
import org.apache.commons.validator.routines.IntegerValidator;
import org.example.config.HibernateConfig;
import org.example.entity.Apartment;
import org.example.entity.Customer;
import org.example.entity.Employee;

public class ValidatorUtils {
    private static final Validator ENTITY_VALIDATOR = HibernateConfig.getValidator();
    public static int validateInteger(String input) throws Exception {
        if (IntegerValidator.getInstance().validate(input) == null) {
            throw new Exception("invalid Integer number");
        }
        return IntegerValidator.getInstance().validate(input);
    }

    public static double validateDouble(String input) throws Exception {
        if (DoubleValidator.getInstance().validate(input) == null) {
            throw new Exception("invalid Double number");
        }
        return DoubleValidator.getInstance().validate(input);
    }

    public static boolean validateEntity(Object obj) {
        boolean check = true;
        if (obj instanceof Apartment) {
            Apartment apartment = (Apartment) obj;
            Set<ConstraintViolation<Apartment>> violations = ENTITY_VALIDATOR.validate(apartment);
            if (violations.size() > 0) {
                System.out.println("  - " + apartment.getClass().getSimpleName() + " invalid:");
                for (ConstraintViolation<Apartment> violation : violations) {
                    System.out.println("    + " + violation.getMessage());
                }
                check = false;
            }
        }

        if (obj instanceof Customer) {
            Customer customer = (Customer) obj;
            Set<ConstraintViolation<Customer>> violations = ENTITY_VALIDATOR.validate(customer);
            if (violations.size() > 0) {
                System.out.println("  - " + customer.getClass().getSimpleName() + " invalid:");
                for (ConstraintViolation<Customer> violation : violations) {
                    System.out.println("    + " + violation.getMessage());
                }
                check = false;
            }
        }

        if (obj instanceof Employee) {
            Employee employee = (Employee) obj;
            Set<ConstraintViolation<Employee>> violations = ENTITY_VALIDATOR.validate(employee);
            if (violations.size() > 0) {
                System.out.println("  - " + employee.getClass().getSimpleName() + " invalid:");
                for (ConstraintViolation<Employee> violation : violations) {
                    System.out.println("    + " + violation.getMessage());
                }
                check = false;
            }
        }
        return check;
    }

}
