package org.ioc.tests.qualifier;

import org.ioc.stereotype.Component;
import org.ioc.stereotype.NamedInstance;

@Component
@NamedInstance("bean_service")
public class BeanServiceImpl implements  BeanService {
    @Override
    public String getIdentity() {
        return "COMMON_SERVICE";
    }
}
