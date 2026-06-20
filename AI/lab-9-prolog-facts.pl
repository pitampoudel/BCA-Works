% 9. Write simple Prolog facts based on English statements.

% ---- FACTS ----

% English: Ram is a man.
man(ram).
man(shyam).

% English: Sita is a woman.
woman(sita).
woman(gita).

% English: Ram likes cricket.
likes(ram, cricket).
likes(shyam, football).
likes(sita, cricket).

% English: Ram is the father of Shyam.
father(ram, shyam).
father(ram, sita).

% ---- RULES ----

% A person is a parent if they are a father.
parent(X, Y) :- father(X, Y).

% Two people are siblings if they share a parent.
sibling(X, Y) :- parent(P, X), parent(P, Y), X \= Y.

% ---- QUERIES ----
?- man(ram).           % Output: true
?- woman(ram).         % Output: false
?- likes(sita, X).    % Output: X = cricket
?- father(ram, X).    % Output: X = shyam ; X = sita
?- sibling(shyam, X). % Output: X = sita
