package org.ioc.events;

import org.ioc.engine.ComponentDetailsCreated;
import org.ioc.engine.ComponentModel;
import org.ioc.engine.ScopeType;

public class CustomScopeEventHandler implements ComponentDetailsCreated {
    @Override
    public void componentDetailsCreated(ComponentModel componentModel) {
        if (componentModel.getComponentType().isAnnotationPresent(CustomProxyScope.class)) {
            componentModel.setScopeType(ScopeType.PROXY);
        }
    }
}
