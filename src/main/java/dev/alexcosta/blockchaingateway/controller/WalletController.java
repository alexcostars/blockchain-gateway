package dev.alexcosta.blockchaingateway.controller;

import dev.alexcosta.blockchaingateway.dto.WalletDTO;
import dev.alexcosta.blockchaingateway.wallet.EthereumWallet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class WalletController {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/wallet/{publicKey}", produces = "application/json")
    public ResponseEntity<WalletDTO> getWallet(@PathVariable String publicKey) throws Exception {
        EthereumWallet wallet = new EthereumWallet(publicKey);
        WalletDTO dto = new WalletDTO();
        dto.setAddress(wallet.getAddress());
        dto.setBalance(wallet.getBalance());
        return ResponseEntity.ok(dto);
    }
}
