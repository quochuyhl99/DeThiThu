package org.example.dao;

import org.example.entity.Apartment;

public interface ApartmentDao {
    public boolean save(Apartment apartment);

    public boolean update(Apartment apartment);

    public boolean delete(Integer apartmentId);

    public Apartment get(Integer apartmentId);
}
