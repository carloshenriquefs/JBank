package tech.buildrun.jbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.buildrun.jbank.entities.Transfer;

import java.util.UUID;

public interface TransferRespository extends JpaRepository<Transfer, UUID> {
}
