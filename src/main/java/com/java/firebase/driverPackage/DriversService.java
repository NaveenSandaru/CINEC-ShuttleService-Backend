package com.java.firebase.driverPackage;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.java.firebase.staffPackage.Staff;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DriversService {

    public Drivers getDriver(String driverID) throws Exception {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFireStore.collection("drivers").document(driverID);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Drivers driver;
        if(document.exists()){
            driver = document.toObject(Drivers.class);
            return driver;
        }
        return null;
    }

    public List<Drivers> getAllDrivers() throws Exception {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection("drivers").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<Drivers> driversList = new ArrayList<>();

        for (QueryDocumentSnapshot document : documents) {
            Drivers drivers = document.toObject(Drivers.class);
            driversList.add(drivers);
        }

        return driversList;
    }

    public String updateDriver(Drivers driver) throws Exception {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("drivers").document(driver.getDriverID()).set(driver);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteDriver(String driverID) throws Exception{
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFireStore.collection("drivers").document(driverID).delete();
        return "Deleted Successfully." + driverID;
    }
}
