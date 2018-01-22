from persistence.user_dao import search_user, add_user, delete_user, get_query_from_user, search_user_from_id


def get_user(login):
    return search_user(login)


def validate_sing_up(user):
    user_result = search_user(user.get_login())
    if user_result:
        return None
    else:
        user = add_user(user)
        return user


def validate_login(user, password):
    user_to_login_obj = search_user(user)
    user_to_login_query = get_query_from_user(user)
    user_data = (user_to_login_obj, user_to_login_query)
    if user_to_login_obj and password == user_to_login_obj.get_password():
        return user_data
    else:
        return None


def get_user_logged(id):
    return search_user_from_id(id)[1]


def exists(user):
    return True if search_user(user.get_login()) else False


def erase_user(user):
    delete_user(user.get_login())


def update_user(user):
    update_user(user)

