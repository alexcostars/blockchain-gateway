package dev.alexcosta.blockchaingateway.wallet;

import dev.alexcosta.blockchaingateway.provider.EthereumProvider;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class EthereumWallet {

    Web3j provider;

    String address = null;
    Credentials credentials = null;

    public EthereumWallet(String address) {
        this.provider = EthereumProvider.get();
        this.address = address;
    }

    public EthereumWallet(String address, String privateKey) {
        this.provider = EthereumProvider.get();
        this.credentials = Credentials.create(privateKey);
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public BigInteger getBalance() throws IOException {
        return provider.ethGetBalance(this.address, DefaultBlockParameterName.LATEST).send().getBalance();
    }

    public boolean transferTo(String address) throws TransactionException, IOException, InterruptedException, Exception {
        if(this.credentials == null) {
            return false;
        }

        TransactionReceipt transactionReceipt = Transfer.sendFunds(
                provider, this.credentials, address,
                BigDecimal.valueOf(1.0), Convert.Unit.ETHER).send();

        return true;
    }
}
