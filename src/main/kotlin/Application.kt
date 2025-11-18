package library

import library.controller.UserPromptController
import library.model.ReadingRoom
import library.view.UserInputParser
import library.view.UserInputView
import library.view.UserOutputView


fun main() {
    val userInputView = UserInputView(UserInputParser())
    val readingRoom = ReadingRoom(50)
    val userOutputView = UserOutputView()
    val userPromptController = UserPromptController(userInputView, readingRoom, userOutputView)
    userPromptController.run()
}

