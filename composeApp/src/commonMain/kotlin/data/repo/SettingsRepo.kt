package data.repo

import data.datastore.LocalDataStore


class SettingsRepo(private val localSettings: LocalDataStore) {

    suspend fun loadSettings() {
        val checkInTime = localSettings.check_in_time
        val checkOutTime = localSettings.check_out_time
        val multiplier = localSettings.multiplier
        val hourlyRate = localSettings.hourly_rate
        val normalWorkingLength = localSettings.normal_working_length
    }

    suspend fun saveSettingsToLocalSettings(checkInTime: String, checkOutTime: String, multiplier: Float, hourlyRate: Float, normalWorkingLength: Float){
        localSettings.saveCheckInTime(checkInTime)
        localSettings.saveCheckOutTime(checkOutTime)
        localSettings.saveMultiplier(multiplier)
        localSettings.saveHourlyRate(hourlyRate)
        localSettings.saveNormalWorkingLength(normalWorkingLength)
    }
}