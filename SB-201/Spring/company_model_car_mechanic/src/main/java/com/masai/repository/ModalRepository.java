package com.masai.repository;

import com.masai.model.Modal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalRepository extends JpaRepository<Modal, Integer> {
}
