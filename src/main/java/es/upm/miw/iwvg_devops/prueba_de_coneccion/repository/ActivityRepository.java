package es.upm.miw.iwvg_devops.prueba_de_coneccion.repository;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import es.upm.miw.iwvg_devops.prueba_de_coneccion.entities.ActividadEntity;

public interface ActivityRepository extends FirestoreReactiveRepository<ActividadEntity> {
}
