package org.ioc.tests.proxies.beans;


import org.ioc.engine.ScopeType;
import org.ioc.stereotype.Bean;
import org.ioc.stereotype.Scope;
import org.ioc.stereotype.Service;

@Service
public class BeanConfig {

    @Bean
    @Scope(ScopeType.PROXY)
    public NonProxiedBean nonProxiedBean() {
        return new NonProxiedBean();
    }

    @Bean
    @Scope(ScopeType.PROXY)
    public ProxyBean proxyBean() {
        return new ProxyBeanImpl();
    }
}
