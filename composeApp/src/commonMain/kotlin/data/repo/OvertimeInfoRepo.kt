package data.repo

import co.touchlab.kermit.Logger
import data.database.LocalDatabase
import data.database.OvertimeInfo

class OvertimeInfoRepo(
    private val localDatabase: LocalDatabase
): OvertimeInfoRepoIface {

    override fun getLocalData(): List<OvertimeInfo> {
        return localDatabase.getAllInfo()
    }

    override fun insertAnEntryToLocalDatabase(
        overtimeDate: String,
        checkInTime: String,
        checkOutTime: String,
        mealCount: Long?,
        multiplier: Double,
        hourlyRate: Double,
        normalWorkingLength: Double,
        overtimePay: Double){
        localDatabase.insertOcDate(
            overtime_date = overtimeDate,
            check_in_time = checkInTime,
            check_out_time = checkOutTime,
            meal_count = mealCount,
            multiplier = multiplier,
            hourly_rate = hourlyRate,
            normal_working_length = normalWorkingLength,
            overtime_pay = overtimePay
        )
    }

    fun checkIfDateExistsAlready(overtimeDate: String): Boolean {
        Logger.i{"[INFO]: Checking if date already exists in local database"}
        Logger.d{ "[DEBUG]: Checking if \"$overtimeDate\" exists in local database"}
        val result = localDatabase.checkIfDateExistsInLocalDatabase(overtime_date = overtimeDate)
        Logger.i{ "[INFO]: Result of check: $result" }
        return result
    }
}