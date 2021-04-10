package model.interfaces;

import java.util.List;
import model.WeatherData;

public interface CalculateAverage {

     public float calculateTemperature(List<WeatherData> weatherdatas);
     public float calculateHumidity(List<WeatherData> weatherdatas);
     public float calculatePressure(List<WeatherData> weatherdatas);
     
     
}
