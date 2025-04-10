package data.database

class LocalDatabase(driverFactory: DatabaseDriverFactory) {
    private val database: AppDatabase = AppDatabase(driverFactory.createDriver())
    private val dbQuery = database.overtimeInfoQueries

    fun getAllInfo(): List<OvertimeInfo> {
        return dbQuery.selectAllDates().executeAsList()
    }
}