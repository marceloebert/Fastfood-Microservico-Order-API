package com.fiap.lanchonete.crosscutting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;


@Configuration
public class DynamoDBConfig {

    @Bean
    public DynamoDbClient dynamoDbClient() {
        /*String region = System.getenv("DYNAMODB_REGION");
        String accessKey = System.getenv("AWS_ACCESS_KEY_ID");
        String secretKey = System.getenv("AWS_SECRET_ACCESS_KEY");
        String sessionToken = System.getenv("AWS_SESSION_TOKEN");*/

        String region = "us-east-1";
        String accessKey = "ASIAR3F4HGIBATB2JFNY";
        String secretKey = "dNM9BY8TpCLOmXFfrXwQp6/6hJCs4SKG/f1U8vMf";
        String sessionToken = "IQoJb3JpZ2luX2VjED0aCXVzLXdlc3QtMiJHMEUCIQDaxQT9ZOwUQe6zCzBxp1rz46WhFG8YEBzN6yROQT98fQIgQP/rpAvrY82xh5NtYXBJA4jwZhheddmu75XWulAiuzEqsQIIZhAAGgwxMjcwOTYyNzEzNjIiDJgNIaZzYZ9YWKcSuiqOAtGbqjP17dS8UX4rYCOzlBj7nJVTcAoqNLCzqewGdyIpPz0fiIBbd+rZLYYihK4B5KRKoeKpV1rLALia7ip0Ji1941ssj9/otSjGcFUKJf/6MnXtmgFNFmpYukEMC7D5sDIU/8FVR7CmthKBs6l6JW3Z643RVXlA3gcNCbnsAJNoiGZtXMwOt7yTOExyIru0KsEBZbXVMR0/+FH0Rei9wYUc1mwHcd6HiTQg/FbEqTsyVBNz1JbAAGNsR4NF5LT+RvLneta+eOmbdJ4B/p4ZGf1suzBzllczlUa6g5O+tQ/LdsPiG9ghmh2Rm8bKQlBDJjWQLsN7fpW/xjlcf5H3Ixx9yMy7KTnNKMo+eVHXIjDCmsm9BjqdAZZ3u2LlWKvNWfSTgaq5dbgyZ+pznqYJJvGAZN1CKYumb7nDy4nlsLeWyZFikboLGAuqSmDDD6MYcC2OEXrE1+cDEm7UkmqMJVE1RpIHLVYfXflNX6K2YMNds29IUT9xCpo/x09xPfV9eeV1sj3+80tYF4JMnKwBp7c21gWC6lrqikxdP04A9b46nREeefDNXWTqeoPc72FEXQMlh5M=";

        return DynamoDbClient.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsSessionCredentials.create(accessKey,secretKey,sessionToken)
                ))
                .build();
    }

    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient) {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
    }
}
