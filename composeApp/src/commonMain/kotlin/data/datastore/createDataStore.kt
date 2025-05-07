package data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

expect fun createDataStore(producePath: () -> String): DataStore<Preferences>

internal const val USER_SETTINGS_DATA_STORE = "userSettings.preferences_pb"