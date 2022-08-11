package com.akito.springwebapimysql.port

import com.akito.springwebapimysql.domain.Task
import com.akito.springwebapimysql.domain.TaskId
import com.akito.springwebapimysql.domain.Tasks

interface TaskPort {
    fun getTasks(): Tasks
    fun getTask(taskId: TaskId): Task
}