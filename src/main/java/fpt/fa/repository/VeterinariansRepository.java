package fpt.fa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import fpt.fa.entity.Veterinarians;

@Repository
public interface VeterinariansRepository extends JpaRepository<Veterinarians, Integer> {
    // Lấy danh sách bác sĩ chưa bị xóa (isDelete = 0)
    List<Veterinarians> findByDelete(int delete);
    
    @Query("SELECT v FROM Veterinarians v WHERE v.delete = 1 AND (v.veterinarianName LIKE %:keyword% OR v.email LIKE %:keyword% OR v.phoneNumber LIKE %:keyword%)")
    List<Veterinarians> searchVeterinarians(@Param("keyword") String keyword);
}

