public class ConversaoDados {
    public static void main(String[] args) {

        // Usamos a ajuda dos tipos objetos para conversão

        // Conversão de uma String para outros tipos
        System.out.println(Byte.valueOf("100"));
        System.out.println(Short.valueOf("100"));
        System.out.println(Integer.valueOf("100"));
        System.out.println(Long.valueOf("100"));
        System.out.println(Double.valueOf("100"));
        System.out.println(Float.valueOf("100"));
        System.out.println(Boolean.valueOf("true"));

        // Conversão de tipos de menor capacidade para maior capacidade
        Byte b = 10;
        System.out.println(b.shortValue());
        System.out.println(b.intValue());
        System.out.println(b.longValue());
        System.out.println(b.floatValue());
        System.out.println(b.doubleValue());

        // Conversão de tipos de maior capacidade para menor capacidade
        Double d = 12000000000000d;
        System.out.println(d.floatValue());
        System.out.println(d.longValue());
        System.out.println(d.intValue()); // Conversão feita com erro quando não há capacidade
        System.out.println(d.byteValue()); // Conversão feita com erro quando não há capacidade

        // Conversão para String
        int num = 500;
        System.out.println("String: " + num);
        System.out.println(String.valueOf(num));

        // Conversão para String usando a função do objeto
        Integer numInteger = 10;
        System.out.println(numInteger.toString());
    }
}