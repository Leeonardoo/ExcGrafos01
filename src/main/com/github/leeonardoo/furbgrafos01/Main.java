package com.github.leeonardoo.furbgrafos01;

public class Main {

    public static void main(String[] args) {
        Grafos grafos = new Grafos();

        System.out.println(grafos.tipoDoGrafo(new int[][]{
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        }));

        System.out.println(grafos.tipoDoGrafo(new int[][]{
                {0, 0, 0, 1},
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 0},
        }));

        System.out.println(grafos.tipoDoGrafo(new int[][]{
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 1, 1},
                {1, 0, 1, 0},
        }));

        //Digrafo multigrafo
        System.out.println(grafos.tipoDoGrafo(new int[][]{
                {0, 1, 0, 1},
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 0},
        }));

        //Nulo
        System.out.println(grafos.tipoDoGrafo(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        }));

        //Nulo
        System.out.println(grafos.tipoDoGrafo(new int[][]{}));

        //Completo
        System.out.println(grafos.tipoDoGrafo(new int[][]{
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0},
        }));

        //Digrafo Simples Completo
        System.out.println(grafos.tipoDoGrafo(new int[][]{
                {0, 1, 1},
                {0, 0, 1},
                {0, 0, 0},
        }));

        //Digrafo Multigrafo (não)Completo (pq não é simples)
        System.out.println(grafos.tipoDoGrafo(new int[][]{
                {0, 1, 1},
                {0, 0, 1},
                {0, 1, 0},
        }));
    }
}
