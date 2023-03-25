package org.ioc.tests.scopes.services;


import org.ioc.stereotype.PostConstruct;
import org.ioc.stereotype.Service;

@Service
public class DefaultScopedServiceImpl implements DefaultScopedService {

    private static int id = 0;

    private int instanceId;

    @PostConstruct
    public void init() {
        this.instanceId = ++id;
    }

    @Override
    public int getIdentity() {
        return this.instanceId;
    }
}
