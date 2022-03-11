package org.challenge.topic6.service;

import org.challenge.topic6.models.Invoce;

import java.util.Optional;

public interface InvoceService {
    Optional<Invoce> findInvoce(Long idBanco);
}
