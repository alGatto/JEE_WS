/**
 * 
 */
package fr.ynov.gattuso.clientSOAP;

import java.rmi.RemoteException;
import java.util.*;
import fr.ynov.gattuso.service.*;
/**
 * @author algattuso
 *
 */
public class ClientLourd {
	public static void main(String[] args) {
		try {
			WeatherStationSOAPServiceProxy stub = new WeatherStationSOAPServiceProxy();
			stub.addWeatherStation("CA4", "TestStation", 13452, 3000, "Aix");
			stub.addInstrument("Thermometre", 13, 0, 0, 0, 0, "CA4");
			stub.addInstrument("Hygrometre", 0, 20, 0, 0, 0, "CA4");
			/**
			 * Affichage des stations
			 */
			WeatherStation[] ws=stub.seeWeatherStation();
			System.out.println("---- Toutes Les stations---");
			for(WeatherStation c:ws){
				System.out.println(c.getReference()+"--"+c.getName()+"--"+c.getClass().getSimpleName());
			}
			System.out.println("--- Instrument d'une station ---");
			Instrument[] instrument=stub.seeInstrument("CA4");
			for(Instrument i:instrument){
				System.out.println(i.getId()+"--"+i.getName()+"--"+i.getStation());
			}
		} catch (RemoteException e) {
		e.printStackTrace();
		}
		}

}
