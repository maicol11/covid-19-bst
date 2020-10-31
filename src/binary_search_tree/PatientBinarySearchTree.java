package binary_search_tree;

public class PatientBinarySearchTree {

	PatientNode root;
	int fever = 0;
	
	public void addPatient(Patient patient) {
		
		if(root == null) {
			root = new PatientNode(patient);
			return;
		}
		
		addChild(root, patient);
	}
	
	private void addChild(PatientNode root, Patient patient) {
		
		if(root == null) {
			return;
		}
		
		if(uniqueId(root, patient.id) == false) {
			System.out.println(patient.name + " (" + patient.id + ") is duplicated, so "+ patient.name +" couldn't be added to the system again.");
			return;
		}
		
		if(patient.id > root.patient.id) {
			if(root.right == null) {
				root.right = new PatientNode(patient);
			}
			else {
				addChild(root.right, patient);
			}
		}else {
			if(root.left == null) {
				root.left = new PatientNode(patient);
			}
			else {
				addChild(root.left, patient);
			}
		}		
	}
	
	public void printTree() {
		search(root);
	}
	
	private void search(PatientNode node) {
		
		if(node == null) {
			return;
		}
		
		if(node.left != null) {
			System.out.println("Left: " + node.left.patient.name);
			search(node.left);
		}
		
		
		if(node.right != null) {
			System.out.println("Right: " + node.right.patient.name);
			search(node.right);
		}
	}
	
	
	
	private boolean uniqueId(PatientNode node, int id) {
		if(node == null) {
			return true;
		}
		if(id == node.patient.id) {
			return false;
		}
		if(id > node.patient.id) {
			return uniqueId(node.right, id);
		}else {
			return uniqueId(node.left, id);
		}
	}
	
	public void printSymptoms(int id) {
		searchSymptomsById(root, id);
	}
	
	private void searchSymptomsById(PatientNode node, int id) {
		if(node == null) {
			System.out.print("User with id " + id + " not found");
			return;
		}
		if(id == node.patient.id) {
			if(node.patient.symptoms.length > 0) {
				System.out.print("Symptoms of " + node.patient.name + ": ");
				for(int i = 0; i < node.patient.symptoms.length; i++) {
					System.out.print(node.patient.symptoms[i] + ", " );
				}
				
			}else {
				System.out.println(node.patient.name + " has no symptoms");
			}
			return;
		}
		if(id > node.patient.id) {
			searchSymptomsById(node.right, id);
		}else {
			searchSymptomsById(node.left, id);
		}
	}
	
	
	public void feverReport() {
		countFever(root);
		System.out.print("Patients with fever: " + fever);
	}
	
	private void countFever(PatientNode node) {
		
		if(node == null) {
			return ;
		}
		
		if(node.patient.symptoms.length > 0) {
			for(int i=0; i < node.patient.symptoms.length; i++) {
				if(node.patient.symptoms[i].equals("fever")) {
					fever += 1;
				}
			}
		}
		
		if(node.right != null) {
			countFever(node.right);
		}
		
		if(node.left != null) {
			countFever(node.left);
		}
		
	}
	
	public void paymentsAverage() {
		float totalPayments = totalPayments(root);
		totalPayments += root.patient.paymentForSymptoms;
		float totalPatients = patientCounter(root);
		totalPatients += 1;
		
		float average =  totalPayments / totalPatients;
		
		System.out.println("Payments average: " + average);
	}
	
	private float totalPayments(PatientNode node) {
		if(node == null) {
			return 0;
		}		

		float right = 0;
		if(node.right != null) {
			right =  totalPayments(node.right);
			right += node.right.patient.paymentForSymptoms;
		}
		
		float left = 0;
		if(node.left != null) {
			left =  totalPayments(node.left);
			left += node.left.patient.paymentForSymptoms;
		}

		float totalPayments = right + left;
		
		return totalPayments;
		
		
	}
	
	private float patientCounter(PatientNode node) {
		if(node == null) {
			return 0;
		}		

		float right = 0;
		if(node.right != null) {
			right =  patientCounter(node.right);
			right += 1;
		}
		
		float left = 0;
		if(node.left != null) {
			left =  patientCounter(node.left);
			left += 1;
		}

		float totalPatients = right + left;
		
		return totalPatients;
		
	}
	
	public void commondSymptom() {
		validate(root);
	}
	
	private void validate(PatientNode node) {
		if(node == null) {
			return;
		}	
	}
	
	public void patientWithBiggetsNumberOfSymptoms() {
		Patient patient = biggetsNumberOfSymptoms(root);
		if(patient != null) {
			System.out.println(patient.name + " is the patient with the biggets number of symptoms");
		}
	}
	
	private Patient biggetsNumberOfSymptoms(PatientNode node) {
		if(node == null) {
			return null;
		}
		
		Patient patientWithMajorSymptomsRight = null;
		if(node.right != null) {
			patientWithMajorSymptomsRight = biggetsNumberOfSymptoms(node.right);
		}
		
		Patient patientWithMajorSymptomsLeft = null;
		if(node.left != null) {
			patientWithMajorSymptomsLeft = biggetsNumberOfSymptoms(node.left);
		}
		
		Patient sickMajor = node.patient;
		
		if(patientWithMajorSymptomsRight != null) {
			if(sickMajor.symptoms.length <= patientWithMajorSymptomsRight.symptoms.length) {
				sickMajor = patientWithMajorSymptomsRight;
			}
		}
		
		if(patientWithMajorSymptomsLeft != null) {
			if(sickMajor.symptoms.length <= patientWithMajorSymptomsLeft.symptoms.length) {
				sickMajor = patientWithMajorSymptomsLeft;;
			}
		}
		
		return sickMajor;
	}

	
}
