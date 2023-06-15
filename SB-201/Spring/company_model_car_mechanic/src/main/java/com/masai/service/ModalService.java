package com.masai.service;

import com.masai.exception.CompanyException;
import com.masai.exception.ModalException;
import com.masai.model.Modal;

import java.util.List;

public interface ModalService {
    public Modal createModal(Modal modal, Integer companyId) throws CompanyException;
    public Modal updateModal(Integer modalId, Modal modal) throws ModalException;
    public Modal deleteModal(Integer modalId) throws ModalException;
    public Modal modalById(Integer modalId) throws ModalException;
    public List<Modal> allModal() throws ModalException;
}
