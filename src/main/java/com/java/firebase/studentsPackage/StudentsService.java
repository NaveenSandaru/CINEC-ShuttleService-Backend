package com.java.firebase.studentsPackage;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;


@Service
public class StudentsService {

    public Students getStudent(String studentID) throws Exception {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFireStore.collection("students").document(studentID);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Students Student;
        if(document.exists()){
            Student = document.toObject(Students.class);
            return Student;
        }
        return null;
    }

    public String updateStudent(Students Student) throws Exception {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("students").document(Student.getStudentsID()).set(Student);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteStudent(String studentID) throws Exception{
        Firestore dbFireStore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFireStore.collection("students").document(studentID).delete();
        return "Deleted Successfully." + studentID;
    }
}
