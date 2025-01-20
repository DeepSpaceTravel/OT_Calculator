package data

import org.example.project.AppDatabase
import org.example.project.OvertimeInfo
import org.example.project.databaseFactory.DatabaseDriverFactory

internal class Database (databaseDriverFactory: DatabaseDriverFactory){
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.overtimeInfoQueries

    internal fun getAllInfo(): List<OvertimeInfo> {
        return dbQuery.selectAllDates().executeAsList()
    }

    internal fun insertDateInfo(
        overtime_date: String,
        check_in_time: String,
        check_out_time: String,
        meal_count: Byte?,
        multiplier: Float
    ) {
        dbQuery.insertOcDate(
            overtime_date,
            check_in_time,
            check_out_time,
            meal_count?.toLong(),
            multiplier.toDouble()
        )
    }

    internal fun deleteAll() {
        return dbQuery.removeAllEntries()
    }


}