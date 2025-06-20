package data.datastore

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.okio.OkioStorage
import kotlinx.coroutines.flow.Flow
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM

class SettingsDataStore(
    private val produceFilePath: () -> String,
) {
    private val db = DataStoreFactory.create(
        storage = OkioStorage<Settings>(
            fileSystem = FileSystem.SYSTEM,
            serializer = SettingsJsonSerializer
            ,
            producePath = {
                produceFilePath().toPath()
            }
        )
    )
    val settings: Flow<Settings>
        get() = db.data
}
