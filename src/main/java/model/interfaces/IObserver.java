
package model.interfaces;

import java.util.List;
import model.WeatherData;


public interface IObserver {
     public void update(List<WeatherData> weatherdatas);
}
