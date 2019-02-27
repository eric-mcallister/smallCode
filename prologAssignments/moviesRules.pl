:- ['movies'].
% same_year(M1, M2) <- whether two movies (M1, M2) were released in the same year.
same_year(M1, M2) :- movie(M1, Y), movie(M2, Y), M1 \== M2.
% released_between(Y1, Y2, M) <- the movie was released after year Y1 but before Y2 (inclusive).
released_between(Y1, Y2, M) :- movie(M, Z), (Z > Y1 ; Z=:=Y1), (Z < Y2 ; Z=:=Y2).
% roles(A, R) <- person A has performed as role R. Hint: recall a person can be an actor or actress
roles(A, R) :- actor(_,A,R) ; actress(_,A,R).
% worked_on(A,M) <- person A was an actor, actress, or director in movie M
worked_on(A, M) :- actor(M,A,_) ; actress(M,A,_) ; director(M, A).
% co_star(A1, A2) <- the actor/actress are in the same movie. Hint: A1 and A2 should not be equal
co_star(A1, A2) :- actor(M, A1, _), actress(M, A2, _);
                actor(M, A1, _), actor(M, A2, _), A1 \== A2;
                actress(M, A1, _), actress(M, A2, _), A1 \== A2.
% directed_by(X,Y) <- person X has been in a movie directed by Y. Hint: you can re-use your worked_on predicate
directed_by(X, Y) :- worked_on(X, M), worked_on(Y, M), director(M, Y), X \== Y.