package library

import library.controller.Controller
import library.controller.UserPromptController
import library.controller.ReserverSeatController
import library.controller.ReturnSeatController
import library.controller.ShowSeatsController
import library.model.ReadingRoom
import library.view.UserInputParser
import library.view.UserInputView
import library.view.UserOutputView


fun main() {
    val userInputView = UserInputView(UserInputParser())
    val readingRoom = ReadingRoom(50)
    val userOutputView = UserOutputView()

    var controllerMap : MutableMap<String, Controller> = mutableMapOf()
    controllerMap.put("userPrompt", UserPromptController(userInputView, readingRoom, userOutputView))
    controllerMap.put("reserveSeat", ReserverSeatController(userInputView, readingRoom, userOutputView))
    controllerMap.put("returnSeat", ReturnSeatController(userInputView, readingRoom, userOutputView))
    controllerMap.put("showSeat", ShowSeatsController(userInputView, readingRoom, userOutputView))

    var command : String? = "userPrompt"
    while(true){
        val controller: Controller? = controllerMap.get(command)
        command = controller?.run()
        if(command == "exit" || command == null){
            break
        }
    }
}

