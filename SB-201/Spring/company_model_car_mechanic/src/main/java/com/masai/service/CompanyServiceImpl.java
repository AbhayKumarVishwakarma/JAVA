package com.masai.service;

import com.masai.exception.CompanyException;
import com.masai.model.Company;
import com.masai.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Integer companyId, Company c) throws CompanyException {
        Company company = companyRepository.findById(companyId).orElseThrow( () -> new CompanyException("Not found any company with id: " + companyId));
        if(c.getCompanyName() != null) company.setCompanyName(c.getCompanyName());
        if(c.getEstd_year() != 0) company.setEstd_year(c.getEstd_year());
        return companyRepository.save(company);
    }

    @Override
    public Company deleteCompany(Integer companyId) throws CompanyException {
        Company company = companyRepository.findById(companyId).orElseThrow( () -> new CompanyException("Not found any company with id: " + companyId));
        companyRepository.delete(company);
        return company;
    }

    @Override
    public Company companyById(Integer companyId) throws CompanyException {
        return companyRepository.findById(companyId).orElseThrow( () -> new CompanyException("Not found any company with id: " + companyId));
    }

    @Override
    public List<Company> allCompany() throws CompanyException {
        List<Company> companyList = companyRepository.findAll();
        if(companyList.isEmpty()) throw new CompanyException("Not found any company!");
        return companyList;
    }
}
