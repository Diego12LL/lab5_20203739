import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document
import java.util.Date

object MongoDBManager {
    private val client = MongoClients.create("mongodb://localhost:27017")
    private val database: MongoDatabase = client.getDatabase("tu_base_de_datos")
    private val tareaCollection: MongoCollection<Document> = database.getCollection("tareas")

    fun guardarTarea(tarea: Tarea) {
        val document = Document("titulo", tarea.titulo)
                .append("descripcion", tarea.descripcion)
                .append("fechaVencimiento", tarea.fechaVencimiento)

        tareaCollection.insertOne(document)
    }

}
