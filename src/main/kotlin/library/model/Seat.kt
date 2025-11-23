package library.model

class Seat{
    private var userId: String?

    constructor() {
        userId = null
    }

    fun isAvailable(): Boolean{
        return userId == null
    }

    fun reserve(userId: String) {
        this.userId = userId
    }

    fun hasReservedBy(userId: String): Boolean{
        return this.userId == userId
    }

    fun doReturn() {
        this.userId = null
    }

    fun getUserId(): String{
        if(userId == null){
            return "no user"
        }
        return userId!!
    }
}
