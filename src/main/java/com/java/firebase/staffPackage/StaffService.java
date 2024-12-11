package com.java.firebase.staffPackage;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.java.firebase.studentsPackage.Students;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StaffService {

    public Staff getStaff(String staffID) throws Exception {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFireStore.collection("staff").document(staffID);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Staff Staff;
        if(document.exists()){
            Staff = document.toObject(Staff.class);
            return Staff;
        }
        return null;
    }

    public List<Staff> getAllStaff() throws Exception {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection("staff").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<Staff> staffList = new ArrayList<>();

        for (QueryDocumentSnapshot document : documents) {
            Staff staff = document.toObject(Staff.class);
            staffList.add(staff);
        }

        return staffList;
    }

    public String updateStaff(Staff Staff) throws Exception {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("staff").document(Staff.getStaffID()).set(Staff);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteStaff(String staffID) throws Exception{
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFireStore.collection("staff").document(staffID).delete();
        return "Deleted Successfully." + staffID;
    }
}
