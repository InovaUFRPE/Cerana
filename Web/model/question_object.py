class QuestionObj:
    def __init__(self, question):
        self.question_id = None
        self.user_id = None
        self.tag_id = None
        self.photo_id = None
        self.description = None
        self.question = question

    def get_question_id(self):
        return self.question_id

    def get_user_id(self):
        return self.user_id

    def get_tag_id(self):
        return self.tag_id

    def get_photo_id(self):
        return self.photo_id

    def get_description(self):
        return self.description

    def get_question(self):
        return self.question

    def set_question_id(self, id):
        self.question_id = id

    def set_user_id(self, id):
        self.user_id = id

    def set_tag_id(self, id):
        self.tag_id = id

    def set_photo_id(self, id):
        self.photo_id = id

    def set_description(self, description):
        self.description = description

    def set_question(self, question):
        self.question = question
