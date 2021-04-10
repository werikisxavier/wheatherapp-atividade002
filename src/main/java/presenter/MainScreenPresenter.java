package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.impli.WeatherDataCollection;
import view.MainScreenView;

public class MainScreenPresenter {

    private final MainScreenView view;
    private final WeatherDataCollection collectionData;


    public MainScreenPresenter(WeatherDataCollection collectionData) {
        view = new MainScreenView();
        view.setSize(1082, 610);
        view.setVisible(true);
        this.collectionData = collectionData;
        this.collectionData.registerObserver(LastUpdatePresenter.getInstance());
        this.collectionData.registerObserver(RecordsPresenter.getInstance());
        this.collectionData.registerObserver(AverageDataPresenter.getInstance());
        
        openViews();
        initListeners();

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

    public MainScreenView getView() {
        return view;
    }

    private void openViews() {
        IncludeTimeDataPresenter display1 = IncludeTimeDataPresenter.getInstance(collectionData);
        view.add(display1.getView());
        LastUpdatePresenter display2 = LastUpdatePresenter.getInstance();
        view.add(display2.getView());
        AverageDataPresenter display3 = AverageDataPresenter.getInstance();
        view.add(display3.getView());
        RecordsPresenter display4 = RecordsPresenter.getInstance();
        view.add(display4.getView());
        ConfigurePresenter display5 = ConfigurePresenter.getInstance();
        view.add(display5.getView());

    }

}
