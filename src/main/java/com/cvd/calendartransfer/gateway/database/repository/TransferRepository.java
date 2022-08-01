package com.cvd.calendartransfer.gateway.database.repository;

import com.cvd.calendartransfer.gateway.database.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransactionEntity, Integer> {

}
