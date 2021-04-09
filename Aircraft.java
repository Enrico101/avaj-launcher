import java.util.*;
import java.io.*;

public abstract class Aircraft {
  protected long id;
  protected String name;
  protected Coordinates coordinates;
  private static long idCounter = 0;

  protected Aircraft(String name, Coordinates coordinates) {
    if (name != null && coordinates != null) {
      this.name = name;
      this.coordinates = coordinates;
      this.id = nextId();
    }
  }
  private static long nextId() {
    return Aircraft.idCounter++;
  }

  protected void logWeatherChange(String aircraftType, String weather) {
    File tmpFile = new File("simulation.txt");
    boolean exists = tmpFile.exists();

    if (exists) {
      try {
        FileWriter myWriter = new FileWriter("simulation.txt", true);
        if (aircraftType.equals("Helicopter")) {
          if (weather.equals("RAIN")) {
            myWriter.write("Helicopter#"+this.name+"("+this.id+"): The rain is just awesome.\n");
            myWriter.close();
          } else if (weather.equals("FOG")) {
            myWriter.write("Helicopter#"+this.name+"("+this.id+"): Dude, the fog is just so scary. You cant see where you going.\n");
            myWriter.close();
          } else if (weather.equals("SUN")) {
            myWriter.write("Helicopter#"+this.name+"("+this.id+"): It looks like smooth sailing from here.\n");
            myWriter.close();
          } else {
            myWriter.write("Helicopter#"+this.name+"("+this.id+"): It looks like its going to cold the entire day.\n");
            myWriter.close();
          }
        } else if (aircraftType.equals("Baloon")) {
          if (weather.equals("RAIN")) {
            myWriter.write("Baloon#"+this.name+"("+this.id+"): Im going to get all wet now.\n");
            myWriter.close();
          } else if (weather.equals("FOG")) {
            myWriter.write("Baloon#"+this.name+"("+this.id+"): Some people say the fog is scary, but from view, its awesome.\n");
            myWriter.close();
          } else if (weather.equals("SUN")) {
            myWriter.write("Baloon#"+this.name+"("+this.id+"): The sun is the best gift from God.\n");
            myWriter.close();
          } else {
            myWriter.write("Baloon#"+this.name+"("+this.id+"): Im going to freeze to death up here.\n");
            myWriter.close();
          }
        } else if (aircraftType.equals("JetPlane")) {
          if (weather.equals("RAIN")) {
            myWriter.write("JetPlane#"+this.name+"("+this.id+"): The rain adds atmosphere to my mood.\n");
            myWriter.close();
          } else if (weather.equals("FOG")) {
            myWriter.write("JetPlane#"+this.name+"("+this.id+"): I cant see clearly through these small windows.\n");
            myWriter.close();
          } else if (weather.equals("SUN")) {
            myWriter.write("JetPlane#"+this.name+"("+this.id+"): The sun is just breathtaking. Stay focused on flying the plain.\n");
            myWriter.close();
          } else {
            myWriter.write("JetPlane#"+this.name+"("+this.id+"): Wish i was at home enjoying this miracle mother nature gave us.\n");
            myWriter.close();
          }
        }
      } catch (IOException ex) {
        System.out.println("An error has occured");
      }
    }
  }

  public void changeCoord(String aircraftType, String weather) {
    if (aircraftType.equals("Helicopter")) {
      if (weather.equals("SUN")) {
        logWeatherChange("Helicopter", weather);
        if ((coordinates.getHeight() + 2) >= 100) {
          coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), 100);
        } else {
          coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
        }
      } else if (weather.equals("RAIN")) {
        logWeatherChange("Helicopter", weather);
        coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
      } else if (weather.equals("FOG")) {
        logWeatherChange("Helicopter", weather);
        coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
      } else if (weather.equals("SNOW"))
        logWeatherChange("Helicopter", weather);
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
      } else if (aircraftType.equals("Baloon")) {
      if (weather.equals("SUN")) {
        logWeatherChange("Baloon", weather);
        if ((coordinates.getHeight() + 2) >= 100) {
          coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), 100);
        } else {
          coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
        }
      } else if (weather.equals("RAIN")) {
        logWeatherChange("Baloon", weather);
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
      } else if (weather.equals("FOG")) {
        logWeatherChange("Baloon", weather);
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
      } else if (weather.equals("SNOW")) {
        logWeatherChange("Baloon", weather);
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
      }
    } else if (aircraftType.equals("JetPlane")) {
      if (weather.equals("SUN")) {
        logWeatherChange("JetPlane", weather);
        if ((coordinates.getHeight() + 2) >= 100) {
          coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, 100);
        } else {
          coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
        }
      } else if (weather.equals("RAIN")) {
        logWeatherChange("JetPlane", weather);
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
      } else if (weather.equals("FOG")) {
        logWeatherChange("JetPlane", weather);
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
      } else if (weather.equals("SNOW")) {
        logWeatherChange("JetPlane", weather);
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
      }
    }
  }
}
