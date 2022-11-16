package es.upm.miw.iwvg_devops.adapters.firebase.entities;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import es.upm.miw.iwvg_devops.domain.models.Actividad;
import org.springframework.beans.BeanUtils;

import java.util.UUID;
@Document(collectionName = "actividadEntity_test")
public class ActividadEntity {
    @DocumentId
    private String id_doc;
    private int id_act;
    private int id_eve;
    private String fecha;
    private String actividadtipo;
    private String nombre;
    private String foto;
    private String descactividad;
    private String nivel;
    private String salida;
    private String salidacoordenadas;
    private String llegada;
    private String llegadacoordenadastru;
    private int horas;
    private String wikiloc;
    private int desnivel;
    private int distancia;

    public ActividadEntity() {
        //empty from framework
    }

    public ActividadEntity(Actividad actividad) {
        BeanUtils.copyProperties(actividad, this);
        this.id_doc = UUID.randomUUID().toString();
    }

    public String getId_doc() {
        return id_doc;
    }

    public int getId_act() {
        return id_act;
    }

    public void setId_act(int id_act) {
        this.id_act = id_act;
    }

    public int getId_eve() {
        return id_eve;
    }

    public void setId_eve(int id_eve) {
        this.id_eve = id_eve;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getActividadtipo() {
        return actividadtipo;
    }

    public void setActividadtipo(String actividadtipo) {
        this.actividadtipo = actividadtipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescactividad() {
        return descactividad;
    }

    public void setDescactividad(String descactividad) {
        this.descactividad = descactividad;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getSalidacoordenadas() {
        return salidacoordenadas;
    }

    public void setSalidacoordenadas(String salidacoordenadas) {
        this.salidacoordenadas = salidacoordenadas;
    }

    public String getLlegada() {
        return llegada;
    }

    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    public String getLlegadacoordenadastru() {
        return llegadacoordenadastru;
    }

    public void setLlegadacoordenadastru(String llegadacoordenadastru) {
        this.llegadacoordenadastru = llegadacoordenadastru;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getWikiloc() {
        return wikiloc;
    }

    public void setWikiloc(String wikiloc) {
        this.wikiloc = wikiloc;
    }

    public int getDesnivel() {
        return desnivel;
    }

    public void setDesnivel(int desnivel) {
        this.desnivel = desnivel;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Actividad toActividad() {
        Actividad actividad = new Actividad();
        BeanUtils.copyProperties(this, actividad);
        return actividad;
    }

    @Override
    public String toString() {
        return "ActividadEntity{" +
                "id_doc='" + id_doc + '\'' +
                ", id_act=" + id_act +
                ", id_eve=" + id_eve +
                ", fecha='" + fecha + '\'' +
                ", actividadtipo='" + actividadtipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", foto='" + foto + '\'' +
                ", descactividad='" + descactividad + '\'' +
                ", nivel='" + nivel + '\'' +
                ", salida='" + salida + '\'' +
                ", salidacoordenadas='" + salidacoordenadas + '\'' +
                ", llegada='" + llegada + '\'' +
                ", llegadacoordenadastru='" + llegadacoordenadastru + '\'' +
                ", horas=" + horas +
                ", wikiloc='" + wikiloc + '\'' +
                ", desnivel=" + desnivel +
                ", distancia=" + distancia +
                '}';
    }
}
