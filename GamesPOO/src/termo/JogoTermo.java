package termo;



import global.ControlJogo;
import global.Main;
import global.Util;


public class JogoTermo {
    Util util = Main.util;
    ControlJogo controlJogo = util.controlJogo;

    public void jogandoTermo() {
        boolean sairDoJogo = false;

        while (!sairDoJogo) {
            util.palavras[0].escolherPalavra();
            ControlTermo termo = new ControlTermo();
            System.out.println("Tente adivinhar a palavra, ela e uma palavra de " + util.palavras[0].palavra.length() + " letras.");
            while (!controlJogo.getAcerto()) {
                for (int x=0; x<26;x++){
                    if (termo.alfabeto[x] != '0') System.out.print(termo.alfabeto[x] + " ");
                    else System.out.print("\033[0;31m" + termo.letrasUsadas[x] + " " + "\033[0m");
                }
                String entrada = controlJogo.mostrarOpcoes(0);

                if (termo.validacaoTermo(entrada)) {
                    break;
                }

            }


            System.out.println("\nDeseja continuar jogando Descubra a palavra (Se sim digite [1] se quer parar [0])");
            int resp = util.sc.nextInt();
            if (resp == 0) sairDoJogo = true;
            else Main.reset(util.main);
        }
    }

}
