package org.ioc.tests.aspect;

import org.ioc.config.Test;
import org.ioc.stereotype.Autowired;
import org.ioc.stereotype.Service;

@Service
public class AspectTest implements Test {
    private final EnrichService enrichService;

    @Autowired
    public AspectTest(EnrichService enrichService) {
        this.enrichService = enrichService;
    }


    @Override
    public void runTest() {
        System.out.println(enrichService.getIdentificationEnriched());
        System.out.println(enrichService.getIdentification());
    }
}
