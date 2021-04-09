public class WeatherProvider {
  private static WeatherProvider weatherProvider;
  private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

  private WeatherProvider() {}
  public static WeatherProvider getProvider() {
    if (weatherProvider == null)
    {
      weatherProvider = new WeatherProvider();
    }
    return weatherProvider;
  }
  public String getCurrentWeather(Coordinates coordinates) {
    if (coordinates != null) {
      int condition = (coordinates.getLongitude() + coordinates.getHeight() + coordinates.getLatitude()) % 20;
      if (condition < 5)
        return weather[0];
      else if (condition < 10)
        return weather[1];
      else if (condition < 15)
        return weather[2];
      else
        return weather[3];
    } else {
      return null;
    }
  }
}
