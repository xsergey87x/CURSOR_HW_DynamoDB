package com.cursor.dynamoDb.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Component
@RequiredArgsConstructor
public class S3Service {

    @Value("${temporaryFilePath}")
    private String temporaryFilePath;

    private final AmazonS3 s3;

    public void createS3Bucket(String bucketName) {
            s3.createBucket(bucketName);
    }

    public void saveDocumentInS3Bucket(String document, String bucketName) throws Exception
    {
        File file = new File("temporaryFile.pdf");
        Path path = Paths.get(temporaryFilePath);
        Files.writeString(path,document,StandardCharsets.UTF_8);

        s3.putObject(bucketName,temporaryFilePath,file);

        file.delete();
    }
}
