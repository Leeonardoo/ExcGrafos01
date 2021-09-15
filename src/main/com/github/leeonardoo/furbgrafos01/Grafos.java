package com.github.leeonardoo.furbgrafos01;

/**
 * 1. Dada a matriz de adjacência do grafo de ordem n, você deve implementar um programa que
 * responda as seguintes perguntas:
 * <p>
 * Observações:
 * <p>
 * 1. o trabalho pode ser feito em dupla. A interpretação do enunciado faz parte da avaliação;
 * <p>
 * 2. a avaliação será feita sobre os programas-fonte entregues ao professor;
 * <p>
 * 3. os programas-fontes devem ser feitos em Java;
 * <p>
 * 4. serão consideradas a racionalidade e lógica da solução;
 * <p>
 * 5. coloque seu nome como comentário no início de cada programa-fonte;
 * <p>
 * 6. os programas-fonte devem ser postados no AVA até o dia 16/09/2021.
 */
public class Grafos {

    /**
     * a. Qual é o tipo do grafo (dirigido/digrafo ou não, simples ou multigrafo, regular, completo ou nulo)
     * nome do método: tipoDoGrafo
     *
     * @param matrizAdj matriz de adjacência
     * @return String contendo o tipo do grafo
     */
    public static String tipoDoGrafo(int[][] matrizAdj) {
        checkMatrix(matrizAdj);

        boolean hasLoop = false;
        int valueCount = 0;
        int reverseValueCount = 0;
        int adjCount = 0;
        boolean hasParallelEdges = false;
        //TODO regular
        for (int i = 0; i < matrizAdj.length; i++) {
            for (int j = 0; j < matrizAdj[i].length; j++) {
                int value = matrizAdj[i][j];
                int valueReversed = matrizAdj[j][i];
                if (value > 0 && i != j) {
                    valueCount += value;
                    if (value > 1) {
                        hasParallelEdges = true;
                    }
                } else if (value > 0) {
                    hasLoop = true;
                }

                if (value > 0 && valueReversed > 0 && i != j) {
                    reverseValueCount += valueReversed;
                }

                if (j >= i && value > 0) {
                    adjCount++;
                }
            }
        }

        boolean isDigraph = !(reverseValueCount >= valueCount);
        boolean isMultiGraph = hasLoop || hasParallelEdges || (reverseValueCount > 0 && reverseValueCount != valueCount);
        boolean isComplete = adjCount == matrizAdj.length && !isMultiGraph;

        var txt = "";

        if (isDigraph) {
            txt += "Dirigido";
        } else {
            txt += "Não Dirigido";
        }

        if (isMultiGraph) {
            txt += ", Multigrafo";
        } else {
            txt += ", Simples";
        }

        /*
        regular
         */

        if (isComplete && adjCount > 0) {
            txt += ", Completo";
        } else if (adjCount == 0) {
            txt += ", Nulo";
        }

        return txt;
    }

    /**
     * b. Quantas arestas esse grafo possui? Liste o conjunto de arestas.
     * nome do método: arestasDoGrafo
     *
     * @param matrizAdj matriz de adjacência
     * @return String com a quantidade e o conjunto de arestas
     */
    public static String arestasDoGrafo(int[][] matrizAdj) {
        checkMatrix(matrizAdj);

        return "";
    }

    /**
     * c. Qual é o grau de cada vértice. Liste a sequência de graus
     * nome do método: grausDoVertice
     *
     * @param matrizAdj matriz de adjacência
     * @return String identificando o grau de cada vértice e por fim, a sequência de graus
     */
    public static String grausDoVertice(int[][] matrizAdj) {
        checkMatrix(matrizAdj);

        if (isDigraph(matrizAdj)) {
            String degrees = "";
            for (int i =0; i < matrizAdj.length; i++) {
                degrees += calculateVertexDegree(matrizAdj, i, true) + " ";
            }
            return degrees;
        } else {
            String degrees = "";
            for (int i =0; i < matrizAdj.length; i++) {
                degrees += calculateVertexDegree(matrizAdj, i, false) + " ";
            }
            return degrees;
        }
//        return "";
    }

    /**
     * Verifica se um grafo é dirigido ou não
     *
     * @param matrizAdj matriz de adjacência
     * @return true se é dirigido, false do contrário
     */
    public static boolean isDigraph(int[][] matrizAdj) {
        checkMatrix(matrizAdj);

        int valueCount = 0;
        int reverseValueCount = 0;
        for (int i = 0; i < matrizAdj.length; i++) {
            for (int j = 0; j < matrizAdj[i].length; j++) {
                int value = matrizAdj[i][j];
                int valueReversed = matrizAdj[j][i];
                if (value > 0 && i != j) {
                    valueCount += value;
                }

                if (value > 0 && valueReversed > 0 && i != j) {
                    reverseValueCount += valueReversed;
                }
            }
        }

        return !(reverseValueCount >= valueCount);
    }

    /**
     * Calcula o grau da vértice solicitada, levando em conta laços e vértices paralelas
     *
     * @param matrizAdj matriz de adjacência
     * @param vertex    vértice da qual o grau vai ser calculado
     * @return grau da vértice
     */
    public static int calculateVertexDegree(int[][] matrizAdj, int vertex, boolean isDigraph) {
        if (matrizAdj.length == 0) return 0;

        int degree = 0;

        for (int i = 0; i < matrizAdj.length; i++) {
            if (matrizAdj[vertex][i] > 0)
                degree += matrizAdj[vertex][i];
        }

        //Considerar loops
        if (matrizAdj[vertex][vertex] > 0) {
            degree += matrizAdj[vertex][vertex];
        }

        return degree;
    }

    /**
     * Verifica se a matriz informada é válida, apenas afim de não causar
     * ArrayIndexOutOfBoundsException ao rodar o método.
     *
     * @param matrizAdj matriz de adjacência a ser validada
     */
    private static void checkMatrix(int[][] matrizAdj) {
        for (int[] ints : matrizAdj) {
            if (ints.length != matrizAdj.length) {
                throw new IllegalArgumentException("Matriz de adjacência inválida");
            }
        }
    }
}