package org.challenge.topic6.models;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Invoce {

    private Long id;
    private Long idBanco;
    private String expire;
    private Long payBill;
    private List<String> bills;

    public Invoce(Long id, Long idBanco, String expire, Long payBill) {
        this.id = id;
        this.idBanco = idBanco;
        this.expire = expire;
        this.payBill = payBill;
        this.bills = new ArrayList<>();
    }

    public DecimalFormat getId() {
        DecimalFormat df = new DecimalFormat("00-" + id);
        df.format(id);
        return df;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(Long idBanco) {
        this.idBanco = idBanco;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public Long getPayBill() {
        return payBill;
    }

    public void setPayBill(Long payBill) {
        this.payBill = payBill;
    }

    public List<String> getBills() {
        return bills;
    }

    public void setBills(List<String> bills) {
        this.bills = bills;
    }
}
