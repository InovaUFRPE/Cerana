from persistence.comment_dao import search_comment, add_comment, update_comment, get_all_comments_from_question


def search_for_comment(answer):
    return search_comment(answer)


def like_comment(comment_obj):
    comment_obj.add_like()
    update_comment(comment_obj)


def comment_post(comment_obj, question_obj):
    comment = search_comment(comment_obj.get_answer())
    if comment:
        return False
    else:
        comment_id = add_comment(comment_obj, question_obj)
        return comment_id


def delete_comment(comment_obj):
    delete_comment(comment_obj.get_answer())


def order_comments_on_question(question):
    comment_list = get_all_comments_from_question(question)
    comment_list = comment_list.sort(key=lambda x: x.get_likes(), reverse=False)
    return comment_list


def report_comment():
    pass
