package windows;

import java.util.Vector;

public  class opPOO {
	 private String gmail, nombre, user, contra;
	

	void setUser(String user) {
		 this.user=user;
	 }
	 
	 void setContra(String contra) {
		 this.contra=contra;
	 }
	 
	 void setGmail(String gmail) {
		 this.gmail=gmail;
	 }
	 
	 void setNombre(String nombre) {
		 this.nombre=nombre;
	 }
	 
	 String getUser() {
		 return user;
	 }
	 String getContra() {
		 return contra;
	 }
	 
	 String getGmail() {
		 return gmail;
	 }
	 
	 String getNombre() {
		 return nombre;
	 }
	 
	 public static int verificarUsuarioNuevo(String user) {
		 Vector<?> lista = mostrar();
		 opPOO obj;
		
		 for(int i = 0; i<lista.size(); i++) {
			 obj = (opPOO)lista.elementAt(i);
			 if(obj.getUser().equalsIgnoreCase(user)) {
				 return i;
			 }
		 }
		 return -1;
	 }
	 
	 public static int publicarLog(String user, String contra) {
		 Vector<?> lista = mostrar();
		 opPOO obj;
		
		 for(int i = 0; i<lista.size(); i++) {
			 obj = (opPOO)lista.elementAt(i);
			 if(obj.getUser().equalsIgnoreCase(user) && obj.getContra().equalsIgnoreCase(contra)) {
				 return i;
			 }
		 }
		 return -1;
	 }
	 
	 public static Vector<?> mostrar() {
		 return opList.mostrar();
	 }

}
