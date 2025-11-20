package library.controller

import library.model.ReadingRoom
import library.model.SeatNumber
import library.view.UserInputView
import library.view.UserOutputView

class ReserverSeatController (val inputView: UserInputView, val outputView: UserOutputView, val readingRoom: ReadingRoom) :
    Controller {
    override fun run(): String{
        val userId = 1L
        val reservedSeat: SeatNumber? = readingRoom.findReservedSeat(userId)
        if(reservedSeat != null){
            outputView.printMessage("배정받은 좌석이 존재합니다")
            return "userPrompt"
        }
        val seatNumber = inputView.getSeatToReserve()
        readingRoom.reserveSeat(userId, seatNumber)
        outputView.reserveSuccess()
        return "userPrompt"
    }
}