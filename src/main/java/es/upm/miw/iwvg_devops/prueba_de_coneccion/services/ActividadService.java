package es.upm.miw.iwvg_devops.prueba_de_coneccion.services;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import es.upm.miw.iwvg_devops.prueba_de_coneccion.entities.ActividadEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ActividadService {

    private static final String COLECTION_NAME = "actividadEntity_test";

    public static String saveActividad_act(ActividadEntity actividad_act) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResultApiFuture = firestore.collection(COLECTION_NAME).document("12345").set(actividad_act);
        return writeResultApiFuture.get().getUpdateTime().toString();
    }

    public ActividadEntity getActividad_act(String id_act) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection(COLECTION_NAME).document(id_act);

        ApiFuture<DocumentSnapshot> writeResultApiFuture = documentReference.get();

        DocumentSnapshot document = writeResultApiFuture.get();

        ActividadEntity actividad_act = null;

        if (document.exists()) {
            actividad_act = document.toObject(ActividadEntity.class);
            return actividad_act;
        } else {
            return null;
        }
    }

    public List<ActividadEntity> getActividadList() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        Iterable<DocumentReference> documentReference = firestore.collection(COLECTION_NAME).listDocuments();
        Iterator<DocumentReference> iterator = documentReference.iterator();

        List<ActividadEntity> actividadList = new ArrayList<>();
        ActividadEntity actividad;

        while (iterator.hasNext()) {
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot document = future.get();

            actividad = document.toObject(ActividadEntity.class);
            actividadList.add(actividad);

        }
        return actividadList;
    }

    public String deleteActividad(String id_doc) {
        FirestoreClient.getFirestore().collection(COLECTION_NAME).document(id_doc).delete();
        return "Documento con id_doc " + id_doc + " eliminado con exito";
    }
}
