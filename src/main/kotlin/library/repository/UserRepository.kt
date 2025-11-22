package library.repository

import library.model.User

class UserRepository {
    protected var userMap : MutableMap<String, User>

    init{
        userMap = mutableMapOf()
        userMap.put("202512345", User("202512345", "woowa", "1234"))
        userMap.put("202212345", User("202212345", "ikhwan", "1234"))
    }

    fun save(user: User) {
        userMap.put(user.id, user)
    }

    fun existsById(id: String): Boolean {
        return userMap.containsKey(id)
    }

    fun findById(id: String): User?{
        return userMap.get(id)
    }
}
