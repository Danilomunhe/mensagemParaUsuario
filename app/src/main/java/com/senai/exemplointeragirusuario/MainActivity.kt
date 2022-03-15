package com.senai.exemplointeragirusuario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.senai.exemplointeragirusuario.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        val toastButton = findViewById<Button>(R.id.toast)
        //val alertButton = findViewById<Button>(R.id.alert)
        //val snackButton = findViewById<Button>(R.id.snack)

        toastButton.setOnClickListener {mensagemToast()}
        //alertButton.setOnClickListener({mensagemAlert()})
        //snackButton.setOnClickListener({mensagemSnack(snackButton)})

        //Não utilizar
        //alert.setOnClickListener({mensagemAlert()})
        //snack.setOnClickListener({mensagemSnack(snack)})

        //Precisa habilitar no arquivo build.gradle dentro da chave android colocar:
        //  viewBinding{
        //        enabled = true
        //    }

        binding.snack.setOnClickListener({mensagemSnack(binding.snack)})

    }

    private fun mensagemSnack(snackButton: Button) {
        Snackbar.make(snackButton, "Teste mensagem SNACKBAR",Snackbar.LENGTH_SHORT).setAction("Sair"){finish()}.show()
    }

    private fun mensagemAlert() {
        AlertDialog
            .Builder(this)
            .setTitle(" Atenção!!!")
            .setMessage("Deseja Sair do APP?")
            .setPositiveButton("Sim" ) {_,_ -> finish()}
            .setNegativeButton("Cancelar") {_,_ ->}
            .show()
    }

    private fun mensagemToast() {
        Toast.makeText(this, "teste de toast!", Toast.LENGTH_SHORT).show()
    }


}