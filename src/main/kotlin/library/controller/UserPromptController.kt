package library.controller

import library.model.MenuOption
import library.model.ReadingRoom
import library.model.SeatNumber
import library.view.UserInputView
import library.view.UserOutputView

class UserPromptController(val inputView: UserInputView, val readingRoom: ReadingRoom, val outputView: UserOutputView) {
    fun run(){
        while(true){
            inputView.printMenu()
            val option: MenuOption = inputView.getOption()
            if(option == MenuOption(1)){
                showSeatAvailablilites()
            }
            if(option == MenuOption(2)){
                reserveSeat()
            }
            if(option == MenuOption(3)){
                returnSeat()
            }
            if(option == MenuOption(4)){
                break
            }
        }
    }

    private fun showSeatAvailablilites(){
        val availablities = readingRoom.getSeatAvailabilities()
        outputView.printSeatAvailabilities(availablities)
    }

    private fun reserveSeat(){
        val userId = 1L
        val seatNumber = inputView.getSeatToReserve()
        try{
            readingRoom.reserveSeat(userId, seatNumber)
            outputView.reserveSuccess()
        }
        catch (e : RuntimeException){
            outputView.printError(e)
        }
    }

    private fun returnSeat() {
        val userId = 1L
        val seatNumber: SeatNumber? = readingRoom.findReservedSeat(userId)
        if(seatNumber == null){
            outputView.printMessage("배정 받은 좌석이 없습니다")
            return
        }
        val willReturn: Boolean = inputView.getReturnSeatIntention(seatNumber)
        if(!willReturn){
            return
        }
        readingRoom.returnSeat(userId)
        outputView.printMessage("좌석 반납을 완료했습니다")
    }
}