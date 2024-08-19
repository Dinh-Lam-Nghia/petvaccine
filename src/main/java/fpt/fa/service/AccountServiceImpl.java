package fpt.fa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.fa.entity.Account;
import fpt.fa.repository.AccountRepository;

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
	
	public void update(Account account) {
		repository.save(account);
	}
	
	public int Login(String username, String password) {
		Account account = repository.findByuserName(username);
			if(account == null) {
				return -1; //k tontai
			}
			
			if(account.getUserPass()==password) {
				if(account.getDelete()== 1) {
					return 1; //admin
				} else {
					return 2; //customer
				}
			} else {
				return 0; //sai mk
			}
			
	}
	
	public boolean checkUserName(String username) {
		boolean isUsername = repository.existsByuserName(username);
		return isUsername;
	}
	
}
