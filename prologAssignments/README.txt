When finish change to PDF

Dataset Information (used aggregate_all() command from stdlib)
    users: 10
    movies: 64
    actors: 1850
    actress: 895
    directors: 100

    most liked movie:
    least liked movie:
    actor with most liked movie:
    actress with most liked movie:
    director with most liked movie:
    director with least liked movie:

Recommendation System:
    1) If the user has liked more than one movie by the same director/actor/actress
    then recommend a movie with the same director/actor/actress.
    2) If userX is friends with userY and both have liked at least 2 of the same movies
    recommend a thrid movie from userY's list that userX has not seen
    3) If it is the most liked movie recommend it
    4) If the user has a movie on his list - find the most liked movie by that director
    and recommend that movie also
    5) If userY is a mutual friend of userX and userZ then recommend a movie from userZ to
    user X