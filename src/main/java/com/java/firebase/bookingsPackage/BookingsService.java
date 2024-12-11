/*package com.java.firebase.bookingsPackage;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;


@Service
public class BookingsService {

    public Bookings getDriver(String driverID) throws Exception {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFireStore.collection("drivers").document(driverID);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Bookings driver;
        if(document.exists()){
            driver = document.toObject(Bookings.class);
            return driver;
        }
        return null;
    }

    public String updateDriver(Bookings driver) throws Exception {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("drivers").document(driver.getDriverID()).set(driver);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteDriver(String driverID) throws Exception{
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFireStore.collection("drivers").document(driverID).delete();
        return "Deleted Successfully." + driverID;
    }
}*/
