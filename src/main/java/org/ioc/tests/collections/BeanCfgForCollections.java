package org.ioc.tests.collections;


import org.ioc.stereotype.Bean;
import org.ioc.stereotype.Service;

@Service
public class BeanCfgForCollections {

    @Bean
    public HomeService homeService() {
        return new Home4Bean();
    }
}
