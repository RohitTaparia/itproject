import java.util.Scanner;


public class Bill {
    private MedicalRecords medRecord;

    public Bill(MedicalRecords medRecords){
        this.medRecord = medRecords;
    }

    public void generateBill(){
        double docFee = 1000,bill;
        double roomFee = medRecord.getHospital().getCostPerRoom();
        double labTestsCharge=0;
        LabTests[] tests = medRecord.getFineLabTest();
        LabTests[] tests2 = medRecord.getNeedDoctorAttentionTest();

        for(int i=0 ;i <medRecord.getFineLabTest().length;i++){
            labTestsCharge += tests[i].getCost();
        }

        for(int i=0; i<medRecord.getNeedDoctorAttentionTest().length; i++){
            labTestsCharge += tests[i].getCost();
        }

        bill = docFee + roomFee*medRecord.getDoctor().recomStayInHospital() + labTestsCharge;

        bill += (18/100)*bill; 

        System.out.println("---------------Bill Explained---------------\n"+
        "Doctors fee - " + docFee + "\n Room charges(Number of days admitted * charges per day) - " +
        roomFee*medRecord.getDoctor().recomStayInHospital() + "Lab Tests Charges - " + labTestsCharge +
        "Total Bill (Hospital Charges + 18 % GST)" + bill
        );
        
    }

    public boolean isBillPaid(){
        return true;
    }

    public String billPayMode(){
        System.out.println("Choose one of the following: ");
        System.out.println("\n 1. Card \n 2. NetBanking \n 3. Cash \n 4. Cheque \n \n Enter the number here : ");
        Scanner scan1 = new Scanner(System.in);
        int input = scan1.nextInt();
        switch(input){
            case 1:
                return "Card";
            case 2:
                return "NetBanking";
            case 3:
                return "Cash";
            case 4:
                return "Cheque";
            default:
                return "Invalid Input";
        }
    }
}
