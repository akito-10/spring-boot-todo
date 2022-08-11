package com.akito.springwebapimysql.gateway

import com.akito.springwebapimysql.domain.*
import com.akito.springwebapimysql.driver.TaskDriver
import com.akito.springwebapimysql.driver.TaskJson
import com.akito.springwebapimysql.driver.TasksJson
import com.akito.springwebapimysql.port.TaskPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TaskGateway: TaskPort {
    @Autowired
    lateinit var taskDriver: TaskDriver

    override fun getTasks(): Tasks {
        val taskJson: TasksJson = taskDriver.getTasks()
        return taskJson.toTasks()
    }

    override fun getTask(taskId: TaskId): Task {
        val taskJson: TaskJson = taskDriver.getTask(taskId.value)
        return taskJson.toTask()
    }
}

fun TasksJson.toTasks(): Tasks {
    return this.list.map {
        Task(Title(it.title), Content(it.content))
    }.let(::Tasks)
}

fun TaskJson.toTask(): Task {
    return Task(Title(this.title), Content(this.content))
}