
package model.interfaces;

import model.WeatherData;


public interface Log {
    
    public void write(String operation, WeatherData weatherdata);
    
}
