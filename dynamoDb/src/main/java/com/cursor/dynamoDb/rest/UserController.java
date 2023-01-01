package com.cursor.dynamoDb.rest;

import com.cursor.dynamoDb.dynamoDb.model.User;
import com.cursor.dynamoDb.services.DynamoDbService;
import com.cursor.dynamoDb.services.S3Service;
import com.cursor.dynamoDb.services.SnsService;
import com.cursor.dynamoDb.utils.Helper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class UserController {

    DynamoDbService dynamoDbService;
    S3Service s3Service;
    SnsService snsService;
    Helper helper;

    @PostMapping(value = "/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        dynamoDbService.createUserDynamoDb(user);
    }

    @GetMapping(value = "/removeUser")
    @ResponseStatus(HttpStatus.GONE)
    public void removeUser(@RequestBody User user) {
        dynamoDbService.removeUserDynamoDb(user);
    }

    @GetMapping(value = "/copyDocumentFromDynamoToS3/{userId}")
    public void copyFromDynamoDbToS3(@PathVariable String userId) throws Exception {
         helper.copyUserDocumentFromDynamoDbToS3(userId);
    }

    @GetMapping(value = "/subscribeUser/{userId}")
    public void subscribeUser(@PathVariable String userId)
    {

    }
}
