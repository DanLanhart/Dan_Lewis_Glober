package com.dan_lewis_glober.repository;

import com.dan_lewis_glober.model.Location;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LocationRepositoryTest {

    @Autowired
    private LocationRepository locationRepository;

    @Test
    void sortLocationsAlphabetically() {

        // the data.sql file must be executed before running this test to populate the locations table
        List<Location> allLocations = locationRepository.findByOrderByCityAsc();
        Location specifiedLocation = allLocations.get(0);
        // Akron would be the first city name once the list of locations is sorted alphabetically
        Assertions.assertThat(specifiedLocation.getCity()).isEqualTo("Akron");


    }
}
