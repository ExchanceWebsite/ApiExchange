package com.example.appexchance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.appexchance.databinding.ActivityTelaUsuarioIntercambistaBinding
import com.example.appexchance.forms.models.RespostaDadosIntercambista
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaUsuarioIntercambista : AppCompatActivity() {


    val binding by lazy {
        ActivityTelaUsuarioIntercambistaBinding.inflate(layoutInflater)
    }

    fun buscarDados(): Call<RespostaDadosIntercambista> {

        val nome = intent.getStringExtra("txt_nome") ?: "Valor não encontrado"
        val email = intent.getStringExtra("txt_email") ?: "Valor não encontrado"

        Log.d("MinhaAtividade", "$nome e $email")


        val apiService = RestClient.create()

        return apiService.buscar(email, nome)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (intent != null) {
            val nome = intent.getStringExtra("txt_nome")
            binding.nomeUsuarioHost.text = "Bem Vindo! $nome"
        }
        colocarDados()
    }

    private fun colocarDados() {
        val call = buscarDados()

        call.enqueue(object : Callback<RespostaDadosIntercambista> {
            override fun onResponse(call: Call<RespostaDadosIntercambista>, response: Response<RespostaDadosIntercambista>) {
                if (response.isSuccessful) {
                    val resposta = response.body()

                    if (resposta != null) {
                        binding.txtBusca.text = " Nome: ${resposta.nome}\n Idade: ${resposta.idade}\n Email: ${resposta.email}"
                    } else {
                        binding.txtBusca.text = "Sem resposta válida do servidor"
                    }

                } else {
                    Toast.makeText(this@TelaUsuarioIntercambista, "Dados não encontrados!!!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<RespostaDadosIntercambista>, t: Throwable) {
                Log.d("MinhaAtividade", "${t.message}")
                Toast.makeText(this@TelaUsuarioIntercambista, "Erro de rede", Toast.LENGTH_SHORT).show()
            }
        })
    }


}