package org.ioc.tests.scopes.services;


import org.ioc.engine.ScopeType;
import org.ioc.stereotype.PostConstruct;
import org.ioc.stereotype.Scope;
import org.ioc.stereotype.Service;

@Service
@Scope(ScopeType.PROTOTYPE)
public class PrototypeScopedServiceImpl implements PrototypeScopedService {

    private static int id = 0;

    private int instanceId;

    public PrototypeScopedServiceImpl() {
        int a = 10;
    }

    @PostConstruct
    public void init() {
        this.instanceId = ++id;
    }

    @Override
    public int getIdentity() {
        return this.instanceId;
    }
}
