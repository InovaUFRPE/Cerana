from persistence.plant_dao import add_plant, delete_plant, search_plant, search_plant_incomplete_name


def create_plant_register(plant):
    plant_result = search_plant(plant.get_scientific_name())
    if plant_result:
        return None
    else:
        add_plant(plant)
        return plant


def exists(plant):
    return True if search_plant(plant.get_scientific_name()) else False


def erase_plant(plant):
    delete_plant(plant.get_scientific_name())


def update_plant(plant):
    pass


def get_plant(scientific_name):
    plant = search_plant(scientific_name)
    if plant:
        return plant
    else:
        return search_plant_incomplete_name(scientific_name)
