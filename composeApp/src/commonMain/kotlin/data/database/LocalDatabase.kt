package data.database

import co.touchlab.kermit.Logger

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
        normal_working_length: Double,
        overtime_pay: Double,
    ): Unit {
        val inserting_data = mapOf("overtime_date" to overtime_date, "check_in_time" to check_in_time, "check_out_time" to check_out_time,"meal_count" to meal_count, "multiplier" to multiplier, "hourly_rate" to hourly_rate, "normal_working_length" to normal_working_length, "overtime_pay" to overtime_pay)
        dbQuery.insertOcDate(
            overtime_date,
            check_in_time,
            check_out_time,
            meal_count,
            multiplier,
            hourly_rate,
            normal_working_length,
            overtime_pay,
        )
        Logger.i { "[INFO]: Data inserted to Local Database" }
        Logger.d { "[DEBUG]: Inserted: " + inserting_data.map { (param, arg) -> "$param: $arg" }}
    }

    fun checkIfDateExistsInLocalDatabase(overtime_date: String): Boolean {
        return dbQuery.checkIfDateExistsAlready(overtime_date).executeAsOne() == "true"
    }
}