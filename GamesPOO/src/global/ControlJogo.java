package global;

public class ControlJogo{
    public Integer quatidadeDePalavras = 1;
    public Integer tentativas = 0;
    public Integer quantidadeDeAcertos = 0;
    public boolean acerto = false;
    public Integer pontos = 0;
    public Integer pontosAnt = 0;
    public boolean[] palavrasAcertada;

    public ControlJogo(){
        System.out.println("Bagulho inicio");
        quatidadeDePalavras = 1;
        quantidadeDeAcertos =0;
        tentativas = 1;
        acerto = false;
        pontos = 0;
        palavrasAcertada = new boolean[1];
    }
    public ControlJogo(Integer quatidadeDePalavras){
        this.quatidadeDePalavras = quatidadeDePalavras;
        quantidadeDeAcertos =0;
        tentativas = 1;
        acerto = false;
        pontos = 0;
        palavrasAcertada = new boolean[quatidadeDePalavras];
    }
    public ControlJogo(Integer quatidadeDePalavras, Integer pontos){
        this.quatidadeDePalavras = quatidadeDePalavras;
        quantidadeDeAcertos =0;
        tentativas = 1;
        acerto = false;
        this.pontos = 0;
        pontosAnt = pontos;
        palavrasAcertada = new boolean[quatidadeDePalavras];
    }

    public static String mostrarOpcoes(){
        System.out.println("\nInforme a palavra, 'dica' para receber uma dica ou '0' para desistir!");
        return Main.sc.nextLine();
    }

    public int verificacaoReposta(String entrada){
        if(entrada.equals("0")){
            System.out.println("desistil com " + tentativas + " tentativas, seu merda,lixo,desperdicio de oxigenio");
            return 1;
        }else if(entrada.equals("dica")){
            Main.dicas.revelacaoPalavra();
            Main.dicas.mostrarDica();
            Main.dicas.quantidadeDicas ++;
            return 0;
        } else {
            boolean acertouAlguma = false;
            for (int x=0; x<Main.controlJogo.quatidadeDePalavras; x++) {
                String palavraEscolhida = Main.palavras[x].palavra;
                if (entrada.equals(palavraEscolhida)) {
                    if (!palavrasAcertada[x]) {
                        quantidadeDeAcertos++;
                        palavrasAcertada[x] = true;
                        acertouAlguma = true;
                        System.out.println("palavra "+ (x+1) +"° certa");

                        if (quantidadeDeAcertos == quatidadeDePalavras) {
                            pontos = pontosAnt + (quatidadeDePalavras * (100 - ((tentativas - 1) * 6)) - (Main.dicas.quantidadeDicas * 18));
                            System.out.println("Parabens vc acertou com " + tentativas + " tentativas e " + Main.dicas.quantidadeDicas + " dicas usadas, Mais os " + pontosAnt + " Pontos das partidas anteriores");
                            System.out.println("Resultando em " + pontos + " pontos. \n\n");

                            acerto = true;
                        }
                    }
                }

            }
            if (!acertouAlguma) {
                tentativas++;
                System.out.println("Palavra errada! Tente novamente.");
            }
        }
        return 0;
    }



}