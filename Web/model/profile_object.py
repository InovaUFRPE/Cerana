class ProfileObj:
    def __init__(self, name, specialty):
        self.id = None
        self.name = name
        self.birth = None
        self.city = None
        self.level = None
        self.occupation = None
        self.phone = None
        self.specialty = specialty
        self.user_id = None

    def get_user_id(self):
        return self.user_id

    def set_user_id(self, id):
        self.user_id = id

    def get_name(self):
        return self.name

    def get_birth(self):
        return self.birth

    def get_city(self):
        return self.city

    def get_level(self):
        return self.level

    def get_occupation(self):
        return self.occupation

    def get_phone(self):
        return self.phone

    def get_specialty(self):
        return self.specialty

    def set_name(self, name):
        self.name = name

    def set_birth(self, birth):
        self.birth = birth

    def set_city(self, city):
        self.city = city

    def set_level(self, level):
        self.level = level

    def set_occupation(self, occupation):
        self.occupation = occupation

    def set_phone(self, phone):
        self.phone = phone

    def set_specialty(self, specialty):
        self.specialty = specialty

    def get_id(self):
        return self.id

    def set_id(self, id):
        self.id = id
