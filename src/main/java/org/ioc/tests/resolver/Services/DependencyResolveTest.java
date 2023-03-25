package org.ioc.tests.resolver.Services;

import org.ioc.config.Assert;
import org.ioc.config.Test;
import org.ioc.stereotype.Autowired;
import org.ioc.stereotype.Component;
import org.ioc.stereotype.Qualifier;

@Component
public class DependencyResolveTest  implements Test {

    @Autowired
    @Qualifier("first_service")
    private OptionService optionService;

    @Autowired
    @Qualifier("second_service")
    private SecondService secondService;
    @Override
    public void runTest() {
        Assert.equal(
                "Should resolve custom resource dependency",
                "12",
                this.optionService.getAllOptions(),
                "Invalid custom dependency handler injection!"
        );
        Assert.equal(
                "Should resolve custom resource dependency",
                "3",
                this.secondService.getOpt3(),
                "Invalid custom dependency handler injection!"
        );
    }
}
