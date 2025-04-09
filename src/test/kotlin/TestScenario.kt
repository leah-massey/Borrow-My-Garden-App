import Adapters.UserPostgresRepo
import Ports.UserRepo
import com.example.Adapters.GardensPostgresRepo
import com.example.Adapters.HttpAPI
import com.example.Ports.GardensRepo
import com.example.domain.GardenReadDomain
import com.example.domain.GardenWriteDomain
import domain.UserWriteDomain

import org.postgresql.ds.PGSimpleDataSource

class TestScenario {
    val appTestGardensDatabase: GardensRepo =  GardensPostgresRepo(PGSimpleDataSource().apply {
        user = "postgres"
        databaseName = "borrow_my_garden_test_db"
    })

    val appTestUserDatabase: UserRepo = UserPostgresRepo(PGSimpleDataSource().apply {
        user = "postgres"
        databaseName = "borrow_my_garden_test_db"
    })

    private val gardenReadDomain = GardenReadDomain(appTestGardensDatabase)
    private val gardenWriteDomain = GardenWriteDomain(appTestGardensDatabase)
    private val userWriteDomain = UserWriteDomain(appTestUserDatabase)

    private val httpAPI = HttpAPI(gardenReadDomain, gardenWriteDomain, userWriteDomain)

    val testApp = TestApp(httpAPI)

}
