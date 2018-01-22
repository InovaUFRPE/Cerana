class ReportObj:
    def __init__(self, description):
        self.report_id = None
        self.user_id = None
        self.question_id = None
        self.report_type = None
        self.description = description

    def get_description(self):
        return self.description

    def get_type(self):
        return self.report_type

    def get_question_id(self):
        return self.question_id

    def get_user_id(self):
        return self.user_id

    def get_report_id(self):
        return self.report_id

    def set_report_id(self, id):
        self.report_id = id

    def set_user_id(self, id):
        self.user_id = id

    def set_question_id(self, id):
        self.question_id = id

    def set_type(self, type):
        self.report_type = type

    def set_description(self, description):
        self.description = description
