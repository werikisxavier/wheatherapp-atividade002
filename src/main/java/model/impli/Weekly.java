/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.impli;

import java.util.List;
import model.interfaces.CalculateAverage;
import model.WeatherData;

/**
 *
 * @author W-E-R
 */
public class Weekly implements CalculateAverage {

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
