
import com.example.Adapters.GardensPostgresRepo
import com.example.Adapters.HttpAPI
import com.example.Ports.GardensRepo
import com.example.domain.ReadDomain
import com.example.domain.WriteDomain
import org.http4k.core.HttpHandler
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters.PrintRequest
import org.http4k.server.SunHttp
import org.http4k.server.asServer
import org.postgresql.ds.PGSimpleDataSource

fun main() {
    val gardensRepoDatasource: GardensRepo = GardensPostgresRepo(PGSimpleDataSource().apply {
        user = "postgres"
        password = "mysecretpassword"
        databaseName = "borrowmygarden"
        serverNames = arrayOf(System.getenv("DB_HOST") ?: "localhost") // will read from docker, otherwise will default to localhost
        portNumbers = intArrayOf(System.getenv("DB_PORT")?.toInt() ?: 5432) // same as above although maybe not needed as always 5432
    })

    val readDomain = ReadDomain(gardensRepoDatasource)
    val writeDomain = WriteDomain(gardensRepoDatasource)
    val httpAPI = HttpAPI(readDomain, writeDomain)

    val printingApp: HttpHandler = PrintRequest().then(httpAPI.app)

    val server = printingApp.asServer(SunHttp(9000)).start()

    println("Server started on " + server.port())
}
