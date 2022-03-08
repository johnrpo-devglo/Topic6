package org.challenge.topic6.models;

import java.math.BigDecimal;

public class Banco {

    private int id;
    private String name;

    public Banco(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void transfer(Cuenta origin, Cuenta destination, BigDecimal monto) {
        origin.debit(monto);
        BigDecimal limitAmount = new BigDecimal("1499999");
        if (monto.compareTo(limitAmount) == 1) {
            monto = monto.subtract((monto.multiply(new BigDecimal(3))).divide(new BigDecimal(100)));
            destination.send(monto);
        }else {
            destination.send(monto);
        }
    }
}
