package fpt.fa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fpt.fa.entity.Pets;

public interface PetsRepository extends JpaRepository <Pets, Integer>{
	List<Pets> findByDelete(int delete);
}
