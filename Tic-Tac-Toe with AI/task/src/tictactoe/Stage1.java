package tictactoe;
import java.util.Scanner;
import tictactoe.Tictactoe.GameState;
import tictactoe.Tictactoe.BoardLocation;

public class Stage1 {
    /* public static char[][] board = new char[3][3];
    public static GameState state = GameState.START;
    public static Boolean successful = false;

    public static Boolean systemIsO(String line) {
        Boolean systemIsO = false;
        int numOfXs = 0;
        int numOfOs = 0;

        for (int i = 0; i < 9; i++) {
            char val = line.charAt(i);

            switch (val) {
                case 'X':
                    numOfXs++;
                    break;
                case 'O':
                    numOfOs++;
                    break;
                default:
                    break;
            }
        }
        if (numOfXs <= numOfOs) {
            systemIsO = true;
        }
        return systemIsO;
    }

    public static void askForInput() {
        switch (state) {
            case START:
                System.out.println("Enter cells:");
                state = GameState.IN_PROGRESS;
                break;
            case IN_PROGRESS:
                System.out.println("Enter the coordinates:");
                break;
            default:
                break;
        }
    }

    public static void determineWinner(int counterO, int counterX) {
        if (counterX == 3) {
            state = GameState.X_WIN;
            return;
        } else if (counterO == 3) {
            state = GameState.O_WIN;
            return;
        } else if (Tictactoe.checkForCompletion(board)) {
            state = GameState.DRAW;
        } else {
            state = GameState.IN_PROGRESS;
        }
    }

    public static void determineState() {
        // check: diagonal 1, diagonal 2, column 1, column 2, column 3, row 1, row 2, row 3
        int counterX = 0;
        int counterO = 0;

        //check rows
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    counterX++;
                } else if (board[i][j] == 'O') {
                    counterO++;
                }
            }
            determineWinner(counterO, counterX);
            if (state.gameOver()) {
                return;
            }

            counterO = 0;
            counterX = 0;
        }

        //check columns
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == 'X') {
                    counterX++;
                } else if (board[j][i] == 'O') {
                    counterO++;
                }
            }
            determineWinner(counterO, counterX);
            if (state.gameOver()) {
                return;
            }
            counterO = 0;
            counterX = 0;
        }

        //check diagonal 1
        counterO = 0;
        counterX = 0;

        if (board[BoardLocation.ONE_THREE.rowIndex()][BoardLocation.ONE_THREE.columnIndex()] == 'X') {
            counterX++;
        } else if (board[BoardLocation.ONE_THREE.rowIndex()][BoardLocation.ONE_THREE.columnIndex()] == 'O') {
            counterO++;
        }

        if (board[BoardLocation.TWO_TWO.rowIndex()][BoardLocation.TWO_TWO.columnIndex()] == 'X') {
            counterX++;
        } else if (board[BoardLocation.TWO_TWO.rowIndex()][BoardLocation.TWO_TWO.columnIndex()] == 'O') {
            counterO++;
        }

        if (board[BoardLocation.THREE_ONE.rowIndex()][BoardLocation.THREE_ONE.columnIndex()] == 'X') {
            counterX++;
        } else if (board[BoardLocation.THREE_ONE.rowIndex()][BoardLocation.THREE_ONE.columnIndex()] == 'O') {
            counterO++;
        }

        determineWinner(counterO, counterX);
        if (state.gameOver()) {
            return;
        }

        //check diagonal 2

        counterO = 0;
        counterX = 0;

        if (board[BoardLocation.THREE_THREE.rowIndex()][BoardLocation.THREE_THREE.columnIndex()] == 'X') {
            counterX++;
        } else if (board[BoardLocation.THREE_THREE.rowIndex()][BoardLocation.THREE_THREE.columnIndex()] == 'O') {
            counterO++;
        }

        if (board[BoardLocation.TWO_TWO.rowIndex()][BoardLocation.TWO_TWO.columnIndex()] == 'X') {
            counterX++;
        } else if (board[BoardLocation.TWO_TWO.rowIndex()][BoardLocation.TWO_TWO.columnIndex()] == 'O') {
            counterO++;
        }

        if (board[BoardLocation.ONE_ONE.rowIndex()][BoardLocation.ONE_ONE.columnIndex()] == 'X') {
            counterX++;
        } else if (board[BoardLocation.ONE_ONE.rowIndex()][BoardLocation.ONE_ONE.columnIndex()] == 'O') {
            counterO++;
        }

        determineWinner(counterO, counterX);
        if (state.gameOver()) {
            return;
        } else {
            state = GameState.INCOMPLETE;
        }
    }

    public static void respondToInput(Boolean playerIsX, int x, int y) {
        if (x > 3 || x < 1 || y > 3 || y < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            return;
        }

        BoardLocation location = BoardLocation.getLocation(x, y);

        char valAtLocation = board[location.rowIndex()][location.columnIndex()];
        if (valAtLocation != '_') {
            System.out.println("This cell is occupied! Choose another one!");
            return;
        } else {
            if (playerIsX) {
                board[location.rowIndex()][location.columnIndex()] = 'X';
            } else {
                board[location.rowIndex()][location.columnIndex()] = 'O';
            }
        }

        successful = true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        askForInput();
        String inputLine = scanner.nextLine();
        board = Tictactoe.generateBoard(inputLine);
        Boolean playerIsX = systemIsO(inputLine);

        //game loop would begin here (for statement based on GameState state)

        Tictactoe.printBoard(board);

        while (true) {
            askForInput();
            String nextLine = scanner.nextLine();
            Boolean containsString = false;
            Boolean withinRange = false;

            if (nextLine.contains("o") || nextLine.contains("e")) {
                System.out.println("You should enter numbers!");
            } else if (nextLine.contains("1") || nextLine.contains("2") || nextLine.contains("3")){
                char X = nextLine.charAt(0);
                char Y = nextLine.charAt(2);
                int x = Integer.parseInt(String.valueOf(X));
                int y = Integer.parseInt(String.valueOf(Y));
                respondToInput(playerIsX, x, y);
                if (successful) {
                    Tictactoe.printBoard(board);
                    determineState();
                    System.out.println(state.sysOutput());
                }
            }

            if (state.gameOver()) {
                break;
            }
        }
    }

     */
}
