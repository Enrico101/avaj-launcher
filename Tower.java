import java.util.*;
import java.io.*;

public abstract class Tower {
  private ArrayList<Flyable> observers = new ArrayList<Flyable>();

  private static void updateSimFile(String type, Flyable flyable, String logType) {
    //Update the file
    File tmpFile = new File("simulation.txt");
    boolean exists = tmpFile.exists();

    if (exists) {
      try {
        FileWriter myWriter = new FileWriter(tmpFile, true);
        if (logType.equals("register")) {
          myWriter.write("Tower says: "+type+"#"+flyable.getName()+"("+flyable.getID()+"): registered to weather tower.\n");
          myWriter.close();
        } else if (logType.equals("unregister")) {
          myWriter.write("Tower says: "+type+"#"+flyable.getName()+"("+flyable.getID()+"): unregistered to weather tower.\n");
          myWriter.close();
        }
      } catch (IOException e) {
        System.out.println("An error occurred.");
      }
    } else {
      //Create a file
      try {
        tmpFile.createNewFile();
        FileWriter myWriter = new FileWriter(tmpFile, true);
        if (logType.equals("register")) {
          myWriter.write("Tower says: Baloon#"+flyable.getName()+"("+flyable.getID()+"): has registered from the Tower.\n");
          myWriter.close();
        } else if (logType.equals("unregister")) {
          myWriter.write("Tower says: Baloon#"+flyable.getName()+"("+flyable.getID()+"): has unregistered from the Tower.\n");
          myWriter.close();
        }
      } catch (IOException e) {
        System.out.println("An error occurred.");
      }
    }
  }

  public void register(Flyable flyable) {
    if (flyable != null)
    {
      char ch1 = flyable.getName().charAt(0);
      if (ch1 == 'B') {
        updateSimFile("Baloon", flyable, "register");
      }
      else if (ch1 == 'J') {
        updateSimFile("JetPlane", flyable, "register");
      }
      else if (ch1 == 'H') {
        updateSimFile("Helicopter", flyable, "register");
      }
      observers.add(flyable);
    }
  }
  public void unregister(Flyable flyable) {
    //unregisters aircraft from tower
    if (flyable != null)
    {
      char ch1 = flyable.getName().charAt(0);
      if (ch1 == 'B') {
        updateSimFile("Baloon", flyable, "unregister");
      }
      else if (ch1 == 'J') {
        updateSimFile("JetPlane", flyable, "unregister");
      }
      else if (ch1 == 'H') {
        updateSimFile("Helicopter", flyable, "unregister");
      }
      observers.remove(flyable);
    }
  }
  protected void conditionsChanged() {
    int x = 0;

    while (x < observers.size()) {
      observers.get(x).updateConditions();
      x++;
    }
  }
}
