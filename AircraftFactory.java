abstract class AircraftFactory {
  public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
    Flyable flyable = null;
    if (type.equals("Helicopter")) {
      Coordinates coordinates = new Coordinates(longitude, latitude, height);
      flyable = new Helicopter(name, coordinates);
    }
    else if (type.equals("Baloon")) {
      Coordinates coordinates = new Coordinates(longitude, latitude, height);
      flyable = new Baloon(name, coordinates);
    }
    else if (type.equals("JetPlane")) {
      Coordinates coordinates = new Coordinates(longitude, latitude, height);
      flyable = new JetPlane(name, coordinates);
    }
    return flyable;
  }
}
