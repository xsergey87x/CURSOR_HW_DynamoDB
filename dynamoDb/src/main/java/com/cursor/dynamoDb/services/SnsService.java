package com.cursor.dynamoDb.services;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.SubscribeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class SnsService {
    private String TOPIC_ARN = "arn:aws:sns:us-east-1:954410434755:news";

    private final AmazonSNSClient amazonSNSClient;

    public void subscribeToSNSTopic(String userEmail) {
        SubscribeRequest subscribeRequest = new SubscribeRequest(TOPIC_ARN, "email", userEmail);
        amazonSNSClient.subscribe(subscribeRequest);
    }
}
