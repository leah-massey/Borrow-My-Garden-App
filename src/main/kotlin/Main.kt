
import Adapters.UserPostgresRepo
import Ports.UserRepo
import com.example.Adapters.GardensPostgresRepo
import com.example.Adapters.HttpAPI
import com.example.Ports.GardensRepo
import com.example.domain.GardenReadDomain
import com.example.domain.GardenWriteDomain
import domain.UserWriteDomain
import org.http4k.core.HttpHandler
import org.http4k.core.then
import org.http4k.filter.DebuggingFilters.PrintRequest
import org.http4k.server.SunHttp
import org.http4k.server.asServer
import org.postgresql.ds.PGSimpleDataSource
fun main() {
    val GardenRepoDatasource: GardensRepo = GardensPostgresRepo(PGSimpleDataSource().apply {
        user = "postgres"
        password = "mysecretpassword"
        databaseName = "borrowmygarden"
        serverNames = arrayOf(System.getenv("DB_HOST") ?: "localhost") // will read from docker, otherwise will default to localhost
        portNumbers = intArrayOf(System.getenv("DB_PORT")?.toInt() ?: 5432) // same as above although maybe not needed as always 5432
    })

    val UserRepoDatasource: UserRepo = UserPostgresRepo(PGSimpleDataSource().apply {
        user = "postgres"
        password = "mysecretpassword"
        databaseName = "borrowmygarden"
        serverNames = arrayOf(System.getenv("DB_HOST") ?: "localhost") // will read from docker, otherwise will default to localhost
        portNumbers = intArrayOf(System.getenv("DB_PORT")?.toInt() ?: 5432) // same as above although maybe not needed as always 5432
    })

    val gardenReadDomain = GardenReadDomain(GardenRepoDatasource)
    val gardenWriteDomain = GardenWriteDomain(GardenRepoDatasource)
    val userWriteDomain = UserWriteDomain(UserRepoDatasource)
    val httpAPI = HttpAPI(gardenReadDomain, gardenWriteDomain, userWriteDomain)

    val printingApp: HttpHandler = PrintRequest().then(httpAPI.app)

    val server = printingApp.asServer(SunHttp(9000)).start()

    println("Server started on " + server.port())
}
