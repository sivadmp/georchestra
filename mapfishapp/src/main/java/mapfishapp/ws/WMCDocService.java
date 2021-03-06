package mapfishapp.ws;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * This service handles the storage and the loading of a wmc file on a temporary directory.
 * @author yoann buch  - yoann.buch@gmail.com
 *
 */

public class WMCDocService extends A_DocService {
    
    public static final String FILE_EXTENSION = ".wmc";
    public static final String MIME_TYPE = "application/vnd.ogc.context+xml";
    public static final String SCHEMA_URL = "http://schemas.opengis.net/context/1.1.0/context.xsd";

    public static final String FILENAME_NODE = "ViewContext";
    public static final String FILENAME_ATTRIBUTE = "id";
    
    public WMCDocService(int maxDocAgeInMinutes) {
        super(maxDocAgeInMinutes, FILE_EXTENSION, MIME_TYPE);
    }
    
    /*=================================Overridden methods===============================================*/
    
    /**
     * Called before saving the content
     * @throws DocServiceException
     */
    @Override
    protected void preSave() throws DocServiceException {
        
        // check if wmc content is valid towards its xsd schema
        
        /* WMC file generated by OpenLayers seems to be not valid!
        isDocumentValid(SCHEMA_URL);
        */
    }
    
    /**
     * Called right after the loading of the file content 
     * @throws DocServiceException
     */
    @Override
    protected void postLoad() throws DocServiceException {
 
        // get the real file name: the one that the user chose
        // it is hidden in the "id" attribute in the first node "ViewContext"
        String name = extractRealFileName(new ByteArrayInputStream(_content.getBytes()));
        if(name == null) {
            //could not extract file name in content, let it with default value
        }
        else {
            _name = name + FILE_EXTENSION;
        }

    }
    
    /*=======================================Private Methods=============================================*/
    
    /**
     * Get the real name of the file given by the user. It is hidden in the id attribute of the ViewContext Node
     * @param content
     * @return String real file name
     * @throws DocServiceException 
     */
    private String extractRealFileName(final InputStream content) throws DocServiceException {
        
        String fileName = null;
        
        // create a document DOM from the content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(content);
            
            // get hidden file name
            NodeList nodes = document.getElementsByTagName(FILENAME_NODE);
            if(nodes.getLength() == 1) {
                Element child = (Element) nodes.item(0);
                fileName = child.getAttribute(FILENAME_ATTRIBUTE);
            }      
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;   
    }
}
