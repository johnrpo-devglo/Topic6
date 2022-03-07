package org.challenge.topic6.models;

import org.challenge.topic6.exceptions.InsufficientFundsException;

import java.math.BigDecimal;

public class Cuenta {

  private String accountType;
  private String name;
  private String lastname;
  private String dni;
  private BigDecimal balance;

    public Cuenta(String accountType, String name, String lastname, String dni, BigDecimal balance) {
        this.accountType = accountType;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void debit(BigDecimal monto){
        BigDecimal newBalance = this.balance.subtract(monto);
        if(newBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new InsufficientFundsException("Insufficient founds");
        }
        this.balance = newBalance;
    }

    public void send(BigDecimal monto){
        this.balance = this.balance.add(monto);
    }
}
