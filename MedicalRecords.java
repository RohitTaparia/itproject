public class MedicalRecords {
    
    /**Instance variables -
	Chronic Disease - String
	Hypertension -  Boolean
	Previous Diseases - String
	Hospital - String
	Doctor - String
	Admitted - Boolean
	FineLabtest - array LabTest
	NeedDoctorAttentionLabtest - array LabTest

Instance Methods-  
	getChronicDisease
	getHypertension
	getPreviousDisease
	setChronicDisease
	setHypertension
 */
    private String chronicDisease;
    private boolean hyperTension;
    private String previousDisease;
    private Hospital hospital;
    private Doctor doctor;
    private boolean admitted;
    private LabTests[] fineLabTest;
    private LabTests[] needDoctorAttentionTest;

    public MedicalRecords(String chronicDisease , boolean hyperTension , String previousDisease){
    	this.chronicDisease = chronicDisease;
    	this.hyperTension = hyperTension;
    	this.previousDisease = previousDisease;
	}

	public String getChronicDisease() {
		return chronicDisease;
	}

	public void setChronicDisease(String chronicDisease) {
		this.chronicDisease = chronicDisease;
	}

	public boolean isHyperTension() {
		return hyperTension;
	}

	public void setHyperTension(boolean hyperTension) {
		this.hyperTension = hyperTension;
	}

	public String getPreviousDisease() {
		return previousDisease;
	}

	public void setPreviousDisease(String previousDisease) {
		this.previousDisease = previousDisease;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String isAdmitted() {
		return admitted?"yes":"no";
	}

	public void setAdmitted(boolean admitted) {
		this.admitted = admitted;
	}
	
	public boolean isBolAdmitted() {
        return admitted ? true : false;
        }

	public LabTests[] getFineLabTest() {
		return fineLabTest;
	}

	public void setFineLabTest(LabTests[] fineLabTest) {
		this.fineLabTest = fineLabTest;
	}

	public LabTests[] getNeedDoctorAttentionTest() {
		return needDoctorAttentionTest;
	}

	public void setNeedDoctorAttentionTest(LabTests[] needDoctorAttentionTest) {
		this.needDoctorAttentionTest = needDoctorAttentionTest;
	}

	public String toString(){
		return "Chronic Disease: \n" + chronicDisease + "\n" +
		"PreviousDisease: \n" + previousDisease  + "\n" +
		hospital + "\n" + 
		doctor + "\n" +
		"Admitted: " + isAdmitted() + "\n" + 
		"FineLabtest: \n" + fineLabTest + "\n" +
		"NeedDoctorAttentionLabtest: \n" + needDoctorAttentionTest + "\n";
	}
}
