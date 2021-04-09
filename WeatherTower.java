public class WeatherTower extends Tower {
  public String getWeather(Coordinates coordinates) {
    if (coordinates != null) {
      return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    } else {
      return null;
    }
  }
  void changeWeather() {
    this.conditionsChanged();
  }
}
