package com.dan_lewis_glober.service;

import com.dan_lewis_glober.model.BugReport;
import com.dan_lewis_glober.model.Location;

import java.util.List;

public interface LocationService {

    List<Location> getAllLocations();

    void saveLocation(Location location);
}
