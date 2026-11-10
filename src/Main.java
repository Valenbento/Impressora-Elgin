public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("admin", "1234");
        boolean logado = false;

        for (int tentativa = 3; tentativa > 0; tentativa--) {
            System.out.println("Usuario:");
            String u = Menu.lerTexto();
            System.out.println("Senha:");
            String s = Menu.lerTexto();

            if (usuario.autenticar(u, s)) {
                logado = true;
                System.out.println("Login realizado!");
                break;
            }
            System.out.println("Usuario ou senha incorretos. Tentativas restantes: " + (tentativa - 1));
        }

        if (!logado) {
            System.out.println("Voce errou 3 vezes. Programa encerrado.");
            return;
        }

        Menu menu = new Menu();
        menu.menuImpressora();
    }
}