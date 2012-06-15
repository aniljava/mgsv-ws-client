
package edu.unt.mgsv.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.unt.mgsv.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _UploadData_QNAME = new QName("http://mgsv.unt.edu/", "uploadData");
    private final static QName _UploadURL_QNAME = new QName("http://mgsv.unt.edu/", "uploadURL");
    private final static QName _UploadURLResponse_QNAME = new QName("http://mgsv.unt.edu/", "uploadURLResponse");
    private final static QName _UploadDataResponse_QNAME = new QName("http://mgsv.unt.edu/", "uploadDataResponse");
    private final static QName _Exception_QNAME = new QName("http://mgsv.unt.edu/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.unt.mgsv.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link UploadDataResponse }
     * 
     */
    public UploadDataResponse createUploadDataResponse() {
        return new UploadDataResponse();
    }

    /**
     * Create an instance of {@link UploadURLResponse }
     * 
     */
    public UploadURLResponse createUploadURLResponse() {
        return new UploadURLResponse();
    }

    /**
     * Create an instance of {@link UploadURL }
     * 
     */
    public UploadURL createUploadURL() {
        return new UploadURL();
    }

    /**
     * Create an instance of {@link UploadData }
     * 
     */
    public UploadData createUploadData() {
        return new UploadData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mgsv.unt.edu/", name = "uploadData")
    public JAXBElement<UploadData> createUploadData(UploadData value) {
        return new JAXBElement<UploadData>(_UploadData_QNAME, UploadData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadURL }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mgsv.unt.edu/", name = "uploadURL")
    public JAXBElement<UploadURL> createUploadURL(UploadURL value) {
        return new JAXBElement<UploadURL>(_UploadURL_QNAME, UploadURL.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadURLResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mgsv.unt.edu/", name = "uploadURLResponse")
    public JAXBElement<UploadURLResponse> createUploadURLResponse(UploadURLResponse value) {
        return new JAXBElement<UploadURLResponse>(_UploadURLResponse_QNAME, UploadURLResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mgsv.unt.edu/", name = "uploadDataResponse")
    public JAXBElement<UploadDataResponse> createUploadDataResponse(UploadDataResponse value) {
        return new JAXBElement<UploadDataResponse>(_UploadDataResponse_QNAME, UploadDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mgsv.unt.edu/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}
