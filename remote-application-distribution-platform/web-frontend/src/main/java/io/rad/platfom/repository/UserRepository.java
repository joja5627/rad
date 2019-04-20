package io.rad.platfom.repository;


import io.rad.platfom.domain.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserDocument, String> {

    void deleteByUsername(String username);
    boolean changePassword(String oldPassword, String newPassword, String username);
    Optional<UserDocument> findByUsername(String username);

}
