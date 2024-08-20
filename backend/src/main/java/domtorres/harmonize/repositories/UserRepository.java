package domtorres.harmonize.repositories;

import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import domtorres.harmonize.models.User;

public interface UserRepository extends Neo4jRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}
