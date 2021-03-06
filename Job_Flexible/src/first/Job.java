package first;
import java.util.ArrayList;

public class Job {
	private int numJob;
	private String sentence = null;
	private ArrayList<Operation> operationsRestantes = new ArrayList<Operation>();   
	private ArrayList<Operation> operationsTotales = new ArrayList<Operation>();
	
	public Job(String sentence, int numJob) {
		this.numJob = numJob;
		this.sentence = sentence;
		for(int i=0;i<10;i++) {
		}
		initJob();
	}
	
	private void initJob() {
		String[] splited;
		int compteurOp = 0;
		splited = this.sentence.split("\\s+");
		for(int i=1;i<splited.length;i++) {
			int machinesNeeded = Integer.parseInt(splited[i]);
			
			if(machinesNeeded == 1) {
				i++;
				int nameMachine = Integer.parseInt(splited[i]);
<<<<<<< HEAD
				i++;
				int timeOperation = Integer.parseInt(splited[i]);
=======
				//System.out.print("numJob: "+this.numJob+", machinesNeeded: "+machinesNeeded+", NameMachine : "+ nameMachine);
				i++;
				int timeOperation = Integer.parseInt(splited[i]);
			//	System.out.println(", timeOperation : "+ timeOperation);
>>>>>>> 0b59a1c8ca179991a7c5e0d3d31d4bfe99f4900f
				String name = "o"+Integer.toString(compteurOp)+"-"+Integer.toString(numJob);
				compteurOp++;
				operationsRestantes.add( new Operation(name,machinesNeeded,nameMachine,timeOperation,numJob) );
				operationsTotales.add( new Operation(name,machinesNeeded,nameMachine,timeOperation,numJob) );
			}
			else {
				int[] nameMachine = new int[machinesNeeded];
				int[] timeOperation = new int[machinesNeeded];
				
				for(int j=0;j<machinesNeeded;j++) {
					i++;
					nameMachine[j] = Integer.parseInt(splited[i]);
<<<<<<< HEAD
					i++;
					timeOperation[j] = Integer.parseInt(splited[i]);
=======
			//		System.out.print("numJob: "+this.numJob+", machinesNeeded: "+machinesNeeded+", NameMachine : "+ nameMachine[j]);
					i++;
					timeOperation[j] = Integer.parseInt(splited[i]);
			//		System.out.println(", timeOperation : "+ timeOperation[j]);
>>>>>>> 0b59a1c8ca179991a7c5e0d3d31d4bfe99f4900f
				}
				String name = "o"+Integer.toString(compteurOp)+"-"+Integer.toString(numJob);
				compteurOp++;
				operationsRestantes.add( new Operation(name,machinesNeeded,nameMachine,timeOperation,numJob));
				operationsTotales.add( new Operation(name,machinesNeeded,nameMachine,timeOperation,numJob) );
			}	
		}
		
	}
	
	public String toString() { 
		String ret = "";
	    for (Operation ope : operationsRestantes) {
	    	ret += ope.toString();
	    }
	    return ret;
	}

	public ArrayList<Operation> getOperationsRestantes(){
		return this.operationsRestantes;	
	}
	
	public ArrayList<Operation> getOperationsTotales(){
		return this.operationsTotales;
	}

	public Operation getOperation() {
		Operation operation;
		if(!operationsRestantes.isEmpty())
			operation = operationsRestantes.get(0);
		else
			operation = null;
		return operation;
	}
	
	public void popOperation() {
		operationsRestantes.remove(0);
	}
	
	
}
