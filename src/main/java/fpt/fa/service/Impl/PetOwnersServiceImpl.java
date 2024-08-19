package fpt.fa.service.Impl;

import java.util.List;

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
	public List<PetOwners> findByDelete() {
		// TODO Auto-generated method stub
		return petOwnersRepository.findByDelete(1);
	}

	@Override
	public void deleteById(int id) {
		PetOwners petOwners = petOwnersRepository.findById(id).orElse(null);
		if (petOwners != null) {
			petOwners.setDelete(0);  // Đặt delete thành 0 để đánh dấu là đã bị xóa
            petOwnersRepository.save(petOwners);  // Cập nhật phòng khám với trạng thái mới
        }
	}

	@Override
	public PetOwners findById(int id) {
		return petOwnersRepository.findById(id).orElse(null);
	}

	@Override
	public void updateById(PetOwners petOwners) {
		petOwnersRepository.save(petOwners);
	}

	@Override
	public List<PetOwners> search(String search) { 
		return petOwnersRepository.findAllByOwnerNameContainingOrPhoneNumberContainingOrEmailContainingOrAddressContainingAndDelete(search, search, search, search, 1);
	}

//	@Override
//	public void updateById(PetOwners petOwners) {
//		petOwnersRepository.updateById(petOwners.getOwnerID(), petOwners.getOwnerName(), petOwners.getPhoneNumber(), petOwners.getEmail(), petOwners.getAddress(), petOwners.getDateOfRegistration(), petOwners.getDelete());
//	}

	

}
