package com.java.firebase.staffPackage;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StaffController {
    public StaffService staffService;

    public StaffController(StaffService staffService){
        this.staffService = staffService;
    }

    @GetMapping("/getStaff")
    public Staff getStaff(@RequestParam String staffID) throws Exception{
        return staffService.getStaff(staffID);
    }


    @PutMapping("/updateStaff")
    public String updateStaff(@RequestBody Staff staff) throws Exception{
        return staffService.updateStaff(staff);
    }

    @PutMapping("/deleteStaff")
    public String deleteStaff(@RequestParam String staffID) throws Exception{
        return staffService.deleteStaff(staffID);
    }

    @GetMapping("/testStaff")
    public ResponseEntity<String> testGetEndPoint(){
        return ResponseEntity.ok("Test get endpoint is working");
    }
}
