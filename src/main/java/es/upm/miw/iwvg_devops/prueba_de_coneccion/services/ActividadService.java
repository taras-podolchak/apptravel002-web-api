package es.upm.miw.iwvg_devops.prueba_de_coneccion.services;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
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

    public String saveActividad_act(ActividadEntity actividad_act) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> writeResultApiFuture = FirestoreClient.getFirestore().collection(COLECTION_NAME).document("12345").set(actividad_act);
        return writeResultApiFuture.get().getUpdateTime().toString();
    }

    public ActividadEntity getActividad_act(String id_act) throws ExecutionException, InterruptedException {
        DocumentSnapshot document = FirestoreClient.getFirestore().collection(COLECTION_NAME).document(id_act).get().get();

        if (document.exists()) {
            return document.toObject(ActividadEntity.class);
        } else {
            return null;
        }
    }

    public List<ActividadEntity> getActividadList() throws ExecutionException, InterruptedException {
        Iterator<DocumentReference> iterator = FirestoreClient.getFirestore().collection(COLECTION_NAME).listDocuments().iterator();

        List<ActividadEntity> actividadList = new ArrayList<>();

        while (iterator.hasNext()) {
            DocumentSnapshot document = iterator.next().get().get();
            actividadList.add(document.toObject(ActividadEntity.class));
        }
        return actividadList;
    }

    public String deleteActividad(String id_doc) {
        FirestoreClient.getFirestore().collection(COLECTION_NAME).document(id_doc).delete();
        return "Documento con id_doc " + id_doc + " eliminado con exito";
    }
}
