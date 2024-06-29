package recommender.recommenderBackend.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import recommender.recommenderBackend.backend.configuration.DynamoDBConfiguration;

@Repository
public class DynamoDBRepository {

  private final DynamoDBConfiguration dynamoDBConfiguration;

  @Autowired
  public DynamoDBRepository (DynamoDBConfiguration dynamoDBConfiguration) {
    this.dynamoDBConfiguration = dynamoDBConfiguration;
  }



}
