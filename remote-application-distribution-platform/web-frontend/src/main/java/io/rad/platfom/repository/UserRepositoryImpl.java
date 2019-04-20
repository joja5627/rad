package io.rad.platfom.repository;

import com.mongodb.client.result.UpdateResult;
import io.rad.platfom.domain.UserDocument;
import org.apache.catalina.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Update.update;

@Component
public class UserRepositoryImpl  {

    private final MongoTemplate mongoTemplate;

    public UserRepositoryImpl(final MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public boolean changePassword(final String oldPassword,
                                  final String newPassword,
                                  final String username) {
        final Query searchUserQuery = new Query(where("username").is(username).andOperator(where("password").is(oldPassword)));
        final UpdateResult updateResult = mongoTemplate.updateFirst(searchUserQuery, update("password", newPassword), UserDocument.class);
        return updateResult.wasAcknowledged();
    }
}
