public class Portaria {
    public String controle(int idade, String tipo, String codigoConvite) {
        if (idade < 18) {
            return "Negado. Menores de idade não são permitidos.";
        }

        if (!tipo.equals("comum") && !tipo.equals("premium") && !tipo.equals("luxo")) {
            return "Negado. Convite inválido.";
        }

        if ((tipo.equals("premium") || tipo.equals("luxo")) && codigoConvite.startsWith("XL")) {
            return "Welcome :)";
        }

        if (tipo.equals("comum") && codigoConvite.startsWith("XT")) {
            return "Welcome :)";
        }

        return "Negado. Convite inválido.";
    }
}
