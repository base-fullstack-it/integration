package com.requestapi.requestapi.integration.external.spacex.service.external_api;

import com.requestapi.requestapi.integration.external.spacex.binding.SpaceXBinding;
import com.requestapi.requestapi.integration.external.spacex.binding.SpaceXFactory;
import com.requestapi.requestapi.integration.external.spacex.model.SpaceXCapsule;
import com.requestapi.requestapi.integration.request.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.file.FileSystem;
import java.util.List;

@Service
public class SpaceXCapsuleServiceImpl implements SpaceXCapsuleService{
    private final SpaceXFactory spaceXFactory;

    @Autowired
    public SpaceXCapsuleServiceImpl(SpaceXFactory spaceXFactory) {
        this.spaceXFactory = spaceXFactory;
    }

    @Override
    public List<SpaceXCapsule> getAllCapsules() {


        SpaceXBinding spaceXBinding = spaceXFactory.getAPIBinding();
        URI uri = UriComponentsBuilder
                .fromHttpUrl(spaceXBinding.getApiUrl())
                .pathSegment("v3","capsules")
                .build().toUri();
        ResponseWrapper<String> responseWrapper = spaceXBinding.makeRequest(uri, HttpMethod.GET, String.class);
        List<SpaceXCapsule> spaceXCapsule = responseWrapper.createRequestedClassListFromJson(SpaceXCapsule.class);
        return spaceXCapsule;
    }

    @Override
    public void postCapsule(SpaceXCapsule spaceXCapsule){
        SpaceXBinding spaceXBinding = spaceXFactory.getAPIBinding();
        URI uri = UriComponentsBuilder
                .fromHttpUrl(spaceXBinding.getApiUrl())
                .pathSegment("v3","capsules")
                .build().toUri();
        spaceXBinding.makeRequest(uri, HttpMethod.POST, String.class,spaceXCapsule);

    }
}
