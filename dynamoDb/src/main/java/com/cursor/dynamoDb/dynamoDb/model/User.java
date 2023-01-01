package com.cursor.dynamoDb.dynamoDb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "cursorDynamoDb")
public class User {

    private String userID;
    private String firstName;
    private String lastName;
    private int age;
    private String email;

    @DynamoDBHashKey(attributeName = "UserID")
    public String getCustomerID() {
        return userID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    @DynamoDBAttribute(attributeName = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
