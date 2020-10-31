package binary_search_tree;

public class Patient {
	int id;
	String name;
	String symptoms[];
	float paymentForSymptoms;
	Patient(int idValue, String nameValue, int symptomsQuantity) {
		this.id = idValue;
		this.name = nameValue;
		symptoms = new String[symptomsQuantity];
		if(symptomsQuantity > 0 ) {
			
			for(int i = 0; i <symptomsQuantity; i++ ) {
				paymentForSymptoms += 100;
			}
		}
	}
}
