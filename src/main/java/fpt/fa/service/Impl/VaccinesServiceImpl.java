package fpt.fa.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fpt.fa.entity.Vaccines;
import fpt.fa.repository.VaccinesRepository;
import fpt.fa.service.VaccinesService;

@Service
public class VaccinesServiceImpl implements VaccinesService{
	@Autowired
	VaccinesRepository repository;
	
	@Override
	public void create(Vaccines vaccines) {
		repository.save(vaccines);
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
	}
	
	public void update(Vaccines vaccines) {
		repository.save(vaccines);
	}
	
	@Override
	public Vaccines findById(int vaccineID) {
		return repository.findById(vaccineID).orElse(null);
	}
	
	@Override
	public List<Vaccines> getListVaccines() {
		return repository.findAll();
	}
	
	@Override
	public Page<Vaccines> getListVaccinesWithPaging(Pageable pageable){
		return repository.findAll(pageable);
		
	}
	
	@Override
	public Page<Vaccines> findVaccinesByName(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAllVaccinesByVaccineNameContaining(name, pageable);
	}
}
