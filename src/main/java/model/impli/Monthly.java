package model.impli;

import java.util.List;
import model.interfaces.CalculateAverage;
import model.WeatherData;

public class Monthly implements CalculateAverage {

    private static Monthly instence = null;

    private Monthly() {
    }

    public static Monthly getInstance() {
        if (instence == null) {
            instence = new Monthly();
        }
        return instence;
    }

    @Override
    public float calculateTemperature(List<WeatherData> weatherdatas) {
        float temperature = 0;
        for (WeatherData weatherdata : weatherdatas) {
            temperature += weatherdata.getHumidity();
        }
        return temperature / 30;

    }

    @Override
    public float calculateHumidity(List<WeatherData> weatherdatas) {
        float humidity = 0;
        for (WeatherData weatherdata : weatherdatas) {
            humidity += weatherdata.getHumidity();
        }
        return humidity / 30;
    }

    @Override
    public float calculatePressure(List<WeatherData> weatherdatas) {
        float pressure = 0;
        for (WeatherData weatherdata : weatherdatas) {
            pressure += weatherdata.getHumidity();
        }
        return pressure / 30;
    }
}
