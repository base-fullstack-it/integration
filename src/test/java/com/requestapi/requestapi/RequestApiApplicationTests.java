package com.requestapi.requestapi;

import com.requestapi.requestapi.integration.external.spacex.service.our_api.SpaceXFacadeService;
import com.requestapi.requestapi.model.OurAPICapsule;
import com.requestapi.requestapi.model.OurAPIMission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RequestApiApplicationTests {

    private final SpaceXFacadeService spaceXFacadeService;

    @Autowired
    RequestApiApplicationTests(SpaceXFacadeService spaceXFacadeService) {
        this.spaceXFacadeService = spaceXFacadeService;
    }

    @Test
    void contextLoads() {
        spaceXFacadeService.invokeIntegration();





//        List<OurAPIMission> ourAPIMissions = new ArrayList<>();
//        ourAPIMissions.add(
//                OurAPIMission.
//                        builder().
//                        ourFlight(32).
//                        ourName("first mission").
//                        build()
//        );
//        ourAPIMissions.add(
//                OurAPIMission.builder().
//                        ourFlight(99).
//                        ourName("doge coin on moon").
//                        build()
//        );
//
//        OurAPICapsule ourAPICapsule = OurAPICapsule.builder()
//                .ourCapsule("Name of our capsule").ourStatus("ready").ourMissions(ourAPIMissions).build();
//
//        spaceXFacadeService.postIntegration(ourAPICapsule);

    }

}
