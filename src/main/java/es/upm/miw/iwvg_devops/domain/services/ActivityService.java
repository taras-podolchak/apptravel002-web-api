package es.upm.miw.iwvg_devops.domain.services;


import es.upm.miw.iwvg_devops.domain.models.Actividad;
import es.upm.miw.iwvg_devops.domain.persistence_ports.ActivityPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityPersistence activityPersistence;

    @Autowired
    public ActivityService(ActivityPersistence activityPersistence) {
        this.activityPersistence = activityPersistence;
    }

    public Flux<Actividad> getActividadList() {
        return activityPersistence.getActividadList();
    }
}
