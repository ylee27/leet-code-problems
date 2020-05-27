package recfun
import java.util.HashMap

class Sudoku {

  /**
   * isValid Sudoku (#36, Medium)
   * Determine if a 9x9 Sudoku board is valid.
   * Only the filled cells need to be validated
   * according to the following rules:
   *
   * 1. Each row must contain the digits 1-9 without repetition.
   * 2. Each column must contain the digits 1-9 without repetition.
   * 3. Each of the 9 3x3 sub-boxes of the grid must contain
   *    the digits 1-9 without repetition.
   */

  def isValidsudoku(board: Array[Array[Char]]): Boolean = {

    // Populate the data
    val rows: Array[HashMap[Integer, Integer]] = Array.ofDim[HashMap[Integer, Integer]](9)
    val columns: Array[HashMap[Integer, Integer]] = Array.ofDim[HashMap[Integer, Integer]](9)
    val boxes: Array[HashMap[Integer, Integer]] = Array.ofDim[HashMap[Integer, Integer]](9)
    for (i <- 0.until (9)) {
      rows(i) = new HashMap[Integer, Integer]()
      columns(i) = new HashMap[Integer, Integer]()
      boxes(i) = new HashMap[Integer, Integer]()
    }

    for (i <- 0 until 9; j <- 0 until 9) {
      val num: Char = board(i)(j)
      if (num != '.'){
        val n: Int = num.toInt
        val box_index: Int = (i/3) * 3 + j/3

        // Keep the current cell value
        rows(i).put(n, rows(i).getOrDefault(n, 0) + 1) // return default only if no mapping
        columns(j).put(n, columns(j).getOrDefault(n, 0) + 1)
        boxes(box_index).put(n, boxes(box_index).getOrDefault(n, 0) + 1)

        // Check if this value has been already seen before
        if (rows(i).get(n) > 1 ||
          columns(j).get(n) > 1 ||
          boxes(box_index).get(n) > 1) false
      }
    }
    true
  }


  /**
   * Sudoku Solver (#37, Medium)
   * Write a program to solve a Sudoku puzzle by filling the empty cells.
   *
   * A sudoku solution must satisfy all of the following rules:
   *
   * 1. Each of the digits 1-9 must occur exactly once in each row.
   * 2. Each of the digits 1-9 must occur exactly once in each column.
   * 3. Each of the the digits 1-9 must occur exactly once in each of
   *    the 9 3x3 sub-boxes of the grid.
   *
   * Note:
   * Empty cells are indicated by the character '.'.
   */

  /** Comment:
   * There is a bug in the solver below (debugging in-progress)! */

  /*
  def solveSudoku(board: Array[Array[Char]]): Unit = {

    // Box size
    var n: Int = 3
    // Row size
    var N: Int = n * n
    var rows: Array[Array[Int]] = Array.ofDim(N, N + 1)
    var columns: Array[Array[Int]] = Array.ofDim(N, N + 1)
    var boxes: Array[Array[Int]] = Array.ofDim(N, N + 1)
    var board: Array[Array[Char]] = Array.ofDim(N, N + 1)

    // Solver boolean
    var sudokuSolved: Boolean = false

    // Check if a number d can be placed in (row, col) cell
    def couldPlace(d: Int, row: Int, col: Int): Boolean = {

      val idx: Int = (row / n) * n + col / n
      rows(row)(d) + columns(col)(d) + boxes(idx)(d) == 0
    }

    // Place a number d in (row, col) cell
    def placeNumber(d: Int, row: Int, col: Int): Unit = {
      val idx: Int = (row / n) * n + col / n
      rows(row)(d) += 1; rows(row)(d) - 1
      columns(col)(d) += 1; columns(col)(d) - 1
      boxes(idx)(d) += 1; boxes(idx)(d) - 1
      board(row)(col) = (d + '0').toChar
    }

    // Remove a number which did not lead to the solution
    def removeNumber(d: Int, row: Int, col: Int): Unit = {
      val idx: Int = (row / n) * n + col / n
      rows(row)(d) -= 1; rows(row)(d) + 1
      columns(col)(d) -= 1; columns(col)(d) + 1
      boxes(idx)(d) -= 1; boxes(idx)(d) + 1
      board(row)(col) = '.'
    }

    // Place next numbers
    /* Call backtrack function in recursion
     * to continue to place numbers until we have a solution */
    def placeNextNumbers(row: Int, col: Int): Unit = {
      // If we have a solution (i.e., col==N-1 && row==N-1)
      if ((col == N - 1) && (row == N - 1)) {
        sudokuSolved = true
      } else {
        // If not, go to the next row
        if (col == N - 1) backtrack(row + 1, 0)
        else // Go to the next column
          backtrack(row, col + 1)
      }
    }

    // Backtrack
    def backtrack(row: Int, col: Int) ={
      // If cell is empty
      if (board(row)(col) == '.') {
        for (d <- 1.until(10) if couldPlace(d, row, col)) {
          placeNumber(d, row, col)
          placeNextNumbers(row, col)

          // Because a single unique solution is needed
          if (!sudokuSolved) removeNumber(d, row, col)
        }
      } // If sudoku is solved, there is no need to backtrack
      else placeNextNumbers(row, col)
    }

    def solveSudoku(board: Array[Array[Char]]): Unit = {
      for (i <- 0 until N; j <- 0 until N) {
        val num: Char = board(i)(j)
        if (num != '.') {
          val d: Int = Character.getNumericValue(num)
          placeNumber(d, i, j)
        }
      }
      backtrack(0, 0)
    }

    solveSudoku(board)
  }
  */

  // Comment: Tested with LeetCode, and additionally need to add tests for sudoku functions
}
