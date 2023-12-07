package serverApp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import common.ITutor;
import common.IService;

public class Service extends UnicastRemoteObject implements IService{
	 List <Tutor> Tutors;
	 
	public Service(List<Tutor> tutors) throws RemoteException  {
		super();
		Tutors = tutors;
	}

	public Service() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String register(String mail, String mdp,String firstname, String lastname) throws RemoteException {
		// TODO Auto-generated method stub	
		boolean b=false;
		for(Tutor t : Tutors) {
		 if (t.getMail().equals(mail)&& t.getMdp().equals(mdp)) {
		 	b=true;
		 	return "This account is already existed";
		} }
		if (b==false) {
			Tutor tut = new Tutor( mail,  mdp, firstname,  lastname);
			Tutors.add(tut);
			return "Registred succefuly";
		}
		return "";
			
	}

	@Override
	public List<ITutor> lookTByName(String firstname, String lastname) throws RemoteException {
		// TODO Auto-generated method stub
		List TutorsList = new ArrayList<Tutor>();
		for(Tutor t : Tutors) {
		 if (t.getFirstname().equals(firstname)&& t.getLastname().equals(lastname))
			 TutorsList.add(t);
		} 
		if (TutorsList.isEmpty()) {System.out.println("There isn't a tutor with this name");}
		return TutorsList;
	}
	@Override
	public List<ITutor> lookTByFirstName(String firstname) throws RemoteException {
		// TODO Auto-generated method stub
		List TutorsList = new ArrayList<Tutor>();
		for(Tutor t : Tutors) {
		 if (t.getFirstname().equals(firstname))
			 TutorsList.add(t);
		} 
		if (TutorsList.isEmpty()) {System.out.println("There isn't a tutor with this first name");}
		return TutorsList;
	}
	@Override
	public List<ITutor> lookTByLastName(String lastname) throws RemoteException {
		// TODO Auto-generated method stub
		List TutorsList = new ArrayList<Tutor>();
		for(Tutor t : Tutors) {
		 if (t.getLastname().equals(lastname))
			 TutorsList.add(t);
		} 
		if (TutorsList.isEmpty()) {System.out.println("There isn't a tutor with this last name");}
		return TutorsList;
	}

	public List<ITutor> getAllTutors() throws RemoteException {
		List TutorsList = new ArrayList<Tutor>();
		TutorsList=Tutors;
		return TutorsList;
	}

	@Override
	public List<ITutor> lookTBySkill(String skill) throws RemoteException {
		// TODO Auto-generated method stub
		List TutorsList = new ArrayList<Tutor>();
		for(Tutor t : Tutors) {
			for(String s : t.getSkills()) {
				 if (s.equals(skill))
					 TutorsList.add(t);
				} 
		}
		if (TutorsList.isEmpty()) {System.out.println("There isn't a tutor with this skill");}
		return TutorsList;
	}

	@Override
	public String login(String mail, String mdp) throws RemoteException {
		// TODO Auto-generated method stub
		boolean b=false;
		for(Tutor t : Tutors) {
		 if (t.getMail().equals(mail)&& t.getMdp().equals(mdp)) {
		 	b=true;
		 	return "Login Succesful";
		} }
		if (b==false) {
			return "User Not Found";
		}
		return "";
		
	}
	public ITutor retrieveElement(String mail) throws RemoteException {
		for(Tutor t : Tutors) {
			 if (t.getMail().equals(mail))
				 return t;
			} 
		Tutor tut=new Tutor();
		return tut ;
	}
	@Override
	public String bookAppointment(String mail, String student, String apt) throws RemoteException {
	    // TODO: Implement lookTByName method


	    if (!retrieveElement(mail).getMail().equals("")) {
	    	
	    	HashMap< String,String > av = retrieveElement(mail).getAvailability();

	        if (av.containsKey(apt)) {
	    		//System.out.println("hiha33");
	            String studentName = av.get(apt);
	    		//System.out.println("hiha33");
	            if (studentName.equals("")) {
	                // If the student name is empty, remove the entry with an empty student name and add a new one
	                av.remove(apt);
	                av.put(apt, student);
	                retrieveElement(mail).setAvailability(av);
	                //System.out.println(retrieveElement(firstName,lastName).getAvailibality().toString());
	                return "Appointement Booked.";
	            } else {
	                List<String> waitingList = retrieveElement(mail).getWaitingList();
		            List<String> newWaitingList = new ArrayList<>(waitingList);
		            newWaitingList.add(student);
		            retrieveElement(mail).setWaitingList(newWaitingList);
	                retrieveElement(mail).setWaitingList(waitingList);
	                return "You are on the waiting list.";
	            }
	        } else {
	            List<String> waitingList = retrieveElement(mail).getWaitingList();
	            List<String> newWaitingList = new ArrayList<>(waitingList);
	            newWaitingList.add(student);
	            retrieveElement(mail).setWaitingList(newWaitingList);
	            return "You are on the waiting list.";
	        }
	    } else {
	        return "Tutor not found.";
	    }
	}
	public void FeedBack(String feedback, String mail) throws RemoteException ,IOException {
	    // TODO: Implement lookTByName method
		String apiKey = "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";

        // API endpoint URL
        String apiUrl = "https://api-inference.huggingface.co/models/nlptown/bert-base-multilingual-uncased-sentiment";

        // JSON payload for the API request
        String jsonInput = "{\"inputs\": [\"" + feedback + "\"]}";

        // Create URL object
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to POST
        connection.setRequestMethod("POST");

        // Set request headers
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + apiKey);

        // Enable input/output streams
        connection.setDoOutput(true);

        // Write the JSON payload to the request
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInput.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Get the response code
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Read the response
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Response: " + response.toString());
            parseJsonResponse(response.toString());
         // Define the pattern for extracting the number
            Pattern pattern = Pattern.compile("\\d+");

            // Create a matcher object
            Matcher matcher = pattern.matcher(response.toString());
            double rating=0.0;
            // Check if the pattern is found
            if (matcher.find()) {
                // Extract the matched number
                String numberStr = matcher.group();

                // Convert the string to an integer
                 rating = Integer.parseInt(numberStr);}
            double moy= (retrieveElement(mail).getRating()* retrieveElement(mail).getNbFeedback() + rating)/(retrieveElement(mail).getNbFeedback()+1);
            retrieveElement(mail).setNbFeedback((retrieveElement(mail).getNbFeedback()+1));
            retrieveElement(mail).setRating(moy);
            
        }

        // Close the connection
        connection.disconnect();
    
	}
	public void parseJsonResponse(String string) {
		// TODO Auto-generated method stub

		try {
            // Use regular expressions to extract label and score
            Pattern pattern = Pattern.compile("\\{\"label\":\"([^\"]+)\",\"score\":([0-9\\.]+)\\}");
            Matcher matcher = pattern.matcher(string);

            double maxScore = Double.MIN_VALUE;
            String highestLabel = "";

            while (matcher.find()) {
                String label = matcher.group(1);
                double score = Double.parseDouble(matcher.group(2));

                if (score > maxScore) {
                    maxScore = score;
                    highestLabel = label;
                }
            }

            System.out.println("Highest Label: " + highestLabel);

        } catch (Exception e) {
            e.printStackTrace();
        }
	}


}
