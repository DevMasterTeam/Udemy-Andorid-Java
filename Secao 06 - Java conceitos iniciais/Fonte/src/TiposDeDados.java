/**
 * Type	      Bit
 * Double	  64
 * Float	  32
 * Long	      64
 * Integer	  32
 * Short	  16
 * Byte	      8
 * Boolean    ?
 * String     ?
 * Char       ?
 */

public class TiposDeDados {
    public static void main(String[] args) {

        // Numéricos
        Byte aByte = 5;
        Short aShort = 5;
        Integer integer = 10;
        Long aLong = 400L;
        Float aFloat = 15f;
        Double aDouble = 825.0;
        Double bDouble = 825D;

        System.out.println("Double: Max: " + Double.MAX_VALUE + " - Double: " + Double.MIN_VALUE);
        System.out.println("Float: Max: " + Float.MAX_VALUE + " - Min: " + Float.MIN_VALUE);
        System.out.println("Long: Max: " + Long.MAX_VALUE + " - Long: " + Long.MIN_VALUE);
        System.out.println("Int: Max: " + Integer.MAX_VALUE + " - Min: " + Integer.MIN_VALUE);
        System.out.println("Short: Max: " + Short.MAX_VALUE + " - Min: " + Short.MIN_VALUE);
        System.out.println("Byte: Max: " + Byte.MAX_VALUE + " - Min: " + Byte.MIN_VALUE);

        // Booleano
        Boolean aBoolean = false;

        // Texto
        Character character = ';';
        String str = "string";

    }
}

/*
  -- Anotações --
  O tamanho Boolean pode ser representado somente com 1 bit, true ou false
  Porém o tamanho é depende da JVM e a especificaçacão não deixa claro

  String
  O tamanho de uma String depende de seu conteúdo.

  Char
  O tamanho de um char, assim como Boolean, também é variável e dependente da JVM

  Fonte
  https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
 */