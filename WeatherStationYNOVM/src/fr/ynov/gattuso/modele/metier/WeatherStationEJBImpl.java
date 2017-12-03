/**
 * 
 */
package fr.ynov.gattuso.modele.metier;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author algattuso
 *
 */
@Stateless(name="STATION") 
public class WeatherStationEJBImpl implements IWeatherStation {
	@PersistenceContext(name="UP_STATION")
	EntityManager em;

	@Override
	public void addWeatherStation(WeatherStation ws) {
		em.persist(ws);
		
	}

	@Override
	public void addInstrument(Instrument i, String refStation) {
		WeatherStation ws=em.find(WeatherStation.class, refStation);
		i.setStation(ws);
		em.persist(i);
		
	}

	@Override
	public List<WeatherStation> getAllStations() {
		Query req=em.createQuery("select ws from Station ws");
		return req.getResultList();
	}

	@Override
	public List<Instrument> getInstruments(String refStation) {
		Query req=em.createQuery("select i from Instrument i where i.station.reference=:x");
		req.setParameter("x", refStation);
		return req.getResultList();
	}

	@Override
	public void deleteWeatherStation(String refStation) {
		WeatherStation ws = em.find(WeatherStation.class, refStation);
		em.remove(ws);
		
	}

	@Override
	public void deleteInstrument(int idInstrument) {
		Instrument i = em.find(Instrument.class, idInstrument);
		em.remove(i);
		
	}
}
