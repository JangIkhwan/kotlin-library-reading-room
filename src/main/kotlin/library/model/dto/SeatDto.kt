package library.library.model.dto

class SeatDto(val userId: String, val available: Boolean) {
    fun getStatus(loginedUserId: String): String {
        if(hasLoginedUserReserved(loginedUserId)){
            return "[You Here]  "
        }
        if(hasAnotherUserReserved()){
            return "[X] "
        }
        return "[O]  "
    }

    private fun hasLoginedUserReserved(loginedUserId: String): Boolean{
        return available == false && userId == loginedUserId
    }

    private fun hasAnotherUserReserved(): Boolean = available == false
}
