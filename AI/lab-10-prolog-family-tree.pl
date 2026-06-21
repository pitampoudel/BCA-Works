% 10. Prolog program to implement a family tree.

% ---- Gender Facts ----
male(ram).    male(biraj).   male(roshan).
male(sunil).  male(ishan).

female(sita). female(anu).   female(kavita).
female(laxmi). female(rita).

% ---- Parent Facts ----
parent_of(ram,    kavita).  parent_of(sita,   kavita).
parent_of(ram,    laxmi).   parent_of(sita,   laxmi).
parent_of(biraj,  ishan).   parent_of(anu,    ishan).
parent_of(kavita, sunil).   parent_of(roshan, sunil).
parent_of(laxmi,  rita).    parent_of(ishan,  rita).

% ---- Rules ----
father_of(X, Y)   :- male(X),   parent_of(X, Y).
mother_of(X, Y)   :- female(X), parent_of(X, Y).
sibling_of(X, Y)  :- parent_of(P, X), parent_of(P, Y), X \= Y.
ancestor_of(X, Y) :- parent_of(X, Y).
ancestor_of(X, Y) :- parent_of(X, Z), ancestor_of(Z, Y).

% ---- Initialization: auto-print query results when file is loaded ----
:- initialization(main).

main :-
    write('=== Family Tree Queries ==='), nl,
    write('Father of kavita    : '),
        (father_of(X1, kavita) -> write(X1) ; write(none)), nl,
    write('Mother of laxmi     : '),
        (mother_of(X2, laxmi)  -> write(X2) ; write(none)), nl,
    findall(S, sibling_of(kavita, S), Siblings),
    write('Siblings of kavita  : '), write(Siblings), nl,
    findall(A, ancestor_of(A, sunil), Ancestors),
    write('Ancestors of sunil  : '), write(Ancestors), nl,
    write('Is ram ancestor of sunil? '),
        (ancestor_of(ram, sunil) -> write(yes) ; write(no)), nl.
