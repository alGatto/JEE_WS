/**
 * 
 */
package fr.ynov.gattuso.modele.metier;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author algattuso
 *
 * Classe des instruments de mesure
 */
@Entity
@Table(name="INSTRUMENT")
public class Instrument implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;//ne pas le générer dans le constructeur car il sera autoincremente
	@Column(name="NAME")
	private String name;
	@Column(name="TEMP")
	private float temperature;
	@Column(name="HYGRO")
	private int hygro;
	@Column(name="CLOUD")
	private int cloudiness;
	@Column(name="WIND")
	private int wind;
	@Column(name="PLUVIO")
	private float pluvio;
	@ManyToOne
	@JoinColumn(name="REF_STATION")//il faut specifier la clé etrangere
	private WeatherStation station; //association manytoone
	public Instrument() {
		super();
	}
	public Instrument(float temperature, int hygro, int cloudiness, int wind, float pluvio, String name) {
		super();
		this.temperature = temperature;
		this.cloudiness = cloudiness;
		this.hygro = hygro;
		this.pluvio = pluvio;
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the temperature
	 */
	public float getTemperature() {
		return temperature;
	}
	/**
	 * @param temperature 
	 * 
	 * the temperature to set
	 */
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	/**
	 * @return the hygro
	 */
	public int getHygro() {
		return hygro;
	}
	/**
	 * @param hygro 
	 * 
	 * the hygro to set
	 */
	public void setHygro(int hygro) {
		this.hygro = hygro;
	}
	/**
	 * @return the cloudiness
	 */
	public int getCloudiness() {
		return cloudiness;
	}
	/**
	 * @param cloudiness 
	 * 
	 * the cloudiness to set
	 */
	public void setCloudiness(int cloudiness) {
		this.cloudiness = cloudiness;
	}
	/**
	 * @return the wind
	 */
	public int getWind() {
		return wind;
	}
	/**
	 * @param wind 
	 * 
	 * the wind to set
	 */
	public void setWind(int wind) {
		this.wind = wind;
	}
	/**
	 * @return the pluvio
	 */
	public float getPluvio() {
		return pluvio;
	}
	/**
	 * @param pluvio 
	 * 
	 * the pluvio to set
	 */
	public void setPluvio(float pluvio) {
		this.pluvio = pluvio;
	}
	/**
	 * @return the station
	 */
	public WeatherStation getStation() {
		return station;
	}
	/**
	 * @param station 
	 * 
	 * the station to set
	 */
	public void setStation(WeatherStation station) {
		this.station = station;
	}
	

}
