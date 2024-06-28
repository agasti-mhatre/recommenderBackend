package recommender.recommenderBackend.backend.client;

import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class DynamoDBConn {

  public DynamoDbClient getClient () {

    DynamoDbClient conn = DynamoDbClient.builder()
            .httpClientBuilder(ApacheHttpClient.builder())
            .build();


    return conn;
  }

}
