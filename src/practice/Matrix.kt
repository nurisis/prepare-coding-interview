package practice

/**
 * Q. You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 *
 * Solution:
 * Rotate == Transpose & Reverse
 */
fun rotate(matrix: Array<IntArray>): Unit {
    // transpose
    val size = matrix.size
    for (i in 0 until size) {
        for (j in 0 until i) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }

    // reversed
    for (i in 0 until size) {
        for(j in 0 until size/2) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[i][size-j-1]
            matrix[i][size-j-1] = temp
        }
    }
}
