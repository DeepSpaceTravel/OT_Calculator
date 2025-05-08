package data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import co.touchlab.kermit.Logger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalDataStore(private val settingsDataStore: DataStore<Preferences>): Settings() {

//    Set up reading methods for each setting
    val checkInTime: Flow<String> = settingsDataStore.data.map { setting -> setting[CHECK_IN_TIME] ?: "" }
    val checkOutTime: Flow<String> = settingsDataStore.data.map { setting -> setting[CHECK_OUT_TIME] ?: "" }
    val multiplier: Flow<Float> = settingsDataStore.data.map { setting -> setting[MULTIPLIER] ?: 1.0f }
    val hourlyRate: Flow<Float> = settingsDataStore.data.map { setting -> setting[HOURLY_RATE] ?: 0.0f }
    val normalWorkingLength: Flow<Float> = settingsDataStore.data.map { setting -> setting[NORMAL_WORKING_LENGTH] ?: 0.0f }

//    set up writing methods for each setting
    suspend fun saveCheckInTime(checkInTime: String) {settingsDataStore.edit { setting ->
        setting[CHECK_IN_TIME] = checkInTime }
        Logger.i("[INFO] Check-in Time saved")
        Logger.d("[DEBUG]: checkInTime: $checkInTime")
    }
    suspend fun saveCheckOutTime(checkOutTime: String) { settingsDataStore.edit { setting ->
        setting[CHECK_OUT_TIME] = checkOutTime }
        Logger.i("[INFO] Check-out Time saved")
        Logger.d("[DEBUG]: checkOutTime: $checkOutTime")}
    suspend fun saveMultiplier(multiplier: Float) {settingsDataStore.edit { setting ->
        setting[MULTIPLIER] = multiplier }
        Logger.i("[INFO] Multiplier saved")
        Logger.d("[DEBUG]: multiplier: $multiplier")}
    suspend fun saveHourlyRate(hourlyRate: Float) {settingsDataStore.edit { setting ->
        setting[HOURLY_RATE] = hourlyRate }
        Logger.i("[INFO] Hourly Rate saved")
        Logger.d("[DEBUG]: hourlyRate: $hourlyRate")}
    suspend fun saveNormalWorkingLength(normalWorkingLength: Float) { settingsDataStore.edit { setting ->
        setting[NORMAL_WORKING_LENGTH] = normalWorkingLength }
        Logger.i("[INFO] Normal Working Length saved")
        Logger.d("[DEBUG]: normalWorkingLength: $normalWorkingLength")}
}