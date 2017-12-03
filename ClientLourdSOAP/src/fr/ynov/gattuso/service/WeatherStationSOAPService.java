/**
 * WeatherStationSOAPService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.ynov.gattuso.service;

public interface WeatherStationSOAPService extends java.rmi.Remote {
    public fr.ynov.gattuso.service.Instrument[] seeInstrument(java.lang.String refStation) throws java.rmi.RemoteException;
    public void addWeatherStation(java.lang.String ref, java.lang.String name, int x, int y, java.lang.String city) throws java.rmi.RemoteException;
    public void addInstrument(java.lang.String name, float temperature, int hygro, int cloudiness, int wind, int pluvio, java.lang.String refStation) throws java.rmi.RemoteException;
    public void deleteInstrument(int idInstrument) throws java.rmi.RemoteException;
    public fr.ynov.gattuso.service.WeatherStation[] seeWeatherStation() throws java.rmi.RemoteException;
}
