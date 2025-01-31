package interfaces;

/**
 * Interfaces podem conter declarações de métodos que serão obrigatoriamente sobrescritos.
 * Os métodos que serão sobrescritos precisam estar com assinatura e tipo de retorno definido,
 * não pode haver corpo.
 * --
 * A diferença de interface com classe abstrata é que interfaces não possuem nenhum método com corpo.
 * Interface não pode ter método ou atributo privado, tudo é público.
 * --
 * É possível que uma classe implemente mais de uma interface, não há problema.
 * Implementar mais de uma interface não caracteriza herança múltipla.
 */
public interface Maquina {

    // Variável que não pode ter seu valor alterado
    // Não é uma boa prática manter uma variável na interface, pelo fato de que uma interface
    // representa um contrato e a ideia é que esse contrato não possua estado.
    // Ou seja, que não existam variáveis com valores definidos.
    // int valor = 10;

    void ligar();
    void desligar();

}
