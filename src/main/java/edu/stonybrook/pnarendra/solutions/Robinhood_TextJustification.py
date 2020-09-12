# Text Justification LEFT or RIGHT each given input line. RobinHood OA
from pprint import pprint

lines = [["hello", "world"],
         ["how", "areYou", "doing"],
         ["Please look", "and align", "to right"]]
aligns = ["LEFT",
          "RIGHT",
          "RIGHT"]
'''
Expected output = ['******************',
          '*hello world     *',
          '*how areYou doing*',
          '*     Please look*',
          '*       and align*',
          '*        to right*',
          '******************']
'''
maxWidth = 16
output = []


def getWords(line, i, width):
    cur_len = len(line[i])
    k = 1
    while i + k < len(line):
        next_len = len(line[i + k]) + 1
        if cur_len + next_len <= width:
            k += 1
            cur_len += next_len
        else:
            break
    return k


def leftAlign(line, width):
    i = 0
    while i < len(line):
        k = getWords(line, i, width)
        l1 = ' '.join(line[i:i + k])
        resLine = '*' + l1 + ' ' * (width - len(l1)) + '*'
        output.append(resLine)
        i += k


def rightAlign(line, width):
    i = 0
    while i < len(line):
        k = getWords(line, i, width)
        l1 = ' '.join(line[i:i + k])
        resLine = '*' + ' ' * (width - len(l1)) + l1 + '*'
        output.append(resLine)
        i += k


def main():
    output.append("*" * (maxWidth + 2))
    for i, line in enumerate(lines):
        if aligns[i] == "LEFT":
            leftAlign(line, maxWidth)
        elif aligns[i] == "RIGHT":
            rightAlign(line, maxWidth)
    output.append("*" * (maxWidth + 2))
    pprint(output)


if __name__ == "__main__":
    main()
