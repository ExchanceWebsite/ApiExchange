package com.example.appexchance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appexchance.databinding.ActivityTelaOpcoesBinding
<<<<<<< HEAD
import com.example.appexchance.forms.FormCadastro
=======
>>>>>>> e38534c6157714f50c8e0165b1a3971245df837e
import com.example.appexchance.forms.FormLogin

class tela_opcoes : AppCompatActivity() {

    val binding by lazy {
        ActivityTelaOpcoesBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

<<<<<<< HEAD

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, FormLogin::class.java)
            startActivity(intent)
        }

        binding.btnCadastro.setOnClickListener {
            val intent = Intent(this, tela_opcao_usuario::class.java)
            startActivity(intent)
        }

=======
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
>>>>>>> e38534c6157714f50c8e0165b1a3971245df837e


    }



}