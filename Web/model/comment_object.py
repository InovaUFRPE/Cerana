class CommentObj:
    def __init__(self):
        self.comment_id = None
        self.question_id = None
        self.user_id = None
        self.likes = 0
        self.mark = False
        self.answer = None

    def get_comment_id(self):
        return self.comment_id

    def get_question_id(self):
        return self.question_id

    def get_user_id(self):
        return self.user_id

    def get_likes(self):
        return self.likes

    def get_mark(self):
        return self.mark

    def get_answer(self ):
        return self.answer

    def set_comment_id(self, id):
        self.comment_id = id

    def set_question_id(self, id):
        self.question_id = id

    def set_user_id(self, id):
        self.user_id = id

    def set_likes(self, n_likes):
        self.likes = n_likes

    def add_like(self):
        self.likes +=1

    def set_mark(self, mark):
        self.mark = mark

    def set_answer(self, answer):
        self.answer = answer
