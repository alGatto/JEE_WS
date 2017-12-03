/**
 * 
 */
package fr.ynov.gattuso.modele.metier;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author algattuso
 * 
 * Classe des stations météo
 *
 */
@Entity
@Table(name="STATION")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)//on specifie la meme table pour toute la hierarchie, i.e : une seul table pour stocker les stations locales et distantes
//@DiscriminatorColumn(name="TYPE_STATION",length=3)//colonne pour specifier le type de station (aura deux caractères Locale=LOC ou Distante=DIS)
public class WeatherStation implements Serializable{
	/**
	 * 
	 */
	@Id
	@Column(name="REF_STATION")
	private String reference;
	@Column(name="X")
	private int x;
	@Column(name="Y")
	private int y;
	@Column(name="NAME")
	private String name;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private boolean state; //Si la station est en panne la variable state = false
	@Column(name="ISACTIVE")
	private boolean isActive; // Etat de la station: En marche ou Arrêtée
	
	@OneToMany(mappedBy="station",fetch=FetchType.LAZY)//mappedBy c’est pour dire que la collection est mappe par station (voir classe station attribut instrument). Comme la cle est déjà specifiée, pas besoin de la definir. Fetchtype lazy c’est pour dire qu’on va charger une station il ne va pas charger les instruents. Elles seront chargé à la demande
	private Collection<Instrument> instrument;//comme on a une association bidirectionnelle on va utiliser une collection
	//on ne selectionne pas les instruments dans le constructeur car on a pas besoin de les connaitres au depart
	
	public WeatherStation(String reference, String name, int x, int y, String city) {
		super();
		this.reference = reference;
		this.name = name;
		this.x = x;
		this.y = y;
		this.city = city;
	}
	public WeatherStation() {
		super();
	}
	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}
	/**
	 * @param reference 
	 * 
	 * the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the 
	 * 
	 * x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the 
	 * 
	 * y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name 
	 * 
	 * the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city 
	 * 
	 * the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public boolean isState() {
		return state;
	}
	/**
	 * @param state 
	 * 
	 * the state to set
	 */
	public void setState(boolean state) {
		this.state = state;
	}
	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}
	/**
	 * @param isActive 
	 * 
	 * the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	/**
	 * @return the instrument
	 */
	@XmlTransient
	public Collection<Instrument> getInstrument() {
		return instrument;
	}
	/**
	 * @param instrument 
	 * 
	 * the instrument to set
	 */
	public void setInstrument(Collection<Instrument> instrument) {
		this.instrument = instrument;
	}
	
}
