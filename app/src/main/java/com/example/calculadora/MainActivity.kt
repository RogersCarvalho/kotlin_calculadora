package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Retira a toolbar
        supportActionBar!!.hide()

        //Ao clicar no numero zero chama a função
        numero_zero.setOnClickListener { AcrescentarUmaExpressao("0", true) }
        numero_um.setOnClickListener { AcrescentarUmaExpressao("1", true) }
        numero_dois.setOnClickListener { AcrescentarUmaExpressao("2", true) }
        numero_tres.setOnClickListener { AcrescentarUmaExpressao("3", true) }
        numero_quatro.setOnClickListener { AcrescentarUmaExpressao("4", true) }
        numero_cinco.setOnClickListener { AcrescentarUmaExpressao("5", true) }
        numero_seis.setOnClickListener { AcrescentarUmaExpressao("6", true) }
        numero_sete.setOnClickListener { AcrescentarUmaExpressao("7", true) }
        numero_oito.setOnClickListener { AcrescentarUmaExpressao("8", true) }
        numero_nove.setOnClickListener { AcrescentarUmaExpressao("9", true) }
        ponto.setOnClickListener { AcrescentarUmaExpressao(".", true) }

        //Operadores
        soma.setOnClickListener { AcrescentarUmaExpressao("+", false) }
        subtracao.setOnClickListener { AcrescentarUmaExpressao("-", false) }
        multiplicacao.setOnClickListener { AcrescentarUmaExpressao("*", false) }
        divisao.setOnClickListener { AcrescentarUmaExpressao("/", false) }

        limpar.setOnClickListener {
            text_expressao.text = ""
            text_resultado.text = ""
        }


        backspace.setOnClickListener {
            val string = text_expressao.text.toString()
            if (string.isNotBlank()) {
                //Para o substring passa a posição 0 e a ultima posicao da string
                // o método substring retira uma posição
                text_expressao.text = string.substring(0, string.length - 1)
            }
            text_resultado.text = ""
        }

            igual.setOnClickListener {

            try {
                val expressao = ExpressionBuilder(text_expressao.text.toString()).build()
                val resultado = expressao.evaluate()
                val longResult = resultado.toLong()

                if (resultado == longResult.toDouble())
                    text_resultado.text = longResult.toString()
                else
                    text_resultado.text = resultado.toString()
            } catch (e: Exception) { } }
    }


    

    fun AcrescentarUmaExpressao(vstring:String, limpar_dados: Boolean){

        if (text_resultado.text.isNotEmpty()){
            text_expressao.text = ""
        }

        if (limpar_dados){
            text_resultado.text = ""
            text_expressao.append(vstring)
        }
        else {
            text_expressao.append(text_resultado.text)
            text_expressao.append(vstring)
            text_resultado.text = ""
        }





    }




}