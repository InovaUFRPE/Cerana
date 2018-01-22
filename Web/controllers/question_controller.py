from model.comment_object import CommentObj
from persistence.comment_dao import get_all_comments_from_question
from persistence.question_dao import search_question, add_question, get_all_questions, delete_question


def exists(question):
    exist = search_question(question.get_name())
    return True if exist else False


def n_comment(question):
    questions = get_all_comments_from_question(question.get_name())
    return len(questions)


def get_all_comments(question):
    comments = get_all_comments_from_question(question.get_question())
    comments_list = []
    for comment_query in comments:
        comments_obj = CommentObj()
        comments_obj.set_answer(comment_query.answer)
        comments_obj.set_likes(comment_query.likes)
        comments_obj.set_mark(comment_query.mark)
        comments_obj.set_question_id(comment_query.id_question)
        comments_obj.set_user_id(comment_query.id_user)
        comments_obj.set_comment_id(comment_query.id)
        comments_list.append(comments_obj)
    return comments_list


def create_question(question):
    question_obj = search_question(question)
    if question_obj:
        return False
    else:
        question_id = add_question(question_obj)
        return question_id


def list_all_questions():
    return get_all_questions()


def erase_question(question):
    delete_question(question)


def get_question(question):
    return search_question(question)
