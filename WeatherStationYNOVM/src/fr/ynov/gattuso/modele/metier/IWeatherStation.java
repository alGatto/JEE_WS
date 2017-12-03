/**
 * 
 */
package fr.ynov.gattuso.modele.metier;

import java.util.List;

import javax.ejb.Local;

/**
 * @author algattuso
 *
 */
@Local //comme c’est une interface Locale, sinon on utilise remote
public interface IWeatherStation {
	/**
	 * Méthode d'ajout d'une station météo
	 * @param ws
	 */
	public void addWeatherStation(WeatherStation ws);
	/**
	 * Méthode d'ajout d'un instrument
	 * @param i
	 * @param refStation
	 */
	public void addInstrument(Instrument i, String refStation);
	/**
	 * Méthode de récupération des stations météo
	 * @return List of WeatherStation
	 */
	public List<WeatherStation> getAllStations();
	/**
	 * Méthode de récupération des Instruments d'une station
	 * @param refStation
	 * @return List of Instrument
	 */
	public List<Instrument> getInstruments(String refStation);
	/**
	 * Méthode de suppression d'une station météo
	 * @param refStation
	 */
	public void deleteWeatherStation (String refStation);
	/**
	 * Méthode de suppression d'un instrument
	 * @param idInstrument
	 */
	public void deleteInstrument(int idInstrument);

}
