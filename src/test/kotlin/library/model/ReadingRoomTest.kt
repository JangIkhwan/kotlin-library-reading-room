package library.library.model

import library.model.ReadingRoom
import library.model.SeatNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ReadingRoomTest {
    @Test
    fun `예약된 좌석은 배정하려고 하면 예외가 발생한다`(){
        // given
        val readingRoom = ReadingRoom(50)
        val seatNumber = SeatNumber(1)
        val userId = "202212345"
        val anotherUserId = "202512345"
        readingRoom.reserveSeat(userId, seatNumber)

        // when & then
        assertThrows<IllegalArgumentException> { readingRoom.reserveSeat(anotherUserId, seatNumber) }
    }

    @Test
    fun `존재하지 않는 좌석을 배정하려고 하면 예외가 발생한다`(){
        // given
        val readingRoom = ReadingRoom(50)
        val seatNumber = SeatNumber(51)

        // when & then
        assertThrows<IllegalArgumentException> { readingRoom.reserveSeat("202212345", seatNumber) }
    }

    @Test
    fun `좌석을 두개 이상 배정하려고 하면 예외가 발생한다`(){
        // given
        val readingRoom = ReadingRoom(50)
        val oneSeatNumber = SeatNumber(1)
        val userId = "202212345"
        readingRoom.reserveSeat(userId, oneSeatNumber)
        val anotherSeatNumber = SeatNumber(2)

        // when & then
        assertThrows<IllegalArgumentException> { readingRoom.reserveSeat(userId, anotherSeatNumber) }
    }

    @Test
    fun `findReservedSeat는 배정받은 좌석이 없으면 null을 반환한다`(){
        // given
        val readingRoom = ReadingRoom(50)
        // when
        val seatNumber: SeatNumber? = readingRoom.findReservedSeat("202212345")

        // then
        assertThat(seatNumber).isNull()
    }

    @Test
    fun `returnSeat는 좌석 반납에 성공한다`(){
        // given
        val readingRoom = ReadingRoom(50)
        val userId = "202212345";
        readingRoom.reserveSeat(userId, SeatNumber(2))

        // when
        readingRoom.returnSeat(userId)

        // then
        assertThat(readingRoom.findReservedSeat(userId)).isNull();
    }

    @Test
    fun `returnSeat는 배정받은 좌석이 없으면 예외를 발생시킨다`(){
        // given
        val readingRoom = ReadingRoom(50)

        // when & then
        assertThrows <IllegalArgumentException>{  readingRoom.returnSeat("202212345") }
    }
}