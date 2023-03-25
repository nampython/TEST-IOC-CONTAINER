package org.ioc.tests.collections;


import org.ioc.stereotype.Bean;
import org.ioc.stereotype.Service;

@Service
public class Home1Impl implements HomeService {

    @Override
    public String getHomeName() {
        return "home1";
    }

    @Bean
    public HomeService home5Bean() {
        return new Home5Bean();
    }
}
