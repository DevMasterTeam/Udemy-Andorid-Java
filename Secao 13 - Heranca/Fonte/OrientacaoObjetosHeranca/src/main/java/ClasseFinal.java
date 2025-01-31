/**
 * Classes final
 * Uma classe com este modificador não pode ser estendida, isto é, não pode ter classes que fazem herança.
 * Isso é importante para garantir que uma determinada implementação não tenha seu comportamento modificado.
 * --
 * Método final
 * É um método que não pode ser sobrescrito nas subclasses.
 * Use para garantir que um determinado algoritmo não possa ser modificado pelas subclasses.
 * --
 * Atributo final
 * Pode ter seu valor atribuído UMA única vez, seja na própria declaração ou no construtor.
 */
public final class ClasseFinal {

    public static final String CONSTANTE = "NAO_POSSO_SER_ALTERADO";

    // Método final - não pode ser sobrescrito por subclasses
    // Não é necessário declarar o método como final, uma vez que a classe já é final.
    // Ou seja, já que não existe herança, não existe override.
    public static void metodoFinal() {
        System.out.println("Este é meu único comportamento.");
    }

}