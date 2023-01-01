package com.cursor.dynamoDb.services;

import com.amazonaws.services.s3.AmazonS3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;


@Component
@RequiredArgsConstructor
public class s3Service {

    private final AmazonS3 s3;

    public void createS3Bucket(String bucketName) {
            s3.createBucket(bucketName);
    }

    public void saveDocumentInS3Bucket(String s1, String s2, File file)
    {

        s3.putObject(s1,s2,file);
    }
}
