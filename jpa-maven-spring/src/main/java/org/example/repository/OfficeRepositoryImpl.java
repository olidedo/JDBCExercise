package org.example.repository;

import org.example.database.Database;
import org.example.entity.Office;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class OfficeRepositoryImpl implements OfficeRepository {
    private EntityManager em;
    private Database database;

    public OfficeRepositoryImpl() {
        database = new Database();
        em = database.getConnection();
    }

    @Override
    public Office getOffice(String officeCode) {
        return em.find(Office.class, officeCode);
    }
}
