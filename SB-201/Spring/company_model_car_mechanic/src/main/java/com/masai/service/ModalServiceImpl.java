package com.masai.service;

import com.masai.exception.CompanyException;
import com.masai.exception.ModalException;
import com.masai.model.Company;
import com.masai.model.Modal;
import com.masai.repository.CompanyRepository;
import com.masai.repository.ModalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModalServiceImpl implements ModalService{

    @Autowired
    private ModalRepository modalRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Modal createModal(Modal modal, Integer companyId) throws CompanyException {
        Company company = companyRepository.findById(companyId).orElseThrow( () -> new CompanyException("Not found any company with id: " + companyId));
        modal.setCompany(company);
        company.getModalList().add(modal);
        return modalRepository.save(modal);
    }

    @Override
    public Modal updateModal(Integer modalId, Modal m) throws ModalException {
        Modal modal = modalRepository.findById(modalId).orElseThrow( () -> new ModalException("Not find any modal with id: " + modalId));
        if(m.getModelName() != null) modal.setModelName(m.getModelName());
        if(m.getLaunchingYear() != 0) modal.setLaunchingYear(m.getLaunchingYear());
        return null;
    }

    @Override
    public Modal deleteModal(Integer modalId) throws ModalException {
        Modal modal = modalRepository.findById(modalId).orElseThrow( () -> new ModalException("Not find any modal with id: " + modalId));
        modalRepository.delete(modal);
        return modal;
    }

    @Override
    public Modal modalById(Integer modalId) throws ModalException {
        return modalRepository.findById(modalId).orElseThrow( () -> new ModalException("Not find any modal with id: " + modalId));
    }

    @Override
    public List<Modal> allModal() throws ModalException {
        List<Modal> modalList = modalRepository.findAll();
        if(modalList.isEmpty()) throw new ModalException("Not find any modal");
        return modalList;
    }
}
