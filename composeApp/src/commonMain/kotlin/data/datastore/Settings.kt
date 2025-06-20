package data.datastore

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.okio.OkioSerializer
import androidx.datastore.core.okio.OkioStorage
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okio.BufferedSink
import okio.BufferedSource
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM
import okio.use

@Serializable
data class Settings(
    val check_in_time: String ,
    val check_out_time: String,
    val multiplier: Float,
    val hourly_rate: Float,
    val normal_working_length: Float,
)

val json = Json { ignoreUnknownKeys= true }

internal object SettingsJsonSerializer: OkioSerializer<Settings> {
    override val defaultValue: Settings
        get() = Settings(
        check_in_time = "0",
        check_out_time = "0",
        multiplier = 0f,
        hourly_rate = 0f,
        normal_working_length = 0f,
    )

    override suspend fun readFrom(source: BufferedSource): Settings {
        return json.decodeFromString(Settings.serializer(), source.readUtf8())
    }

    override suspend fun writeTo(t: Settings, sink: BufferedSink) {
        sink.use {
            it.writeUtf8(json.encodeToString(Settings.serializer(), t))
        }
    }
}