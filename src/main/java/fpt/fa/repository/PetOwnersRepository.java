package fpt.fa.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import fpt.fa.entity.PetOwners;

public interface PetOwnersRepository extends JpaRepository<PetOwners, Integer> {
	// tìm kiếm
//	Page<PetOwners> findAllPetOwnersBynameContaining(String name, Pageable pageable);
}
