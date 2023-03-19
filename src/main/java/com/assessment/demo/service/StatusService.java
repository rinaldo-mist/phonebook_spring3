package com.assessment.demo.service;

import org.springframework.stereotype.Service;

import com.assessment.demo.model.Status;
import com.assessment.demo.repository.StatusRepository;


@Service
public class StatusService implements StatusImpl {
    
    StatusRepository oStatusRepository;

    public StatusService(StatusRepository oStatusRepository) {
        this.oStatusRepository = oStatusRepository;
    }

    public Status getStatus(int mode){
        String status = "";
        if(mode == LibStatus.Active.getStatus()){
            status = "Active";
        } else {
            status = "Inactive";
        }
        return oStatusRepository.getStatus(status);
    }
}
