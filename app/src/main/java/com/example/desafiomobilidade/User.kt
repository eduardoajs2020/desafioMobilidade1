package com.example.desafiomobilidade

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var etApelido: EditText
    private lateinit var btnSalvar: Button
    private lateinit var btnCamera: Button
    private lateinit var imageView: ImageView

    private val CAMERA_REQUEST_CODE = 123

    private val cameraLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data
                val bitmap = data?.extras?.getString("data") as Bitmap
                // Exiba a foto capturada
                imageView.setImageBitmap(bitmap)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etApelido = findViewById(R.id.et_apelido)
        btnSalvar = findViewById(R.id.btn_salvar)
        btnCamera = findViewById(R.id.btn_camera)


        btnSalvar.setOnClickListener {
            val apelido = etApelido.text.toString()

            if (StringUtils.isAlphanumeric(apelido) && StringUtils.isValidLength(apelido, 3, 20)) {
                // Apelido válido
                Toast.makeText(this, "Apelido salvo com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                // Apelido inválido
                Toast.makeText(
                    this,
                    "Apelido inválido. Digite apenas letras e números (3 a 20 caracteres).",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        btnCamera.setOnClickListener {
            openCamera()
        }
    }

    private fun openCamera() {
        if (checkPermission()) {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            cameraLauncher.launch(intent)
        }
    }

    private fun checkPermission(): Boolean {
        // Implemente a lógica de verificação de permissão aqui
        return true // Retorne true se a permissão estiver concedida
    }
}
