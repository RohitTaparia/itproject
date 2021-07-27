import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Doctor {
	 private  int HospitalID;
	 private  String Name;
	 private  String Dept;
	 private  double Fees;
	 private Doctor DoctorArr[]=new Doctor[1000];
	 
	public void buildDoctor(String filename) {
	        File myObj = new File(filename);
	        Scanner myReader;
	        int i = 0;
	        try {
	        	myReader = new Scanner(myObj);
	        	while (myReader.hasNextLine()) {
		            String line = myReader.nextLine();
		            System.out.println(line);
		            
		            String[] parts=line.split(",");
		            Doctor D1 = new Doctor(Integer.parseInt(parts[0]),
		                    parts[1],
		                    parts[2],
		                   Double.parseDouble(parts[3]));
		             
		            DoctorArr[i] = D1;
		            i++;
	        	}
	        }
	        catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	 }
	 public Doctor(int HospitalID,String Name,String Dept,double Fees) {
	        this.Name = Name;
	        this.Dept = Dept;
	        this.Fees = Fees;
	        this.HospitalID = HospitalID;
	   }
	 public String getName() {
			return Name;
		}
	public void setName(String name) {
		Name = name;
	}

	public String getDept() {
		return Dept;
	}

	public void setDept(String dept) {
		Dept = dept;
	}

	public double getFees() {
		return Fees;
	}

	public void setFees(int fees) {
		Fees = fees;
	}

	public int getHospitalID() {
		return HospitalID;
	}

	public Doctor[] getDoctorArr() {
		return DoctorArr;
	}
	
	public void selectDoctor(int index,String dep) {
		for(int i=1;i<27;i++) {
			if(DoctorArr[i].HospitalID==index && DoctorArr[i].Dept.equals(dep)) {
				DoctorArr[i].toString();
			}
		}
	}

	@Override
	public String toString() {
		return "Details of the Doctor:-\nHospitalID: " + HospitalID + "\nName=" + Name + "\nDept=" + Dept + "\nFees=" + Fees;
	}
	public void prescribeMed() {
		//this method needs some modifications. will discuss in meet
	}
}
