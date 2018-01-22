class UserObj:
    def __init__(self, login, password):
        self.login = login
        self.password = password
        self.user_id = None
        self.active = True
        self.type = "student"

    def get_id(self):
        return self.user_id

    def set_id(self, user_id):
        self.user_id = user_id

    def get_login(self):
        return self.login

    def set_login(self, login):
        self.login = login

    def get_password(self):
        return self.password

    def set_password(self, password):
        self.password = password

    def set_inactive(self):
        self.active = False

    def set_active(self):
        self.active = True

    def get_state(self):
        return self.active

    def get_type(self):
        return self.type

    def set_type(self, type):
        self.type = type
