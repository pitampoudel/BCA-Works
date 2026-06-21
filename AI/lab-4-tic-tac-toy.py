# 4. Implement the Tic-Tac-Toe game using the Minimax algorithm.

WINS = [[0,1,2],[3,4,5],[6,7,8],[0,3,6],[1,4,7],[2,5,8],[0,4,8],[2,4,6]]

def print_board(board):
    symbols = {0: '-', 1: 'O', -1: 'X'}
    print()
    for i in range(9):
        if i % 3 == 0 and i > 0:
            print()
        print(symbols[board[i]], end=' ')
    print("\n")

def check_winner(board):
    for w in WINS:
        if board[w[0]] != 0 and board[w[0]] == board[w[1]] == board[w[2]]:
            return board[w[0]]
    return 0

def minimax(board, player):
    result = check_winner(board)
    if result != 0:
        return result * player
    scores = []
    for i in range(9):
        if board[i] == 0:
            board[i] = player
            scores.append(-minimax(board, -player))
            board[i] = 0
    return max(scores) if scores else 0

def comp_turn(board):
    best_score, best_pos = -2, -1
    for i in range(9):
        if board[i] == 0:
            board[i] = 1
            score = -minimax(board, -1)
            board[i] = 0
            if score > best_score:
                best_score, best_pos = score, i
    board[best_pos] = 1
    print(f"Computer (O) plays at position {best_pos + 1}")

def user_turn(board):
    while True:
        try:
            pos = int(input("Your move (X) - enter position (1-9): ")) - 1
            if 0 <= pos < 9 and board[pos] == 0:
                board[pos] = -1
                break
            print("Invalid! Position already taken or out of range. Try again.")
        except ValueError:
            print("Enter a number between 1 and 9.")

print("=" * 40)
print("   LAB 4 Tic-Tac-Toe  |  Minimax Algorithm by Pitam")
print("   Computer: O        You: X")
print("=" * 40)
print("\nBoard positions:\n 1 2 3\n 4 5 6\n 7 8 9\n")

board = [0] * 9
first = input("Do you want to play 1st or 2nd? (1/2): ").strip()
first = int(first) if first in ('1', '2') else 2

for i in range(9):
    if check_winner(board):
        break
    if (i + first) % 2 == 0:
        comp_turn(board)
    else:
        print_board(board)
        user_turn(board)

print_board(board)
result = check_winner(board)
print("Draw!" if result == 0 else ("You (X) Win!" if result == -1 else "Computer (O) Wins!"))
