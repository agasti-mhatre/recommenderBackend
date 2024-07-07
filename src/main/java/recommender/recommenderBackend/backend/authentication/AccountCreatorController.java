package recommender.recommenderBackend.backend.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@RestController
public class AccountCreatorController {

  @Autowired
  UserInfoRepository userInfoRepository;

  @PostMapping("/createAccount")
  public void createAccount(@RequestBody AccountDTO accountDTO) {



  }

}
