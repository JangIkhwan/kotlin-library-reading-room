package library.library.model.vo

class SeatNumber(val value: Int) {
    init{
        require(value > 0, { "[ERROR] 좌석번호는 0보다 커야합니다" })
    }

    fun toIndex(): Int{
        return value - 1;
    }
}