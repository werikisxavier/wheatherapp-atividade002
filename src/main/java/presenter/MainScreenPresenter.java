package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.impli.WeatherDataCollection;
import view.MainScreenView;

public class MainScreenPresenter {

    private static MainScreenPresenter instence = null;
    private final MainScreenView view;
    private final WeatherDataCollection collectionData;

    private MainScreenPresenter(WeatherDataCollection collection) {
        
        view = new MainScreenView();
        view.setSize(1082, 610);
        view.setVisible(true);
        collectionData = collection;
        collectionData.registerObserver(LastUpdatePresenter.getInstance());
        collectionData.registerObserver(RecordsPresenter.getInstance(collectionData));
        collectionData.registerObserver(AverageDataPresenter.getInstance(collectionData));
        openViews();
        initListeners();
    }

    public static MainScreenPresenter getInstance(WeatherDataCollection collection) {
        if (instence == null) {
            instence = new MainScreenPresenter(collection);
        }
        return instence;
    }

    public MainScreenView getView() {
        return view;
    }

    private void initListeners() {
        view.getItemConfig().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfigurePresenter display5 = ConfigurePresenter.getInstance();
                display5.getView().setVisible(true);
            }
        });

    }

    private void openViews() {
        IncludeTimeDataPresenter display1 = IncludeTimeDataPresenter.getInstance(collectionData);
        view.add(display1.getView());
        LastUpdatePresenter display2 = LastUpdatePresenter.getInstance();
        view.add(display2.getView());
        AverageDataPresenter display3 = AverageDataPresenter.getInstance(collectionData);
        view.add(display3.getView());
        RecordsPresenter display4 = RecordsPresenter.getInstance(collectionData);
        view.add(display4.getView());
        ConfigurePresenter display5 = ConfigurePresenter.getInstance();
        view.add(display5.getView());

    }

}
