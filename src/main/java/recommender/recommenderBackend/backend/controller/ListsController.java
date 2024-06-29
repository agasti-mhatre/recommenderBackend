package recommender.recommenderBackend.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import recommender.recommenderBackend.backend.repository.DynamoDBRepository;

@RestController
public class ListsController {

  private final DynamoDBRepository dynamoDBRepository;

  @Autowired
  public ListsController(DynamoDBRepository dynamoDBRepository) {
    this.dynamoDBRepository = dynamoDBRepository;
  }

  @GetMapping("/getLists")
  public String handleFilterGetRequest() {

    return "hello world";
  }

}
