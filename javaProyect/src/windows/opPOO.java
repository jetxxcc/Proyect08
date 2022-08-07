package windows;

import java.util.Vector;

public  class opPOO {
	private int id, id_tipo;
	 private String gmail, nombre, user, contra, last_session, nombre_tipo;
	

	public void setUser(String user) {
		 this.user=user;
	 }
	 
	 public void setContra(String contra) {
		 this.contra=contra;
	 }
	 
	 public void setGmail(String gmail) {
		 this.gmail=gmail;
	 }
	 
	 public void setNombre(String nombre) {
		 this.nombre=nombre;
	 }
	 
	 public String getUser() {
		 return user;
	 }
	 public String getContra() {
		 return contra;
	 }
	 
	 public String getGmail() {
		 return gmail;
	 }
	 
	 public String getNombre() {
		 return nombre;
	 }
	 
	 public static int verificarUsuarioNuevo(String user) {
		 Vector lista = mostrar();
		 opPOO obj;
		
		 for(int i = 0; i<lista.size(); i++) {
			 obj = (opPOO)lista.elementAt(i);
			 if(obj.getUser().equalsIgnoreCase(user)) {
				 return i;
			 }
		 }
		 return -1;
	 }
	 
	 public static int verificarLog(String user, String contra) {
		 Vector lista = mostrar();
		 opPOO obj;
		
		 for(int i = 0; i<lista.size(); i++) {
			 obj = (opPOO)lista.elementAt(i);
			 if(obj.getUser().equalsIgnoreCase(user) && obj.getContra().equalsIgnoreCase(contra)) {
				 return i;
			 }
		 }
		 return -1;
	 }
	 
	 public static Vector mostrar() {
		 return opList.mostrar();
	 }

	public int getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLast_session() {
		return last_session;
	}

	public void setLast_session(String last_session) {
		this.last_session = last_session;
	}

	public String getNombre_tipo() {
		return nombre_tipo;
	}

	public void setNombre_tipo(String nombre_tipo) {
		this.nombre_tipo = nombre_tipo;
	}

	

}
