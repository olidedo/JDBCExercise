package org.example.controller;

import org.example.entity.Office;
import org.example.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OfficeController {
    @Autowired
    OfficeService officeService;

    public Office getOffice(String officeCode){
        return officeService.getOffice(officeCode);
    }
}
