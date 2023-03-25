package org.ioc.tests.collections;


import org.ioc.engine.ScopeType;
import org.ioc.stereotype.Scope;
import org.ioc.stereotype.Service;

@Service
@Scope(ScopeType.PROXY)
public class Home2ImplProxy implements HomeService {
    @Override
    public String getHomeName() {
        return "home2";
    }
}
