package library.controller

import library.model.ReadingRoom
import library.view.UserInputView
import library.view.UserOutputView

class ShowSeatsController(val inputView: UserInputView, val readingRoom: ReadingRoom, val outputView: UserOutputView) :
    Controller {
    override fun run() : String{
        val availablities = readingRoom.getSeatAvailabilities()
        outputView.printSeatAvailabilities(availablities)
        return "userPrompt"
    }
}