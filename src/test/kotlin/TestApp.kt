import com.example.Adapters.HttpAPI
import org.http4k.core.HttpHandler
import org.http4k.filter.CorsPolicy
import org.http4k.filter.ServerFilters

class TestApp(val httpAPI: HttpAPI) {
    val cors = ServerFilters.Cors(CorsPolicy.UnsafeGlobalPermissive)

    val app: HttpHandler = httpAPI.app
}