package tech.buildrun.jbank.controller;

public record CreateWalletDto(String cpf,
                              String email,
                              String name) {
}
