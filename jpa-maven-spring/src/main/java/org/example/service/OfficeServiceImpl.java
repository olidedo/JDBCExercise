package org.example.service;

import org.example.entity.Office;
import org.example.repository.OfficeRepository;
import org.example.repository.OfficeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficeServiceImpl implements OfficeService{
    @Autowired
    private OfficeRepository officeRepository;
    @Override
    public Office getOffice(String officeCode) {
        return officeRepository.getOffice(officeCode);
    }
}
