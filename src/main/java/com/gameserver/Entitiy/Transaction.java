package com.gameserver.Entitiy;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {
    private Short id;
    private String traxid;
    private String username;
    private short transactionStatus;
    private double transactionAmount;

    @Id
    @Column(name = "id")
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "traxid")
    public String getTraxid() {
        return traxid;
    }

    public void setTraxid(String traxid) {
        this.traxid = traxid;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "transaction_status")
    public short getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(short transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Basic
    @Column(name = "transaction_amount")
    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (transactionStatus != that.transactionStatus) return false;
        if (Double.compare(that.transactionAmount, transactionAmount) != 0) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (traxid != null ? !traxid.equals(that.traxid) : that.traxid != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (traxid != null ? traxid.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (int) transactionStatus;
        temp = Double.doubleToLongBits(transactionAmount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
