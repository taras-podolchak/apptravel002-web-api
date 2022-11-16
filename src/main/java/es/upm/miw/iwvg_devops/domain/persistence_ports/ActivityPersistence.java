package es.upm.miw.iwvg_devops.domain.persistence_ports;

import es.upm.miw.iwvg_devops.domain.models.Actividad;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ActivityPersistence {

    Flux<Actividad> getActividadList();
}
