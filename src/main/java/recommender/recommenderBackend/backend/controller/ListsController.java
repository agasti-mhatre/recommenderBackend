package recommender.recommenderBackend.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListsController {

  @GetMapping("/getLists")
  public String handleFilterGetRequest() {

    return "hello world";
  }

}
