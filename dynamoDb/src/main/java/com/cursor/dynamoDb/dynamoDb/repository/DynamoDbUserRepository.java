package com.cursor.dynamoDb.dynamoDb.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.cursor.dynamoDb.dynamoDb.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DynamoDbUserRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public void createUser(User user)
    {
        dynamoDBMapper.save(user);
    }

    public void deleteUser(User user)
    {
        dynamoDBMapper.delete(user);
    }

    public User getUserByHashKey(String userId){
        return dynamoDBMapper.load(User.class,userId);
    }
}
