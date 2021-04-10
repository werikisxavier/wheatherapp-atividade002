package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private IncludeTimeDataPresenter(WeatherDataCollection collection) {
        view = new IncludeTimeDataView();
        view.setSize(316, 235);
        view.setVisible(true);
        view.setLocation(20, 20);
        this.collectionData = collection ;
        initListeners();

    }

    public static IncludeTimeDataPresenter getInstance(WeatherDataCollection collection) {
        if (instence == null) {
            instence = new IncludeTimeDataPresenter(collection);
        }
        return instence;
    }

    public IncludeTimeDataView getView() {
        return view;
    }

    private void initListeners()  {
        view.getBtInclude().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    include();
                    cleanTextFields();
                } catch (ParseException ex) {
                    Logger.getLogger(IncludeTimeDataPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        view.getBtCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cleanTextFields();
            }
        });
    }

    private void include() throws ParseException {
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
