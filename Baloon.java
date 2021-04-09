import java.io.*;

class Baloon extends Aircraft implements Flyable {
  private WeatherTower weatherTower;

  Baloon(String name, Coordinates coordinates) {
      super(name, coordinates);
  }
  @Override
  public void updateConditions() {
    String currentWeather = weatherTower.getWeather(coordinates);
    changeCoord("Baloon", currentWeather);
    if (this.coordinates.getHeight() <= 0) {
      weatherTower.unregister(this);
      try {
        FileWriter myWriter = new FileWriter("simulation.txt", true);
        myWriter.write("Tower says: Baloon#"+this.name+"("+this.id+"): has unregister from the tower and landed at the following coordinates. Latitude: "+this.coordinates.getLatitude()+", Longitude: "+this.coordinates.getLongitude()+", Height: 0\n");
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
