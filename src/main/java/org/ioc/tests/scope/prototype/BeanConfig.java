package org.ioc.tests.scope.prototype;

import org.ioc.engine.ScopeType;
import org.ioc.stereotype.*;

@Service
public class BeanConfig {

    @Bean
    @NamedInstance("bean_1")
    @Scope(ScopeType.PROTOTYPE)
    public PrototypeBean getPrototypeBean1() {
        return new PrototypeBean1();
    }

    @Bean
    @NamedInstance("bean_2")
    @Scope(ScopeType.PROTOTYPE)
    public PrototypeBean getPrototypeBean2() {
        return new PrototypeBean2();
    }
}
