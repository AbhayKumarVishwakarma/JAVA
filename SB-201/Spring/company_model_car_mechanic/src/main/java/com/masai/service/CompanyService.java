package com.masai.service;

import com.masai.exception.CompanyException;
import com.masai.model.Company;

import java.util.List;

public interface CompanyService {
    public Company createCompany(Company company);
    public Company updateCompany(Integer companyId, Company company) throws CompanyException;
    public Company deleteCompany(Integer companyId) throws CompanyException;
    public Company companyById(Integer companyId) throws CompanyException;
    public List<Company> allCompany() throws CompanyException;
}
