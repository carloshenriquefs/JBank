package tech.buildrun.jbank.controller.dto;

public record CreateWalletDto(String cpf,
                              String email,
                              String name) {
}
