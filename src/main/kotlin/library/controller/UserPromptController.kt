package library.controller

import library.model.MenuOption
import library.model.ReadingRoom
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
}