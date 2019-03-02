package Main;

import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Yugi {

    final static String DELIMITADOR = "\t\n|";
    final static String PATH_DATOS = "cards_desc.txt";
    final static String TEST_PATH_DATOS = "cards_desc_test.txt";

    public static void main(String[] args) throws IOException{

//        System.out.println(System.getProperty("user.dir"));
//          getcwd
        Scanner scan = new Scanner(System.in);
        System.out.println("Que implementacion desea");
        MapFactory mp = new MapFactory();
        Map<String, String> cards = null;
        //  baraja completa
        Map<String, String> collection = null;
        //  coleccion de usuario

        String word = scan.next();
        switch (word){
            case "1":
                //  hashmap
                cards = mp.get_hash();
                collection = mp.get_hash();
                break;

            case "2":
                //  tree
                cards = mp.get_tree();
                collection = mp.get_tree();
                break;

            case "3":
                //  linked
                cards = mp.get_linked();
                collection = mp.get_linked();
                break;

            default:
                System.out.println("a");
                break;
        }
        //  popular deck principal
        cards = setCards(cards);
        System.out.println("This many cards: " + cards.size());
//        switch (word){
//            case "1":
//                //  agregar a coleccion
//                break;
//
//            case "2":
//                //  get tipo
//                break;
//
//            case "3":
//                //  nombre, tipo y cantidad en coleccion
//                break;
//
//            case "4":
//                //  3 pero sorted
//                break;
//
//            case "5":
//                //  all the cards
//                break;
//
//            case "6":
//                //  all the cards but sorted.
//                break;
//
//            default:
//                System.out.println("a");
//                break;
//        }


    }

    static Map<String, String> setCards(Map<String, String> deck) throws IOException {
        StringTokenizer st = new StringTokenizer(getTokens(), DELIMITADOR);
        String k;
        String v;
        while (st.hasMoreTokens()){
            //  meterlos a la implementacion escogida
            k = st.nextToken();
            v = st.nextToken();
            deck.put(k.toLowerCase(), v.toLowerCase());
        }
        return deck;
    }

    static String getTokens() throws IOException, FileNotFoundException{

        BufferedReader reader;
        File file;
        String linea, datos = "";
        try{
            if((new File(PATH_DATOS)).exists()){ //verificamos que el archivo exista


                reader = new BufferedReader(new FileReader(PATH_DATOS));

                while((linea = reader.readLine()) != null){
                    //concatenamos con un tabular la lectura de la linea,
                    //el tabular se eliminara al separar las expresiones.
                    datos += linea + "\t";
                }

                reader.close();
            }
            else{
                System.out.println("El archivo ingresado no fue encontrado.");
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return datos;
    }
}
