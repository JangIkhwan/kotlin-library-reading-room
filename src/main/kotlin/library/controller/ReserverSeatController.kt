package library.controller

import library.controller.constant.Command
import library.model.ReadingRoom
import library.model.SeatNumber
import library.service.LoginService
import library.view.UserInputView
import library.view.UserOutputView

class ReserverSeatController (val inputView: UserInputView, val outputView: UserOutputView, val readingRoom: ReadingRoom, val loginService: LoginService) : Controller {
    override fun run(): Command{
        val userId = loginService.getLoginedUserId()
        val reservedSeat: SeatNumber? = readingRoom.findReservedSeat(userId)
        if(reservedSeat != null){
            outputView.printMessage("배정받은 좌석이 존재합니다")
            return Command.USER_PROMPT
        }
        val seatNumber = inputView.getSeatToReserve()
        try{
            readingRoom.reserveSeat(userId, seatNumber)
            outputView.reserveSuccess()
        }
        catch (e: IllegalArgumentException){
            outputView.printError(e)
        }
        return Command.USER_PROMPT
    }
}