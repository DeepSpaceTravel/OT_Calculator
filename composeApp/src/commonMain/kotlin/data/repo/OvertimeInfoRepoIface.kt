package data.repo

import data.database.OvertimeInfo

interface OvertimeInfoRepoIface {

    fun getLocalData(): List<OvertimeInfo>

    fun insertAnEntryToLocalDatabase(
        overtimeDate: String,
        checkInTime: String,
        checkOutTime: String,
        mealCount: Long?,
        multiplier: Double,
        hourlyRate: Double,
        normalWorkingLength: Double
    ): Unit

}