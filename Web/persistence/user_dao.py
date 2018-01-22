from db.db_helper import get_session, User
from model.user_object import UserObj


def add_user(user_obj):
    session = get_session()
    session = session()
    new_user = User()
    new_user.login = user_obj.get_login()
    new_user.password = user_obj.get_password()
    new_user.active = user_obj.get_state()
    new_user.user_type = user_obj.get_type()
    session.add(new_user)
    session.commit()
    session.refresh(new_user)
    user_id = new_user.id
    session.close()
    return user_id


def update_user(user_obj):
    session = get_session()
    session = session()
    returned_user = session.query(User).filter(User.login == user_obj.get_login())
    returned_user = returned_user[0]
    returned_user.login = user_obj.get_login()
    returned_user.password = user_obj.get_password()
    returned_user.id = user_obj.get_id()
    returned_user.active = user_obj.get_state()
    returned_user.type = user_obj.get_type()
    session.commit()
    session.close()


def search_user_from_id(user_id):
    session = get_session()
    session = session()
    user_query = session.query(User).filter(User.id == user_id)
    user_query = user_query[0]
    if user_query:
        user_obj = UserObj(user_query.login, user_query.password)
        user_obj.set_type(user_query.user_type)
        session.close()

        return (user_obj, user_query)
    else:
        return None


def search_user(login):
    session = get_session()
    session = session()
    user_query = session.query(User).filter(User.login == login).all()
    if len(user_query) > 0:
        user_query = user_query[0]
    if user_query:
        user_obj = UserObj(user_query.login, user_query.password)
        user_obj.set_type(user_query.user_type)
        session.close()

        return user_obj
    else:
        session.close()
        return None


def get_query_from_user(user):
    session = get_session()
    session = session()
    user_query = session.query(User).filter(User.login == user).first()
    if user_query:
        return user_query
    else:
        return None


def get_all_users():
    session = get_session()
    session = session()
    user_query = session.query(User).all()
    session.close()
    return user_query


def delete_user(login):
    session = get_session()
    session = session()
    session.query(User).filter(User.login == login).delete()
    session.commit()
    session.close()
