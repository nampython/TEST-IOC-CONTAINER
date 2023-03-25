package org.ioc.tests.proxies;


import org.ioc.App;
import org.ioc.config.Assert;
import org.ioc.config.Test;
import org.ioc.contex.ApplicationContext;
import org.ioc.stereotype.Autowired;
import org.ioc.stereotype.Service;
import org.ioc.tests.proxies.beans.NonProxiedBean;
import org.ioc.tests.proxies.beans.ProxyBean;
import org.ioc.tests.proxies.beans.ProxyBeanImpl;
import org.ioc.tests.proxies.services.ConcreteProxyService;

@Service
public class ServiceProxiesTest implements Test {

    private final ConcreteProxyService concreteProxyService;

    private final NonProxiedBean nonProxiedBean;

    private final ProxyBean proxyBean;

    @Autowired
    public ServiceProxiesTest(ConcreteProxyService concreteProxyService, NonProxiedBean nonProxiedBean, ProxyBean proxyBean) {
        this.concreteProxyService = concreteProxyService;
        this.nonProxiedBean = nonProxiedBean;
        this.proxyBean = proxyBean;
    }

    @Override
    public void runTest() {
        final ApplicationContext dependencyContainer = App.applicationContext;

        Assert.notEqual(
                "Proxy scoped service should inject proxy instance",
                ConcreteProxyService.class,
                this.concreteProxyService.getClass(),
                "Invalid Injection!"
        );

        Assert.equal(
                "Proxy bean instance should not be injected on non-interface bean, even if bean is scope proxy!",
                NonProxiedBean.class,
                this.nonProxiedBean.getClass(),
                "Invalid Injection!"
        );

        Assert.notEqual(
                "Proxy bean instance should be injected on interface bean.",
                ProxyBeanImpl.class,
                this.proxyBean.getClass(),
                "Invalid Injection!"
        );

        final int oldConcreteProxyId = this.concreteProxyService.getIdentity();
        dependencyContainer.reload(this.concreteProxyService.getClass());

        Assert.notEqual(
                "Reloading proxy service should result in swapping all injected instances",
                oldConcreteProxyId,
                this.concreteProxyService.getIdentity(),
                "Invalid reload!"
        );

        final int oldNonProxiedBeanId = this.nonProxiedBean.getIdentity();
        dependencyContainer.reload(this.nonProxiedBean.getClass());

        Assert.equal(
                "Reloading non interface proxy scoped bean should not hot swap",
                oldNonProxiedBeanId,
                this.nonProxiedBean.getIdentity(),
                "Invalid reload!"
        );

        final int oldProxyBeanId = this.proxyBean.getIdentity();
        dependencyContainer.reload(this.proxyBean.getClass());

        Assert.notEqual(
                "Reloading interface proxy scoped bean should how swap",
                oldProxyBeanId,
                this.proxyBean.getIdentity(),
                "Invalid reload!"
        );
    }
}
