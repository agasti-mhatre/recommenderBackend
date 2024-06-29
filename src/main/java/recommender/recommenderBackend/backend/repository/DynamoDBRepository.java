package recommender.recommenderBackend.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;

@Repository
public class DynamoDBRepository {

  private final DynamoDbClient dynamoDBClient;

  @Autowired
  public DynamoDBRepository (DynamoDbClient dynamoDBClient) {
    this.dynamoDBClient = dynamoDBClient;
  }

  public Map<String, AttributeValue> getItem(String id) {

    Map<String, AttributeValue> key = new HashMap<>();
    key.put("username", AttributeValue.builder().s(id).build());

    GetItemRequest request = GetItemRequest.builder()
            .tableName("user_lists")
            .key(key)
            .build();

    GetItemResponse response = dynamoDBClient.getItem(request);
    return response.item();
  }

}
