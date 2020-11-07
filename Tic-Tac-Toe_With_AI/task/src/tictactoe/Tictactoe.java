package tictactoe;

import java.util.Random;

public class Tictactoe {
    enum GameMode {
        EASY,
        MEDIUM,
        HARD;

        GameMode() {}

        public static char[][] makeEasyMove(char[][] startBoard, Boolean aiIsPlayerOne)
        {
            char[][] board = startBoard;
            Random random = new Random();

            System.out.println("Making move level \"easy\"");

            while (true) {
                int num = random.nextInt(9); //might need to be 8?
                BoardLocation location = BoardLocation.locationFromValue(num);

                if (board[location.rowIndex()][location.columnIndex()] == ' ') {
                    if (aiIsPlayerOne) {
                        board[location.rowIndex()][location.columnIndex()] = 'X';
                    } else {
                        board[location.rowIndex()][location.columnIndex()] = 'O';
                    }
                    return board;
                }
            }
        }
    }

    enum Value {
        X('X'),
        O('O'),
        BLANK(' ');

        private char charVal;

        Value(final char charVal) {
            this.charVal = charVal;
        }

        public char charVal() {
            return charVal;
        }
    }

    enum PlayerMode {
        PLAYER_X_AI_O(false, true),
        PLAYER_X_PLAYER_O(false, false),
        AI_X_AI_O(true, true),
        AI_X_PLAYER_O(true, false);

        private boolean oneIsAI;
        private boolean twoIsAI;

        PlayerMode(boolean oneIsAI, boolean twoIsAI) {
            this.oneIsAI = oneIsAI;
            this.twoIsAI = twoIsAI;
        }

        public boolean oneIsAI()
        {
            return oneIsAI;
        }

        public boolean twoIsAI()
        {
            return twoIsAI;
        }
    }

    enum PlayerID {
        PLAYER_X(true, Value.X),
        PLAYER_O(false, Value.O);
        
        private boolean isFirst;
        private Value associatedInput;
        
        PlayerID(final boolean isFirst, final Value associatedInput) {
            this.isFirst = isFirst;
            this.associatedInput = associatedInput;
        }
        
        public boolean isFirst()
        {
            return isFirst;
        }

        public Value associatedInput()
        {
            return associatedInput;
        }
    }
    
    enum BoardLocation {
        ONE_THREE("1 3", 0, 0, 0),
        TWO_THREE("2 3", 1, 0, 1),
        THREE_THREE("3 3", 2, 0, 2),
        ONE_TWO("1 2", 3, 1, 0),
        TWO_TWO("2 2", 4, 1, 1),
        THREE_TWO("3 2", 5, 1, 2),
        ONE_ONE("1 1", 6, 2, 0),
        TWO_ONE("2 1", 7, 2, 1),
        THREE_ONE("3 1", 8, 2, 2),
        DEFAULT("0 0", 10, 5, 5);

        private String coordinate;
        private double value;
        private int rowIndex;
        private int columnIndex;

        BoardLocation(final String coordinate, final double value, final int rowIndex, final int columnIndex) {
            this.coordinate = coordinate;
            this.value = value;
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }

        public String coordinate() {
            return coordinate;
        }

        public double value() {
            return value;
        }

        public int rowIndex() {
            return rowIndex;
        }

        public int columnIndex() {
            return columnIndex;
        }

        public static BoardLocation locationFromValue(int val)
        {
            BoardLocation location = DEFAULT;

            switch (val) {
                case 0:
                    location = ONE_THREE;
                    break;
                case 1:
                    location = TWO_THREE;
                    break;
                case 2:
                    location = THREE_THREE;
                    break;
                case 3:
                    location = ONE_TWO;
                    break;
                case 4:
                    location = TWO_TWO;
                    break;
                case 5:
                    location = THREE_TWO;
                    break;
                case 6:
                    location = ONE_ONE;
                    break;
                case 7:
                    location = TWO_ONE;
                    break;
                case 8:
                    location = THREE_ONE;
                    break;
            }

            return location;
        }

        public static BoardLocation getLocation(int x, int y)
        {
            BoardLocation location = DEFAULT;
            String coordinate = x + " " + y;
            switch (coordinate) {
                case "1 3":
                    location = ONE_THREE;
                    break;
                case "2 3":
                    location = TWO_THREE;
                    break;
                case "3 3":
                    location = THREE_THREE;
                    break;
                case "1 2":
                    location = ONE_TWO;
                    break;
                case "2 2":
                    location = TWO_TWO;
                    break;
                case "3 2":
                    location = THREE_TWO;
                    break;
                case "1 1":
                    location = ONE_ONE;
                    break;
                case "2 1":
                    location = TWO_ONE;
                    break;
                case "3 1":
                    location = THREE_ONE;
                    break;
                default:
            }
            return location;
        }
    }

    enum GameState {
        START("", false),
        X_MOVE("Player X, enter coordinates:", false),
        O_MOVE("Player O, enter coordinates:", false),
        DRAW("Draw", true),
        X_WIN("X wins", true),
        O_WIN("O wins", true);

