package org.ioc.tests.bean;

import org.ioc.stereotype.Bean;
import org.ioc.stereotype.Configuration;
import org.ioc.stereotype.NamedInstance;

@Configuration
public class BeanConfig {

    @Bean
    @NamedInstance("bean_1")
    public BeanInterface getBean1() {
        return new BeanInterface1Impl();
    }


    @Bean
    @NamedInstance("bean_2")
    public BeanInterface getBean2() {
        return new BeanInterface2Impl();
    }
}
