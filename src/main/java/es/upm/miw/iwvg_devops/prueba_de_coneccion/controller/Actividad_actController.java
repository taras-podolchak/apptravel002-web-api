package es.upm.miw.iwvg_devops.prueba_de_coneccion.controller;


import es.upm.miw.iwvg_devops.prueba_de_coneccion.entities.Actividad_actEntity;
import es.upm.miw.iwvg_devops.prueba_de_coneccion.services.Actividad_actService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class Actividad_actController {
    @Autowired
    private Actividad_actService actividad_actService;

    @PostMapping("/actividades")
    public String saveActividad_act(@RequestBody Actividad_actEntity actividad_act) throws ExecutionException, InterruptedException {
        return actividad_actService.saveActividad_act(actividad_act);
    }

    @GetMapping("/actividades/{id_doc}")
    public Actividad_actEntity getActividad_act(@PathVariable String id_doc) throws ExecutionException, InterruptedException {
        return actividad_actService.getActividad_act(id_doc);
    }

    @GetMapping("/actividadesList")
    public List<Actividad_actEntity> getActividad_actList() throws ExecutionException, InterruptedException {
        return actividad_actService.getActividad_actList();
    }

    @DeleteMapping("/actividades/{id_doc}")
    public String deleteActividad_act(@PathVariable String id_doc) throws ExecutionException, InterruptedException {
        return actividad_actService.deleteActividad_act(id_doc);
    }
}