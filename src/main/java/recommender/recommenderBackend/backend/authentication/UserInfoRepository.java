package recommender.recommenderBackend.backend.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

@Repository
public class UserInfoRepository {

  @Autowired
  DynamoDbClient dynamoDbClient;

  public static GetItemRequest createGetItemRequest(Map<String, AttributeValue> key) {
    return GetItemRequest.builder()
            .tableName("userAccountInfo")
            .key(key)
            .build();
  }

  public boolean hasItem(String username) {

    Map<String, AttributeValue> key = new HashMap<>();
    key.put("username", AttributeValue.builder().s(username).build());

    GetItemRequest hasUsername = UserInfoRepository.createGetItemRequest(key);

    return dynamoDbClient.getItem(hasUsername).hasItem();
  }

  public void createAccount(AccountDTO accountDTO) {

    Map<String, AttributeValue> key = new HashMap<>();

    key.put("username", AttributeValue.builder().s(accountDTO.getUsername()).build());
    key.put("firstName", AttributeValue.builder().s(accountDTO.getFirstName()).build());
    key.put("lastName", AttributeValue.builder().s(accountDTO.getLastName()).build());
    key.put("email", AttributeValue.builder().s(accountDTO.getEmail()).build());
    key.put("hashedPassword", AttributeValue.builder().s(accountDTO.getHashedPassword()).build());

    PutItemRequest putItemRequest = PutItemRequest.builder().tableName("userAccountInfo").item(key).build();

    dynamoDbClient.putItem(putItemRequest);
  }

}
