/**
 * Uma classe tem necessariamente um nome e não precisa ter métodos ou atributos.
 * Mesmo uma classe vazia sem métodos e atributos ainda precisa das chaves {} para que seja compilada.
 * --
 * Os métodos são considerados comportamentos da classe e também são referenciados como funções.
 * Os atributos são as características da classe, são os dados que ela carrega.
 * Os atributos, com seus valores, representam o estado de um objeto. Estado são as informações que os atributos carregam.
 * --
 * Ao se criar a instância de uma classe usando a palavra new, é criado um objeto.
 * Esse objeto será alocado na memória e referenciado pela variável usada para istanciá-lo.
 */
class Introducao {

    // Atributo inteiro chamado 'id'
    int id = 0;

    String ola() {
        return "Olá, mundo!";
    }

    public static void main(String[] args) {

        // Como instanciar uma classe e acessar atributos e métodos
        Introducao introducao = new Introducao();
        System.out.println(introducao.id);
        System.out.println(introducao.ola());

    }
}

// Este é o formato mais simples de se declarar uma classe. Sem atributos e sem métodos
// class Introducao { }