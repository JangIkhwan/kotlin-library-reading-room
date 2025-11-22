package library

import library.controller.Controller
import library.controller.LoginAndSignupPromptController
import library.controller.UserPromptController
import library.controller.ReserverSeatController
import library.controller.ReturnSeatController
import library.controller.ShowSeatsController
import library.controller.SignupController
import library.service.SignupService
import library.model.ReadingRoom
import library.repository.UserRepository
import library.view.LoginAndSignupInputView
import library.view.LoginAndSignupOutputView
import library.view.UserInputParser
import library.view.UserInputView
import library.view.UserOutputView


fun main() {
    val userInputView = UserInputView(UserInputParser())
    val readingRoom = ReadingRoom(50)
    val userOutputView = UserOutputView()
    val loginAndSignupInputView = LoginAndSignupInputView()
    val loginAndSignupOutputView = LoginAndSignupOutputView()
    val userRepository = UserRepository()

    var controllerMap : MutableMap<String, Controller> = mutableMapOf()
    controllerMap.put("userPrompt", UserPromptController(userInputView, userOutputView))
    controllerMap.put("reserveSeat", ReserverSeatController(userInputView, userOutputView, readingRoom))
    controllerMap.put("returnSeat", ReturnSeatController(userInputView, userOutputView, readingRoom))
    controllerMap.put("showSeat", ShowSeatsController(userOutputView, readingRoom))
    controllerMap.put("loginPrompt", LoginAndSignupPromptController(loginAndSignupInputView, loginAndSignupOutputView))
    controllerMap.put("signup", SignupController(loginAndSignupInputView, loginAndSignupOutputView, SignupService(
        userRepository
    )))

    var command : String? = "loginPrompt"
    while(true){
        val controller: Controller? = controllerMap.get(command)
        command = controller?.run()
        if(command == "exit" || command == null){
            break
        }
    }

}

