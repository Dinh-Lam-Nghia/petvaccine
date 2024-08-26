package fpt.fa.service.Impl;

import java.security.SecureRandom;

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
	
	@Override
	public String forgotAccount(String username,String phone) {
		String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		int lengh = 6;
		SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(lengh);
        
        for (int i = 0; i < lengh; i++) {
            int index = random.nextInt(CHARACTERS.length());
            password.append(CHARACTERS.charAt(index));
        }
        
        Account account = checkAccount(username);
        
        if (account == null) {
        	return "Không tìm thấy account";
		}
        
        if(!phone.equals(account.getPhone())) {
        	return "FALSE";
        }
        account.setUserPass(password.toString());
        repository.save(account);
        
        return password.toString();
		
	}
	
}
