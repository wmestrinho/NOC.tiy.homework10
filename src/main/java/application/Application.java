package application;

import com.google.gson.Gson;
import data.Agents;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by WagnerMestrinho on 2/6/17.
 */


public class Application {


    public static void main(String[] args) {

        Properties prop = new Properties();
        FileReader input = null;

        try {
            // load into your own prop object


            InputStream fis = Application.class.getClassLoader().getResourceAsStream(KeyHolder.APP_PROP_FILE_NAME);
            prop.load(fis);

            // load into the system properties
            System.getProperties().load(Application.class.getClassLoader().getResourceAsStream(KeyHolder.APP_PROP_FILE_NAME));
        } catch (IOException io) {
            io.printStackTrace();
        }
//        printAllSystemProperties();

        doPersonJsonFun(prop);

    }

    private static void doPersonJsonFun(Properties aPropHolder) {
        System.out.println("=======> Starting Regular Person Stuff...");
        // create reader to read file
        try {

            // read a single perosn
            FileReader fr = new FileReader(System.getProperty(KeyHolder.KEY_JSON_PERSON));
            Gson tmpG = new Gson();
            Agents person = tmpG.fromJson(fr, Agents.class);
            System.out.println("single --------> GOT: " + person);

            // read an array of people
            FileReader fr2 = new FileReader(System.getProperty(KeyHolder.KEY_JSON_PEOPLE_ARRAY));
            Gson tmpG2 = new Gson();
            Agents[] persons = tmpG2.fromJson(fr2, Agents[].class);

            for (Agents p : persons) {
                // find one named 'jason'
                if (p.getCoverName().toLowerCase().equals("")) {
                    System.out.println("");
                }
                System.out.println("array --------> GOT: " + p);
            }
                catch(FileNotFoundException e){
                    e.printStackTrace();
                }


            }
        }
      }
    }
}