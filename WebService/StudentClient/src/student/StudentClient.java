package student;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.*;
import common.IService;
import common.ITutor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class StudentClient extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/register.fxml"));
        Parent root = loader.load();

        // Set up the scene
        Scene scene = new Scene(root);

        // Set up the stage
        primaryStage.setTitle("Student Mangement Application");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	public static void main(String[] args) {
		try {
			List<Student> students = new ArrayList<>();

        // Real data for three students
        String[] mails = {
            "heni.walha@edu.univ-eiffel.fr",
            "emma.johnson@edu.univ-eiffel.fr",
            "michael.smith@edu.univ-eiffel.fr"
        };
        String[] passwords = {"heni123", "emma456", "michael789"};
        String[] fullNames = {
            "Heni Walha",
            "Emma Johnson",
            "Michael Smith"
        };

        for (int i = 0; i < 3; i++) {
           
                Student student = new Student(mails[i], passwords[i], fullNames[i], "Gustave Eiffel");
                students.add(student);}
        
        StudentService studentService = new StudentService(students);
        //IService tuts = (IService) Naming.lookup("rmi://localhost/TutorService");
        //System.out.println(tuts.bookAppointment("alice.smith@univ-eiffel.fr", "hiha3", "2023-12-01 9:00 to 10:00"));
		launch(args);
		 }
		 catch (Exception e) {
		 System.out.println("Trouble " + e);
		 }
		 }
}
