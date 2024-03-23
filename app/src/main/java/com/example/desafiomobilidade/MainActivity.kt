package com.example.desafiomobilidade


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.desafiomobilidade.R.id
import com.example.desafiomobilidade.R.layout

class MainActivity : AppCompatActivity() {

    private lateinit var etApelido: EditText
    private lateinit var btnSalvar: Button
    private lateinit var btnCamera: Button
    private lateinit var imageView: ImageView

    private val CAMERA_REQUEST_CODE = 123

    private val cameraLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data
                val bitmap = data?.extras?.get("data") as? Bitmap
                // Exiba a foto capturada
                imageView.setImageBitmap(bitmap)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        etApelido = findViewById(id.et_apelido)
        btnSalvar = findViewById(id.btn_salvar)
        btnCamera = findViewById(id.btn_camera)



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
        val cameraPermission = Manifest.permission.CAMERA
        val permissionGranted =
            checkSelfPermission(cameraPermission) == PackageManager.PERMISSION_GRANTED

        if (!permissionGranted) {
            // Se a permissão não foi concedida, solicita permissão ao usuário
            requestPermissions(arrayOf(cameraPermission), REQUEST_CAMERA_PERMISSION)
            return false
        }

        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Se a permissão foi concedida, chama novamente o método para abrir a câmera
                openCamera()
            } else {
                // Lógica para lidar com a recusa da permissão
                Toast.makeText(this, "Permissão da câmera foi negada", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val REQUEST_CAMERA_PERMISSION = 100
    }
}
