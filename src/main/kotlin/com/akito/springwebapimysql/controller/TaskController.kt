package com.akito.springwebapimysql.controller

import com.akito.springwebapimysql.domain.Task
import com.akito.springwebapimysql.domain.TaskId
import com.akito.springwebapimysql.domain.Tasks
import com.akito.springwebapimysql.usecase.TaskUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TaskController {
    @Autowired
    lateinit var taskUseCase: TaskUseCase

    @GetMapping(value = ["/api/tasks"])
    fun getTasks(): ResponseEntity<TasksJson> {
        return ResponseEntity.ok(taskUseCase.getTasks().toJson())
    }

    @GetMapping(value = ["/api/tasks/{taskId}"])
    fun getTask(
            @PathVariable(value = "taskId", required = true) taskId: Int
    ): ResponseEntity<TaskJson> {
        return ResponseEntity.ok(taskUseCase.getTask(TaskId(taskId)).toJson())
    }
}

data class TaskJson(val title: String, val content: String)
data class TasksJson(val tasks: List<TaskJson>)

fun Tasks.toJson() = this.list.map { it.toJson() }.let(::TasksJson)
fun Task.toJson() = TaskJson(this.title.value, this.content.value)