package fpt.fa.service.Impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<Vaccines> findByDelete(int delete) {
		return repository.findByDelete(delete);
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
	@Override
	public long countAllVaccines() {
	    return repository.count();
	}

	@Override
	public long countDeletedVaccines() {
	    return repository.countByDelete(1);
	}

	@Override
	public Vaccines findById(int vaccineID) { 
		return repository.findById(vaccineID).orElse(null);
	}

	@Override
	public void deleteById(int id) { 
		Vaccines vaccines = repository.findById(id).orElse(null);
		if(vaccines != null) {
			vaccines.setDelete(0);
			repository.save(vaccines);
		}
		
	}
	
	@Override
	@Transactional
    public void deleteByIds(List<Integer> ids) {
		 try {
			 repository.deleteAllByVaccineID(ids);
	        } catch (DataAccessException e) {
	            // Xử lý lỗi, ghi log hoặc ném lại lỗi
	            System.err.println("Lỗi khi xóa các bản ghi: " + e.getMessage());
	            throw e;
	        }
    }
	
	

}
