package com.java.firebase.studentsPackage;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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

    public List<Students> getAllStudents() throws Exception {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection("students").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<Students> studentsList = new ArrayList<>();

        for (QueryDocumentSnapshot document : documents) {
            Students student = document.toObject(Students.class);
            studentsList.add(student);
        }

        return studentsList;
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
