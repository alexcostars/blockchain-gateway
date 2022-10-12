package dev.alexcosta.blockchaingateway.controller;

import dev.alexcosta.blockchaingateway.wallet.EthereumWallet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@RestController
public class TransactionController {

    @RequestMapping(method = RequestMethod.POST, value = "/api/v1/transaction/transfer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> transfer(@RequestBody Map<String, Object> params) throws Exception {
        EthereumWallet wallet = new EthereumWallet(null, params.get("privateKey").toString());
        return ResponseEntity.ok("status: " + wallet.transferTo(params.get("to").toString()));
    }
}
