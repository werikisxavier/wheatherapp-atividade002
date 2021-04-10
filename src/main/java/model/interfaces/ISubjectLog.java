/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

/**
 *
 * @author W-E-R
 */
public interface ISubjectLog {

    public void registerObserver(IObserverLog o);

    public void removeObserver(IObserverLog o);

    public void notifyObservers();
}
