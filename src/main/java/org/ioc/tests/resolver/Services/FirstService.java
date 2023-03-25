package org.ioc.tests.resolver.Services;

import org.ioc.stereotype.Component;
import org.ioc.stereotype.NamedInstance;
import org.ioc.tests.resolver.Producers.Resource;

@Component
@NamedInstance("first_service")
public class FirstService implements OptionService{
    private final String option;
    private final String option1;

    public FirstService(@Resource("opt1") String option, @Resource("opt2") String option1) {
        this.option = option;
        this.option1 = option1;
    }

    @Override
    public String getAllOptions() {
        return option + option1;
    }
}
