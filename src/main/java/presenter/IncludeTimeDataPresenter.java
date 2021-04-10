package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.interfaces.IObserver;
import model.WeatherData;
import model.impli.WeatherDataCollection;
import util.DateFormat;
import view.IncludeTimeDataView;

public class IncludeTimeDataPresenter implements IObserver {

    private static IncludeTimeDataPresenter instence = null;
    private final IncludeTimeDataView view;
    private final WeatherDataCollection collectionData;

    private IncludeTimeDataPresenter(WeatherDataCollection collectionData) {
        view = new IncludeTimeDataView();
        view.setSize(316, 235);
        view.setVisible(true);
        view.setLocation(20, 20);
        this.collectionData = collectionData ;
        initListeners();

    }

    public static IncludeTimeDataPresenter getInstance(WeatherDataCollection collectionData) {
        if (instence == null) {
            instence = new IncludeTimeDataPresenter(collectionData);
        }
        return instence;
    }

    public IncludeTimeDataView getView() {
        return view;
    }

    private void initListeners() {
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

        try {

            if (view.getTfDate().equals("  /  /    ")) {
                throw new NumberFormatException();
            } else {

                weatherData.setMeasurements(
                        Float.parseFloat(view.getTfTemperature()),
                        Float.parseFloat(view.getTfHumidity()),
                        Float.parseFloat(view.getTfPressure()),
                        DateFormat.parseStringToDate(view.getTfDate()));

                collectionData.addWeatherData(weatherData);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Inclusão falhou, prencha todos os campos!");
        }
    }

    private void cleanTextFields() {
        view.setTxTemperature("");
        view.setTxHumidity("");
        view.setTxPressure("");
        view.setTxDate("");
    }

    @Override
    public void update(List<WeatherData> weatherdatas) {

    }

}
