import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class Doctor {
    private  int HospitalID;
    private  String Name;
    private  String Dept;
    private  Double Fees;


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

    public int getHospitalID() {
        return HospitalID;
    }





    @Override
    public String toString() {
        return "Details of the Doctor:-\nHospitalID: " + HospitalID + "\nName=" + Name + "\nDept=" + Dept + "\nFees=" + Fees;
    }
    public void prescribeMed() {
        //this method needs some modifications. will discuss in meet
    }

    public int recomStayInHospital(){
        return (int)(28*Math.random());
    }
}
