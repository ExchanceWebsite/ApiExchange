package com.example.appexchance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appexchance.databinding.ActivityTelaOpcoesBinding
import com.example.appexchance.forms.FormLogin

class tela_opcoes : AppCompatActivity() {

    val binding by lazy {
        ActivityTelaOpcoesBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    binding.buttonLogin.setOnClickListener{
      val opcaoLogin =Intent(this, FormLogin::class.java)

      startActivity(opcaoLogin)
    }

    binding.buttonCadastro.setOnClickListener{
      val opcaoCadastro = Intent(this, tela_opcao_usuario::class.java)

        startActivity(opcaoCadastro)
    }

    binding.buttonPular.setOnClickListener {
        val opcaoPular = Intent(this, TelaPrincipal::class.java)

        startActivity(opcaoPular)
    }


    }
}