package windows;

import java.util.Vector;

public class opList {
	private static Vector<opPOO> datos = new Vector<opPOO>();
	
		public static void agregar(opPOO obj) {
		datos.addElement(obj); 
	}
	
	public static void eliminar(int pos) {
		datos.removeElementAt(pos);
	}
	
	public static Vector mostrar() {
		return datos;
	}
}
