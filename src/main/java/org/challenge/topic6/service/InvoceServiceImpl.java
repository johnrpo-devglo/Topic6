package org.challenge.topic6.service;

import org.challenge.topic6.dao.InvoceRepository;
import org.challenge.topic6.models.Invoce;

import java.util.Optional;

public class InvoceServiceImpl implements InvoceService{

    private InvoceRepository invoceRepository;

    public InvoceServiceImpl(InvoceRepository invoceRepository) {
        this.invoceRepository = invoceRepository;
    }

    @Override
    public Optional<Invoce> findInvoce(Long idBanco) {
        return invoceRepository.findAll()
                .stream()
                .filter(e -> e.getIdBanco().equals(idBanco))
                .findFirst();

    }
}
