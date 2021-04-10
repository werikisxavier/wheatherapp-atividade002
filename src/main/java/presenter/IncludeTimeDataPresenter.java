package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.interfaces.IObserver;
import model.WeatherData;
import model.impli.WeatherDataCollection;
import model.interfaces.Log;
import util.DateFormat;
import view.IncludeTimeDataView;

public class IncludeTimeDataPresenter implements IObserver {

    private static IncludeTimeDataPresenter instence = null;
    private final IncludeTimeDataView view;
    private final WeatherDataCollection collectionData;
    //private final Log log;

    private IncludeTimeDataPresenter() {
        view = new IncludeTimeDataView();
        view.setSize(316, 235);
        view.setVisible(true);
        view.setLocation(20, 20);
        collectionData = WeatherDataCollection.getInstance();
        initListeners();
        
        
    }

   private void initListeners(){
        view.getBtInclude().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                include();
                cleanTextFields();
            } 
        });
        
        view.getBtCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanTextFields();
            }
        });
    }
    
    private void include() {
        WeatherData weatherData = new WeatherData();

        weatherData.setMeasurements(
                Float.parseFloat(view.getTfTemperature()),
                Float.parseFloat(view.getTfHumidity()),
                Float.parseFloat(view.getTfPressure()),
                DateFormat.parseStringToDate(view.getTfDate()));

        collectionData.addWeatherData(weatherData);
        JOptionPane.showMessageDialog(view, "Success, weather data included!");
    }

    private void cleanTextFields() {
        view.setTxTemperature("");
        view.setTxHumidity("");
        view.setTxPressure("");
        view.setTxDate("");
    }

    public static IncludeTimeDataPresenter getInstance() {
        if (instence == null) {
            instence = new IncludeTimeDataPresenter();
        }
        return instence;
    }

    public IncludeTimeDataView getView() {
        return view;
    }

    @Override
    public void update(List<WeatherData> weatherdatas) {

    }

}
