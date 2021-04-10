package model.impli;

import java.util.List;
import model.interfaces.CalculateAverage;
import model.WeatherData;

public class Daily implements CalculateAverage {

    private static Daily instence = null;
    
    private Daily() {
    }

    public static Daily getInstance() {
        if (instence == null) {
            instence = new Daily();
        }
        return instence;
    }
    
    @Override
    public float calculateTemperature(List<WeatherData> weatherdatas) {
        float temperature = 0;
        for (WeatherData weatherdata : weatherdatas) {
            temperature += weatherdata.getHumidity();
        }
        return temperature / weatherdatas.size();

    }

    @Override
    public float calculateHumidity(List<WeatherData> weatherdatas) {
        float humidity = 0;
        for (WeatherData weatherdata : weatherdatas) {
            humidity += weatherdata.getHumidity();
        }
        return humidity / weatherdatas.size();
    }

    @Override
    public float calculatePressure(List<WeatherData> weatherdatas) {
        float pressure = 0;
        for (WeatherData weatherdata : weatherdatas) {
            pressure += weatherdata.getHumidity();
        }
        return pressure / weatherdatas.size();
    }

}
