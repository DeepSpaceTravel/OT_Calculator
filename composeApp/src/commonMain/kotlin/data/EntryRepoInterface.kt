package data

import org.example.project.OvertimeInfo

interface EntryRepoInterface{
    suspend fun getAllInfoStream(): List<OvertimeInfo>
}
