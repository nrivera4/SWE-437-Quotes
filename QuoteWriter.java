package quotes;
import java.io.*;
 
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;






public class QuoteWriter{

  public void write(String file, String quoteTxt, String author, String keyword){
    Document d;
    Element el = null;
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    
    try{
      DocumentBuilder doc = factory.newDocumentBuilder();
      d = doc.parse(file);
      Element base =  d.createElement("quote");
      Element rootElement = d.getDocumentElement();
      
      el = d.createElement("quote-text");
      el.appendChild(d.createTextNode(quoteTxt));
      base.appendChild(el);
      
       el = d.createElement("author");
      el.appendChild(d.createTextNode(author));
      base.appendChild(el);


         el = d.createElement("keyword");
      el.appendChild(d.createTextNode(keyword));
      base.appendChild(el);
      rootElement.appendChild(base);
      
       try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            // send DOM to file
            tr.transform(new DOMSource(d), 
                                 new StreamResult(new FileOutputStream(file)));

        } catch (TransformerException te) {
            System.out.println(te.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    } catch (ParserConfigurationException pce) {
        System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
    } catch(SAXException sae){
      sae.printStackTrace();
    }catch (IOException ioe) {
  ioe.printStackTrace();
    } 

    }
  
  
  
  
}