package es.upm.miw.iwvg_devops.adapters.firebase.persistence;

import es.upm.miw.iwvg_devops.adapters.firebase.daos.ActivityRepository;
import es.upm.miw.iwvg_devops.adapters.firebase.entities.ActividadEntity;
import es.upm.miw.iwvg_devops.domain.models.Actividad;
import es.upm.miw.iwvg_devops.domain.persistence_ports.ActivityPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository("activityPersistence")
public class ActivityPersistenceFirestore implements ActivityPersistence {

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityPersistenceFirestore(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public Flux<Actividad> getActividadList() {
        return this.activityRepository.findAll().map(ActividadEntity::toActividad);
    }
}