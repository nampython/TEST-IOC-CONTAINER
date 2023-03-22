package org.ioc.tests.scope.prototype;

import org.ioc.App;
import org.ioc.config.Assert;
import org.ioc.config.Test;
import org.ioc.contex.ApplicationContext;
import org.ioc.stereotype.Qualifier;
import org.ioc.stereotype.Service;

@Service
public class PrototypeTest implements Test {
    private final PrototypeBean prototypeBean1;
    private final PrototypeBean prototypeBean_2;
    private final PrototypeBean prototypeBean2;

    public PrototypeTest(@Qualifier("bean_1") PrototypeBean prototypeBean1,
                         @Qualifier("bean_1") PrototypeBean prototypeBean_2,
                         @Qualifier("bean_2") PrototypeBean prototypeBean2) {

        this.prototypeBean1 = prototypeBean1;
        this.prototypeBean_2 = prototypeBean_2;
        this.prototypeBean2 = prototypeBean2;
    }

    @Override
    public void runTest() {

        final ApplicationContext applicationContext = App.applicationContext;


        Assert.notEqual(
                "Requesting multiple prototype beans from the same type should inject different instances",
                this.prototypeBean1.getIdentity(),
                this.prototypeBean_2.getIdentity(),
                "Invalid bean scope handling!"
        );

        Assert.notEqual(
                "Prototype scope beans with different qualifiers should work together",
                this.prototypeBean1.getClass(),
                this.prototypeBean2.getClass(),
                "Invalid Injection!"
        );

        PrototypeBean bean_1 = applicationContext.getBean(PrototypeBean.class, "bean_1");
        Assert.notEqual(
                "Prototype bean should give new instance when requested",
                this.prototypeBean1.getIdentity(),
                bean_1.getIdentity(),
                "Invalid scope handling!"
        );

    }
}
