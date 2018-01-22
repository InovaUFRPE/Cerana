from db.db_helper import get_session, Comment
from model.comment_object import CommentObj
from persistence.question_dao import search_question
from persistence.user_dao import search_user_from_id


def get_user_from_question(question):
    question_obj = search_question(question)
    user_obj = search_user_from_id(question_obj.get_user_id())
    return user_obj[0]


def get_question_id(question):
    question_obj = search_question(question)
    return question_obj.get_question_id()


def add_comment(comment_obj, question_obj):
    session = get_session()
    session = session()
    new_comment = Comment()
    new_comment.likes = comment_obj.get_likes()
    new_comment.mark = comment_obj.get_mark()
    new_comment.answer = comment_obj.get_answer()
    new_comment.id_question = get_question_id(question_obj)
    new_comment.id_user = get_user_from_question(question_obj).get_id()
    session.add(new_comment)
    session.commit()
    session.refresh(new_comment)
    comment_id = new_comment.id
    session.close()
    return comment_id


def search_comment(answer):
    session = get_session()
    session = session()
    comment_query = session.query(Comment).filter(Comment.answer == answer)
    comment_query = comment_query[0]
    if comment_query:
        comment_obj = CommentObj()
        comment_obj.set_answer(comment_query.answer)
        comment_obj.set_likes(comment_query.likes)
        comment_obj.set_mark(comment_query.mark)
        comment_obj.set_question_id(comment_query.id_question)
        comment_obj.set_user_id(comment_query.id_user)
        comment_obj.set_comment_id(comment_query.id)
        session.close()
        return comment_obj
    else:
        session.close()
        return None


def update_comment(comment):
    session = get_session()
    session = session()
    new_comment = session.query(Comment).filter(Comment.answer == comment.get_answer())
    new_comment = new_comment[0]
    new_comment.answer = comment.get_answer()
    new_comment.id_question = comment.get_question_id()
    new_comment.id_user = comment.get_user_id()
    new_comment.likes = comment.get_likes()
    new_comment.mark = comment.get_mark()
    session.commit()
    session.close()

    # can be done in another way
    # ex = update(User.__table__).where(User.id==123).values(name=u"Fulana")
    # Session.execute(ex)


def get_all_comments():
    session = get_session()
    session = session()
    comment_query = session.query(Comment).all()
    session.close()
    return comment_query


def get_all_comments_from_question(question):
    session = get_session()
    session = session()
    questions = session.query(Comment).filter(Comment.id_question == question.get_id()).all()
    return questions


def delete_comment(answer):
    session = get_session()
    session = session()
    session.query(Comment).filter(Comment.answer == answer).delete()
    session.commit()
    session.close()
