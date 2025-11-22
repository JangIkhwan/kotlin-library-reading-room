package library.library.service

import io.mockk.every
import io.mockk.mockk
import library.model.User
import library.repository.UserRepository
import library.service.LoginService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LoginServiceTest {
    var userRepository = mockk<UserRepository>()
    var loginService = LoginService(userRepository)

    @Test
    fun `입력한 계정과 일치하는 사용자가 존재하지 않으면 false를 반환한다`(){
        every { userRepository.findById(any()) } returns null

        val result = loginService.login("202212345", "1234")

        Assertions.assertThat(result).isFalse()
    }

    @Test
    fun `입력한 계정과 일치하는 사용자가 있으면 true를 반환한다`(){
        val mockUser = mockk<User>()
        every { mockUser.hasSamePassword(any()) } returns true
        every { userRepository.findById(any()) } returns mockUser

        val result = loginService.login("202212345", "1234")

        Assertions.assertThat(result).isTrue()
    }
}