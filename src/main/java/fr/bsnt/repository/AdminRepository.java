package fr.bsnt.repository;

import fr.bsnt.model.Admin;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
