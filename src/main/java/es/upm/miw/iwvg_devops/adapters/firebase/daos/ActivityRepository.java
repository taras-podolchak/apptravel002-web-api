package es.upm.miw.iwvg_devops.adapters.firebase.daos;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import es.upm.miw.iwvg_devops.adapters.firebase.entities.ActividadEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
public interface ActivityRepository extends FirestoreReactiveRepository<ActividadEntity> {

}
