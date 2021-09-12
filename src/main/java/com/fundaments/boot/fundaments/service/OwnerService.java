package com.fundaments.boot.fundaments.service;

import com.fundaments.boot.fundaments.entity.Owner;
import com.fundaments.boot.fundaments.repository.OwnerRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OwnerService {
    private final Log LOG = LogFactory.getLog(OwnerService.class);
    private OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Transactional
    public void saveTransactional(List<Owner> owners){
        owners.stream()
                .peek(owner -> LOG.info("Owner inserted: " + owner))
                .forEach(ownerRepository::save);
    }

    public List<Owner> getAllOwners(){
        return ownerRepository.findAll();
    }
}
