package presenter;

import java.util.List;
import model.interfaces.IObserver;
import model.WeatherData;
import util.DateFormat;
import view.LastUpdateView;

public class LastUpdatePresenter implements IObserver {

    private static LastUpdatePresenter instence = null;
    private final LastUpdateView view;

    private LastUpdatePresenter() {
        view = new LastUpdateView();
        view.setSize(300, 200);
        view.setVisible(true);
        view.setLocation(20, 280);

    }

    public static LastUpdatePresenter getInstance() {
        if (instence == null) {
            instence = new LastUpdatePresenter();
        }
        return instence;
    }

    public LastUpdateView getView() {
        return view;
    }

    @Override
    public void update(List<WeatherData> weatherdatas) {
        if (weatherdatas.isEmpty()) {
            view.setTxTemperature("TEMPERATURA");
            view.setTxHumidity("HUMIDADE");
            view.setTxPressure("PRESSÃO");
            view.setTxDate("DD/MM/AAAA");
        } else {
            WeatherData weatherData = weatherdatas.get(weatherdatas.size() - 1);

            view.setTxTemperature(String.valueOf(weatherData.getTemperature()));
            view.setTxHumidity(String.valueOf(weatherData.getHumidity()));
            view.setTxPressure(String.valueOf(weatherData.getPressure()));
            view.setTxDate(DateFormat.parseDateToString(weatherData.getDate()));
        }
    }

}
