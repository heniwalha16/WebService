package serverApp;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerService extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/register.fxml"));
        Parent root = loader.load();

        // Set up the scene
        Scene scene = new Scene(root);

        // Set up the stage
        primaryStage.setTitle("Tutor Mangement Application");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	private static HashMap<String, String> createAvailabilityMap(String... slots) {
        HashMap<String, String> availability = new HashMap<>();
        for (int i = 0; i < slots.length; i += 2) {
            availability.put(slots[i], slots[i + 1]);
        }
        return availability;
    }
	 public static void main(String[] args) {
	        try {
	            // Create the registry at default port 1099
	            LocateRegistry.createRegistry(1099);
	            List<Tutor> tutors = new ArrayList<>();

	            // Données fictives pour trois Tutors
	            String[] firstNames = {"Alice", "Bob", "Charlie"};
	            String[] lastNames = {"Smith", "Johnson", "Williams"};
	            String[] mails = {"alice.smith@univ-eiffel.fr", "bob.johnson@univ-eiffel.fr", "charlie.williams@univ-eiffel.fr"};
	            String[] passwords = {"mdpAlice", "mdpBob", "mdpCharlie"};
	            double[] ratings = {4.5, 3.8, 4.2};
	            double[] rates = {60.0, 45.0, 50.0};

	            List<String>[] waitingLists = new List[]{
	            	    new ArrayList<>(Arrays.asList("Heni Walha <heni.walha@esprit.tn>", "John Doe <john.doe@edu.univ-eiffel.fr>")),
	            	    new ArrayList<>(Arrays.asList("Emma Johnson <emma.johnson@edu.univ-eiffel.fr>", "Michael Smith <michael.smith@edu.univ-eiffel.fr>")),
	            	    new ArrayList<>(Arrays.asList("Sophia Williams <sophia.williams@edu.univ-eiffel.fr>", "William Brown <william.brown@edu.univ-eiffel.fr>"))
	            	};

	            	List<String>[] skills = new List[]{
	            	    new ArrayList<>(Arrays.asList("Java", "Python", "Machine Learning")),
	            	    new ArrayList<>(Arrays.asList("C++", "JavaScript")),
	            	    new ArrayList<>(Arrays.asList("Data Science", "SQL"))
	            	};
	            HashMap<String, String>[] availabilities = new HashMap[]{
	                    createAvailabilityMap("2023-12-01 9:00 to 10:00", "", "2023-12-02 14:00 to 16:00", "John Doe <john.doe@edu.univ-eiffel.fr>","2023-12-02 16:00 to 17:00", ""),
	                    createAvailabilityMap("2023-12-03 10:00 to 12:00", "", "2023-12-04 11:00 to 12:00", "Michael Smith <michael.smith@edu.univ-eiffel.fr>"),
	                    createAvailabilityMap("2023-12-05 8:00 to 10:00", "Sophia Williams <sophia.williams@edu.univ-eiffel.fr>", "2023-12-06 9:00 to 11:00", "William Brown <william.brown@edu.univ-eiffel.fr>")
	            };
	            for (int i = 0; i < 3; i++) {
	                Tutor tutor = new Tutor(mails[i], passwords[i], firstNames[i], lastNames[i], ratings[i], rates[i], waitingLists[i], skills[i], availabilities[i]);
	                tutors.add(tutor);
	            }
	            // Create an instance of the server
	            Service tutorService = new Service(tutors);
	            
	            Naming.rebind("TutorService", tutorService);
	            
	            launch(args);
	            System.out.println("TutorServiceServer is running...");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	
}
