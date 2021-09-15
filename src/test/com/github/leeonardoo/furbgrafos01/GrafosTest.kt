package com.github.leeonardoo.furbgrafos01

import org.junit.jupiter.api.Test
import kotlin.reflect.full.functions
import kotlin.reflect.jvm.isAccessible
import kotlin.reflect.jvm.javaMethod
import kotlin.test.assertEquals
import kotlin.test.fail

class GrafosTest {

    @Test
    fun nao_dirigido_simples() {
        println(
            Grafos.tipoDoGrafo(
                arrayOf(
                    intArrayOf(0, 1, 1, 1),
                    intArrayOf(1, 0, 1, 0),
                    intArrayOf(1, 1, 0, 1),
                    intArrayOf(1, 0, 1, 0)
                )
            )
        )
    }

    @Test
    fun dirigido_simples() {
        println(
            Grafos.tipoDoGrafo(
                arrayOf(
                    intArrayOf(0, 0, 0, 1),
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(0, 1, 0, 0),
                    intArrayOf(0, 1, 1, 0)
                )
            )
        )
    }

    @Test
    fun nao_dirigido_multigrafo() {
        println(
            Grafos.tipoDoGrafo(
                arrayOf(
                    intArrayOf(0, 1, 1, 1),
                    intArrayOf(1, 0, 1, 0),
                    intArrayOf(1, 1, 1, 1),
                    intArrayOf(1, 0, 1, 0)
                )
            )
        )
    }

    @Test
    fun dirigido_multigrafo() {
        println(
            Grafos.tipoDoGrafo(
                arrayOf(
                    intArrayOf(0, 1, 0, 1),
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(0, 1, 0, 0),
                    intArrayOf(0, 1, 1, 0)
                )
            )
        )
    }

    @Test
    fun nao_dirigido_simples_nulo() {
        println(
            Grafos.tipoDoGrafo(
                arrayOf(
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0)
                )
            )
        )
    }

    @Test
    fun nao_dirigido_simples_nulo_vazio() {
        println(Grafos.tipoDoGrafo(arrayOf()))
    }

    @Test
    fun nao_dirigido_simples_completo() {
        println(Grafos.tipoDoGrafo(arrayOf(intArrayOf(0, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 0))))
    }

    @Test
    fun dirigido_simples_completo() {
        println(Grafos.tipoDoGrafo(arrayOf(intArrayOf(0, 1, 1), intArrayOf(0, 0, 1), intArrayOf(0, 0, 0))))
    }

    @Test
    fun dirigido_multigrafo_nao_completo_nao_simples() {
        println(Grafos.tipoDoGrafo(arrayOf(intArrayOf(0, 1, 1), intArrayOf(0, 0, 1), intArrayOf(0, 1, 0))))
    }

    @Test
    fun nao_dirigido_multigrafo_arestas_paralelas() {
        println(
            Grafos.tipoDoGrafo(
                arrayOf(
                    intArrayOf(0, 1, 1, 2),
                    intArrayOf(1, 0, 1, 0),
                    intArrayOf(1, 1, 0, 1),
                    intArrayOf(2, 0, 1, 0)
                )
            )
        )
    }

    @Test
    fun graus_vertice_nao_dirigido_1() {
        val testArr = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 2),
            intArrayOf(0, 2, 1)
        )

        assertEquals(0, Grafos.calculateVertexDegree(testArr, 0))

        assertEquals(2, Grafos.calculateVertexDegree(testArr, 1))

        assertEquals(4, Grafos.calculateVertexDegree(testArr, 2))

        //Handshaking
        assertEquals(
            testArr.size * 2,
            Grafos.calculateVertexDegree(testArr, 0) +
                    Grafos.calculateVertexDegree(testArr, 1) +
                    Grafos.calculateVertexDegree(testArr, 2)
        )
    }

    @Test
    fun graus_vertice_nao_dirigido_2() {
        val testArr = arrayOf(
            intArrayOf(1)
        )

        assertEquals(2, Grafos.calculateVertexDegree(testArr, 0))

        //Handshaking
        assertEquals(
            testArr.size * 2,
            Grafos.calculateVertexDegree(testArr, 0)
        )
    }

    @Test
    fun dummy() {
        println(Grafos.grausDoVertice(
            arrayOf(
                intArrayOf(0, 1, 1, 1),
                intArrayOf(1, 0, 1, 0),
                intArrayOf(1, 1, 0, 1),
                intArrayOf(1, 0, 1, 0)
            )
        ))
    }
}