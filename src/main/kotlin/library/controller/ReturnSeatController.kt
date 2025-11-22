package library.controller

import library.controller.constant.Command
import library.model.ReadingRoom
import library.model.SeatNumber
import library.view.UserInputView
import library.view.UserOutputView

class ReturnSeatController(val inputView: UserInputView, val outputView: UserOutputView, val readingRoom: ReadingRoom) : Controller {
    override fun run() : Command{
        val userId = 1L
        val seatNumber: SeatNumber? = readingRoom.findReservedSeat(userId)
        if(seatNumber == null){
            outputView.printMessage("배정 받은 좌석이 없습니다")
            return Command.USER_PROMPT
        }
        val willReturn: Boolean = inputView.getReturnSeatIntention(seatNumber)
        if(willReturn){
            readingRoom.returnSeat(userId)
            outputView.printMessage("좌석 반납을 완료했습니다")
        }
        return Command.USER_PROMPT
    }
}