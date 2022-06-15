import java.util.Arrays;
import java.util.Objects;

public class Labirinto {
    private String [][] labirinto = {
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", "E", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", " ", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", "#", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", " ", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", "#", "#", " ", "#", "#", "#", "#", " ", "#", "#", "#", "#", "#", "#"},
            {"#", "#", "#", " ", "#", " ", " ", " ", " ", " ", "#", "#", "#", "#", "#"},
            {"#", "#", "#", " ", " ", " ", "#", "#", "#", " ", "#", "#", "#", "#", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", " ", " ", " ", " ", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", " ", "#", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", " ", "#", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", " ", "#", "S", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
    };

    /* Labirinto sem saída
    private String [][] labirinto = {
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", "E", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", " ", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", "#", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", " ", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", "#", "#", " ", "#", "#", "#", "#", " ", "#", "#", "#", "#", "#", "#"},
            {"#", "#", "#", " ", "#", " ", " ", " ", " ", " ", "#", "#", "#", "#", "#"},
            {"#", "#", "#", " ", " ", " ", "#", "#", "#", " ", "#", "#", "#", "#", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", " ", " ", " ", " ", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", " ", "#", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", " ", "#", "#", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", " ", "#", "S", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
    };*/

    /* Labirinto auxiliar
    private String [][] labirinto = {
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", "E", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", " ", " ", " ", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", "#", " ", "#", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", "#", "#", "#", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", "#", " ", " ", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", " ", " ", "#", "#", "#", "#", " ", "#", "#", "#", "#", "#", "#"},
            {"#", "#", "#", " ", "#", " ", "#", " ", " ", " ", "#", "#", "#", "#", "#"},
            {"#", "#", "#", " ", " ", " ", "#", " ", "#", " ", "#", "#", "#", "#", "#"},
            {"#", "#", "#", "#", "#", " ", "#", " ", "#", " ", " ", " ", " ", "#", "#"},
            {"#", "#", "#", "#", "#", " ", " ", " ", "#", "#", "#", " ", "#", "#", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", " ", "#", "#", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", " ", " ", "S", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
    };*/


    ArrayStack linha = new ArrayStack(1,0);
    ArrayStack coluna = new ArrayStack(1,0);
    ArrayStack ultimaPosicao = new ArrayStack(1,0);

    public Labirinto() {
        this.labirinto = labirinto;
    }


    //Anda pelo labirinto
    public void andaPeloLabirinto() {

        posicaoInicial();

        while (!encontraSaida()) {
            marcaPosicao();
            System.out.println("Linha: " + linha);
            System.out.println("Coluna: " + coluna);
            mostraLabirinto();

            //Anda para cima
            if ((labirinto[linha.ultimaPosicao() - 1][coluna.ultimaPosicao()] == " ") || (labirinto[linha.ultimaPosicao() - 1][coluna.ultimaPosicao()] == "S")) {
                var posicao = labirinto[linha.ultimaPosicao() - 1][coluna.ultimaPosicao()];
                linha.push(linha.ultimaPosicao() - 1);
                ultimaPosicao.push(0);

            }

            //Anda para direita
            else if ((labirinto[linha.ultimaPosicao()][coluna.ultimaPosicao() + 1] == " ") || (labirinto[linha.ultimaPosicao()][coluna.ultimaPosicao() + 1] == "S")) {
                var posicao = labirinto[linha.ultimaPosicao()][coluna.ultimaPosicao() + 1];
                coluna.push(coluna.ultimaPosicao() + 1);
                ultimaPosicao.push(1);

            }

            //Anda para baixo
            else if ((labirinto[linha.ultimaPosicao() + 1][coluna.ultimaPosicao()] == " ") || (labirinto[linha.ultimaPosicao() + 1][coluna.ultimaPosicao()] == "S")) {
                var posicao = labirinto[linha.ultimaPosicao() + 1][coluna.ultimaPosicao()];
                linha.push(linha.ultimaPosicao() + 1);
                ultimaPosicao.push(2);
            }

            //Anda para esquerda
            else if ((labirinto[linha.ultimaPosicao()][coluna.ultimaPosicao() - 1] == " ") || (labirinto[linha.ultimaPosicao()][coluna.ultimaPosicao() - 1] == "S")) {
                var posicao = labirinto[linha.ultimaPosicao()][coluna.ultimaPosicao() - 1];
                coluna.push(coluna.ultimaPosicao() - 1);
                ultimaPosicao.push(3);
            }

            //Quando não se acha saída, desempilha as posições até encontrar outro caminho
            else {
                switch (ultimaPosicao.ultimaPosicao()) {

                    //Volta para baixo
                    case 0:
                        linha.pop();
                        ultimaPosicao.pop();
                        break;

                    //Volta para esquerda
                    case 1:
                        coluna.pop();
                        ultimaPosicao.pop();
                        break;

                    //Volta para cima
                    case 2:
                        ultimaPosicao.pop();
                        linha.pop();
                        break;

                    //Volta para direita
                    case 3:
                        coluna.pop();
                        ultimaPosicao.pop();
                        break;
                }
            }
        }
    }

    //Função para validar se encontrou a saída ou não e se o labirinto possui saída
    public boolean encontraSaida() {
        if (Objects.equals(labirinto[linha.ultimaPosicao()][coluna.ultimaPosicao()], "S")) {
            System.out.println("Vc encontrou a saida! UHUUUL");

            return true;
        }
        else if (linha.isEmpty() || coluna.isEmpty()) {
            System.out.println("Labirinto sem saída :(");
            System.out.println("Linha: " + linha);
            System.out.println("Coluna: " + coluna);
            return true;
        }
        return false;
    }

    //Define a posição de entrada do labirinto como [1][1]
    public void posicaoInicial() {
        linha.push(1);
        coluna.push(1);
        ultimaPosicao.push(0);

        System.out.println("Vc esta na entrada: " + linha.ultimaPosicao() + ", " + coluna.ultimaPosicao());

    }

    //Marca a posição por onde andou com a letra P
    public void marcaPosicao() {
        labirinto[linha.ultimaPosicao()][coluna.ultimaPosicao()] = "P";
    }

    //Imprime o labirinto
    public void mostraLabirinto() {
        for (String[] strings : labirinto) {
            System.out.println(Arrays.toString(strings));
        }
    }
}
