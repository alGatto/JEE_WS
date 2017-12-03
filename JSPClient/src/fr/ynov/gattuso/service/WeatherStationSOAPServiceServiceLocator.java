/**
 * WeatherStationSOAPServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.ynov.gattuso.service;

public class WeatherStationSOAPServiceServiceLocator extends org.apache.axis.client.Service implements fr.ynov.gattuso.service.WeatherStationSOAPServiceService {

    public WeatherStationSOAPServiceServiceLocator() {
    }


    public WeatherStationSOAPServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WeatherStationSOAPServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WeatherStationSOAPServicePort
    private java.lang.String WeatherStationSOAPServicePort_address = "http://localhost:8888/WeatherStationYNOVM/WeatherStationSOAPService";

    public java.lang.String getWeatherStationSOAPServicePortAddress() {
        return WeatherStationSOAPServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WeatherStationSOAPServicePortWSDDServiceName = "WeatherStationSOAPServicePort";

    public java.lang.String getWeatherStationSOAPServicePortWSDDServiceName() {
        return WeatherStationSOAPServicePortWSDDServiceName;
    }

    public void setWeatherStationSOAPServicePortWSDDServiceName(java.lang.String name) {
        WeatherStationSOAPServicePortWSDDServiceName = name;
    }

    public fr.ynov.gattuso.service.WeatherStationSOAPService getWeatherStationSOAPServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WeatherStationSOAPServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWeatherStationSOAPServicePort(endpoint);
    }

    public fr.ynov.gattuso.service.WeatherStationSOAPService getWeatherStationSOAPServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fr.ynov.gattuso.service.WeatherStationSOAPServiceServiceSoapBindingStub _stub = new fr.ynov.gattuso.service.WeatherStationSOAPServiceServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getWeatherStationSOAPServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWeatherStationSOAPServicePortEndpointAddress(java.lang.String address) {
        WeatherStationSOAPServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fr.ynov.gattuso.service.WeatherStationSOAPService.class.isAssignableFrom(serviceEndpointInterface)) {
                fr.ynov.gattuso.service.WeatherStationSOAPServiceServiceSoapBindingStub _stub = new fr.ynov.gattuso.service.WeatherStationSOAPServiceServiceSoapBindingStub(new java.net.URL(WeatherStationSOAPServicePort_address), this);
                _stub.setPortName(getWeatherStationSOAPServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WeatherStationSOAPServicePort".equals(inputPortName)) {
            return getWeatherStationSOAPServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.gattuso.ynov.fr/", "WeatherStationSOAPServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.gattuso.ynov.fr/", "WeatherStationSOAPServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WeatherStationSOAPServicePort".equals(portName)) {
            setWeatherStationSOAPServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
