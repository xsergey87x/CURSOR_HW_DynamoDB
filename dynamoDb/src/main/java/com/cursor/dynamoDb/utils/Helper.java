package com.cursor.dynamoDb.utils;

import com.amazonaws.services.dynamodbv2.model.ExportTableToPointInTimeRequest;
import com.cursor.dynamoDb.dynamoDb.model.User;
import com.cursor.dynamoDb.services.DynamoDbService;
import com.cursor.dynamoDb.services.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Helper {

     DynamoDbService dynamoDbService;
     S3Service s3Service;

     public void copyUserDocumentFromDynamoDbToS3(String userId) throws Exception {
          User user = dynamoDbService.getUserById(userId);
          String document = user.getDocument();
          String userFirstName = user.getFirstName();
          String bucketName = userFirstName + "Bucket";

          s3Service.createS3Bucket(bucketName);
          s3Service.saveDocumentInS3Bucket(document,bucketName);
     }

}
