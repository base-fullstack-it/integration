package com.requestapi.requestapi.integration.external.spacex.service.our_api;

import com.requestapi.requestapi.model.OurAPICapsule;

public interface SpaceXFacadeService {
    void invokeIntegration();

    void postIntegration(OurAPICapsule ourAPICapsule);
}
