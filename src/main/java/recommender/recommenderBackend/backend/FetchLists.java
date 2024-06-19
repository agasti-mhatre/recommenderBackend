package recommender.recommenderBackend.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;

@RestController
public class FetchLists {

  @GetMapping("/test")
  public String handleFilterGetRequest() {

    String AWS_ACCESS_KEY_ID = "";
    String AWS_SECRET_ACCESS_KEY = "";

    DynamoDbClient dynamoDbClient = DynamoDbClient.builder()
            .region(Region.US_EAST_2)
            .credentialsProvider(StaticCredentialsProvider.create(
                    AwsBasicCredentials.create(AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY)))
            .build();

    String userId = "bruh"; // Replace with the partition key value you want to retrieve
    getItem(dynamoDbClient, userId);

    dynamoDbClient.close();

    return "Request received!";
  }

  private static void getItem(DynamoDbClient dynamoDbClient, String userId) {
    Map<String, AttributeValue> key = new HashMap<>();
    key.put("username", AttributeValue.builder().s(userId).build());

    GetItemRequest request = GetItemRequest.builder()
            .tableName("temp-db")
            .key(key)
            .build();

    try {
      GetItemResponse response = dynamoDbClient.getItem(request);
      if (response.hasItem()) {
        Map<String, AttributeValue> item = response.item();
        System.out.println("Item retrieved: " + item);
      } else {
        System.out.println("No item found with the given key.");
      }
    } catch (DynamoDbException e) {
      System.err.println(e.getMessage());
    }
  }
}
