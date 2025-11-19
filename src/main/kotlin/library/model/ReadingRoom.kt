package library.model

import library.model.SeatNumber

class ReadingRoom(size: Int) {
    val seats : Array<Boolean>

    init{
        require(size > 0, { "[ERROR] 열람실에 좌석은 1개 이상이어야 합니다." })
        seats = Array<Boolean>(size) { false }
    }

    fun getSeatAvailabilities(): Array<Boolean> {
        return seats.copyOf()
    }

    fun reserve(seatNumber: SeatNumber) {
        if(seatNumber.toIndex() >= seats.size){
            throw IllegalArgumentException("[ERROR] 존재하지 않는 좌석입니다.")
        }
        if(seats[seatNumber.toIndex()]){
            throw IllegalArgumentException("[ERROR] 이미 예약된 좌석입니다.")
        }
        seats[seatNumber.toIndex()] = true
    }
}
