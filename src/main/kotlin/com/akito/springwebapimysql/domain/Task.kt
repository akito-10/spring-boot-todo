package com.akito.springwebapimysql.domain

data class TaskId(val value: Int)

data class Title(val value: String)

data class Content(val value: String)

data class Task(val title: Title, val content: Content)

data class Tasks(val list: List<Task>)