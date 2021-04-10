
package model.impli;

import java.util.List;
import model.interfaces.CalculateAverage;
import model.WeatherData;

public class Weekly implements CalculateAverage {
    
    private static Weekly instence = null;
    
    private Weekly() {
    }

    public static Weekly getInstance() {
        if (instence == null) {
            instence = new Weekly();
        }
        return instence;
    }

    @Override
    public float calculateTemperature(List<WeatherData> weatherdatas) {
        float temperature = 0;
        for (WeatherData weatherdata : weatherdatas) {
            temperature += weatherdata.getHumidity();
        }
        return temperature / 7;

    }

    @Override
    public float calculateHumidity(List<WeatherData> weatherdatas) {
        float humidity = 0;
        for (WeatherData weatherdata : weatherdatas) {
            humidity += weatherdata.getHumidity();
        }
        return humidity / 7;
    }

    @Override
    public float calculatePressure(List<WeatherData> weatherdatas) {
        float pressure = 0;
        for (WeatherData weatherdata : weatherdatas) {
            pressure += weatherdata.getHumidity();
        }
        return pressure / 7;
    }

}
