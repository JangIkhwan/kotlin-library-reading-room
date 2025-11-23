package library.model

interface Clock {
    fun updateTime(currentTime: String)
    fun getTime(): String
}
