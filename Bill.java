public class Bill {
    private MedicalRecords medRecord;

    public Bill(MedicalRecords medRecords){
        this.medRecord = medRecords;
    }

    public double generateBill(){
        double docFee = medRecord.getDoctor().getFees();
        double roomFee = medRecord.getHospital().getCostPerRoom();
        double labTestsCharge=0;
        LabTests[] tests = medRecord.getFineLabTest();
        for(int i=0 ;i <medRecord.getFineLabTest().length;i++){
            labTestsCharge += tests[i]. 

        }

        return bill;
    }
}
