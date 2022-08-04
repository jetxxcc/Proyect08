package windows;

public abstract class opPOO {
	 String user, contra;
	
	 opPOO(String user, String contra){
		 this.user=user;
		 this.contra=contra;
	 }
	 
	 void setUser(String x) {
		 this.user=x;
	 }
	 
	 void setContra(String y) {
		 this.contra=y;
	 }
	 
	 String getUser() {
		 return user;
	 }
	 String getContra() {
		 return contra;
	 }

}
