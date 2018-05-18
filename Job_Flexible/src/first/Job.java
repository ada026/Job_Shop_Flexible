//package first;
import java.util.ArrayList;
import java.util.Iterator;

public class Job {
	private int numJob;
	private int compteurOp = 0;
	private String sentence = null;
	private int nbOperations = 0;
	private ArrayList<Operation> listOperations = new ArrayList<Operation>();   //restante
	private ArrayList<Operation> listOperationsGlobale = new ArrayList<Operation>();
	private int compteur = 0;
	
	public Job(String sentence, int numJob) {
		this.numJob = numJob;
		this.sentence = sentence;
		for(int i=0;i<10;i++) {
		}
		initJob();
	}
	
	public void initJob() {
		
		this.nbOperations = Character.getNumericValue(this.sentence.charAt(0));
		for(int i=4;i<this.sentence.length();i+=12) {
			int machinesNeeded = Character.getNumericValue(this.sentence.charAt(i));
			if(machinesNeeded == 1) {
				int nameMachine = Character.getNumericValue(this.sentence.charAt(i+4));
				int timeOperation = Character.getNumericValue(this.sentence.charAt(i+8));
				String name = "o"+Integer.toString(compteurOp)+"-"+Integer.toString(numJob);
				compteurOp++;
				listOperations.add( new Operation(name,machinesNeeded,nameMachine,timeOperation,numJob) );
				listOperationsGlobale.add( new Operation(name,machinesNeeded,nameMachine,timeOperation,numJob) );
			}
			else {
				int[] nameMachine = new int[machinesNeeded];
				int[] timeOperation = new int[machinesNeeded];
				int f = 0;
				for(int j=0;j<machinesNeeded;j++) {
					// Attention
					f+=4;
					nameMachine[j] = Character.getNumericValue(this.sentence.charAt(i+f));
					f+=4;
					timeOperation[j] = Character.getNumericValue(this.sentence.charAt(i+f));
				}
				i += (machinesNeeded-1)*8;
				String name = "o"+Integer.toString(compteurOp)+"-"+Integer.toString(numJob);
				compteurOp++;
				listOperations.add( new Operation(name,machinesNeeded,nameMachine,timeOperation,numJob));
				listOperationsGlobale.add( new Operation(name,machinesNeeded,nameMachine,timeOperation,numJob) );
			}
		}
		System.out.println(this.listOperations.toString());
		
	}
	
	public String toString() { 
		String ret = "";
	    for (Operation ope : listOperations) {
	    	ret += ope.toString();
	    }
	    return ret;
	}

	public int getCompteur(){
		return compteur;
	}

	public ArrayList<Operation> getListOperations(){
		return listOperations;	
	}

	public void updateCompteur(){
		compteur++;
		listOperations.remove(0); //on enleve le 1er element
	}

	public int getTime(int numOp, int numMachine){
		int time = 0;
		int k;
		int machinesNeeded;
		Operation operation;
		operation = listOperationsGlobale.get(numOp);
		machinesNeeded = operation.getMachinesNeeded();
		for(k = 0;k<machinesNeeded;k++){
			if(numMachine == operation.getMachineTime()[k].getNomMachine()){
							time = operation.getMachineTime()[k].getTimeOperation();
			}
		}
		return time;
	}
	
}
