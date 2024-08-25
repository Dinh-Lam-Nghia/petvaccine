package fpt.fa.service;

import fpt.fa.entity.Account;

public interface AccountService {
	void create(Account account);
	void delete(int id);
	void update(Account account);
	int Login(String username,String password);
	boolean checkUserName(String username);
	Account checkAccount(String username);

	
}
