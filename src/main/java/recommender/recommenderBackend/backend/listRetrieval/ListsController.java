package recommender.recommenderBackend.backend.listRetrieval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

@RestController
public class ListsController {

  @Autowired
  private ListsRepository listsRepository;

  @GetMapping("/getLists")
  public List<String> handleFilterGetRequest() {

    // Put this part in the model
    List<String> result = new ArrayList<>();
    for (Map.Entry<String, AttributeValue> entry : listsRepository.getItem("bruh").entrySet()) {
      result.add(String.valueOf(entry.getKey()));
    }
    //

    return result;
  }

}
