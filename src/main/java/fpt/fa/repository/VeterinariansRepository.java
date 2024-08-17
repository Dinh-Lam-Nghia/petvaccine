package fpt.fa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fpt.fa.entity.Veterinarians;

@Repository
public interface VeterinariansRepository extends JpaRepository<Veterinarians, Integer> {
    // Lấy danh sách bác sĩ chưa bị xóa (isDelete = 0)
    List<Veterinarians> findByDelete(int delete);
}

