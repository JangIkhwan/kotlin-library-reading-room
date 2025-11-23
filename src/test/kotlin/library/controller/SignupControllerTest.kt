package library.library.controller

import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import library.controller.SignupController
import library.model.Clock
import library.service.SignupService
import library.view.LoginAndSignupInputView
import library.view.LoginAndSignupOutputView
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import java.lang.IllegalArgumentException

@ExtendWith(MockKExtension::class)
class SignupControllerTest {
    var signupService = mockk<SignupService>()

    var inputView = mockk<LoginAndSignupInputView>()

    var outputView =  mockk<LoginAndSignupOutputView>()

    var clock = mockk<Clock>()

    var signupController: SignupController = SignupController(inputView, outputView, signupService, clock)

    @Test
    fun `회원가입에 성공하면 에러 메시지를 출력하지 않는다`(){
        // given
        every { clock.getTime() } returns "time"
        every { inputView.readLine(any()) } returns "202212345" andThen "jang" andThen "1234" andThen "time"
        justRun { outputView.printSignupBeginning(any()) }
        justRun { outputView.printError(any()) }
        justRun { clock.updateTime(any()) }
        justRun { signupService.signup(any(), any(), any()) }
        justRun { outputView.printMessage(any()) }

        // when
        assertDoesNotThrow { signupController.run() }

        // then
        verify(exactly = 4) { inputView.readLine(any()) }
        verify(exactly = 1) { clock.updateTime(any()) }
        verify(exactly = 1) { signupService.signup(any(), any(), any()) }
        verify(exactly = 1) { outputView.printMessage(any()) }
        verify(exactly = 0) { outputView.printError(any()) }
    }

    @Test
    fun `회원가입 중에 예외가 발생하면 에러 메시지를 출력한다`(){
        // given

        every { inputView.readLine(any()) } returns "202212345" andThen "jang" andThen "1234" andThen "time"
        justRun { outputView.printSignupBeginning(any()) }
        justRun { outputView.printMessage(any()) }
        justRun { outputView.printError(any()) }
        every { clock.getTime() } returns "time"
        justRun { clock.updateTime(any()) }
        every { signupService.signup(any(), any(), any()) } throws IllegalArgumentException("ERROR")

        // when
        signupController.run()

        // then
        verify(exactly = 4) { inputView.readLine(any()) }
        verify(exactly = 1) { clock.updateTime(any()) }
        verify(exactly = 1) { signupService.signup(any(), any(), any()) }
        verify(exactly = 0) { outputView.printMessage(any()) }
        verify(exactly = 1) { outputView.printError(any()) }
    }

}