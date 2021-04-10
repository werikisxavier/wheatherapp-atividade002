package model.impli;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import model.interfaces.IObserver;
import model.interfaces.ISubject;
import model.WeatherData;
import model.interfaces.IObserverLog;
import model.interfaces.Log;

public class WeatherDataCollection implements ISubject,IObserverLog {

    private static WeatherDataCollection instence = null;
    private final ArrayList<WeatherData> weatherdatas;
    private ArrayList<IObserver> observers;
    private Log log = null;

    private WeatherDataCollection() {
        weatherdatas = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static WeatherDataCollection getInstance() {
        if (instence == null) {
            instence = new WeatherDataCollection();
        }
        return instence;
    }

    public void addWeatherData(WeatherData weatherdata) {
        if(log == null){
        JOptionPane.showMessageDialog(null, "É necessário que o Log do sistema esteja configurado!");
        }else{
        weatherdatas.add(weatherdata);
        notifyObservers();
        log.escreve("Inclusão" ,weatherdata);
        JOptionPane.showMessageDialog(null, "Sucesso, dado de tempo incluso!");
        }
    }

    public void removeWeatherData(WeatherData weatherdata) {
        weatherdatas.remove(weatherdata);
        notifyObservers();
        log.escreve("Remocão", weatherdata);
    }

    public List<WeatherData> getWeatherdatas() {
        return Collections.unmodifiableList(weatherdatas);
    }

    @Override
    public void registerObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            IObserver ob = observers.get(i);
            ob.update(Collections.unmodifiableList(weatherdatas));
        }
    }

    @Override
    public void update(Log log) {
        this.log=log;
        JOptionPane.showMessageDialog(null, "Configuração Log definida com sucesso!");
    }


}
