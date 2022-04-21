package com.dan_lewis_glober.service;


import com.dan_lewis_glober.model.Location;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LocationServiceImplTest {

    @Autowired
    private LocationService locationService;

    @Test
    @Transactional
    void getAllLocations() {

        List<Location> allLocations = locationService.getAllLocations();
        int beforeAddingLocation = allLocations.size();

        Assertions.assertThat(beforeAddingLocation).isEqualTo(150);

        Location location = new Location();
        location.setCity("Test City");
        location.setState("Test State");
        location.setCity_code(111111);

        locationService.saveLocation(location);
        int afterAddingLocation = locationService.getAllLocations().size();

        Assertions.assertThat(afterAddingLocation).isEqualTo(beforeAddingLocation + 1);
        Assertions.assertThat(allLocations.contains(location));
    }
}
