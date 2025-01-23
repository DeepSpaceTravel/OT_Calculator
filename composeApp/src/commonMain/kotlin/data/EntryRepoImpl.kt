package data

import org.example.project.OvertimeInfo

class EntryRepoImpl(private val database: Database): EntryRepoInterface {

    override suspend fun getAllInfoStream(): List<OvertimeInfo> {
        return database.getAllInfo()
    }
}
