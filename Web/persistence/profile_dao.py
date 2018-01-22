from db.db_helper import get_session, Profile
from model.profile_object import ProfileObj


def add_profile(profile):
    session = get_session()
    session = session()
    new_profile = Profile()
    new_profile.name = profile.get_name()
    new_profile.birth = profile.get_birth()
    new_profile.city = profile.get_city()
    new_profile.level = profile.get_level()
    new_profile.occupation = profile.get_occupation()
    new_profile.telephone = profile.get_phone()
    new_profile.specialty = profile.get_specialty()
    session.add(new_profile)
    session.commit()
    session.refresh(new_profile)
    profile_id = new_profile.id
    session.close()
    return profile_id


def search_profile(user_id):
    session = get_session()
    session = session()
    profile_query = session.query(Profile).filter(Profile.id_user == user_id)
    profile_query = profile_query[0]
    profile_obj = ProfileObj(profile_query.name, profile_query.specialty)

    profile_obj.set_birth(profile_query.birth)
    profile_obj.set_city(profile_query.city)
    profile_obj.set_level(profile_query.level)
    profile_obj.set_occupation(profile_query.occupation)
    profile_obj.set_phone(profile_query.phone)

    profile_obj.set_id(profile_query.id)
    session.close()

    return profile_obj


def get_all_profiles():
    session = get_session()
    session = session()
    profile_query = session.query(Profile).all()
    session.close()

    return profile_query


def update_profile(profile):
    session = get_session()
    session = session()
    returned_profile = session.query(Profile).filter(Profile.id_user == profile.get_user_id())
    returned_profile = returned_profile[0]
    returned_profile.name = profile.get_name()
    returned_profile.birth = profile.get_birth()
    returned_profile.id = profile.get_id()
    returned_profile.city = profile.get_city()
    returned_profile.level = profile.get_level()
    returned_profile.occupation = profile.get_occupation()
    returned_profile.phone = profile.get_phone()
    returned_profile.specialty = profile.get_specialty()
    returned_profile.id_user = profile.get_user_id()
    session.commit()
    session.close()


def delete_profile(user_id):
    session = get_session()
    session = session()
    session.query(Profile).filter(Profile.id_user == user_id).delete()
    session.commit()
    session.close()
