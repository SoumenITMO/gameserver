package com.gameserver.Dto;

public class ServerResponseDto {

    private int transactionId;
    private int errorCode;
    private int balanceVersion;
    private float betAmount;
    private double remainingBanance;

    public ServerResponseDto(int transactionId, int errorCode, int balanceVersion, float betAmount, double remainingBanance) {

        this.transactionId = transactionId;
        this.errorCode = errorCode;
        this.balanceVersion = balanceVersion;
        this.betAmount = betAmount;
        this.remainingBanance = remainingBanance;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getBalanceVersion() {
        return balanceVersion;
    }

    public void setBalanceVersion(int balanceVersion) {
        this.balanceVersion = balanceVersion;
    }

    public float getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(float betAmount) {
        this.betAmount = betAmount;
    }

    public double getRemainingBanance() {
        return remainingBanance;
    }

    public void setRemainingBanance(double remainingBanance) {
        this.remainingBanance = remainingBanance;
    }
}
