package presentacion;
import dominio.Localidad;
import dominio.Municipio;
import dominio.Provincia;
import java.util.*;
public class Interfaz {
    private List<Provincia> provincias;
    private Scanner sc;
    public Interfaz() {
        provincias = new ArrayList<>();
        sc = new Scanner(System.in);
    }


    public void iniciarPrograma() {
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    crearLocalidades();
                    break;
                case 2:
                    crearMunicipios();
                    break;
                case 3:
                    crearProvincias();
                    break;
                case 4:
                    mostrarInformacion();
                    break;
                case 5:
                    System.out.println("Bienvenido el programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 5);

    }
    private void mostrarMenu() {
        System.out.println("  MENÚ ");
        System.out.println("1. Crear localidades");
        System.out.println("2. Crear municipios");
        System.out.println("3. Crear provincias");
        System.out.println("4. Mostrar información");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opción: ");
    }

    private void crearLocalidades() {
        System.out.print("\nIngrese la cantidad de localidades que desea crear: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- CREANDO LOCALIDAD " + (i + 1) + " ---");
            System.out.print("el nombre de la localidad: ");
            String nombre = sc.nextLine();
            System.out.print("el número de habitantes de la localidad: ");
            int habitantes = sc.nextInt();
            sc.nextLine();
            Localidad localidad = new Localidad();
            localidad.setNombre(nombre);
            localidad.setNumerohabitantes(habitantes);
            System.out.println("Localidad creada: " + localidad);
            agregarLocalidad(localidad);
        }

    }

 

    private void crearMunicipios() {
        System.out.print("\nCantidad de municipios que desea crear: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- CREANDO MUNICIPIO " + (i + 1) + " ---");
            System.out.print("Ingrese el nombre del municipio: ");
            String nombre = sc.nextLine();
            Municipio municipio = new Municipio(nombre);
            System.out.print("Ingrese la cantidad de localidades que desea agregar al municipio: ");
            int cantidadLocalidades = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < cantidadLocalidades; j++) {
                System.out.println("\n--- AGREGANDO LOCALIDAD " + (j + 1) + " AL MUNICIPIO " + (i + 1) + " ---");
                System.out.print("Ingrese el nombre de la localidad: ");
                String nombreLocalidad = sc.nextLine();
                System.out.print("Ingrese el número de habitantes de la localidad: ");
                int habitantes = sc.nextInt();
                sc.nextLine();
                Localidad localidad = new Localidad();
                localidad.setNombre(nombreLocalidad);
                localidad.setNumerohabitantes(habitantes);
                municipio.addLocalidad(localidad);
                System.out.println("Localidad agregada al municipio: " + localidad);

            }
            agregarMunicipio(municipio);

        }

    }

 

    private void crearProvincias() {
        System.out.print("\nIngrese la cantidad de provincias que desea crear: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- CREANDO PROVINCIA " + (i + 1) + " ---");
            System.out.print("Ingrese el nombre de la provincia: ");
            String nombre = sc.nextLine();
            Provincia provincia = new Provincia(nombre);
            System.out.print("Ingrese la cantidad de municipios que desea agregar a la provincia: ");
            int cantidadMunicipios = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < cantidadMunicipios; j++) {
                System.out.println("\n--- AGREGANDO MUNICIPIO " + (j + 1) + " A LA PROVINCIA " + (i + 1) + " ---");
                System.out.print("Ingrese el nombre del municipio: ");
                String nombreMunicipio = sc.nextLine();
                Municipio municipio = new Municipio(nombreMunicipio);
                System.out.print("Ingrese la cantidad de localidades que desea agregar al municipio: ");
                int cantidadLocalidades = sc.nextInt();
                sc.nextLine();
                for (int k = 0; k < cantidadLocalidades; k++) {
                    System.out.println("\n--- AGREGANDO LOCALIDAD " + (k + 1) + " AL MUNICIPIO " + (j + 1) + " DE LA PROVINCIA " + (i + 1) + " ---");
                    System.out.print("Ingrese el nombre de la localidad: ");
                    String nombreLocalidad = sc.nextLine();
                    System.out.print("Ingrese el número de habitantes de la localidad: ");
                    int habitantes = sc.nextInt();
                    sc.nextLine();
                    Localidad localidad = new Localidad();
                    localidad.setNombre(nombreLocalidad);
                    localidad.setNumerohabitantes(habitantes);
                    municipio.addLocalidad(localidad);
                    System.out.println("Localidad agregada al municipio: " + localidad);

                }
                provincia.addMunicipio(municipio);

            }
            agregarProvincia(provincia);

        }

    }

 

    private void agregarLocalidad(Localidad localidad) {
        for (Provincia provincia : provincias) {
            System.out.println("--- AGREGANDO LOCALIDAD A LA PROVINCIA " + provincia.getNombre() + " ---");
            System.out.print("¿Desea agregar la localidad a esta provincia? (S/N): ");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("S")) {
                Municipio municipio = elegirMunicipio(provincia);
                if (municipio != null) {
                    municipio.addLocalidad(localidad);
                    System.out.println("Localidad agregada al municipio " + municipio.getNombre() +
                            " de la provincia " + provincia.getNombre() + ".");
                }

                return;

            }

        }

        System.out.println("No se ha encontrado una provincia a la cual agregar la localidad.");

    }

    private void agregarMunicipio(Municipio municipio) {
        for (Provincia provincia : provincias) {
            System.out.println("--- AGREGANDO MUNICIPIO A LA PROVINCIA " + provincia.getNombre() + " ---");
            System.out.print("¿Desea agregar el municipio a esta provincia? (S/N): ");
            String respuesta = sc.nextLine(); 
            if (respuesta.equalsIgnoreCase("S")) {
                provincia.addMunicipio(municipio);
                System.out.println("Municipio agregado a la provincia " + provincia.getNombre() + ".");
                return;

            }

        }
        System.out.println("No se ha encontrado una provincia a la cual agregar el municipio.");

    }

    private void agregarProvincia(Provincia provincia) {
        provincias.add(provincia);
        System.out.println("Provincia agregada.");
    }

    private Municipio elegirMunicipio(Provincia provincia) {
        System.out.print("Ingrese el nombre del municipio al que desea agregar la localidad: ");
        String nombreMunicipio = sc.nextLine();
        for (Municipio municipio : provincia.getMunicipios()) {
            if (municipio.getNombre().equalsIgnoreCase(nombreMunicipio)) {
                return municipio;
            }

        }

        return null;

    }
    private void mostrarInformacion() {
        System.out.println("\n--- INFORMACIÓN ---");
        for (Provincia provincia : provincias) {
            System.out.println("Provincia: " + provincia.getNombre());
            System.out.println("Total habitantes: " + provincia.NumeroTotalDeHabitantes());
            System.out.println("Municipios:");
            for (Municipio municipio : provincia.getMunicipios()) {
                System.out.println("- " + municipio.getNombre());
                System.out.println("  Habitantes: " + municipio.calcularNumeroTotalHabitantesMunicipio());
                System.out.println("  Localidades:");
                for (Localidad localidad : municipio.getLocalidades()) {
                    System.out.println("  - " + localidad.getNombre());
                    System.out.println("    Habitantes: " + localidad.getNumerohabitantes());
                }

            }
            System.out.println("--------------------------------------");

        }

    }



    public static void main(String[] args) {

        Interfaz interfaz = new Interfaz();

        interfaz.iniciarPrograma();

    }

}


