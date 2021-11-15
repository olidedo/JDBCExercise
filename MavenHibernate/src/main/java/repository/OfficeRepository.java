package repository;

import entity.Office;

public interface OfficeRepository {
    Office getOffice(String officeCode);
}
