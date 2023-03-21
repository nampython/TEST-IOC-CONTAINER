package org.ioc.tests.scope.prototype;

import org.ioc.config.Test;
import org.ioc.stereotype.Qualifier;
import org.ioc.stereotype.Service;

@Service
public class PrototypeTest implements Test {
    private final PrototypeBean prototypeBean1;

    public PrototypeTest(@Qualifier("bean_1") PrototypeBean prototypeBean1) {
        this.prototypeBean1 = prototypeBean1;
    }

    @Override
    public void runTest() {
        System.out.println(prototypeBean1.getIdentity());
    }
}
