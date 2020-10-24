package tictactoe;

public class Stage1Tictactoe {
    /* enum Value {
        X('X'),
        O('O'),
        BLANK('_');

        private char charVal;

        Value(final char charVal) {
            this.charVal = charVal;
        }

        public char charVal() {
            return charVal;
        }
    }

    enum BoardLocation {
        ONE_THREE("1 3", 1.3, 0, 0),
        TWO_THREE("2 3", 2.3, 0, 1),
        THREE_THREE("3 3", 3.3, 0, 2),
        ONE_TWO("1 2", 1.2,1, 0),
        TWO_TWO("2 2", 2.2, 1, 1),
        THREE_TWO("3 2", 3.2, 1, 2),
        ONE_ONE("1 1", 1.1, 2, 0),
        TWO_ONE("2 1", 2.2, 2, 1),
        THREE_ONE("3 1", 3.1, 2, 2),
        DEFAULT("0 0", 0,0,0);

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

        public static BoardLocation getLocation(int x, int y) {
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
        IN_PROGRESS("", false),
        INCOMPLETE("Game not finished", true),
        DRAW("Draw", true),
        X_WIN("X wins", true),
        O_WIN("O wins", true);

        private final String sysOutput;
        private final Boolean gameOver;

        GameState(final String sysOutput, final Boolean gameOver) {
            this.sysOutput = sysOutput;
            this.gameOver = gameOver;
        }

        public String sysOutput() {
            return sysOutput;
        }

        public Boolean gameOver() {
            return gameOver;
        }
    }

    public static char[][] generateBoard(String input)
    {
        char[][] board = new char[3][3];
        int indexing = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = input.charAt(indexing);
                indexing++;
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
                line = line + board[i][j] + " ";
            }
            System.out.println(line + "|");
            line = "| ";
        }

        System.out.println("---------");
    }

    public static Boolean checkForCompletion(char[][] board)
    {
        boolean complete = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    complete = false;
                }
            }
        }

        return complete;
    }

     */
}

