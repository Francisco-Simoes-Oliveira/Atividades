package Termo;


import global.ControlJogo;
import global.Main;


public class JogoTermo {



    public void jogandoTermo() {
        boolean sairDoJogo = false;




        while (!sairDoJogo) {
            Main.palavras[0].escolherPalavra();
            Termo termo = new Termo();
            System.out.println("Tente adivinhar a palavra, ela e uma palavra de " + Main.palavras[0].palavra.length() + " letras.");
            while (!Main.controlJogo.acerto) {
                for (int x=0; x<26;x++){
                    if (termo.alfabeto[x] != '0') System.out.print(termo.alfabeto[x] + " ");
                    else System.out.print("\033[0;31m" + termo.letrasUsadas[x] + " " + "\033[0m");
                }
                String entrada = ControlJogo.mostrarOpcoes();

                if (termo.validacaoTermo(entrada)) {
                    break;
                }

            }


            System.out.println("\nDeseja continuar jogando Descubra a palavra (Se sim digite [1] se quer parar [0])");
            int resp = Main.sc.nextInt();
            if (resp == 0) sairDoJogo = true;
            else Main.reset();
        }
    }

}
