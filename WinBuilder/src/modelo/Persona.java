package modelo;

public class Persona {
	private static int indice=1;
	private int id;
	private String nombre;
	private String apellido;
	private int edad;
	public Persona(String nombre, String apellido, int edad) {
//		super();				
//		this.id = indice++;
//		this.id = indice;
//		indice++;		
//		this.id = ++indice;
//		indice++;
//		this.id = indice;
				
		this.id = indice++;		
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;		
	}
	

//	alt + shift+s 
	
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public Persona(int id, String nombre, String apellido, int edad) {
		super();//no es necesario
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}	
}
