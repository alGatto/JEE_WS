package fr.ynov.gattuso.service;

public class WeatherStationSOAPServiceProxy implements fr.ynov.gattuso.service.WeatherStationSOAPService {
  private String _endpoint = null;
  private fr.ynov.gattuso.service.WeatherStationSOAPService weatherStationSOAPService = null;
  
  public WeatherStationSOAPServiceProxy() {
    _initWeatherStationSOAPServiceProxy();
  }
  
  public WeatherStationSOAPServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initWeatherStationSOAPServiceProxy();
  }
  
  private void _initWeatherStationSOAPServiceProxy() {
    try {
      weatherStationSOAPService = (new fr.ynov.gattuso.service.WeatherStationSOAPServiceServiceLocator()).getWeatherStationSOAPServicePort();
      if (weatherStationSOAPService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)weatherStationSOAPService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)weatherStationSOAPService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (weatherStationSOAPService != null)
      ((javax.xml.rpc.Stub)weatherStationSOAPService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.ynov.gattuso.service.WeatherStationSOAPService getWeatherStationSOAPService() {
    if (weatherStationSOAPService == null)
      _initWeatherStationSOAPServiceProxy();
    return weatherStationSOAPService;
  }
  
  public fr.ynov.gattuso.service.Instrument[] seeInstrument(java.lang.String refStation) throws java.rmi.RemoteException{
    if (weatherStationSOAPService == null)
      _initWeatherStationSOAPServiceProxy();
    return weatherStationSOAPService.seeInstrument(refStation);
  }
  
  public void addWeatherStation(java.lang.String ref, java.lang.String name, int x, int y, java.lang.String city) throws java.rmi.RemoteException{
    if (weatherStationSOAPService == null)
      _initWeatherStationSOAPServiceProxy();
    weatherStationSOAPService.addWeatherStation(ref, name, x, y, city);
  }
  
  public void addInstrument(java.lang.String name, float temperature, int hygro, int cloudiness, int wind, int pluvio, java.lang.String refStation) throws java.rmi.RemoteException{
    if (weatherStationSOAPService == null)
      _initWeatherStationSOAPServiceProxy();
    weatherStationSOAPService.addInstrument(name, temperature, hygro, cloudiness, wind, pluvio, refStation);
  }
  
  public void deleteInstrument(int idInstrument) throws java.rmi.RemoteException{
    if (weatherStationSOAPService == null)
      _initWeatherStationSOAPServiceProxy();
    weatherStationSOAPService.deleteInstrument(idInstrument);
  }
  
  public fr.ynov.gattuso.service.WeatherStation[] seeWeatherStation() throws java.rmi.RemoteException{
    if (weatherStationSOAPService == null)
      _initWeatherStationSOAPServiceProxy();
    return weatherStationSOAPService.seeWeatherStation();
  }
  
  
}