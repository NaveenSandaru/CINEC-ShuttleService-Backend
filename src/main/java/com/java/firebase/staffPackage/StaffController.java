package com.java.firebase.staffPackage;

import com.java.firebase.studentsPackage.Students;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAllStaff")
    public List<Staff> getAllStaff() throws Exception {
        return staffService.getAllStaff();
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
