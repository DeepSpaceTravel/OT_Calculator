package data.database

class LocalDatabase(driverFactory: DatabaseDriverFactory) {
    private val database: AppDatabase = AppDatabase(driverFactory.createDriver())
    private val dbQuery = database.overtimeInfoQueries

    fun getAllInfo(): List<OvertimeInfo> {
        return dbQuery.selectAllDates().executeAsList()
    }

    fun insertOcDate(
        overtimeInfo: OvertimeInfo
    ): Unit {
        dbQuery.insertOcDate(
            overtime_date = overtimeInfo.overtime_date,
            check_in_time = overtimeInfo.check_in_time,
            check_out_time = overtimeInfo.check_out_time,
            meal_count = overtimeInfo.meal_count,
            multiplier = overtimeInfo.multiplier,
            hourly_rate = overtimeInfo.hourly_rate,
            normal_working_length = overtimeInfo.normal_working_length
        )
    }
}