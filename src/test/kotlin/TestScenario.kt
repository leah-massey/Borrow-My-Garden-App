import com.example.Adapters.GardensPostgresRepo
import com.example.Adapters.HttpAPI
import com.example.Ports.GardensRepo
import com.example.domain.ReadDomain
import com.example.domain.WriteDomain

import org.postgresql.ds.PGSimpleDataSource

class TestScenario {
    val appTestDatabase: GardensRepo =  GardensPostgresRepo(PGSimpleDataSource().apply {
        user = "postgres"
        databaseName = "borrow_my_garden_test_db"
    })

    private val readDomain = ReadDomain(appTestDatabase)
    private val writeDomain = WriteDomain(appTestDatabase)

    private val httpAPI = HttpAPI(readDomain, writeDomain)

    val testApp = TestApp(httpAPI)

}
