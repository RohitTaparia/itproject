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
    
}
