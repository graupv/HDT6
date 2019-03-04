package Main;

public final class Carta implements Comparable<Carta> {
    //  clase inmutable
    private final String nombre;
    private final String tipo;
    private Carta(String n, String t){
        this.nombre = n;
        this.tipo = t;
    }

    static Carta new_inst(String n, String t){
        return new Carta(n, t);
    }

    String getNombre(){
        return this.nombre;
    }

    String getTipo(){
        return this.tipo;
    }

    public String toString(){

        return this.nombre + " ";
    }

    @Override
    public int hashCode(){
        int a = (int)this.nombre.charAt(0);
        int b = (int)this.nombre.charAt(this.nombre.length() - 1);
        return a * b  + this.nombre.length() + this.tipo.length();
    }

    public int compareTo(Carta c) {
            return this.nombre.compareTo(c.nombre);
            // tecnicamente trampa
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carta other = (Carta) obj;

        return this.nombre.equals(other.nombre);
    }


}
