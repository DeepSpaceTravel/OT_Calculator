package data.repo

import data.database.OvertimeInfo

interface OvertimeInfoRepoIface {

    fun getLocalData(): List<OvertimeInfo>

    fun insertAnEntryToLocalDatabase(overtimeInfo: OvertimeInfo): Unit

}