package recommender.recommenderBackend.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDBConfiguration {

  @Value("${AWS_REGION}")
  private String region;

  @Value("${AWS_ACCESSKEYID}")
  private String accessKeyID;

  @Value("${AWS_SECRETACCESSKEY}")
  private String secretAccessKey;

  @Bean
  public DynamoDbClient getClient () {

    AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKeyID, secretAccessKey);

    DynamoDbClient conn = DynamoDbClient.builder()
            .region(Region.of(region))
            .credentialsProvider(StaticCredentialsProvider.create(credentials))
            .build();

    return conn;
  }

}
