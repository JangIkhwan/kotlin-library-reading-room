package library.library.model

import library.model.ReadingRoom
import library.model.SeatNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ReadingRoomTest {
    @Test
    fun `예약된 좌석은 배정하려고 하면 예외가 발생한다`(){
        // given
        val readingRoom = ReadingRoom(50)
        val seatNumber = SeatNumber(1)
        readingRoom.reserveSeat(1, seatNumber)

        // when & then
        assertThrows<IllegalArgumentException> { readingRoom.reserveSeat(2, seatNumber) }
    }

    @Test
    fun `존재하지 않는 좌석을 배정하려고 하면 예외가 발생한다`(){
        // given
        val readingRoom = ReadingRoom(50)
        val seatNumber = SeatNumber(51)

        // when & then
        assertThrows<IllegalArgumentException> { readingRoom.reserveSeat(1, seatNumber) }
    }

    @Test
    fun `좌석을 두개 이상 배정하려고 하면 예외가 발생한다`(){
        // given
        val readingRoom = ReadingRoom(50)
        val oneSeatNumber = SeatNumber(1)
        readingRoom.reserveSeat(1, oneSeatNumber)
        val anotherSeatNumber = SeatNumber(2)

        // when & then
        assertThrows<IllegalArgumentException> { readingRoom.reserveSeat(1, anotherSeatNumber) }
    }
}