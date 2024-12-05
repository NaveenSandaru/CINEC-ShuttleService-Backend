package com.java.firebase.staffPackage;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;


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
