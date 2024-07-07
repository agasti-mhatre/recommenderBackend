package recommender.recommenderBackend.backend.authentication;

public class AccountDTO {

  private String firstName;
  private String lastName;
  private String email;
  private String username;
  private String hashedPassword;


  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getUsername() {
    return username;
  }

  public String getHashedPassword() {
    return hashedPassword;
  }
}