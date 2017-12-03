/**
 * Instrument.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.ynov.gattuso.service;

public class Instrument  implements java.io.Serializable {
    private int cloudiness;

    private int hygro;

    private int id;

    private java.lang.String name;

    private float pluvio;

    private fr.ynov.gattuso.service.WeatherStation station;

    private float temperature;

    private int wind;

    public Instrument() {
    }

    public Instrument(
           int cloudiness,
           int hygro,
           int id,
           java.lang.String name,
           float pluvio,
           fr.ynov.gattuso.service.WeatherStation station,
           float temperature,
           int wind) {
           this.cloudiness = cloudiness;
           this.hygro = hygro;
           this.id = id;
           this.name = name;
           this.pluvio = pluvio;
           this.station = station;
           this.temperature = temperature;
           this.wind = wind;
    }


    /**
     * Gets the cloudiness value for this Instrument.
     * 
     * @return cloudiness
     */
    public int getCloudiness() {
        return cloudiness;
    }


    /**
     * Sets the cloudiness value for this Instrument.
     * 
     * @param cloudiness
     */
    public void setCloudiness(int cloudiness) {
        this.cloudiness = cloudiness;
    }


    /**
     * Gets the hygro value for this Instrument.
     * 
     * @return hygro
     */
    public int getHygro() {
        return hygro;
    }


    /**
     * Sets the hygro value for this Instrument.
     * 
     * @param hygro
     */
    public void setHygro(int hygro) {
        this.hygro = hygro;
    }


    /**
     * Gets the id value for this Instrument.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Instrument.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the name value for this Instrument.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Instrument.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the pluvio value for this Instrument.
     * 
     * @return pluvio
     */
    public float getPluvio() {
        return pluvio;
    }


    /**
     * Sets the pluvio value for this Instrument.
     * 
     * @param pluvio
     */
    public void setPluvio(float pluvio) {
        this.pluvio = pluvio;
    }


    /**
     * Gets the station value for this Instrument.
     * 
     * @return station
     */
    public fr.ynov.gattuso.service.WeatherStation getStation() {
        return station;
    }


    /**
     * Sets the station value for this Instrument.
     * 
     * @param station
     */
    public void setStation(fr.ynov.gattuso.service.WeatherStation station) {
        this.station = station;
    }


    /**
     * Gets the temperature value for this Instrument.
     * 
     * @return temperature
     */
    public float getTemperature() {
        return temperature;
    }


    /**
     * Sets the temperature value for this Instrument.
     * 
     * @param temperature
     */
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }


    /**
     * Gets the wind value for this Instrument.
     * 
     * @return wind
     */
    public int getWind() {
        return wind;
    }


    /**
     * Sets the wind value for this Instrument.
     * 
     * @param wind
     */
    public void setWind(int wind) {
        this.wind = wind;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Instrument)) return false;
        Instrument other = (Instrument) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cloudiness == other.getCloudiness() &&
            this.hygro == other.getHygro() &&
            this.id == other.getId() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            this.pluvio == other.getPluvio() &&
            ((this.station==null && other.getStation()==null) || 
             (this.station!=null &&
              this.station.equals(other.getStation()))) &&
            this.temperature == other.getTemperature() &&
            this.wind == other.getWind();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getCloudiness();
        _hashCode += getHygro();
        _hashCode += getId();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += new Float(getPluvio()).hashCode();
        if (getStation() != null) {
            _hashCode += getStation().hashCode();
        }
        _hashCode += new Float(getTemperature()).hashCode();
        _hashCode += getWind();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Instrument.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.gattuso.ynov.fr/", "instrument"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cloudiness");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cloudiness"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hygro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hygro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pluvio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pluvio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("station");
        elemField.setXmlName(new javax.xml.namespace.QName("", "station"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.gattuso.ynov.fr/", "weatherStation"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("temperature");
        elemField.setXmlName(new javax.xml.namespace.QName("", "temperature"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wind");
        elemField.setXmlName(new javax.xml.namespace.QName("", "wind"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
