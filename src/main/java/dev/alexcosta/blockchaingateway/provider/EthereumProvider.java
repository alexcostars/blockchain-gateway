package dev.alexcosta.blockchaingateway.provider;

import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@Component
public class EthereumProvider {

    public static Web3j get() {
        return Web3j.build(new HttpService("http://localhost:8545"));
    }
}
