package com.requestapi.requestapi.integration.external.spacex.service.our_api;

import com.requestapi.requestapi.integration.external.spacex.binding.SpaceXFactory;
import com.requestapi.requestapi.integration.external.spacex.model.SpaceXCapsule;
import com.requestapi.requestapi.integration.external.spacex.service.external_api.SpaceXCapsuleService;
import com.requestapi.requestapi.model.OurAPICapsule;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceXFacadeServiceImpl implements SpaceXFacadeService{

    private final SpaceXFactory spaceXFactory;
    private final SpaceXCapsuleService spaceXCapsuleService;

    @Autowired
    public SpaceXFacadeServiceImpl(SpaceXFactory spaceXFactory, SpaceXCapsuleService spaceXCapsuleService) {
        this.spaceXFactory = spaceXFactory;
        this.spaceXCapsuleService = spaceXCapsuleService;
    }

    @SneakyThrows
    @Override
    public void invokeIntegration() {
        spaceXFactory.
                getAPIBinding()
                .getExecutorService()
                .submit(() -> aggregateOfInvocations()).get();
    }

    private void aggregateOfInvocations(){
        List<SpaceXCapsule> spaceXCapsuleList = spaceXCapsuleService.getAllCapsules();
    }






    @SneakyThrows
    @Override
    public void postIntegration(OurAPICapsule ourAPICapsule) {
        SpaceXCapsule spaceXCapsule = SpaceXCapsule.from(ourAPICapsule);

        spaceXFactory.
                getAPIBinding()
                .getExecutorService()
                .submit(() -> spaceXCapsuleService.postCapsule(spaceXCapsule)).get();
    }
}















//                .execute(() -> aggregateOfInvocations());
//https://stackoverflow.com/questions/18730290/what-is-the-difference-between-executorservice-submit-and-executorservice-execut