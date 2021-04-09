import java.io.*;

class Helicopter extends Aircraft implements Flyable {
  private WeatherTower weatherTower;

  Helicopter(String name, Coordinates coordinates) {
      super(name, coordinates);
  }
  @Override
  public void updateConditions() {
    //Method will be called when there is an update in the whether conditions.
    String currentWeather = weatherTower.getWeather(coordinates);
    changeCoord("Helicopter", currentWeather);
    if (this.coordinates.getHeight() <= 0) {
      weatherTower.unregister(this);
      try {
        FileWriter myWriter = new FileWriter("simulation.txt", true);
        myWriter.write("Tower says: Helicopter#"+this.name+"("+this.id+"): has unregister from the tower and landed at the following coordinates. Latitude: "+this.coordinates.getLatitude()+", Longitude: "+this.coordinates.getLongitude()+", Height: 0\n");
        myWriter.close();
      } catch (IOException ex) {
        System.out.println(ex);
      }
    }
  }
  @Override
  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
    weatherTower.register(this);
  }
  @Override
  public String getName() {
    return this.name;
  }
  @Override
  public long getID() {
    return this.id;
  }
}
