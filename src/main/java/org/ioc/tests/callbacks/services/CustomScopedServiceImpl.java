package org.ioc.tests.callbacks.services;


import org.ioc.events.CustomProxyScope;
import org.ioc.stereotype.Service;

@Service
@CustomProxyScope
public class CustomScopedServiceImpl implements CustomScopedService {
}
