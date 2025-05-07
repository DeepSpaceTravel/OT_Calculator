package data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

class LocalDataStore(private val settingsDataStore: DataStore<Preferences>) {

    companion object {

    }
}