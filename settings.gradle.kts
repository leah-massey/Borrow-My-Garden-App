rootProject.name = "BorrowMyGardenMain"
include("src:main:resources")
findProject(":src:main:resources")?.name = "resources"
