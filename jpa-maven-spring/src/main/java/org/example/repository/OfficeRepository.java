package org.example.repository;

import org.example.entity.Office;

public interface OfficeRepository {
    Office getOffice(String officeCode);
}
