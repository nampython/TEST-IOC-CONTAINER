package org.ioc.tests.customannotations;

import org.ioc.config.Assert;
import org.ioc.config.Test;
import org.ioc.stereotype.Component;

@Component
public class CustomAnnotationTest implements Test {

    private final CustomAnnotatedHomeService customAnnotatedHomeService;

    public CustomAnnotationTest(CustomAnnotatedHomeService customAnnotatedHomeService) {
        this.customAnnotatedHomeService = customAnnotatedHomeService;
    }

    @Override
    public void runTest() {
        Assert.notNull(
                "Custom annotated service should not be null",
                this.customAnnotatedHomeService,
                "Expecting service to be injected"
        );
        Assert.equal(
                "Custom annotated service value",
                "customAnnotatedHomeService1",
                this.customAnnotatedHomeService.getIdentification(),
                "Invalid service value"
        );
        Assert.equal(
                "Custom annotated service post construct annotation",
                "customPostConstruct",
                this.customAnnotatedHomeService.getPostConstructValue(),
                "Post construct was not executed properly"
        );
    }
}
