package fpt.fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fpt.fa.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository <Account, Integer>{
	boolean existsByuserName(String userName);
	Account findByUserName(String userName);
	
}
