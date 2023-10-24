package dominio;

import java.util.ArrayList;
import java.util.List;
public class Municipio {
    private String nombre;
    private List<Localidad> localidades; // Array de Localidad
    private int totalNumeroHabitantesMunicipio;

    public Municipio(String nombre) {
        this.nombre = nombre;
        localidades = new ArrayList<>();
    }
    public int calcularNumeroTotalHabitantesMunicipio() {
        int totalNumeroHabitantesMunicipio = 0;
        for (Localidad localidad : localidades) {
            totalNumeroHabitantesMunicipio += localidad.getNumerohabitantes();
        }
        return totalNumeroHabitantesMunicipio;
    }


    // Método para agregar una localidad al municipio
    public void addLocalidad(Localidad localidad) {
       localidades.add(localidad);
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Localidad> getLocalidades() {
        return localidades;
    }


    public int getTotalNumeroHabitantesMunicipio() {
        return totalNumeroHabitantesMunicipio;
    }

    public void setTotalNumeroHabitantesMunicipio(int totalNumeroHabitantesMunicipio) {
        this.totalNumeroHabitantesMunicipio = totalNumeroHabitantesMunicipio;
    }

    // Otros métodos de la clase Municipio si son necesarios
    @Override
    public String toString() {
        return "Municipio{" + "nombre='" + nombre +", localidades=" + localidades + ", totalNumeroHabitantesMunicipio=" + calcularNumeroTotalHabitantesMunicipio();
    }
}

