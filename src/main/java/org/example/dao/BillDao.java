package org.example.dao;

import org.example.entity.Bill;

public interface BillDao {
    public boolean save(Bill bill);

    public boolean update(Bill bill);

    public boolean delete(Integer billId);

    public Bill get(Integer billId);
}
