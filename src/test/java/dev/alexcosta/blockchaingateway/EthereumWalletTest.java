package dev.alexcosta.blockchaingateway;

import dev.alexcosta.blockchaingateway.wallet.EthereumWallet;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.io.IOException;
import java.math.BigInteger;

public class EthereumWalletTest {

    @Test
    public void getBalanceTest() {
        EthereumWallet wallet = new EthereumWallet("0x1857272E8e1b4848ff5Ba127c6DaC08C1665B016");
        BigInteger balance = null;

        try {
            balance = wallet.getBalance();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Saldo lido: " + balance.toString());

        Assert.isTrue(balance.compareTo(new BigInteger("100000000000000000000")) == 0, "Saldo lido corretamente");
    }

    @Test
    public void transfer() {
        EthereumWallet from = new EthereumWallet("0x301699d978AdcCCA887eaA14de837F2C779c70cB", "0x1309478fa87268b99a41939aabfa6554ba47dd86b952e59395189d858623f13e");
        EthereumWallet to = new EthereumWallet("0x27b13E82Da76777224495DA1Fd160ec366925DeA");

        BigInteger balanceFromBefore = null;
        BigInteger balanceToBefore = null;
        BigInteger balanceFromAfter = null;
        BigInteger balanceToAfter = null;

        try {
            balanceFromBefore = from.getBalance();
            balanceToBefore = to.getBalance();
            from.transferTo(to.getAddress());
            balanceFromAfter = from.getBalance();
            balanceToAfter = to.getBalance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("From before: " + balanceFromBefore);
        System.out.println("To before: " + balanceToBefore);
        System.out.println("From after: " + balanceFromAfter);
        System.out.println("To after: " + balanceToAfter);

        Assert.isTrue(balanceFromBefore.compareTo(balanceFromAfter) > 0, "Saldo da carteira origem não foi alterado");
        Assert.isTrue(balanceToBefore.compareTo(balanceToAfter) < 0, "Saldo da carteira destino não foi alterado");
    }
}
