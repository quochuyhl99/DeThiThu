package org.example.dao;

import org.example.entity.Bill;
import org.example.entity.Customer;

public interface CustomerDao {
    public boolean save(Customer customer);

    public boolean update(Customer customer);

    public boolean delete(Integer customerId);

    public Customer get(Integer customerId);
}
