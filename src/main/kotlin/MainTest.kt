package com.example

//class MainTest {
//
//        val gardensRepoDatasource: GardensRepo = GardensPostgresRepo(PGSimpleDataSource().apply {
//            user = "postgres"
//            databaseName = "borrow_my_gardenTest_db"
//        })
//        val readDomain = ReadDomain(gardensRepoDatasource)
//        val writeDomain = WriteDomain(gardensRepoDatasource)
//        val httpAPI = HttpAPI(readDomain, writeDomain)
//
//        val printingApp: HttpHandler = DebuggingFilters.PrintRequest().then(httpAPI.app)
//
//        val server = printingApp.asServer(SunHttp(9001)).start()
//
//        println("Server started on " + server.port())
//
//}
//
