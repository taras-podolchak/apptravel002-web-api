package es.upm.miw.iwvg_devops.prueba_de_coneccion.controller;


import es.upm.miw.iwvg_devops.prueba_de_coneccion.entities.ActividadEntity;
import es.upm.miw.iwvg_devops.prueba_de_coneccion.services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class ActividadController {
    @Autowired
    private ActividadService actividadService;

    //https://apptravel002-web-api.herokuapp.com/api/actividades
    @PostMapping("/actividades")
    public String saveActividad(@RequestBody ActividadEntity actividad_act) throws ExecutionException, InterruptedException {
        return ActividadService.saveActividad_act(actividad_act);
    }

    //https://apptravel002-web-api.herokuapp.com/api/actividades/1
    @GetMapping("/actividades/{id_doc}")
    public ActividadEntity getActividad(@PathVariable String id_doc) throws ExecutionException, InterruptedException {
        return actividadService.getActividad_act(id_doc);
    }

    //https://apptravel002-web-api.herokuapp.com/api/actividadesList
    @GetMapping("/actividadesList")
    public List<ActividadEntity> getActividadList() throws ExecutionException, InterruptedException {
        return actividadService.getActividadList();
    }

    //https://apptravel002-web-api.herokuapp.com/api/actividades/1
    @DeleteMapping("/actividades/{id_doc}")
    public String deleteActividad_act(@PathVariable String id_doc) {
        return actividadService.deleteActividad(id_doc);
    }
}