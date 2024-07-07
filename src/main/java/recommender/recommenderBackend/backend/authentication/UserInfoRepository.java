package recommender.recommenderBackend.backend.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Repository
public class UserInfoRepository {

  @Autowired
  DynamoDbClient dynamoDbClient;

}
