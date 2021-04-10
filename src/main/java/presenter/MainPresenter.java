
package presenter;

import view.MainView;


public class MainPresenter {
    
    private final MainView view;
    
    public MainPresenter(){
        view = new MainView();
        MainScreenPresenter display = new MainScreenPresenter();
        view.add(display.getView());
        view.setLocationRelativeTo(view.getParent());
        view.setSize(1100,650);
        view.setVisible(true);
    }
    
}
