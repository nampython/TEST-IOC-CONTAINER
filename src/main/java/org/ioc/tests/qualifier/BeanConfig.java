package org.ioc.tests.qualifier;

import org.ioc.stereotype.Bean;
import org.ioc.stereotype.Configuration;
import org.ioc.stereotype.NamedInstance;

@Configuration
public class BeanConfig {
    @Bean
    @NamedInstance("common_bean")
    public CommonBean getCommonBean() {
        return new CommonBean();
    }
}
