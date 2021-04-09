//import java.io.File;
import java.util.*;
import java.io.*;

public class Simulator {

  public static int getSimulations(String fileName) {
    File fileObj = new File(fileName);
    try {
      Scanner readObj = new Scanner(fileObj);
      try {
        return Integer.parseInt(readObj.nextLine());
      } catch (NumberFormatException ex) {
        return 0;
      }
    }
    catch (FileNotFoundException ex)
    {
      return 0;
    }
  }

  public static ArrayList<String> readFile(String fileName) {
    ArrayList<String> fileContent = new ArrayList<String>();
    File fileObj = new File(fileName);

    try {
      Scanner readObj = new Scanner(fileObj);

      while (readObj.hasNextLine()) {
        fileContent.add(readObj.nextLine());
      }

      return fileContent;
    }
    catch (FileNotFoundException ex)
    {
      fileContent.add("An error occured");
      return fileContent;
    }
  }
  public static boolean validateFile(ArrayList<String> airCrafts) {
    int x = 1;
    int y = 0;
    String temp;
    String aircraftInfo[];
    boolean checker = true;
    int val;

    while (x < airCrafts.size())
    {
      temp = airCrafts.get(x);
      aircraftInfo = temp.split(" ");
      if (aircraftInfo.length == 5) {
        try {
          val = Integer.parseInt(aircraftInfo[2]);
          if (val < 0) {
            checker = false;
            break;
          }
        } catch(NumberFormatException ex) {
          checker = false;
          break;
        }
        try {
          val = Integer.parseInt(aircraftInfo[3]);
          if (val < 0) {
            checker = false;
            break;
          }
        } catch(NumberFormatException ex) {
          checker = false;
          break;
        }
        try {
          val = Integer.parseInt(aircraftInfo[4]);
          if (val < 0) {
            checker = false;
            break;
          }
        } catch(NumberFormatException ex) {
          checker = false;
          break;
        }
      } else {
        checker = false;
        break;
      }
      x++;
    }
    return checker;
  }
  public static void createAirCrafts(ArrayList<String> airCrafts, WeatherTower weatherTower) {
    int x = 1;
    int y = 0;
    String temp;
    String aircraftInfo[];
    Flyable flyable;

    while (x < airCrafts.size())
    {
      temp = airCrafts.get(x);
      aircraftInfo = temp.split(" ");
      flyable = AircraftFactory.newAircraft(aircraftInfo[0], aircraftInfo[1], Integer.parseInt(aircraftInfo[2]), Integer.parseInt(aircraftInfo[3]), Integer.parseInt(aircraftInfo[4]));
      flyable.registerTower(weatherTower);
      x++;
    }
  }

  public static void runSimulations(WeatherTower weatherTower, int simulations) {
    int x = 0;
    while (x < simulations)
    {
      //Change weather
      //Update the file
      File tmpFile = new File("simulation.txt");
      boolean exists = tmpFile.exists();

      if (exists) {
        try {
          FileWriter myWriter = new FileWriter(tmpFile, true);
            myWriter.write("== Simulation #"+x+" ==\n");
            myWriter.close();
        } catch (IOException e) {
          System.out.println("An error occurred.");
        }
      } else {
        //Create a file
        try {
          tmpFile.createNewFile();
          FileWriter myWriter = new FileWriter(tmpFile, true);
          myWriter.write("== Simulation #"+x+" ==\n");
          myWriter.close();
        } catch (IOException e) {
          System.out.println("An error occurred.");
        }
      }
      weatherTower.changeWeather();
      x++;
    }
  }

  public static void main(String args[])
  {
    int simulations;
    if (args.length == 1) {
      String filePath = args[0];
      ArrayList fileContent;
      Flyable flyable;
      boolean validater = true;

      //get the amount of simulations
      simulations = getSimulations(filePath);
      if (simulations != 0 && simulations >= 1) {
        //parse the file content;
        fileContent = readFile(filePath);
        //validate file file content.
        validater = validateFile(fileContent);
        if (validater == true) {
          //Create weather tower
          WeatherTower weatherTower = new WeatherTower();
          //Create the airCrafts
          createAirCrafts(fileContent, weatherTower);
          //Run simulations
          runSimulations(weatherTower, simulations);
        } else {
          System.out.println("There are format issues in the source file");
        }
      } else {
        System.out.println("An error occured with the file");
      }
    }
    else {
      System.out.println("There must be extacly one argument ...");
    }
  }
}
