package tech.buildrun.jbank.service;

import org.springframework.stereotype.Service;
import tech.buildrun.jbank.controller.dto.CreateWalletDto;
import tech.buildrun.jbank.entities.Wallet;
import tech.buildrun.jbank.exception.WalletDataAlreadyExistsException;
import tech.buildrun.jbank.repository.WalletRepository;

import java.math.BigDecimal;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {

        var walletDb = walletRepository.findByCpfOrEmail(dto.cpf(), dto.email());

        if (walletDb.isPresent()) {
            throw new WalletDataAlreadyExistsException("cpf or email already exists");
        }

        var wallet = new Wallet();
        wallet.setBalance(BigDecimal.ZERO);
        wallet.setName(dto.name());
        wallet.setCpf(dto.cpf());
        wallet.setEmail(dto.email());

        return walletRepository.save(wallet);
    }
}
