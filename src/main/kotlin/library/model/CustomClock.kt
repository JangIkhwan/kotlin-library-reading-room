package library.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class CustomClock (var time: LocalDateTime) : Clock {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    override fun updateTime(currentTime: String) {
        try{
            val parsedTime = LocalDateTime.parse(currentTime, formatter)
            if(parsedTime.isBefore(time)){
                throw IllegalArgumentException("[ERROR] 입력한 시간은 시스템이 인지하는 시간보다 과거일 수 없습니다")
            }
            time = parsedTime
        }
        catch (e : DateTimeParseException){
            throw IllegalArgumentException("[ERROR] 시간은 yyyy-MM-dd HH:mm:ss 형식이어야 합니다")
        }
    }

    override fun getTime(): String{
        return time.format(formatter)
    }
}
