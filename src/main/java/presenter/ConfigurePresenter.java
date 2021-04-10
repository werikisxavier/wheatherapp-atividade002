package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.List;
import javax.swing.JOptionPane;
import model.WeatherData;
import model.impli.JSONLog;
import model.impli.WeatherDataCollection;
import model.impli.XMLLog;

import model.interfaces.IObserverLog;
import model.interfaces.ISubjectLog;
import model.interfaces.Log;
import view.ConfigureView;

public class ConfigurePresenter implements ISubjectLog {

    private static ConfigurePresenter instence = null;
    private final ConfigureView view;
    private final WeatherDataCollection collectionData;
    private final ArrayList<IObserverLog> observers;
    private final List<WeatherData> weatherdatas;
    private Log log = null;

    private ConfigurePresenter() {
        view = new ConfigureView();
        view.setSize(240, 130);
        view.setVisible(false);
        view.setLocation(750, 20);
        observers = new ArrayList<>();
        collectionData = WeatherDataCollection.getInstance();
        weatherdatas = collectionData.getWeatherdatas();
        registerObserver(WeatherDataCollection.getInstance());

        initListeners();

    }

    public void initListeners() {
        view.getBtClose().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
            }
        });

        view.getBtSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String valorSelecionado = (String) view.getCbLog().getSelectedItem();

                if (valorSelecionado.equals("XML")) {
                    log = XMLLog.getInstance();
                    notifyObservers();
                    JOptionPane.showMessageDialog(view, "Configuração Log definida: XML");
                } else if (valorSelecionado.equals("JSON")) {
                    log = JSONLog.getInstance();
                    notifyObservers();
                    JOptionPane.showMessageDialog(view, "Configuração Log definida: JSON");
                } else {

                }

            }
        });

    }

    public static ConfigurePresenter getInstance() {
        if (instence == null) {
            instence = new ConfigurePresenter();
        }
        return instence;
    }

    public ConfigureView getView() {
        return view;
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            IObserverLog ob = observers.get(i);
            ob.update(log);
        }
    }

    @Override
    public void registerObserver(IObserverLog o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(IObserverLog o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(o);
        }
    }

}
