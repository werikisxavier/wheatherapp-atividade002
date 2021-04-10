package presenter;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JOptionPane;
import model.interfaces.CalculateAverage;
import model.impli.Daily;
import model.interfaces.IObserver;
import model.impli.Monthly;
import model.WeatherData;
import model.impli.WeatherDataCollection;
import model.impli.Weekly;
import view.AverageDataView;

public class AverageDataPresenter implements IObserver {

    private static AverageDataPresenter instence = null;
    private final AverageDataView view;
    private final WeatherDataCollection collectionData;
    private final List<WeatherData> weatherdatas;

    private AverageDataPresenter(WeatherDataCollection collection) {
        view = new AverageDataView();
        view.setSize(300, 220);
        view.setVisible(true);
        view.setLocation(380, 20);
        collectionData = collection;
        weatherdatas = collectionData.getWeatherdatas();
        initListeners();

    }

    public static AverageDataPresenter getInstance(WeatherDataCollection collection) {
        if (instence == null) {
            instence = new AverageDataPresenter(collection);
        }
        return instence;
    }

    public AverageDataView getView() {
        return view;
    }

    private void initListeners() {

        view.getCbPeriod().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String valorSelecionado = e.getItem().toString();
                    switch (valorSelecionado) {
                        case "Diario":
                            Daily daily = Daily.getInstance();
                            calculateAverage(daily);
                            break;
                        case "Semanal":
                            Weekly weekly = Weekly.getInstance();
                            calculateAverage(weekly);
                            break;
                        case "Mensal":
                            Monthly monthly = Monthly.getInstance();
                            calculateAverage(monthly);
                            break;
                        default:
                            JOptionPane.showMessageDialog(view, "Opção incorreta!");
                            break;
                    }
                }

            }
        });
    }

    private void calculateAverage(CalculateAverage calc) {
        float temperature = calc.calculateTemperature(weatherdatas);
        float humidity = calc.calculateHumidity(weatherdatas);
        float pressure = calc.calculatePressure(weatherdatas);
        update(temperature, humidity, pressure);
    }

    private void resetTextFields() {
        view.setTxTemperatureMed("TEMPERATURA");
        view.setTxHumidityMed("HUMIDADE");
        view.setTxPressureMed("PRESSÃO");
        view.setTxNumberRecordMed("NRO REGISTROS");
    }

    private void update(float temperature, float humidity, float pressure) {

        if (weatherdatas.isEmpty()) {
            resetTextFields();
        } else {
            view.setTxTemperatureMed(String.valueOf(temperature));
            view.setTxHumidityMed(String.valueOf(humidity));
            view.setTxPressureMed(String.valueOf(pressure));
            view.setTxNumberRecordMed(String.valueOf(weatherdatas.size()));
        }
    }

    @Override
    public void update(List<WeatherData> weatherdatas) {
        resetTextFields();
    }

}
