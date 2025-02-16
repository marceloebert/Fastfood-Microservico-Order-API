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
        String accessKey = "ASIAR3F4HGIBI7BSKUHQ";
        String secretKey = "vbp5UlBb5eCc8+Jrd/9yrPEliCA0YhF2hYqtdz2f";
        String sessionToken = "IQoJb3JpZ2luX2VjEDkaCXVzLXdlc3QtMiJIMEYCIQDPkLvMedxt1bexnrQulqP72Iqys1oEm4F1Ha0z/wrhlwIhANZdt1aZfTFtFJgV4Bsn8fuOy+pW/ev3UndS6IAsgElJKrECCGIQABoMMTI3MDk2MjcxMzYyIgx2bMLDqk+TEwnZw40qjgKvS2ZPk1tz8z5M7d8ZB49IFbVe/lv/8VUZmJmRDHGsefFmzDusyddPhdmuCqJx+vmLwYy6922iqJIDlcDMdF2GKx4vlh3GZRfg+UJ7/bnxZaA0hUwB1sTQc8D0O+lHqAiROhrsSkwCZFE8byOtpVpTuvCZr/oOi2zyd0XmWwBweySsXo5TcpH3e4X4V22JnsHsYD0y4uJAuw5+r+WxWWegGgjfEf9qUWSX6XSVJ5tvvZoGIaPhLzbE0uAn8Sh0cg6uS6kCnE5lEiidXihEMe1576ryOzzBdefdp1VMdxKuI9AQ/Z6N908dyhFdGcFIXcrU8GWoRfKvzzzl2T4zi6L3eMSxhOPJi4k4Ctw5dYswsqbIvQY6nAE+VCHkPnogu0WZ0ide1Q6uhInN73X9tALzgZ0xSolclvS2tRUALQhHSBjG1ieoNBPmIFv/Us3pZRih9krWN9nVzAtPLsqtNcdYcLW4piTu60/NRKpx5PHlGRtzpGDzVwMGfTm2Go3VgrpmCpBGgQaeHNmXXmbLUJgzmYP3bEf78jkRQ+ynuD9BSlpC/ljHkdugO31uFUZ6KvMzqPg=";

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
