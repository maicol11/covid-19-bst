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
		
		tree.feverReport();
		
		//tree.printSymptoms(4);
		
		
//		Patient p1 = new Patient(4, "Paciente 1", 3);
//		p1.symptoms[0] = "estomago";
//		p1.symptoms[1] = "estomago";
//		p1.symptoms[2] = "tos";
//		
//		Patient p2 = new Patient(2, "Paciente 2", 2);
//		p2.symptoms[0] = "fever";
//		p2.symptoms[1] = "estomago";
//		
//		Patient p3 = new Patient(3, "Paciente 3", 1);
//		p3.symptoms[0] = "estomago";
//		
//		Patient p4 = new Patient(1, "Paciente 4", 4);
//		p4.symptoms[0] = "fever";
//		p4.symptoms[1] = "estomago";
//		p4.symptoms[2] = "tos";
//		p4.symptoms[3] = "dolor";
//		
//		Patient p5 = new Patient(5, "Paciente 5", 3);
//		p5.symptoms[0] = "fever";
//		p5.symptoms[1] = "estomago";
//		p5.symptoms[2] = "tos";
//		
//		Patient p6 = new Patient(200, "Paciente 6", 1);
//		p6.symptoms[0] = "estomago";
//		
//		Patient p7 = new Patient(9, "Paciente 7", 1);
//		p7.symptoms[0] = "estomago";
//		PatientBinarySearchTree tree = new PatientBinarySearchTree();
//		
//		tree.addPatient(p1);
//		tree.addPatient(p2);
//		tree.addPatient(p3);
//		tree.addPatient(p4);
//		tree.addPatient(p5);
//		tree.addPatient(p6);
//		tree.addPatient(p7);
		
		
		//tree.printTree();
		
		//tree.paymentsAverage();
		
		//tree.feberReport();
		
		

		
	}

}
