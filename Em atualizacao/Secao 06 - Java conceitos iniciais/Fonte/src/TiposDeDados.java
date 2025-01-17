/*
    Type	    Bit     Intervalo
    Double	    64      [1.7976931348623157 x (10)^308, 4.9406564584124654 x (10)^-324]
    Float	    32      [3.40282347 x 10^(38), 1.40239846 x (10)^-45]
    Long	    64      [-9,223,372,036,854,775,808 - 9,223,372,036,854,775,807]
    Integer     32      [-2,147,483,648 - 2,147,483,647]
    Short	    16      [-32,768 .. 32,767]
    Byte	    8       [-128,127]
    Character   16      -
    String      ?       -
    Boolean     ?       [false,true]

    Sobre unidades de medida:
    1 Byte = 8 bits
    1 kilobyte (kB) = 1024 bytes
    1 megabyte (MB) = 1024 kilobytes
    1 gigabyte (GB) = 1024 megabytes

    Boolean
    Tamanho ser representado somente com 1 bit, true ou false.
    Porém o tamanho depende da JVM e a especificaçacão não deixa claro.

    String
    O tamanho de uma String depende de seu conteúdo.

    Char
    O tamanho de um char, assim como Boolean, também é variável e dependente da JVM

    Fonte: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
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