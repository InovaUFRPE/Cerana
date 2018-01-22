class StudyObj:
    def __init__(self):
        self.study_id = None
        self.user_id = None
        self.degree_level = None
        self.details = None

    def get_study_id(self):
        return self.study_id

    def get_user_id(self):
        return self.user_id

    def get_degree_level(self):
        return self.degree_level

    def get_details(self):
        return self.details

    def set_study_id(self, id):
        self.study_id = id

    def set_user_id(self, id):
        self.user_id = id

    def set_degree_level(self, degree):
        self.degree_level = degree

    def set_details(self, details):
        self.details = details
