package binary_search_tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		PatientBinarySearchTree tree = new PatientBinarySearchTree();
		
		BufferedReader file = new BufferedReader(new FileReader("data.txt"));
		
		int patientsNumber = Integer.parseInt(file.readLine());
		
	
		for(int i = 0; i < patientsNumber; i++) {
			String dataPatient[] = file.readLine().split(",");
			Patient patient = new Patient(Integer.parseInt(dataPatient[0]), dataPatient[1], Integer.parseInt(dataPatient[2]));
			int symptomsNumber = Integer.parseInt(dataPatient[2]);
			
			for(int j = 0; j < symptomsNumber; j++) {
				String symptom = file.readLine();
				patient.symptoms[j] = symptom;
				
			}
			
			tree.addPatient(patient);
			
		}
		
		//tree.feverReport();
		tree.patientWithBiggetsNumberOfSymptoms();
		//tree.printSymptoms(4);
		
		
		

		
	}

}
