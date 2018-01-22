from persistence.animal_dao import search_animal, add_animal, delete_animal


def create_animal_register(animal):
    animal_result = search_animal(animal.get_scientific_name())
    if animal_result:
        return None
    else:
        add_animal(animal)
        return animal


def exists(animal):
    return True if search_animal(animal.get_scientific_name()) else False


def erase_animal(animal):
    delete_animal(animal.get_scientific_name())


def update_animal(animal):
    pass


def get_animal(scientific_name):
    return search_animal(scientific_name)