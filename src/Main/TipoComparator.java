// package Main;

import java.util.Comparator;

public class TipoComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Carta c1 = (Carta)o1;
        Carta c2 = (Carta)o2;

        return c1.getTipo().compareTo(c2.getTipo());
    }
}
