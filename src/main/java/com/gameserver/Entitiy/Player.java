package com.gameserver.Entitiy;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Player {
    private Short id;
    private String username;
    private String password;
    private String clientName;
    private short profileStatus;
    private BigDecimal walletBalance;
    private short balanceVersion;
    private float betAmountLimit;

    @Id
    @Column(name = "id")
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
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
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "client_name")
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Basic
    @Column(name = "profile_status")
    public short getProfileStatus() {
        return profileStatus;
    }

    public void setProfileStatus(short profileStatus) {
        this.profileStatus = profileStatus;
    }

    @Basic
    @Column(name = "wallet_balance")
    public BigDecimal getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(BigDecimal walletBalance) {
        this.walletBalance = walletBalance;
    }

    @Basic
    @Column(name = "balance_version")
    public short getBalanceVersion() {
        return balanceVersion;
    }

    public void setBalanceVersion(short balanceVersion) {
        this.balanceVersion = balanceVersion;
    }

    @Basic
    @Column(name = "bet_amount_limit")
    public float getBetAmountLimit() {
        return betAmountLimit;
    }

    public void setBetAmountLimit(float betAmountLimit) {
        this.betAmountLimit = betAmountLimit;
    }
}
