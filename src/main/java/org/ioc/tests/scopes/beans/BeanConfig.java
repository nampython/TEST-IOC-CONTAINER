package org.ioc.tests.scopes.beans;

import org.ioc.engine.ScopeType;
import org.ioc.stereotype.Bean;
import org.ioc.stereotype.NamedInstance;
import org.ioc.stereotype.Scope;
import org.ioc.stereotype.Service;

@Service
public class BeanConfig {

    @Bean
    @Scope(ScopeType.PROTOTYPE)
    @NamedInstance("bean_1")
    public PrototypeScopeBean proxyScopeBean() {
        return new PrototypeScopeBean1();
    }

    @Bean
    @Scope(ScopeType.PROTOTYPE)
    @NamedInstance("bean_2")
    public PrototypeScopeBean proxyScopeBean2() {
        return new PrototypeScopeBean2();
    }
}
