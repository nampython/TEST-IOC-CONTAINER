package org.ioc.tests.qualifier;

import org.ioc.config.Assert;
import org.ioc.config.Test;
import org.ioc.stereotype.Component;
import org.ioc.stereotype.Nullable;
import org.ioc.stereotype.Qualifier;

@Component
public class QualifierBeanTest implements Test {

    private final CommonBean qualifierCommonBean;
    private final CommonBean wrongQualifierCommonBean;

    private final BeanService beanService;
    private final BeanService wrongBeanService;

    public QualifierBeanTest(@Nullable @Qualifier("common_bean") CommonBean qualifierCommonBean,
                             @Nullable @Qualifier("wrong") CommonBean wrongQualifierCommonBean,
                             @Nullable @Qualifier("bean_service") BeanService beanService,
                             @Nullable @Qualifier("wrong_service") BeanService wrongBeanService) {
        this.qualifierCommonBean = qualifierCommonBean;
        this.wrongQualifierCommonBean = wrongQualifierCommonBean;
        this.beanService = beanService;
        this.wrongBeanService = wrongBeanService;
    }

    @Override
    public void runTest() {
        Assert.notNull("Inject with common name qualifier not null", qualifierCommonBean, "Invalid Injection!");
        Assert.notNull("Inject with common name qualifier not null", beanService, "Invalid Injection!");

        Assert.isNull("Inject with invalid qualifier null", wrongQualifierCommonBean, "Invalid Injection!");
        Assert.isNull("Inject with invalid qualifier null", wrongBeanService, "Invalid Injection!");
    }
}
