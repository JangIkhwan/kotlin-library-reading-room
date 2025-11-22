package library.library.controller

import io.mockk.Runs
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.justRun
import io.mockk.verify
import library.controller.SignupController
import library.service.SignupService
import library.view.LoginAndSignupInputView
import library.view.LoginAndSignupOutputView
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import java.lang.IllegalArgumentException

@ExtendWith(MockKExtension::class)
class SignupControllerTest {
    @InjectMockKs
    lateinit var signupController: SignupController

    @MockK
    lateinit var signupService: SignupService

    @MockK
    lateinit var inputView: LoginAndSignupInputView

    @MockK
    lateinit var outputView: LoginAndSignupOutputView



    @Test
    fun `회원가입에 성공하면 에러 메시지를 출력하지 않는다`(){
        // given
        every { inputView.readLine(any()) } returns "202212345" andThen "jang" andThen "1234"
        justRun { outputView.printMessage(any()) }
        justRun { outputView.printError(any()) }
        justRun { signupService.signup(any(), any(), any()) }

        // when
        assertDoesNotThrow { signupController.run() }

        // then
        verify(exactly = 3) { inputView.readLine(any()) }
        verify(exactly = 1) { signupService.signup(any(), any(), any()) }
        verify(exactly = 2) { outputView.printMessage(any()) }
        verify(exactly = 0) { outputView.printError(any()) }
    }

    @Test
    fun `회원가입 중에 예외가 발생하면 에러 메시지를 출력한다`(){
        // given

        every { inputView.readLine(any()) } returns "202212345" andThen "jang" andThen "1234"
        justRun { outputView.printMessage(any()) }
        justRun { outputView.printError(any()) }
        every { signupService.signup(any(), any(), any()) } throws IllegalArgumentException("ERROR")

        // when
        signupController.run()

        // then
        verify(exactly = 3) { inputView.readLine(any()) }
        verify(exactly = 1) { signupService.signup(any(), any(), any()) }
        verify(exactly = 1) { outputView.printMessage(any()) }
        verify(exactly = 1) { outputView.printError(any()) }
    }

}