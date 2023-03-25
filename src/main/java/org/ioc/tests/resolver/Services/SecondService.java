package org.ioc.tests.resolver.Services;

import org.ioc.stereotype.Component;
import org.ioc.stereotype.NamedInstance;
import org.ioc.tests.resolver.Producers.Resource;

@NamedInstance("second_service")
@Component
public class SecondService {
    private final String opt3;

    public SecondService(@Resource("opt3") String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt3() {
        return opt3;
    }
}
