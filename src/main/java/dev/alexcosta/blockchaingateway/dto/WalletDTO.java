package dev.alexcosta.blockchaingateway.dto;

import java.math.BigInteger;

public class WalletDTO {
    String address;
    BigInteger balance;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getBalance() {
        return balance;
    }

    public void setBalance(BigInteger balance) {
        this.balance = balance;
    }
}
