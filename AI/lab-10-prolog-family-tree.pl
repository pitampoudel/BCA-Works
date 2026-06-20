# 10.Write a Prolog program to implement a family tree.
/* Gender Facts */
male(ram).
male(biraj).
male(roshan).
male(sunil).
male(ishan).

female(sita).
female(anu).
female(kavita).
female(laxmi).
female(rita).

/* Parent Facts */
parent_of(ram, kavita).
parent_of(ram, laxmi).
parent_of(sita, kavita).
parent_of(sita, laxmi).

parent_of(biraj, ishan).
parent_of(anu, ishan).

parent_of(kavita, sunil).
parent_of(roshan, sunil).

parent_of(laxmi, rita).
parent_of(ishan, rita).

/* ---- Rules ---- */

/* 1. Father */
father_of(X,Y) :- male(X), parent_of(X,Y).

/* 2. Mother */
mother_of(X,Y) :- female(X), parent_of(X,Y).

/* 3. Sibling (covers sister/brother logic) */
sibling_of(X,Y) :- parent_of(P,X), parent_of(P,Y), X \= Y.

/* 4. Ancestor */
ancestor_of(X,Y) :- parent_of(X,Y).
ancestor_of(X,Y) :- parent_of(X,Z), ancestor_of(Z,Y).


/* ---- Queries ---- */

?- father_of(X, kavita).
?- mother_of(X, laxmi).
?- sibling_of(kavita, X).
findall(X, sibling_of(kavita, X), List).

?- ancestor_of(X, sunil).
findall(X, ancestor_of(X, sunil), List).
?- ancestor_of(ram, sunil).
