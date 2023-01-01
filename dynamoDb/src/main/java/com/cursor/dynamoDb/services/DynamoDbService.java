package com.cursor.dynamoDb.services;

import com.cursor.dynamoDb.dynamoDb.model.User;
import com.cursor.dynamoDb.dynamoDb.repository.DynamoDbUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DynamoDbService {

    DynamoDbUserRepository dynamoDbUserRepository;

    public void createUserDynamoDb(User user) {
        dynamoDbUserRepository.createUser(user);
    }

    public void removeUserDynamoDb(User user) {
        dynamoDbUserRepository.deleteUser(user);
    }

    public User getUserById(String userId) {
        return dynamoDbUserRepository.getUserByHashKey(userId);
    }

    public String getUserEmailByUserId(String userId) {
        return getUserById(userId).getEmail();
    }

}
