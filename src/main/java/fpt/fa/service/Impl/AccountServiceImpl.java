package fpt.fa.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.fa.entity.Account;
import fpt.fa.repository.AccountRepository;
import fpt.fa.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository repository;
	
	@Override
	public void create(Account account) {
		repository.save(account);
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	@Override
	public void update(Account account) {
		repository.save(account);
	}
	
	@Override
	public int Login(String username, String password) {
		Account account = repository.findByUserName(username);
			if(account == null) {
				return -1; //k tontai
			}
			
			if(account.getUserPass().equals(password)) {
				if(account.getPositionID().equals(1)) {
					return 1; //admin
				} else {
					return 2; //customer
				}
			} else {
				return 0; //sai mk
			}
			
	}
	@Override
	public Account checkAccount(String username) {
		Account account = repository.findByUserName(username);
		return account;
	}
	
	@Override
	public boolean checkUserName(String username) {
		boolean isUsername = repository.existsByuserName(username);
		return isUsername;
	}
	
}
