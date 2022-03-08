package org.challenge.topic6.models;

import org.challenge.topic6.exceptions.InsufficientFundsException;
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

    @Test
    void point_A_insufficient_founds() {
        double discount4Transaction = 3500;
        Cuenta cuenta = new Cuenta(
                "savings account",
                "John",
                "Restrepo",
                "12345",
                new BigDecimal("10500.123")
        );
        Exception exception = assertThrows(InsufficientFundsException.class, () -> {
            cuenta.debit(new BigDecimal(10000 + discount4Transaction));
        });
        String actual = exception.getMessage();
        String expected = "Insufficient founds";
        assertEquals(expected, actual);
        System.out.println(expected);
    }

    @Test
    void point_B_pay_curent_account() {
        Cuenta cuenta = new Cuenta(
                "current account",
                "John",
                "Restrepo",
                "23456",
                new BigDecimal("600")
        );
        Exception exception2 = assertThrows(InvalidTargetFundsException.class, () -> {
            cuenta.payCurrentAccount(new BigDecimal(199));
        });
        String actual = exception2.getMessage();
        String expected = "Invalid Target";
        assertEquals(expected, actual);
    }



    @Test
    void point_C_trasfer() {
        Cuenta cuenta = new Cuenta(
                "savings account",
                "John",
                "Restrepo",
                "12345",
                new BigDecimal("1500000.123")
        );
        Cuenta cuenta2 = new Cuenta(
                "savings account",
                "Natalia",
                "Paris",
                "56789",
                new BigDecimal("13550000.123")
        );

        Banco banco = new Banco(5, "Banco Globant");
        banco.transfer(cuenta2, cuenta, new BigDecimal(1_500_000));
        assertEquals("12050000.123", cuenta2.getBalance().toPlainString());
        assertEquals("2955000.123", cuenta.getBalance().toPlainString());
    }
}