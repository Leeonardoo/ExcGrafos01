package com.github.leeonardoo.furbgrafos01;

public class Main {

    public static void main(String[] args) {
        System.out.println(Grafos.tipoDoGrafo(new int[][]{
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        }));

        System.out.println(Grafos.tipoDoGrafo(new int[][]{
                {0, 0, 0, 1},
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 0},
        }));

        System.out.println(Grafos.tipoDoGrafo(new int[][]{
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 1, 1},
                {1, 0, 1, 0},
        }));

        //Digrafo multigrafo
        System.out.println(Grafos.tipoDoGrafo(new int[][]{
                {0, 1, 0, 1},
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 0},
        }));

        //Nulo
        System.out.println(Grafos.tipoDoGrafo(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        }));

        //Nulo
        System.out.println(Grafos.tipoDoGrafo(new int[][]{}));

        //Completo
        System.out.println(Grafos.tipoDoGrafo(new int[][]{
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0},
        }));

        //Digrafo Simples Completo
        System.out.println(Grafos.tipoDoGrafo(new int[][]{
                {0, 1, 1},
                {0, 0, 1},
                {0, 0, 0},
        }));

        //Digrafo Multigrafo (não)Completo (pq não é simples)
        System.out.println(Grafos.tipoDoGrafo(new int[][]{
                {0, 1, 1},
                {0, 0, 1},
                {0, 1, 0},
        }));

        //Nao dirigido arestas paralelas
        System.out.println(Grafos.tipoDoGrafo(new int[][]{
                {0, 1, 1, 2},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {2, 0, 1, 0},
        }));

        System.out.println(Grafos.grausDoVertice(new int[][]{
                {0, 0, 0},
                {0, 0, 2},
                {0, 2, 1},
        }));
    }
}
