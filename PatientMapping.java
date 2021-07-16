import java.io.*;


public class PatientMapping {
   private static Location location=new Location(12.98762137807232, 77.56866140167492);

    public static void main(String[] args) {
        try {
            File file=new File("/home/lohith/IdeaProjects/gui/src/hospital.txt");
            BufferedReader br =new BufferedReader(new FileReader((file)));
            String st;
            String[] hpid = new String[58];
            String[] hname=new String[58];
            String[] latlong=new String[58];
            int j=0;
            while ((st=br.readLine())!= null) {
                String[] arr=st.split(",");
                hpid[j]=arr[0];
                hname[j]=arr[3];
                latlong[j]=arr[1]+","+arr[2];
                j++;
            }
            br.close();
            String s=getlist.list(location);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
