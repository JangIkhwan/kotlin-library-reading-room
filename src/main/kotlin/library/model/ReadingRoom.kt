package library.model

class ReadingRoom(size: Int) {
    val seats : Array<Boolean>

    init{
        seats = Array<Boolean>(size) { false }
    }

    fun getSeatAvailability(): Array<Boolean> {
        return seats
    }
}
