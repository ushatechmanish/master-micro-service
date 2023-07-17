package in.ushatech.mastermicroservice.repository;

import in.ushatech.mastermicroservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
