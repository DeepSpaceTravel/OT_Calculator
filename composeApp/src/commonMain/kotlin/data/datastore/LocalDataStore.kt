package data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import co.touchlab.kermit.Logger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalDataStore(private val settingsDataStore: SettingsDataStore) {

//    set up writing methods for each setting
    suspend fun saveCheckInTime(checkInTime: String) {
        Logger.i("[INFO] Check-in Time saved")
        Logger.d("[DEBUG]: checkInTime: $checkInTime")
    }
}