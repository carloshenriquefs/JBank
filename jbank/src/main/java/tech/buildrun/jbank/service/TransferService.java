package tech.buildrun.jbank.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tech.buildrun.jbank.controller.dto.TransferMoneyDto;
import tech.buildrun.jbank.entities.Transfer;
import tech.buildrun.jbank.entities.Wallet;
import tech.buildrun.jbank.exception.TransferException;
import tech.buildrun.jbank.exception.WalletNotFoundException;
import tech.buildrun.jbank.repository.TransferRespository;
import tech.buildrun.jbank.repository.WalletRepository;

import java.time.LocalDateTime;

@Service
public class TransferService {

    private final TransferRespository transferRespository;
    private final WalletRepository walletRepository;

    public TransferService(TransferRespository transferRespository, WalletRepository walletRepository) {
        this.transferRespository = transferRespository;
        this.walletRepository = walletRepository;
    }

    @Transactional
    public void transferMoney(TransferMoneyDto dto) {

        var sender = walletRepository.findById(dto.sender())
                .orElseThrow(() -> new WalletNotFoundException("sender does not exist"));

        var receiver = walletRepository.findById(dto.receiver())
                .orElseThrow(() -> new WalletNotFoundException("receiver does not exist"));

        if (sender.getBalance().compareTo(dto.value()) == -1) {
            throw new TransferException("insufficient balance. you current balance is $" + sender.getBalance());
        }

        updateWallets(dto, sender, receiver);

        persistTransfer(dto, receiver, sender);
        
    }

    private void updateWallets(TransferMoneyDto dto, Wallet sender, Wallet receiver) {
        sender.setBalance(sender.getBalance().subtract(dto.value()));
        receiver.setBalance(receiver.getBalance().add(dto.value()));

        walletRepository.save(sender);
        walletRepository.save(receiver);
    }

    private void persistTransfer(TransferMoneyDto dto, Wallet receiver, Wallet sender) {
        var transfer = new Transfer();
        transfer.setReceiver(receiver);
        transfer.setSender(sender);
        transfer.setTransferValue(dto.value());
        transfer.setTransferDateTime(LocalDateTime.now());
        transferRespository.save(transfer);
    }
}
