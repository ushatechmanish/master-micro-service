package in.ushatech.mastermicroservice.controller;


import in.ushatech.mastermicroservice.config.CurrencyServiceConfig;
import in.ushatech.mastermicroservice.domain.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

// .courses
// Course: id,name,author
@RestController
public class CurrencyConfigurationController
{
    private final CurrencyServiceConfig currencyServiceConfig;

    public CurrencyConfigurationController(CurrencyServiceConfig currencyServiceConfig) {
        this.currencyServiceConfig = currencyServiceConfig;
    }

    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfig retrieveCurrencyServiceConfig()
    {
        return currencyServiceConfig;
    }
}
