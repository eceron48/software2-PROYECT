package modelo.factorymethod;

public class GenerateRDSAuthToken {

    public static void main(String[] args) {
/*
	    String region = "us-east-1";
	    String hostname = "zonas.cbkftzn8geuh.us-east-1.rds.amazonaws.com";
	    String port = "3306";
	    String username = "zonas_mysql";
	
	    System.out.println(generateAuthToken(region, hostname, port, username));
    }

    static String generateAuthToken(String region, String hostName, String port, String username) {

	    RdsIamAuthTokenGenerator generator = RdsIamAuthTokenGenerator.builder()
		    .credentials(new DefaultAWSCredentialsProviderChain())
		    .region(region)
		    .build();

	    String authToken = generator.getAuthToken(
		    GetIamAuthTokenRequest.builder()
		    .hostname(hostName)
		    .port(Integer.parseInt(port))
		    .userName(username)
		    .build());
	    
	    return authToken;
    }

*/
}
}