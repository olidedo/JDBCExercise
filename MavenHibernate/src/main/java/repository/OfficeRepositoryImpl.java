package repository;

import database.Database;
import entity.Office;

import javax.persistence.EntityManager;

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
