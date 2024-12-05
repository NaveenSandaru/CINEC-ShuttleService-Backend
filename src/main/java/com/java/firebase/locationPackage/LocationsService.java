package com.java.firebase.locationPackage;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;


@Service
public class LocationsService {

    public Locations getLocation(String shuttleID) throws Exception {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFireStore.collection("shuttles").document(shuttleID);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Locations location;
        if(document.exists()){
            location = document.toObject(Locations.class);
            return location;
        }
        return null;
    }

    public String updateLocation(Locations location) throws Exception {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("shuttles").document(location.getShuttleID()).set(location);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteLocation(String shuttleID) throws Exception{
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFireStore.collection("shuttles").document(shuttleID).delete();
        return "Deleted Successfully." + shuttleID;
    }
}
