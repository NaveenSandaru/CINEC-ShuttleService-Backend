package com.java.firebase.locationPackage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationsController {
    public LocationsService locationsService;

    public LocationsController(LocationsService locationsService){
        this.locationsService = locationsService;
    }

    @GetMapping("/getLocation")
    public Locations getLocation(@RequestParam String shuttleID) throws Exception{
        return locationsService.getLocation(shuttleID);
    }


    @PutMapping("/updateLocation")
    public String updateLocation(@RequestBody Locations locations) throws Exception{
        return locationsService.updateLocation(locations);
    }

    @PutMapping("/deleteLocation")
    public String deleteLocation(@RequestParam String shuttleID) throws Exception{
        return locationsService.deleteLocation(shuttleID);
    }

    @GetMapping("/testLocation")
    public ResponseEntity<String> testGetEndPoint(){
        return ResponseEntity.ok("Test get endpoint is working");
    }
}
