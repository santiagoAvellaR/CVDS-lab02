package edu.eci.cvds.patterns.archetype;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String mensaje = (args.length > 0) ? "Hello " + args[0] + " " + args[1] + ":)"  : "Hello World!";
        System.out.println(mensaje);
    }
}
