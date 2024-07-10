package recommender.recommenderBackend.backend.authentication;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {

  private static String generateToken(ExpirationLength tokenType) {

    int expTime[] = getExpLength(tokenType);

    LocalDate currDate = LocalDate.now();
    String secret = "abc123";

    return Jwts.builder()
            .subject("davey_the_sus_one")
            .claim("name", "Davey McWavey")
            .claim("email", "BruhMoment@sus.com")
            .issuedAt(new Date())
            .expiration(new Date(expTime[0] + currDate.getYear(), currDate.getMonthValue(), currDate.getDayOfMonth()))
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();

  }

  public static void parseToken() {

    Jws<Claims> jwsClaims = null;

  }


  private static int[] getExpLength(ExpirationLength tokenType) {

    if (tokenType == ExpirationLength.ACCESS_TOKEN) {
      return new int[]{1, 2, 3};
    }

    return new int[]{1, 2, 3};
  }
}