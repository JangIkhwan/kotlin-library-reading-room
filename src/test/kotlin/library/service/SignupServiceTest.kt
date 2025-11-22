package library.library.service

import io.mockk.every
import io.mockk.mockk
import library.repository.UserRepository
import library.service.SignupService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SignupServiceTest {
    var userRepository = mockk<UserRepository>()
    var signupService: SignupService = SignupService(userRepository)
    @Test
    fun `학번이 9자리 숫자가 아니면 예외를 발생시킨다`(){
        val studentNumber = "number"
        val name = "name"
        val password = "password"

        every { userRepository.existsById(any()) } returns false

        assertThrows<IllegalArgumentException> { signupService.signup(studentNumber, name, password) }
    }

    @Test
    fun `이름이 빈 문자열이면 예외를 발생시킨다`(){
        val studentNumber: String = "202214213"
        val name = ""
        val password = "password"

        every { userRepository.existsById(any()) } returns false

        assertThrows<IllegalArgumentException> { signupService.signup(studentNumber, name, password) }
    }

    @Test
    fun `비밀번호가 길이가 4~8자리이고 영어대소문자나 숫자로 이루어진 문자열이 아니면 예외를 발생시킨다`(){
        val studentNumber: String = "202214213"
        val name = ""
        val password = "password1234"

        every { userRepository.existsById(any()) } returns false

        assertThrows<IllegalArgumentException> { signupService.signup(studentNumber, name, password) }
    }

    @Test
    fun `이미 존재하는 학번이면 예외를 발생시킨다`(){
        val studentNumber: String = "202214213"
        val name = "name"
        val password = "password"

        every { userRepository.existsById(any()) } returns true

        assertThrows<IllegalArgumentException> { signupService.signup(studentNumber, name, password) }
    }
}