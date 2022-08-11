package com.akito.springwebapimysql.usecase

import com.akito.springwebapimysql.domain.Task
import com.akito.springwebapimysql.domain.TaskId
import com.akito.springwebapimysql.domain.Tasks
import com.akito.springwebapimysql.port.TaskPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TaskUseCase() {
    @Autowired
    lateinit var taskPort: TaskPort

    fun getTasks(): Tasks {
        return taskPort.getTasks()
    }

    fun getTask(taskId: TaskId): Task {
        return taskPort.getTask(taskId)
    }
}