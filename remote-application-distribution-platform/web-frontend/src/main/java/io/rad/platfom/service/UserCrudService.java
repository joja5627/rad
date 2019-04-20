package io.rad.platfom.service;


import io.rad.platfom.domain.UserDocument;

import java.util.Optional;

public interface UserCrudService {

  UserDocument save(UserDocument user);

  Optional<UserDocument> find(String id);

  Optional<UserDocument> findByUsername(String username);
}
