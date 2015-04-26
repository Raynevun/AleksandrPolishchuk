import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by mrGorobec on 25.04.2015.
 */
public class SendGet {

    public SendGet() {
    }

    public static String sendGet(String timestamp) throws Exception {
        String url = "https://beacon.nist.gov/rest/record/" + timestamp;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        //con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print result
        System.out.println("RESPOSE" + response.toString());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        InputSource is;
        String respons = null;
        try {
            builder = factory.newDocumentBuilder();
            is = new InputSource(new StringReader(response.toString()));
            Document doc = builder.parse(is);
            NodeList list = doc.getElementsByTagName("outputValue");
            respons =  list.item(0).getTextContent();
            System.out.println("PARSE " + list.item(0).getTextContent());
            return list.item(0).getTextContent();
        } catch (ParserConfigurationException e) {
        } catch (SAXException e) {
        } catch (IOException e) {
        }
        return respons;
    }
}




