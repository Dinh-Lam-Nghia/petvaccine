package fpt.fa.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.fa.entity.PetOwners;
import fpt.fa.repository.PetOwnersRepository;
import fpt.fa.service.PetOwnersService;

@Service
public class PetOwnersServiceImpl implements PetOwnersService {
	@Autowired
	private PetOwnersRepository petOwnersRepository;

	@Override
	public void create(PetOwners petOwners) {
		petOwnersRepository.save(petOwners);
	}

	@Override
	public void select(PetOwners petOwners) {
		petOwnersRepository.findAll();		
	}
	

}
