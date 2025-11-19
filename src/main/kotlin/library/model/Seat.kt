package library.model

class Seat{
    private var userId: Long

    constructor() {
        userId = -1
    }

    fun isAvailable(): Boolean{
        return userId == -1L
    }

    fun reserve(userId: Long) {
        this.userId = userId
    }

    fun hasReservedBy(userId: Long): Boolean{
        return this.userId == userId
    }
}
