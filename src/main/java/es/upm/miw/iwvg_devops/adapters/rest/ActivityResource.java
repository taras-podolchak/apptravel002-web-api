package es.upm.miw.iwvg_devops.adapters.rest;

import es.upm.miw.iwvg_devops.domain.models.Actividad;
import es.upm.miw.iwvg_devops.domain.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class ActivityResource {
    private final ActivityService activityService;

    @Autowired
    public ActivityResource(ActivityService activityService) {
        this.activityService = activityService;
    }


    @GetMapping("/actividadesListNew")
    public Flux<Actividad> actividadesListNew() {
        return activityService.getActividadList();
    }
}
