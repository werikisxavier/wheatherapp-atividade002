package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.interfaces.IObserver;
import model.interfaces.ISubject;
import model.WeatherData;
import model.impli.WeatherDataCollection;
import util.DateFormat;
import view.RecordsView;

public class RecordsPresenter implements IObserver, ISubject {
    
    private static RecordsPresenter instence = null;
    private final List<WeatherData> weatherdatas;
    private final ArrayList<IObserver> observers;
    private final RecordsView view;
    private DefaultTableModel tbWeatherDatas;
    private final WeatherDataCollection collectionData;

    private RecordsPresenter(WeatherDataCollection collection) {
        view = new RecordsView();
        view.setSize(660, 224);
        view.setVisible(true);
        view.setLocation(380, 292);
        observers = new ArrayList<>();
        collectionData = collection;
        weatherdatas = collectionData.getWeatherdatas();
        
        registerObserver(AverageDataPresenter.getInstance(collectionData));
        tableInit();
        initListeners();
    }

    public static RecordsPresenter getInstance(WeatherDataCollection collection) {
        if (instence == null) {
            instence = new RecordsPresenter(collection);
        }
        return instence;
    }

    public RecordsView getView() {
        return view;
    }

    private void initListeners() {
        view.getBtRemover().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getTbRecods().getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(view, "Selecione um item para remover!");
                } else {
                    removeItemTable();
                }

            }
        });

    }

    @Override
    public void update(List<WeatherData> weatherdatas) {

        if (weatherdatas != null) {
            clearTable();
            for (WeatherData weatherData : weatherdatas) {
                tbWeatherDatas.addRow(new Object[]{
                    DateFormat.parseDateToString(weatherData.getDate()),
                    weatherData.getTemperature(),
                    weatherData.getHumidity(),
                    weatherData.getPressure()
                });
            }
        }
    }

    private void clearTable() {
        if (tbWeatherDatas.getRowCount() > 0) {
            for (int i = tbWeatherDatas.getRowCount() - 1; i > -1; i--) {
                tbWeatherDatas.removeRow(i);
            }
        }
    }

    private void tableInit() {
        tbWeatherDatas = new DefaultTableModel(
                new Object[][][][]{},
                new String[]{"Data", "Temperatura", "Humidade", "Pressão"}
        );

        view.getTbRecods().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbWeatherDatas.setNumRows(0);

        view.getTbRecods().setModel(tbWeatherDatas);
    }

    private void removeItemTable() {
        List<WeatherData> auxList = new ArrayList<>(collectionData.getWeatherdatas());
        for (int i = 0; i < auxList.size(); i++) {
            if (view.getTbRecods().getSelectedRow() == i) {
                collectionData.removeWeatherData(auxList.get(i));
            }
        }
        notifyObservers();
    }

    @Override
    public final void registerObserver(IObserver o) {
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
}
