package com.example.forgotpassword.network

import com.example.forgotpassword.model.Task
import com.example.forgotpassword.model.TaskDetailResponse
import com.example.forgotpassword.model.TaskResponse
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

suspend fun fetchTasks(): List<Task> {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    val response: TaskResponse =
        client.get("https://amock.io/api/researchUTH/tasks").body()

    client.close()
    return response.data
}

suspend fun fetchTaskDetail(id: Int): TaskDetailResponse {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    val response: TaskDetailResponse =
        client.get("https://amock.io/api/researchUTH/task/$id").body()

    client.close()
    return response
}

suspend fun deleteTask(taskId: Int) {
    val client = HttpClient(CIO)
    client.delete("https://amock.io/api/researchUTH/task/$taskId")
    client.close()
}
