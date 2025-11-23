package library.model

import library.library.model.dto.SeatDto

class ReadingRoom(size: Int) {
    val seats: Array<Seat>

    init{
        require(size > 0, { "[ERROR] 열람실에 좌석은 1개 이상이어야 합니다." })
        seats = Array<Seat>(size) { i -> Seat() }
    }

    fun getSeats(): List<SeatDto> {
        return seats.map { seat -> SeatDto(seat.getUserId(), seat.isAvailable()) }.toList()
    }

    fun reserveSeat(userId: String, seatNumber: SeatNumber) {
        validateUserAlreadyReserved(userId)
        validateNumberRange(seatNumber)
        validateSeatAvailability(seatNumber)

        seats[seatNumber.toIndex()].reserve(userId)
    }

    private fun validateSeatAvailability(seatNumber: SeatNumber) {
        if (!seats[seatNumber.toIndex()].isAvailable()) {
            throw IllegalArgumentException("[ERROR] 이미 예약된 좌석입니다.")
        }
    }

    private fun validateNumberRange(seatNumber: SeatNumber) {
        if (seatNumber.toIndex() >= seats.size) {
            throw IllegalArgumentException("[ERROR] 존재하지 않는 좌석입니다.")
        }
    }

    private fun validateUserAlreadyReserved(userId: String) {
        for(seat in seats){
            if(seat.hasReservedBy(userId)){
                throw IllegalArgumentException("[ERROR] 이미 예약한 좌석이 존재합니다.")
            }
        }
    }

    fun findReservedSeat(userId: String): SeatNumber? {
        for(i in 0..seats.size - 1){
            if(seats[i].hasReservedBy(userId)){
                return SeatNumber(i + 1)
            }
        }
        return null
    }

    fun returnSeat(userId: String) {
        val seatNumber = findReservedSeat(userId)
        if(seatNumber == null){
            throw IllegalArgumentException("[ERROR] 반납할 좌석이 없습니다")
        }
        seats[seatNumber.toIndex()].doReturn();
    }
}
