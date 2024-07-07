package recommender.recommenderBackend.backend.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountCreatorController {

  @Autowired
  UserInfoRepository userInfoRepository;

  @PostMapping("/createAccount")
  public String createAccount(@RequestBody AccountDTO accountDTO) {

    if (userInfoRepository.hasItem(accountDTO.getUsername())) {

      return "Username already exists";
    }

    userInfoRepository.createAccount(accountDTO);
    return "Created user";
  }

}
