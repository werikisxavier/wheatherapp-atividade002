package application;


import model.impli.WeatherDataCollection;
import presenter.MainPresenter;




public class Program {

    public static void main(String[] args) {
        
        WeatherDataCollection collectionData = WeatherDataCollection.getInstance();
        MainPresenter.getInstance(collectionData);

    }
}
