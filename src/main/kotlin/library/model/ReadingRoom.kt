package library.model

class ReadingRoom(size: Int) {
    val seats : Array<Boolean>

    init{
        require(size > 0, { "좌석은 1개 이상이어야 합니다." })
        seats = Array<Boolean>(size) { false }
    }

    fun getSeatAvailabilities(): Array<Boolean> {
        return seats.copyOf()
    }
}
