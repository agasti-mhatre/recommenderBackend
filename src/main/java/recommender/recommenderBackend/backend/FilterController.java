package recommender.recommenderBackend.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

  @GetMapping("/test")
  public String handleFilterGetRequest() {

    return "Request received!";
  }
}
