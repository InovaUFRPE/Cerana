from db.db_helper import get_session, Animal
from model.animal_object import AnimalObj


def add_animal(animal_obj):
    session = get_session()
    session = session()
    new_animal = Animal()
    new_animal.scientific_name = animal_obj.get_scientific_name()
    new_animal.popular_name = animal_obj.get_popular_name()
    new_animal.family = animal_obj.get_family()
    new_animal.kingdom = animal_obj.get_kingdom()
    new_animal.phylum = animal_obj.get_phylum()
    new_animal.description = animal_obj.get_description()
    session.add(new_animal)
    session.commit()
    session.refresh(new_animal)
    animal_id = new_animal.id
    session.close()
    return animal_id


def search_animal(scientific_name):
    session = get_session()
    session = session()
    animal_query = session.query(Animal).filter(Animal.scientific_name == scientific_name)
    if animal_query:
        animal_query = animal_query[0]
        animal_obj = AnimalObj(animal_query.scrientific_name, animal_query.popular_name)
        animal_obj.set_description(animal_query.description)
        animal_obj.set_family(animal_query.family)
        animal_obj.set_phylum(animal_query.phylum)
        animal_obj.set_kingdom(animal_query.kingdom)
        animal_obj.set_animal_id(animal_query.id)
        animal_obj.set_animal_id(animal_query.id)
        session.close()

        return animal_obj
    else:
        session.close()
        return None


def get_all_animals():
    session = get_session()
    session = session()
    animal_query = session.query(Animal).all()
    session.close()

    return animal_query


def delete_animal(scientific_name):
    session = get_session()
    session = session()
    session.query(Animal).filter(Animal.scientific_name == scientific_name).delete()
    session.commit()
    session.close()
