package library.model

class ReadingRoom(size: Int) {
    val seats: Array<Seat>

    init{
        require(size > 0, { "[ERROR] 열람실에 좌석은 1개 이상이어야 합니다." })
        seats = Array<Seat>(size) { i -> Seat() }
    }

    fun getSeatAvailabilities(): List<Boolean> {
        return seats.map { seat -> seat.isAvailable() }.toList()
    }

    fun reserveSeat(userId: Long, seatNumber: SeatNumber) {
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

    private fun validateUserAlreadyReserved(userId: Long) {
        for(seat in seats){
            if(seat.hasReservedBy(userId)){
                throw IllegalArgumentException("[ERROR] 이미 예약한 좌석이 존재합니다.")
            }
        }
    }

    fun findReservedSeat(userId: Long): SeatNumber? {
        for(i in 0..seats.size - 1){
            if(seats[i].hasReservedBy(userId)){
                return SeatNumber(i + 1)
            }
        }
        return null
    }

    fun returnSeat(userId: Long) {
        val seatNumber = findReservedSeat(userId)
        if(seatNumber == null){
            throw IllegalArgumentException("[ERROR] 반납할 좌석이 없습니다")
        }
        seats[seatNumber.toIndex()].doReturn();
    }
}
