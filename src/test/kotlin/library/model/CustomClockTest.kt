package library.library.model

import library.model.CustomClock
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDateTime

class CustomClockTest {
    val customClock = CustomClock(LocalDateTime.of(2025, 11, 22, 12, 0, 0))

    @Test
    fun `올바르지 않은 형식의 시간으로 갱신하려고 하면 예외를 발생시킨다`(){
        val invalidFormat: String = "2025년 11월 22일 토요일 저녁 7시"

        assertThrows<IllegalArgumentException> { customClock.updateTime(invalidFormat) }
    }

    @Test
    fun `입력된 시간이 알고 있는 시간보다 과거이면 예외를 발생시킨다`(){
        val pastTime: String = "2025-11-22 08:00:00"

        assertThrows<IllegalArgumentException> { customClock.updateTime(pastTime) }
    }

    @Test
    fun `올바른 시간을 입력하면 시계의 시간이 변경된다`(){
        val futureTime: String = "2025-11-22 13:00:00"

        customClock.updateTime(futureTime)
        val time = customClock.getTime()

        assertThat(time).isEqualTo(futureTime)
    }
}