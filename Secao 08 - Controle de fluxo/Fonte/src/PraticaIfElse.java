public class PraticaIfElse {
    private float ex1(String cargo) {
        float bonus = 0f;
        if (cargo == "Gerente") {
            bonus = 2000f;
        } else if (cargo == "Coordenador") {
            bonus = 1500f;
        } else if (cargo == "Engenheiro de software") {
            bonus = 1000f;
        } else if (cargo == "Estagiário") {
            bonus = 500f;
        }
        return bonus;
    }

    private float ex2(String cargo, int experiencia) {
        float bonus = 0f;
        if (cargo == "Gerente") {
            if (experiencia < 2) {
                bonus = 2000f;
            } else {
                bonus = 3000f;
            }
        } else if (cargo == "Coordenador") {
            if (experiencia < 1) {
                bonus = 1500f;
            } else {
                bonus = 1800f;
            }
        } else if (cargo == "Engenheiro de software") {
            bonus = 1000f;
        } else if (cargo == "Estagiário") {
            bonus = 500f;
        }
        return bonus;
    }

    private void ex3() {
        boolean a = false;
        boolean b = false;
        boolean c = true;
        boolean d = true;

        System.out.println(a && b && c && d);
        System.out.println(!a && !b && (c && d));
        System.out.println(a && ((b || c) || d));
        System.out.println(a || ((!b && c) || !d));
    }

    public static void main(String[] args) {
        System.out.println(new PraticaIfElse().ex1("Gerente"));

        System.out.println(new PraticaIfElse().ex2("Gerente", 2));
        System.out.println(new PraticaIfElse().ex2("Gerente", 5));
        new PraticaIfElse().ex3();
    }
}