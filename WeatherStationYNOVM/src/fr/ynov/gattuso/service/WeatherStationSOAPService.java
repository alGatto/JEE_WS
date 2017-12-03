/**
 * 
 */
package fr.ynov.gattuso.service;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.ynov.gattuso.modele.metier.IWeatherStation;
import fr.ynov.gattuso.modele.metier.Instrument;
import fr.ynov.gattuso.modele.metier.WeatherStation;

/**
 * @author algattuso
 *
 */
@WebService
public class WeatherStationSOAPService {
	@EJB
	private IWeatherStation metier;
	@WebMethod
	public void addWeatherStation(
	@WebParam(name="ref")String ref,
	@WebParam(name="name")String name,
	@WebParam(name="x")int x,
	@WebParam(name="y")int y,
	@WebParam(name="city")String city){
		metier.addWeatherStation(new WeatherStation(ref,name,x,y,city));
	}
	
	@WebMethod
	public void addInstrument(
	@WebParam(name="name")String name,
	@WebParam(name="temperature")float temperature,
	@WebParam(name="hygro")int hygro,
	@WebParam(name="cloudiness")int cloudiness,
	@WebParam(name="wind")int wind,
	@WebParam(name="pluvio")int pluvio,
	@WebParam(name="refStation")String refStation){
		metier.addInstrument(new Instrument(temperature, hygro, cloudiness, wind, pluvio, name), refStation);
	}
	/**
	 * @return List of Weather Stations
	 */
	@WebMethod
	public List<WeatherStation> seeWeatherStation(){
	return metier.getAllStations();
	}
	@WebMethod
	public List<Instrument> seeInstrument(@WebParam(name="refStation")String ref){
	return metier.getInstruments(ref);
	}
	@WebMethod
	public void deleteInstrument(@WebParam(name="idInstrument") int idInstrument){
	metier.deleteInstrument(idInstrument);
	}

}
