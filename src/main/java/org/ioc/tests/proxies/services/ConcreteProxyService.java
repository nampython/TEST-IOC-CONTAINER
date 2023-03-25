package org.ioc.tests.proxies.services;


import org.ioc.engine.ScopeType;
import org.ioc.stereotype.PostConstruct;
import org.ioc.stereotype.Scope;
import org.ioc.stereotype.Service;

@Service
@Scope(ScopeType.PROXY)
public class ConcreteProxyService {

    private static int id = 0;

    private int instanceId;

    @PostConstruct
    public void onInt() {
        this.instanceId = ++id;
    }


    public int getIdentity() {
        return this.instanceId;
    }
}
