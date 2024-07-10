package recommender.recommenderBackend.backend.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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


  //Delete this later. Using this to test token creation
  @GetMapping("/testTokenGenerate")
  public String tempGen() {

    return JWTUtil.generateToken(ExpirationLength.ACCESS_TOKEN);
  }

  //Delete this later. Using this to test token creation
  @GetMapping("/testTokenParse")
  public String tempParse(@RequestBody TokenDTO tokenDTO) {

    return JWTUtil.parseToken(tokenDTO.getToken());
  }

}
