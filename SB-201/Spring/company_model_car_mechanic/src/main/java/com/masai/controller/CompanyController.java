package com.masai.controller;

import com.masai.model.Company;
import com.masai.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/companyC")
    public ResponseEntity<Company> createCompanyHandler(@RequestBody Company company){
        Company c = companyService.createCompany(company);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PutMapping("/companyU/{companyId}")
    public ResponseEntity<Company> updateCompanyHandler(@RequestBody Company company, @PathVariable Integer companyId){
        Company c = companyService.updateCompany(companyId, company);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @DeleteMapping("/companyD/{companyId}")
    public ResponseEntity<Company> deleteCompanyHandler(@PathVariable Integer companyId){
        Company c = companyService.deleteCompany(companyId);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<Company> viewCompanyHandler(@PathVariable Integer companyId){
        Company c = companyService.companyById(companyId);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping("/companyAll")
    public ResponseEntity<List<Company>> viewAllCompanyHandler(){
        List<Company> c = companyService.allCompany();
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

}
