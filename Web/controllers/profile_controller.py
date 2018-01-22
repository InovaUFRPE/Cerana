from persistence.profile_dao import search_profile, add_profile, delete_profile
from persistence.question_dao import get_all_questions_from_user
from persistence.user_dao import search_user


def load_user_data(user):
    user = search_user(user.get_login())
    return user if user else None


def load_user_questions(user):
    questions = get_all_questions_from_user(user)
    return questions if questions else None


def profile_data(user_id):
    profile = search_profile(user_id)
    return profile if profile else None


def list_all_questions_from_user(user):
    return get_all_questions_from_user(user)


def register_profile(profile):
    profile_result = search_profile(profile.get_user_id())
    if profile_result:
        return None
    else:
        add_profile(profile)
        return profile


def exists(user_id):
    return True if search_profile(user_id) else False


def erase_profile(user_id):
    delete_profile(user_id)


def update_profile(user_id):
    update_profile(user_id)
