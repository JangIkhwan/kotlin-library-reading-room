package library.library.model

import library.model.SeatNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SeatNumberTest {
    @Test
    fun `좌석번호는 1이상이어야 한다`(){
        // given
        val number = 0

        // when & then
        assertThrows<IllegalArgumentException> { SeatNumber(number) }
    }
}