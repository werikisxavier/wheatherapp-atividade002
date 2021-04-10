package model;

import java.util.Date;
import java.util.Objects;

public class WeatherData {

    private float temperature;
    private float humidity;
    private float pressure;
    private Date date;

    public WeatherData() {

    }

    public void setMeasurements(float t, float h, float p, Date date) {
        this.temperature = t;
        this.humidity = h;
        this.pressure = p;
        this.date = date;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public Date getDate() {
        return date;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WeatherData other = (WeatherData) obj;
        if (Float.floatToIntBits(this.temperature) != Float.floatToIntBits(other.temperature)) {
            return false;
        }
        if (Float.floatToIntBits(this.humidity) != Float.floatToIntBits(other.humidity)) {
            return false;
        }
        if (Float.floatToIntBits(this.pressure) != Float.floatToIntBits(other.pressure)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }
    
    
    

}
