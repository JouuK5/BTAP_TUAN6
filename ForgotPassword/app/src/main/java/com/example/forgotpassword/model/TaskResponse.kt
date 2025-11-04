package com.example.forgotpassword.model

import kotlinx.serialization.Serializable

@Serializable
data class TaskResponse(
    val isSuccess: Boolean,
    val message: String,
    val data: List<Task>
)

@Serializable
data class TaskDetailResponse(
    val isSuccess: Boolean,
    val message: String,
    val data: Task
)

@Serializable
data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val status: String,
    val priority: String,
    val category: String,
    val dueDate: String,
    val createdAt: String,
    val updatedAt: String,

    // 🔹 Thêm các danh sách con để khớp với màn hình chi tiết
    val subtasks: List<Subtask> = emptyList(),
    val attachments: List<Attachment> = emptyList(),
    val reminders: List<Reminder> = emptyList()
)

@Serializable
data class Subtask(
    val id: Int,
    val title: String,
    val isCompleted: Boolean
)

@Serializable
data class Attachment(
    val id: Int,
    val fileName: String,
    val fileUrl: String
)

@Serializable
data class Reminder(
    val id: Int,
    val time: String,
    val type: String
)
