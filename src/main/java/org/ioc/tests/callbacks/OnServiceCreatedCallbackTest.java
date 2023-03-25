package org.ioc.tests.callbacks;


import org.ioc.config.Assert;
import org.ioc.config.Test;
import org.ioc.stereotype.Service;
import org.ioc.tests.callbacks.services.CustomScopedService;
import org.ioc.tests.callbacks.services.CustomScopedServiceImpl;

@Service
public class OnServiceCreatedCallbackTest implements Test {

    private final CustomScopedService customScopedService;

    public OnServiceCreatedCallbackTest(CustomScopedService customScopedService) {
        this.customScopedService = customScopedService;
    }

    @Override
    public void runTest() {
        Assert.notEqual(
                "CustomScopeEventHandler should have made CustomScopedService to proxy scope",
                CustomScopedServiceImpl.class,
                this.customScopedService.getClass(),
                "Error invoking custom service created callback."
        );
    }
}
