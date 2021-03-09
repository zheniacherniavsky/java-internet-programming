package by.belstu.cherniavsky.main;

import by.belstu.cherniavsky.banks.Bank;
import by.belstu.cherniavsky.banks.Belarusbank;
import by.belstu.cherniavsky.banks.Priorbank;
import by.belstu.cherniavsky.parser.JaxbParser;
import by.belstu.cherniavsky.users.Admin;
import by.belstu.cherniavsky.users.Client;

import by.belstu.cherniavsky.users.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Main {

    private final static Logger log4jLogger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        try
        {
            {
                SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
                File schemaLocation = new File("files/XmlSchema.xsd");
                Schema schema = factory.newSchema(schemaLocation);
                Validator validator = schema.newValidator();

                Source source = new StreamSource("files/info.xml");
                log4jLogger.info("Validate xml document");
                try {
                    validator.validate(source);
                    System.out.println("files/info.xml " + " is valid.");
                } catch (SAXException ex) {
                    System.out.println("files/info.xml " + " is not valid");
                    log4jLogger.error("Xml file is not valid");
                    return;
                } catch (IOException ex) {
                    ex.printStackTrace();
                    return;
                }

            }

            Main.GetFromXML();


//            Priorbank priorbank = new Priorbank("1113-3332-3112-3411", "23-32-12");
//            Belarusbank belarusbank = new Belarusbank("1324-1515-2312-5122", "44-41-11");
//
//            Client user1 = new Client("Eugeny", "Cherniavsky", "+375297606925", 2002);
//            Admin  user2 = new Admin("Sabina", "Glinskaya", "+375293144231", 2001);
//            Client user3 = new Client("Vladimir", "Stankevich", "+375294111223", 2002);
//            Client user4 = new Client("Kirill", "Synkevich", "+375294111423", 2002);
//
//            priorbank.add(user1);
//            priorbank.add(user2);
//            priorbank.add(user3);
//
//            priorbank.setAdmin(user1);
//            priorbank.setAdmin(user2);
//
//            priorbank.createCard(user4,"1111 4144 1212 4123");
//            priorbank.createCard(user1,"1111 4144 1212 4123");
//            belarusbank.createCard(user1, "4141 4141 4141 4141");
//
//            System.out.println(user1.card.getBalance());
//            belarusbank.addBalance(user1.card, 23);
//            priorbank.addBalance(user1.card, 99);
//            System.out.println(user1.card.getBalance());
//
//            for (User u:
//                 User.collection) {
//                System.out.println(u);
//            }

        } catch (Error | SAXException e)
        {
            System.out.println("Ошибка: " + e);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void GetFromXML() throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("L:\\Labs\\Java programming in Internet\\Java4\\files\\info.xml"));
        NodeList userElements = document.getDocumentElement().getElementsByTagName("user");
        for (int i = 0; i < userElements.getLength(); i++) {
            Node user = userElements.item(i);
            NamedNodeMap attributes = user.getAttributes();
            if (attributes.getNamedItem("type").getNodeValue().equals("USER")) {
                User.collection.add(new Client(attributes.getNamedItem("name").getNodeValue(),
                        attributes.getNamedItem("lastname").getNodeValue(),
                        attributes.getNamedItem("phone").getNodeValue(),
                        Integer.parseInt(attributes.getNamedItem("birthyear").getNodeValue())));
            }
            if (attributes.getNamedItem("type").getNodeValue().equals("ADMIN")) {
                User.collection.add(new Admin(attributes.getNamedItem("name").getNodeValue(),
                        attributes.getNamedItem("lastname").getNodeValue(),
                        attributes.getNamedItem("phone").getNodeValue(),
                        Integer.parseInt(attributes.getNamedItem("birthyear").getNodeValue())));
            }
        }
        for (User user : User.collection) {
            System.out.println(user);
        }
    }
}
