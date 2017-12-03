/**
 * 
 */
package fr.ynov.gattuso.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.ynov.gattuso.modele.metier.IWeatherStation;
import fr.ynov.gattuso.modele.metier.Instrument;
import fr.ynov.gattuso.modele.metier.WeatherStation;

/**
 * @author algattuso
 *
 */
@Stateless
@Path("/station")
public class WeatherStationRESTService {
	@EJB
	private IWeatherStation metier;
	@GET
	@Path("/addWeatherStation/{ref}/{name}/{x}/{y}/{city}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addWeatherStation(
			@PathParam(value="ref")String ref,
			@PathParam(value="name")String name,
			@PathParam(value="x")int x,
			@PathParam(value="y")int y,
			@PathParam(value="city")String city){
		metier.addWeatherStation(new WeatherStation(ref,name,x,y,city));
	}
	
	@GET
	@Path("/addInstrument/{refStation}/{name}/{temperature}/{hygro}/{cloudiness/{wind}/{pluvio}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addInstrument(
			@PathParam(value="name")String name,
			@PathParam(value="temperature")float temperature,
			@PathParam(value="hygro")int hygro,
			@PathParam(value="cloudiness")int cloudiness,
			@PathParam(value="wind")int wind,
			@PathParam(value="pluvio")int pluvio,
			@PathParam(value="refStation")String refStation){
		metier.addInstrument(new Instrument(temperature, hygro, cloudiness, wind, pluvio, name), refStation);
	}
	/**
	 * @return List of Weather Stations
	 */
	@GET
	@Path("/seeWeatherStation")
	@Produces(MediaType.APPLICATION_JSON)
	public List<WeatherStation> seeWeatherStation(){
	return metier.getAllStations();
	}
	@GET
	@Path("/seeInstrument/{refStation}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Instrument> seeInstrument(@PathParam(value="refStation")String ref){
	return metier.getInstruments(ref);
	}
	@GET
	@Path("/deleteInstrument/{idInstrument}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteInstrument(@PathParam(value="idInstrument") int idInstrument){
	metier.deleteInstrument(idInstrument);
	}

}
