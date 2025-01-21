package data

import kotlinx.coroutines.flow.Flow
import org.example.project.OvertimeInfo

interface EntryRepo{
    suspend fun getAllInfoStream(): List<OvertimeInfo>
}
