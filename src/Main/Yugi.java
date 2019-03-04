package Main;

import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*;


public class Yugi {

    final static String DELIMITADOR = "\t\n|";
    final static String PATH_DATOS = "cards_desc.txt";
    final static String TEST_PATH_DATOS = "cards_desc_test.txt";
    static String menu = "\nOpciones:\n\n1. Agregar a coleccion por nombre\n" +
            "2. Mostrar tipo por nombre\n" +
            "3. Mostrar detalles de coleccion\n" +
            "4. Mostrar coleccion ordenada por tipo\n" +
            "5. Mostrar detalles de todas las cartas\n" +
            "6. Mostrar detalles de todas las cartas ordenadas por tipo\n" +
            "7. quit";

    public static void main(String[] args) throws IOException{

//        System.out.println(System.getProperty("user.dir"));
//          getcwd
        Scanner scan = new Scanner(System.in);
        System.out.println("Que implementacion desea:\n" +
                "1. HashMap\n" +
                "2. TreeMap\n" +
                "3. LinkedHashMap\n");
        MapFactory mp = new MapFactory();
        Map<String, String> cards = null;
        //  baraja completa
        Map<Carta, Integer> collection = null;
        //  coleccion de usuario {Carta, cantidad}

        String word = scan.next();
        switch (word){
            case "1":
                //  hashmap
                cards = mp.get_hash();
                collection = mp.get_col_hash();
                break;

            case "2":
                //  tree
                cards = mp.get_tree();
                collection = mp.get_col_tree();
                break;

            case "3":
                //  linked
                cards = mp.get_linked();
                collection = mp.get_col_linked();
                break;

            default:
                System.out.println("a");
                break;
        }
        //  popular deck principal
        cards = setCards(cards);

        System.out.println(menu);
        word = scan.next();
        scan.nextLine();
        String search, k, v;
        while (word != "quit"){
//            word = scan.next();
            switch (word){
                case "1":
                    //  agregar a coleccion
                    System.out.println("Ingresar nombre de la carta:");
                    search = scan.nextLine().toLowerCase();
                    //  do the do
                    try{
                        if (cards.containsKey(search)) {
                            v = cards.get(search);
                            Carta car = Carta.new_inst(search, v);
                            System.out.println(car.hashCode());
                            int cant;
                            if (collection.containsKey(car)){
                                System.out.println("Ya existe en coleccion entonces sumamos 1");
                                cant = collection.get(car) + 1;
                                System.out.println(cant);
                                collection.put(car, cant);
                            } else {
                                System.out.println("Not the same card");
                                collection.put(car, 1);
                            }


                            System.out.println("Se agrego: " + search + " | " + v);
                            System.out.println(collection);
                        } else {
                            System.out.println("No encontramos esa carta.\n");
                        }

                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(menu);
                    word = scan.next();
                    scan.nextLine();
                    break;

                case "2":
                    //  get tipo
                    System.out.println("Ingresar nombre de la carta:");
                    search = scan.nextLine().toLowerCase();
                    //  do the do
                    try{
                        if (cards.containsKey(search)) {
                            v = cards.get(search);
                            System.out.println(search.toUpperCase() + " es tipo: " + v.toUpperCase());
//                            System.out.println(collection);
                        } else {
                            System.out.println("No encontramos esa carta.\n");
                        }

                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(menu);
                    word = scan.next();
                    break;

                case "3":
                    //  nombre, tipo y cantidad en coleccion
                    Carta car;
                    for (Map.Entry<Carta, Integer> m: collection.entrySet()){
                        //  detalles de coleccion
                        car = m.getKey();
                        System.out.println(car.getNombre() + " | " + car.getTipo() + " | " + String.valueOf(m.getValue()));

                    }

                    System.out.println(menu);
                    word = scan.next();
                    scan.nextLine();
                    break;

                case "4":
                    //  3 pero mostrar en un orden
                    //  no dice ordenar el map sino que mostrar en orden.
                    //
                    String con;
                    for (int i=0; i < 3; i++){
                        if (i == 0){
                            con = "hechizo";
                        } else if (i == 1){
                            con = "monstruo";
                        } else {
                            con = "trampa";
                        }
                        for (Map.Entry<Carta, Integer> m: collection.entrySet()){
                            //  detalles de coleccion
                            car = m.getKey();
                            if (car.getTipo().equals(con)){
                                System.out.println(car.getNombre() + " | " + car.getTipo() + " | " + String.valueOf(m.getValue()));
                            }


                        }
                    }


                    System.out.println(menu);

                    word = scan.next();
                    scan.nextLine();
                    break;

                case "5":
                    //  all the cards
                    allthecards(cards);
                    System.out.println(menu);
                    word = scan.next();
                    scan.nextLine();
                    break;

                case "6":
                    //  all the cards but in order.
                    for (int i=0; i < 3; i++){
                        if (i == 0){
                            con = "hechizo";
                        } else if (i == 1){
                            con = "monstruo";
                        } else {
                            con = "trampa";
                        }
                        for (Map.Entry<String, String> m: cards.entrySet()){
                            //  detalles de coleccion
                            if (m.getValue().equals(con)){
                                System.out.println(m.getKey() + " | " + m.getValue());
                            }

                        }
                    }
                    System.out.println(menu);
                    word = scan.next();
                    scan.nextLine();
                    break;

                case "7":
                    //  c ya
                    word = "quit";
                    break;

                default:
                    System.out.println("Opcion invalida\n");
                    System.out.println(menu);
                    word = scan.next();
                    scan.nextLine();
                    break;
            }
        }

    }


    static void allthecards(Map<String, String> cards){
        //  metodo estatico de main para que lo detecte el profiler
        for (Map.Entry<String, String> m: cards.entrySet()){
            //  16 mil prints.
            System.out.println("Nombre: " + m.getKey());
            System.out.println("Tipo: " + m.getValue() + "\n");
        }
    }

    static Map<String, String> setCards(Map<String, String> deck) throws IOException {
        //  Luego de escoger la implementacion usamos el algoritmo polimorfico Map.Put()
        //  y asi llenar nuestro map de todas las cartas.
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
            if((new File(PATH_DATOS)).exists()){
                //verificamos que el archivo exista
                reader = new BufferedReader(new FileReader(PATH_DATOS));

                while((linea = reader.readLine()) != null){
                    //concatenamos con un tabular la lectura de la linea,
                    //el tabular se eliminara al separar las expresiones.
                    datos += linea + "\t";
                }

                reader.close();
            }
            else{
                System.out.println("El archivo ingresado no fue encontrado :(");
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return datos;
    }
}
