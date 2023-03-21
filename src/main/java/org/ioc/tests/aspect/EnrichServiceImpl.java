package org.ioc.tests.aspect;

import org.ioc.stereotype.Component;

@Component
//TODO: not correct
public class EnrichServiceImpl implements EnrichService {
    @Override
    public String getIdentification() {
        return "realValue";
    }

    @Override
    @AspectAnnotation("enrichedValue")
    public String getIdentificationEnriched() {
        return "realValue";
    }
}
