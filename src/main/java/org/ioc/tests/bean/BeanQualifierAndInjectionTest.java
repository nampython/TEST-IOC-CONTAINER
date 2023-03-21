package org.ioc.tests.bean;

import org.ioc.config.Assert;
import org.ioc.config.Test;
import org.ioc.stereotype.Autowired;
import org.ioc.stereotype.Component;
import org.ioc.stereotype.Nullable;
import org.ioc.stereotype.Qualifier;

@Component
public class BeanQualifierAndInjectionTest implements Test {

    @Qualifier("bean_1")
    @Autowired
    private BeanInterface beanField1;

    @Autowired
    @Nullable
    @Qualifier("invalid_bean")
    private BeanInterface invalidBean;


    private final BeanInterface beanInterface1;
    private final BeanInterface beanInterface2;

    public BeanQualifierAndInjectionTest(@Qualifier("bean_1") BeanInterface beanInterface1,@Qualifier("bean_2") BeanInterface beanInterface2) {
        this.beanInterface1 = beanInterface1;
        this.beanInterface2 = beanInterface2;
    }


    @Override
    public void runTest() {
        Assert.equal("Should get value from bean_1", "impl1 bean", beanInterface1.getValue(), "Invalid Injection!");
        Assert.equal("Should get value from bean_2", "impl2 bean", beanInterface2.getValue(), "Invalid Injection!");
        Assert.equal("Autowired field with same qualifier should match constructor param",
                beanField1.getValue(), beanInterface1.getValue(),
                "Invalid Injection!");
        Assert.isNull("Invalid qualifier should inject null field dependency", invalidBean, "Invalid Injection");
    }
}
