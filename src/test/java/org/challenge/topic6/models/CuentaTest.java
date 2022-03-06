package org.challenge.topic6.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void debit_money() {
        Cuenta cuenta = new Cuenta(
                "savings account",
                "John",
                "Restrepo",
                "12345",
                new BigDecimal("1500.123")
        );
        cuenta.debit(new BigDecimal(500));
        assertNotNull(cuenta.getBalance());
        assertEquals(1000, cuenta.getBalance().intValue());
        assertEquals("1000.123", cuenta.getBalance().toPlainString());
    }

    @Test
    void consign_money() {
        Cuenta cuenta = new Cuenta(
                "savings account",
                "John",
                "Restrepo",
                "12345",
                new BigDecimal("1500.123")
        );
        cuenta.send(new BigDecimal(500));
        assertNotNull(cuenta.getBalance());
        assertEquals(2000, cuenta.getBalance().intValue());
        assertEquals("2000.123", cuenta.getBalance().toPlainString());
    }
}