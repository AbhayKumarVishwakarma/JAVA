package com.masai.controller;

import com.masai.model.Modal;
import com.masai.service.ModalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class modalController {

    @Autowired
    private ModalService modalService;

    @PostMapping("/modalC")
    public ResponseEntity<Modal> createModalHandler(@RequestBody Modal modal, @RequestParam Integer companyId){
        Modal m = modalService.createModal(modal,companyId);
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @PutMapping("/modalU/{modalId}")
    public ResponseEntity<Modal> updateModalHandler(@RequestBody Modal modal, @PathVariable Integer modalId){
        Modal m = modalService.updateModal(modalId, modal);
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @DeleteMapping("/modalD/{modalId}")
    public ResponseEntity<Modal> deleteModalHandler(@PathVariable Integer modalId){
        Modal m = modalService.deleteModal(modalId);
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @GetMapping("/modal/{modalId}")
    public ResponseEntity<Modal> viewModalHandler(@PathVariable Integer modalId){
        Modal m = modalService.modalById(modalId);
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @GetMapping("/modalU/{modalId}")
    public ResponseEntity<List<Modal>> updateModalHandler(){
        List<Modal> m = modalService.allModal();
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

}
