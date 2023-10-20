package aplicacion;
import dominio.Localidad;
import dominio.Municipio;

public class Principal {

    public static void main(String[] args) {
        //Inicializar objeto Localidad
        Localidad localidad = new Localidad();
        Municipio municipio = new Municipio();

        //Poner los valores
        localidad.setNombre("Madrid");
        localidad.setNumerohabitantes(1);

        //Imprimimos
        System.out.print(localidad.getNombre()+" tiene " + localidad.getNumerohabitantes()+" habitantes");

        //Creamos otra localidad
        Localidad localidad2 = new Localidad();
		localidad2.setNombre("fefe");

        //Añadimos las localidades al objeto municipio
        municipio.setNombre("Comunidad de Madrid");
        municipio.addLocalidad(localidad);
        municipio.addLocalidad(localidad2);
        municipio.calcularNumeroTotalHabitantesMunicipio();

        System.out.println(municipio);



       System.out.print(municipio.getTotalNumeroHabitantesMunicipio());







    }
}
