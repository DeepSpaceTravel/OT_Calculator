package data.repo

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
        normalWorkingLength: Double){
        localDatabase.insertOcDate(
            overtime_date = overtimeDate,
            check_in_time = checkInTime,
            check_out_time = checkOutTime,
            meal_count = mealCount,
            multiplier = multiplier,
            hourly_rate = hourlyRate,
            normal_working_length = normalWorkingLength
        )
    }

    fun checkIfDateExistsAlready(overtimeDate: String): Boolean {
        val returnValue = localDatabase.checkIfDateExistsInLocalDatabase(overtime_date = overtimeDate)
        return returnValue
    }
}