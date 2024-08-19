package fpt.fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fpt.fa.entity.Account;

public interface AccountRepository extends JpaRepository <Account, Integer>{
	boolean existsByuserName(String userName);
	Account findByuserName(String userName);
	
}
