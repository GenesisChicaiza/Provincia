package dominio;

public class Provincia {
    private String nombre;
    private Municipio[] municipios;
    private int numeroTotalHabitantesProvincia;

    public Provincia(String nombre) {
        this.nombre = nombre;
        this.municipios = new Municipio[0]; // Crear un array de municipios vacío
        this.numeroTotalHabitantesProvincia=0;
    }

    // Método para agregar un municipio a la provincia
    public void addMunicipio(Municipio municipio) {
        // Crear un nuevo array de municipios con una longitud 1 mayor que el actual
        Municipio[] nuevoArray = new Municipio[municipios.length + 1];

        // Copiar los municipios existentes al nuevo array
        for (int i = 0; i < municipios.length; i++) {
            nuevoArray[i] = municipios[i];
        }

        // Agregar el nuevo municipio al final del nuevo array
        nuevoArray[municipios.length] = municipio;

        // Reemplazar el array de municipios actual con el nuevo array
        municipios = nuevoArray;
    }

    // Método para calcular el total de habitantes en la provincia
    public void getNumeroTotalDeHabitantes() {
        int totalHabitantes = 0;
        for (Municipio municipio : municipios) {
            totalHabitantes += municipio.getTotalNumeroHabitantesMunicipio();
        }
        this.numeroTotalHabitantesProvincia=totalHabitantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Municipio[] getMunicipios() {
        return municipios;
    }

    public void setMunicipios(Municipio[] municipios) {
        this.municipios = municipios;
    }


    // Otros métodos de la clase Provincia
}
