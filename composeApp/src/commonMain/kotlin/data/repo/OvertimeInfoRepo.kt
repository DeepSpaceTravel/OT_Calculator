package data.repo

import data.database.LocalDatabase
import data.database.OvertimeInfo

class OvertimeInfoRepo(
    private val localDatabase: LocalDatabase
): OvertimeInfoRepoIface {

    override fun getLocalData(): List<OvertimeInfo> {
        return localDatabase.getAllInfo()
    }

    override fun insertAnEntryToLocalDatabase(overtimeInfo: OvertimeInfo): Unit {
        localDatabase.insertOcDate(overtimeInfo)
    }

    
}