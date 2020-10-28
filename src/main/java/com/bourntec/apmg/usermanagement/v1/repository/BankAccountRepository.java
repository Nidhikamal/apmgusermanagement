package com.bourntec.apmg.usermanagement.v1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.BankAccounts;

@Repository(value = "BankAccountRepository")

public interface BankAccountRepository
extends JpaRepository<BankAccounts,String>,JpaSpecificationExecutor {

	Optional<BankAccounts> findBybankNo(String bankNo);


}
