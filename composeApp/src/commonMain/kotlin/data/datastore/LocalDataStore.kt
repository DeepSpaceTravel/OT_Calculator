package data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

class LocalDataStore(private val settingsDataStore: DataStore<Preferences>) {
//    Define Setting Keys
    companion object {
        private val CHECK_IN_TIME = stringPreferencesKey("check_in_time")
        private val CHECK_OUT_TIME = stringPreferencesKey("check_out_time")
        private val MULTIPLIER = floatPreferencesKey("multiplier")
        private val HOURLY_RATE = floatPreferencesKey("hourly_rate")
        private val NORMAL_WORKING_LENGTH = floatPreferencesKey("normal_working_length")
    }

    suspend fun saveCheckInTime(checkInTime: String) {

    }
}