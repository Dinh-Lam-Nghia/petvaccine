package fpt.fa.repository;
  
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fpt.fa.entity.PetOwners;
 
@Repository
public interface PetOwnersRepository extends JpaRepository<PetOwners, Integer> { 
	List<PetOwners> findByDelete(int delete);
	PetOwners findByOwnerName(String ownerName);
	List<PetOwners> findAllByOwnerNameContainingOrPhoneNumberContainingOrEmailContainingOrAddressContainingAndDelete(String ownerName, String phoneNumber, String email, String address, int delete);


//	@Modifying
//	@Query("UPDATE PetOwners SET address = :address, dateOfRegistration = :dateOfRegistration, isDelete = :delete, email = :email, ownerName = :ownerName, phoneNumber = :phoneNumber WHERE ownerID = :ownerID")
//	void updateById(@Param("ownerID") int ownerID, @Param("ownerName") String ownerName,
//			@Param("phoneNumber") String phoneNumber, @Param("email") String email, @Param("address") String address,
//			@Param("dateOfRegistration") Date dateOfRegistration, @Param("delete") int delete);

}