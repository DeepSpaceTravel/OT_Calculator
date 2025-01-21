package data

import kotlinx.coroutines.flow.Flow
import org.example.project.OvertimeInfo
import org.example.project.databaseFactory.DatabaseDriverFactory

class EntryRepoImpl(databaseDriverFactory: DatabaseDriverFactory): EntryRepo {
    private val database: Database = Database(databaseDriverFactory = databaseDriverFactory)

    override suspend fun getAllInfoStream(): List<OvertimeInfo> {
        return database.getAllInfo()
    }
}
