package Graded.ITproject;

import java.io.*;
import java.util.Scanner;

public class Room {
    private final int ID;
    private final String name;
    private int noOfRooms;

    public Room(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getNoOfRooms(String File) throws FileNotFoundException {
        String[] rms = this.getHospital(File).getRooms().split("-");
        this.noOfRooms = Integer.parseInt(rms[0]);
        return Integer.parseInt(rms[0]);
    }

    public Hospital getHospital(String File) throws FileNotFoundException {
        PatientMapping p1 = new PatientMapping();
        p1.HospitalBuilder(File);
        int i;
        for (i = 0; i < p1.getTotalHospitals(); i++) {
            if (p1.getHspArray()[i].getID() == this.ID) {
                return p1.getHspArray()[i];
            }
        }
        return p1.getHspArray()[i];
    }

    public int generateRoom(String File) throws IOException {
        int roomAlloted = ((int) (Math.random() * this.getNoOfRooms(File))) + 1;
        String[] rms = this.getHospital(File).getRooms().split("-");
        if (rms.length == Integer.parseInt(rms[0]) + 1) {
            System.out.println("There are no rooms left unoccupied");
            return 0;
        }
        for (int i = 1; i < rms.length; i++) {
            if (roomAlloted == Integer.parseInt(rms[i])) {
                return this.generateRoom(File);
            }
        }
        this.appendFile(roomAlloted, File);
        return roomAlloted;
    }

    public void appendFile(int roomNo, String File) throws IOException {

        //Instantiating the File class
        String filePath = File;
        //Instantiating the Scanner class to read the file
        Scanner sc = new Scanner(new File(filePath));
        //instantiating the StringBuffer class
        StringBuffer buffer = new StringBuffer();
        String oldLine = " ";
        //Reading lines of the file and appending them to StringBuffer
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine() + System.lineSeparator());
        }
        File myObj = new File(File);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();

            if (line.contains(this.getHospital(File).getName())) {
                oldLine = line;
            }
        }
        String fileContents = buffer.toString();

        //closing the Scanner object
        sc.close();
        System.out.println(oldLine);
        String newLine = oldLine + roomNo + "-";
        System.out.println(newLine);
        //Replacing the old line with new line
        fileContents = fileContents.replace(oldLine, newLine);
        //instantiating the FileWriter class
        FileWriter writer = new FileWriter(filePath);
        System.out.println("");
        System.out.println("new data: " + fileContents);
        writer.append(fileContents);
        writer.flush();
    }


    public static void main(String[] args) throws IOException {
        Room r1 = new Room(21, "Rockland Hospital");
        System.out.println(r1.generateRoom("C:\\Users\\Praveen Raj HL\\Desktop/ITproject.txt"));


    }
}
