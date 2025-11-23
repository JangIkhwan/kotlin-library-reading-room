package library.view

import library.library.model.dto.SeatDto
import library.model.SeatNumber

class UserOutputView{
    fun printSeats(seats: List<SeatDto>, loginedUserId: String){
        println("열람실 좌석 현황")
        for(i in 0..seats.size - 1){
            printSeatNumber(i)
            print(seats.get(i).getStatus(loginedUserId))
            enterAtLineEnd(i)
        }
    }

    private fun printSeatNumber(i: Int) {
        print("${i + 1}:")
    }

    private fun enterAtLineEnd(i: Int) {
        if ((i + 1) % 10 == 0) {
            println()
        }
    }

    fun reserveSuccess() {
        println("좌석 배정이 완료되었습니다")
    }

    fun printError(e: RuntimeException) {
        println(e.message)
    }

    fun printMessage(message: String) {
        println(message)
    }

    fun printDuplicateResevervationMessage(reservedSeat: SeatNumber) {
        println("이미 배정받은 좌석이 존재합니다")
        println("배정 받은 좌석은 " + reservedSeat.value + "번 입니다")
    }
}
