package recommender.recommenderBackend.backend.authentication;

import java.time.LocalDate;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {

  public static String generateToken(ExpirationLength tokenType) {

    int expTime[] = getExpLength(tokenType);

    LocalDate currDate = LocalDate.now();

    return Jwts.builder()
            .subject("davey_the_sus_one")
            .claim("name", "Davey McWavey")
            .claim("email", "BruhMoment@sus.com")
            .issuedAt(new Date())
            .expiration(new Date(expTime[0] + currDate.getYear(), expTime[1] + currDate.getMonthValue(), expTime[2] + currDate.getDayOfMonth()))
            .signWith(SignatureAlgorithm.HS256, getSecretKey())
            .compact();

  }

  public static String parseToken(String token) {

    Claims jwsClaim = Jwts.parser()
            .verifyWith(getSecretKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();

    String subject = jwsClaim.getSubject();
    String name = jwsClaim.get("name", String.class);
    String email = jwsClaim.get("email", String.class);

    return email;
  }

  private static int[] getExpLength(ExpirationLength tokenType) {

    if (tokenType == ExpirationLength.ACCESS_TOKEN) {
      return new int[]{0, 0, 2};
    }

    return new int[]{1, 0, 0};
  }

  private static SecretKeySpec getSecretKey() {

    //Signing key has to be at least 256 bits
    return new SecretKeySpec(
            "abcdefghijklmnopqrstuvwxyz123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes(),
            SignatureAlgorithm.HS256.getJcaName()
            );
  }
}