package data.database

class LocalDatabase(driverFactory: DatabaseDriverFactory) {
    private val database: AppDatabase = AppDatabase(driverFactory.createDriver())
    private val dbQuery = database.overtimeInfoQueries

    fun getAllInfo(): List<OvertimeInfo> {
        return dbQuery.selectAllDates().executeAsList()
    }

    fun insertOcDate(
        overtime_date: String,
        check_in_time: String,
        check_out_time: String,
        meal_count: Long?,
        multiplier: Double,
        hourly_rate: Double,
        normal_working_length: Double
    ): Unit {
        dbQuery.insertOcDate(
            overtime_date,
            check_in_time,
            check_out_time,
            meal_count,
            multiplier,
            hourly_rate,
            normal_working_length
        )
    }

    fun checkIfDateExistsInLocalDatabase(overtime_date: String): Boolean {
        val dbReturnValue = dbQuery.checkIfDateExistsAlready(overtime_date).executeAsOne()
        println("dbReturnValue is: $dbReturnValue")
        return dbReturnValue == "true"
    }
}