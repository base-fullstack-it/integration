package com.requestapi.requestapi.integration.external.spacex.service.external_api;

import com.requestapi.requestapi.integration.external.spacex.model.SpaceXCapsule;

import java.util.List;

public interface SpaceXCapsuleService {
    List<SpaceXCapsule> getAllCapsules();

    void postCapsule(SpaceXCapsule spaceXCapsule);
}
