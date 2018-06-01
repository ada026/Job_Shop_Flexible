package first;


public class Tuple { 
	public final int nomMachine; 
	public final int timeOperation; 

	public Tuple(int x, int y) { 
		this.nomMachine = x; 
		this.timeOperation = y; 
	} 
  
	public String toString() {
	  String ret = "";
	  
	  ret += "M:" + this.nomMachine + "|t:" + this.timeOperation;
	  
	  return ret;
	}

	public int getNomMachine(){
		return nomMachine;	
	}
	
	public int getTimeOperation(){
		return timeOperation;
	}
	
	
} 
