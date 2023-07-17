package in.ushatech.mastermicroservice.repository;

import in.ushatech.mastermicroservice.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
