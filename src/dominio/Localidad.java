package dominio;
public class Localidad {
	private String nombre;
	private int numerohabitantes;
	
	//constructor
	//public Localidad(String nombre, int numero_habitantes){
	//	this.nombre = nombre;
	//	this.numero_habitantes = numero_habitantes;
	//}
	//get lo coje
	public String getNombre(){
	return nombre;
	}

	//set da valor 
	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public int getNumerohabitantes(){
		return numerohabitantes;
	}

	public void setNumerohabitantes(int numerohabitantes) {
		this.numerohabitantes = numerohabitantes;
	}

	//mostrar parametros
	@Override
	public String toString(){
		String result = ("La Localidad" + this.nombre + "tiene" +this.numerohabitantes + "habitantes");
		return result;
	}
}