        private final String sysOutput;
        private final Boolean gameOver;

        GameState(final String sysOutput, final Boolean gameOver)
        {
            this.sysOutput = sysOutput;
            this.gameOver = gameOver;
        }

        public String sysOutput() {
            return sysOutput;
        }

        public Boolean gameOver() {
            return gameOver;
        }

        public static GameState findWhoseMove(char[][] board, GameState inState)
        {
            GameState state = inState;
            int counterX = 0;
            int counterO = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 'O') {
                        counterO++;
                    } else if (board[i][j] == 'X') {
                        counterX++;
                    }
                }
            }

            if (counterX > counterO) {
                state = O_MOVE;
            } else {
                state = X_MOVE;
            }

            return state;
        }

        public static GameState determineWinner(int counterO, int counterX, char[][] board)
        {
            GameState state = START;

            if (counterX == 3) {
                state = X_WIN;
            } else if (counterO == 3) {
                state = O_WIN;
            } else {
                state = findWhoseMove(board, state);
            }

            return state;
        }

        public static int checkDiagonalOne(char ch, char[][] board)
        {
            int counter = 0;

            if (board[BoardLocation.ONE_THREE.rowIndex()][BoardLocation.ONE_THREE.columnIndex()] == ch) {
                counter++;
            }

            if (board[BoardLocation.TWO_TWO.rowIndex()][BoardLocation.TWO_TWO.columnIndex()] == ch) {
                counter++;
            }

            if (board[BoardLocation.THREE_ONE.rowIndex()][BoardLocation.THREE_ONE.columnIndex()] == ch) {
                counter++;
            }

            return counter;
        }

        public static int checkDiagonalTwo(char ch, char[][] board)
        {
            int counter = 0;

            if (board[BoardLocation.THREE_THREE.rowIndex()][BoardLocation.THREE_THREE.columnIndex()] == ch) {
                counter++;
            }

            if (board[BoardLocation.TWO_TWO.rowIndex()][BoardLocation.TWO_TWO.columnIndex()] == ch) {
                counter++;
            }

            if (board[BoardLocation.ONE_ONE.rowIndex()][BoardLocation.ONE_ONE.columnIndex()] == ch) {
                counter++;
            }

            return counter;
        }

        public static GameState checkRows(char[][] board, GameState state)
        {
            for (int i = 0; i < 3; i++) {
                int counterO = 0;
                int counterX = 0;

                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == 'X') {
                        counterX++;
                    } else if (board[i][j] == 'O') {
                        counterO++;
                    }
                }
                state = determineWinner(counterO, counterX, board);
                if (state.gameOver()) {
                    return state;
                }
            }
            return state;
        }

        public static GameState checkColumns(char[][] board, GameState state)
        {
            for (int i = 0; i < 3; i++) {
                int counterO = 0;
                int counterX = 0;
                for (int j = 0; j < 3; j++) {
                    if (board[j][i] == 'X') {
                        counterX++;
                    } else if (board[j][i] == 'O') {
                        counterO++;
                    }
                }
                state = determineWinner(counterO, counterX, board);
                if (state.gameOver()) {
                    return state;
                }
            }
            return state;
        }

        public static GameState determineState(char[][] board, GameState inState)
        {
            GameState state = inState;

            state = checkRows(board, state);
            if (state.gameOver()) {
                return state;
            }

            state = checkColumns(board, state);
            if (state.gameOver()) {
                return state;
            }

            int counterX = checkDiagonalOne('X', board);
            int counterO = checkDiagonalOne('O', board);
            state = determineWinner(counterO, counterX, board);
            if (state.gameOver()) {
                return state;
            }

            counterX = checkDiagonalTwo('X', board);
            counterO = checkDiagonalTwo('O', board);
            state = determineWinner(counterO, counterX, board);
            if (!state.gameOver()) {
                state = findWhoseMove(board, inState);
            }

            boolean gameOver = checkForCompletion(board);
            if (gameOver) {
                state = GameState.DRAW;
            }
            return state;
        }
    }

    public static char[][] generateBoard()
    {
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        return board;
    }

    public static void printBoard(char[][] board)
    {
        String line = "| ";

        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                line = line.concat(board[i][j] + " ");
            }
            System.out.println(line + "|");
            line = "| ";
        }

        System.out.println("---------");
    }

    public static boolean checkForCompletion(char[][] board)
    {
        boolean gameOver = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    gameOver = false;
                }
            }
        }

        return gameOver;
    }

    public static class Player
    {
        private PlayerID id;
        private boolean isAI;
        private boolean isPlayerOne;

        Player(PlayerID id, boolean isAI, boolean isPlayerOne) {
            this.id = id;
            this.isAI = isAI;
            this.isPlayerOne = isPlayerOne;
        }

        public PlayerID getID()
        {
            return id;
        }

        public boolean getIsAI()
        {
            return isAI;
        }

        public boolean getIsPlayerOne()
        {
            return isPlayerOne;
        }

    }
}
