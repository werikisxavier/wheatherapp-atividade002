package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private final ArrayList<IObserverLog> observers;
    private Log log = null;

    private ConfigurePresenter() {
        view = new ConfigureView();
        view.setSize(240, 130);
        view.setVisible(false);
        view.setLocation(750, 20);
        observers = new ArrayList<>();
        registerObserver(WeatherDataCollection.getInstance());
        initListeners();
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

    private void initListeners() {
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

                } else if (valorSelecionado.equals("JSON")) {
                    log = JSONLog.getInstance();
                    notifyObservers();

                } else {

                }

            }
        });

    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            IObserverLog ob = observers.get(i);
            ob.update(log);
        }
    }

    @Override
    public final void registerObserver(IObserverLog o) {
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
