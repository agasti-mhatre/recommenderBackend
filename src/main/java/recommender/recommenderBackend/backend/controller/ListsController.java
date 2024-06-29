package recommender.recommenderBackend.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import recommender.recommenderBackend.backend.repository.DynamoDBRepository;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

@RestController
public class ListsController {

  private final DynamoDBRepository dynamoDBRepository;

  @Autowired
  public ListsController(DynamoDBRepository dynamoDBRepository) {
    this.dynamoDBRepository = dynamoDBRepository;
  }

  @GetMapping("/getLists")
  public List<String> handleFilterGetRequest() {

    List<String> result = new ArrayList<>();
    for (Map.Entry<String, AttributeValue> entry : dynamoDBRepository.getItem("bruh").entrySet()) {
      result.add(String.valueOf(entry.getKey()));
    }
    return result;
  }



}
