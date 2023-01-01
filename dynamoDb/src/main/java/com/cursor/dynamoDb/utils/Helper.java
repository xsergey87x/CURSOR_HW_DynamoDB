package com.cursor.dynamoDb.utils;

import com.amazonaws.services.dynamodbv2.model.ExportTableToPointInTimeRequest;
import com.cursor.dynamoDb.services.DynamoDbService;
import com.cursor.dynamoDb.services.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Helper {

     DynamoDbService dynamoDbService;
     S3Service s3Service;

     public void copyDocumentFromDynamoDbToS3()
     {

     }

}
