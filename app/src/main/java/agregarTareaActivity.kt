import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lab5_iot_20203739.R
import java.util.Date

class AgregarTareaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.guardar)

        val buttonGuardar = findViewById<Button>(R.id.buttonGuardar)
        buttonGuardar.setOnClickListener {
            guardarTarea()
        }
    }

    private fun guardarTarea() {
        val editTextTitulo = findViewById<EditText>(R.id.editTextTitulo)
        val editTextDescripcion = findViewById<EditText>(R.id.editTextDescripcion)

        val titulo = editTextTitulo.text.toString()
        val descripcion = editTextDescripcion.text.toString()
        val fechaVencimiento = Date()

        val tarea = Tarea(titulo, descripcion, fechaVencimiento)

        MongoDBManager.guardarTarea(tarea)


        Toast.makeText(this, "Tarea guardada exitosamente", Toast.LENGTH_SHORT).show()
    }
}
