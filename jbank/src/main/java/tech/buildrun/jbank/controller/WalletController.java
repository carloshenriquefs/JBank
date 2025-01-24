package tech.buildrun.jbank.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.buildrun.jbank.controller.dto.CreateWalletDto;
import tech.buildrun.jbank.service.WalletService;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(path = "/wallets")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public ResponseEntity<Void> createWallert(@RequestBody @Valid CreateWalletDto dto) {

        var wallet = walletService.createWallet(dto);

        return ResponseEntity.created(URI.create("/wallets/" + wallet.getWalletId().toString())).build();
    }

    @DeleteMapping(path = "/{walletId}")
    public ResponseEntity<Void> deleteWallet(@PathVariable("walletId") UUID walletId) {
        var deleted = walletService.deleteWallet(walletId);

        return deleted ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
