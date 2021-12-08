package igti.desafio.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI(
                "postgres://rpiwstbgblgffw:d48de461a62caa61adcbf7e573e2cbaf34465c5d10585541f0f43cfab893b8f1@ec2-3-89-214-80.compute-1.amazonaws.com:5432/d4ns1iib8rs83t");

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
}
