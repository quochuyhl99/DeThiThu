package org.example.dao;

import org.example.entity.Employee;

public interface EmployeeDao {
    public boolean save(Employee employee);

    public boolean update(Employee employee);

    public boolean delete(Integer employeeId);

    public Employee get(Integer employeeId);
}
