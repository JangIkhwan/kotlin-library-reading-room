package library.repository

import library.model.User

class UserRepository {
    var userMap : MutableMap<String, User>

    init{
        userMap = mutableMapOf()
    }
    fun save(user: User) {
        userMap.put(user.id, user)
    }

    fun existsById(id: String): Boolean {
        return userMap.containsKey(id)
    }

}
