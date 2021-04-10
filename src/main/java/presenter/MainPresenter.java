package presenter;

import model.impli.WeatherDataCollection;
import view.MainView;

public class MainPresenter {

    private static MainPresenter instence = null;
    private final MainView view;
    private final WeatherDataCollection collectionData;

    private MainPresenter(WeatherDataCollection collection) {
        view = new MainView();
        collectionData = collection;
        MainScreenPresenter display = MainScreenPresenter.getInstance(collectionData);
        view.add(display.getView());
        view.setLocationRelativeTo(view.getParent());
        view.setSize(1100, 650);
        view.setVisible(true);
    }

    public static MainPresenter getInstance(WeatherDataCollection collection) {
        if (instence == null) {
            instence = new MainPresenter(collection);
        }
        return instence;
    }
    
        public MainView getView() {
        return view;
    }

}
