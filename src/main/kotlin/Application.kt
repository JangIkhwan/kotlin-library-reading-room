package library

import library.controller.Controller
import library.controller.LoginAndSignupPromptController
import library.controller.LoginController
import library.controller.UserPromptController
import library.controller.ReserverSeatController
import library.controller.ReturnSeatController
import library.controller.ShowSeatsController
import library.controller.SignupController
import library.controller.constant.Command
import library.model.CustomClock
import library.service.SignupService
import library.model.ReadingRoom
import library.repository.UserRepository
import library.view.LoginAndSignupInputView
import library.view.LoginAndSignupOutputView
import library.view.UserInputParser
import library.view.UserInputView
import library.view.UserOutputView
import java.time.LocalDateTime


fun main() {
    val userInputView = UserInputView(UserInputParser())
    val readingRoom = ReadingRoom(50)
    val userOutputView = UserOutputView()
    val loginAndSignupInputView = LoginAndSignupInputView()
    val loginAndSignupOutputView = LoginAndSignupOutputView()
    val userRepository = UserRepository()
    val clock = CustomClock(
        LocalDateTime.now()
    )

    var controllerMap : MutableMap<Command, Controller> = mutableMapOf()
    controllerMap.put(Command.USER_PROMPT, UserPromptController(userInputView, userOutputView))
    controllerMap.put(Command.RESERVE_SEAT, ReserverSeatController(userInputView, userOutputView, readingRoom))
    controllerMap.put(Command.RETURN_SEAT, ReturnSeatController(userInputView, userOutputView, readingRoom))
    controllerMap.put(Command.SHOW_SEATS, ShowSeatsController(userOutputView, readingRoom))
    controllerMap.put(Command.LOGIN_PROMPT, LoginAndSignupPromptController(loginAndSignupInputView, loginAndSignupOutputView))
    controllerMap.put(Command.SIGNUP,
        SignupController(loginAndSignupInputView, loginAndSignupOutputView, SignupService(userRepository), clock)
    )
    controllerMap.put(Command.LOGIN, LoginController())

    var command : Command? = Command.LOGIN_PROMPT
    while(true){
        val controller: Controller? = controllerMap.get(command)
        command = controller?.run()
        if(command == Command.EXIT || command == null){
            break
        }
    }

}

