package global;

public class ControlJogo{
    public Integer quantidadeDePalavras;
    public Integer tentativas ;
    private Integer quantidadeDeAcertos ;
    private boolean acerto ;
    public Integer pontos ;
    private Integer pontosAnt = 0;
    private boolean[] palavrasAcertada;
    private Main main ;

    protected ControlJogo(){
        System.out.println("Bagulho inicio");
        quantidadeDePalavras = 1;
        quantidadeDeAcertos =0;
        tentativas = 1;
        acerto = false;
        pontos = 0;
        palavrasAcertada = new boolean[1];
    }
    public ControlJogo(Main main){
        this.main = main;
        quantidadeDePalavras = 1;
        quantidadeDeAcertos =0;
        tentativas = 1;
        acerto = false;
        pontos = 0;
        palavrasAcertada = new boolean[1];
    }
    public ControlJogo(Integer quantidadeDePalavras){
        this.quantidadeDePalavras = quantidadeDePalavras;
        quantidadeDeAcertos =0;
        tentativas = 1;
        acerto = false;
        pontos = 0;
        palavrasAcertada = new boolean[quantidadeDePalavras];
    }
    public ControlJogo(Integer quantidadeDePalavras, Integer pontos, Main main){
        this.quantidadeDePalavras = quantidadeDePalavras;
        quantidadeDeAcertos =0;
        tentativas = 1;
        acerto = false;
        this.pontos = 0;
        pontosAnt = pontos;
        palavrasAcertada = new boolean[quantidadeDePalavras];
        this.main = main;
    }

    public String mostrarOpcoes(){
        System.out.println("\nInforme a palavra, 'dica' para receber uma dica ou '0' para desistir!");
        return main.util.sc.nextLine();
    }
    public String mostrarOpcoes(int n){
        System.out.println("\nInforme a palavra ou '0' para desistir!");
        return main.util.sc.nextLine();
    }

    public int verificacaoReposta(String entrada){
        if(entrada.equals("0")){
            System.out.println("desistil com " + tentativas + " tentativas, seu merda,lixo,desperdicio de oxigenio");
            return 1;
        }else if(entrada.equals("dica")){
            main.dicas.revelacaoPalavra();
            main.dicas.mostrarDica();
            main.dicas.quantidadeDicas ++;
            return 0;
        } else {
            boolean acertouAlguma = false;
            for (int x = 0; x<main.util.controlJogo.quantidadeDePalavras; x++) {
                String palavraEscolhida = main.util.palavras[x].palavra;
                if (entrada.equals(palavraEscolhida)) {
                    if (!palavrasAcertada[x]) {
                        quantidadeDeAcertos++;
                        palavrasAcertada[x] = true;
                        acertouAlguma = true;
                        System.out.println("palavra "+ (x+1) +"° certa");

                        if (quantidadeDeAcertos == quantidadeDePalavras) {
                            pontos = pontosAnt + (quantidadeDePalavras * (100 - ((tentativas - 1) * 6)) - (main.dicas.quantidadeDicas * 18));
                            System.out.println("Parabens vc acertou com " + tentativas + " tentativas e " + main.dicas.quantidadeDicas + " dicas usadas, Mais os " + pontosAnt + " Pontos das partidas anteriores");
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

    public void setMain(Main main) {
        this.main = main;
    }

    public Integer getPontosAnt() {
        return pontosAnt;
    }
    public boolean getPalavrasAcertada(int i) {
        return palavrasAcertada[i];
    }
    public boolean getAcerto() {
        return acerto;
    }
    public Integer getQuantidadeDeAcertos() {
        return quantidadeDeAcertos;
    }
}