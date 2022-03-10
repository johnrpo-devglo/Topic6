package org.challenge.topic6.dao;

import org.challenge.topic6.models.Invoce;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class InvoceRepositoryImpl implements InvoceRepository{
    @Override
    public List<Invoce> findAll() {
        return Arrays.asList(new Invoce(1L, 1L, "01/01/20", 578000L),
                new Invoce(2L, 2L, "01/02/20", 155000L),
                new Invoce(3L, 3L, "01/03/20", 450000L),
                new Invoce(4L, 4L, "01/04/20", 157000L),
                new Invoce(5L, 5L, "01/05/20", 187000L));
    }
}
