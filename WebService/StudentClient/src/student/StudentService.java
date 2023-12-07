package student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import common.ISServicetudents;
import common.IStudent;

public class StudentService  implements ISServicetudents{
	 List <Student> students=new ArrayList<>();
	 
	 public StudentService(List<Student> students){
		super();
		
		writeStudentsToFile(students,"student_data.txt");
		this.students = students;
		System.out.println("wsolt");
	}
	public StudentService()  {
		super();
		// TODO Auto-generated constructor stub
	}



	public void writeStudentsToFile(List<Student> students, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Student student : students) {
                // Assuming the order of attributes in each line is mail, mdp, fullName, university
                String line = student.getMail() + "/" + student.getMdp() + "/" + student.getFullName() + "/" + student.getUniversity();

                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public void ReadAndAffectData() {
	
		     try (BufferedReader br = new BufferedReader(new FileReader("student_data.txt"))) {
		         String line;
		         while ((line = br.readLine()) != null) {
		             String[] attributes = line.split("/");

		             // Assuming the order of attributes in each line is mail, mdp, fullName, university
		             if (attributes.length == 4) {
		                 String Mail = attributes[0];
		                 String Mdp = attributes[1];
		                 String FullName = attributes[2];
		                 String University = attributes[3];

		                 Student student = new Student(Mail, Mdp, FullName, University);
		                 this.students.add(student);

		             } else {
		                 System.err.println("Invalid data format on line: " + line);
		             }
		         }
		     } catch (IOException e) {
		         e.printStackTrace();
		     }
	}
	public String register(String mail, String mdp,String fullName,String Uni)  {
			// TODO Auto-generated method stub	
		 ReadAndAffectData();
			boolean b=false;
			for(Student st : students) {

				if (st.getMail().equals(mail)&& st.getMdp().equals(mdp)) {
				 	b=true;
				 	return "This account is already existed";
				}

			 }
			if (b==false) {
				Student std = new Student( mail,  mdp, fullName,Uni);

				students.add(std);
				List <Student> studentToADD=new ArrayList<>();
				studentToADD.add(std);
				writeStudentsToFile(studentToADD,"student_data.txt");
				return "Registred succefuly";
			}
			return "";
				
		}
	 public String login(String mail, String mdp) {
			// TODO Auto-generated method stub
		 ReadAndAffectData();
			boolean b=false;
			for(Student st : students) {
			 if (st.getMail().equals(mail)) {
			 	b=true;
			 	return "Login Succesful";
			} }
			if (b==false) {
				return "User Not Found";
			}
			return "";
			
		}
	 public Student retrieveElementt(String mail) {
		 ReadAndAffectData();
			for(Student st : students) {
				 if (st.getMail().equals(mail)) {
					 System.out.println("ahou l9itou");
					 return st;
				} }
			Student tut=new Student();
			return tut ;
		}
}
