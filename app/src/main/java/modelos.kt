import java.util.Date

data class Tarea(
        val titulo: String,
        val descripcion: String,
        val fechaVencimiento: Date
)

data class Recordatorio(
        val tareaId: String,
        val fechaRecordatorio: Date,
        val importancia: Int
)