package data.datastore

import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

open class Settings(){
    //    Define Setting Keys
    val CHECK_IN_TIME = stringPreferencesKey("check_in_time")
    val CHECK_OUT_TIME = stringPreferencesKey("check_out_time")
    val MULTIPLIER = floatPreferencesKey("multiplier")
    val HOURLY_RATE = floatPreferencesKey("hourly_rate")
    val NORMAL_WORKING_LENGTH = floatPreferencesKey("normal_working_length")
}