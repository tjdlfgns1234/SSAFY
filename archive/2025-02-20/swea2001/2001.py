import sys

sys.stdin = open("swea/2001/input.txt", "r")

T = int(input())


def sum_flies(flies, swatter, row, col):
    sum = 0
    for i in range(swatter):
        for j in range(swatter):
            sum += flies[row + i][col + j]

    return sum


def find_max_flies_to_kill(flies, swatter):
    MAX = 0
    flies_length = len(flies[0])
    if swatter >= flies_length:
        MAX = sum(flies)
    elif swatter < flies_length:
        diff = flies_length - swatter
        for i in range(diff + 1):
            for j in range(diff + 1):
                MAX = max(MAX, sum_flies(flies, swatter, i, j))
    else:
        pass

    return MAX


for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    flies = [list(map(int, input().split())) for _ in range(N)]
    result = find_max_flies_to_kill(flies, M)
    print(f"#{test_case} {result}")
