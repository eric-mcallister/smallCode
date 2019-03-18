:- [social_network].
% set_prolog_flag(answer_write_options, [quoted(true), portray(true),max_depth(0), spacing(next_argument)]).
allMovies(L) :- findall(X, movie(X, _), L).
numberOfLikes(X) :- aggregate_all(count, liked(_, X), V).


 