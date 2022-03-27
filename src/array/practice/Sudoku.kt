package array.practice

fun main() {

}

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val rows = Array<HashSet<Char>>(9) {
        hashSetOf()
    }
    val columns = Array<HashSet<Char>>(9) {
        hashSetOf()
    }
    val boxes = Array<HashSet<Char>>(9) {
        hashSetOf()
    }

    for (i in board.indices) {
        for (j in board[i].indices) {
            val num = board[i][j]
            if (num == '.') continue

            if (rows[i].contains(num)) return false
            else rows[i].add(num)

            if (columns[j].contains(num)) return false
            else columns[j].add(num)

            val boxInx = when {
                i/3 == 0 -> {
                    when {
                        j/3 == 0 -> 1
                        j/3 == 1 -> 2
                        else -> 3
                    }
                }
                i/3 == 1 -> {
                    when {
                        j/3 == 0 -> 4
                        j/3 == 1 -> 5
                        else -> 6
                    }
                }
                else -> {
                    when {
                        j/3 == 0 -> 7
                        j/3 == 1 -> 8
                        else -> 9
                    }
                }
            }

            if (boxes[boxInx].contains(num)) return false
            else boxes[boxInx].add(num)
        }
    }

    return true
}
