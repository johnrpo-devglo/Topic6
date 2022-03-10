package org.challenge.topic6.dao;

import org.challenge.topic6.models.Invoce;

import java.util.List;

public interface InvoceRepository {
    List<Invoce> findAll();

}
