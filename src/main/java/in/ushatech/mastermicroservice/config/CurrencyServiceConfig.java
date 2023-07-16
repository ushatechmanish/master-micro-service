package in.ushatech.mastermicroservice.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "currency-service")
public class CurrencyServiceConfig
{
    private  String url;
    private  String username;
    private  String key;
}
