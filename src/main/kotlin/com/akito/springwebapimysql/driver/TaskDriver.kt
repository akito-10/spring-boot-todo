package com.akito.springwebapimysql.driver

import com.fasterxml.jackson.annotation.JsonCreator
import org.springframework.stereotype.Component

@Component
class TaskDriver() {
    fun getTasks(): TasksJson {
        return TasksJson(listOf(TaskJson("title", "content"), TaskJson("title2", "content2")))
    }

    fun getTask(taskId: Int): TaskJson {
        return TaskJson("title", "content")
    }
}

data class TasksJson @JsonCreator constructor(
        val list: List<TaskJson>
)

data class TaskJson @JsonCreator constructor(
        val title: String,
        val content: String
)