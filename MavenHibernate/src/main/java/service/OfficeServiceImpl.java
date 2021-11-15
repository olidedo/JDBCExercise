package service;

import entity.Office;
import repository.OfficeRepository;
import repository.OfficeRepositoryImpl;

public class OfficeServiceImpl implements OfficeService{
    private OfficeRepository officeRepository = new OfficeRepositoryImpl();
    @Override
    public Office getOffice(String officeCode) {
        return officeRepository.getOffice(officeCode);
    }
}
