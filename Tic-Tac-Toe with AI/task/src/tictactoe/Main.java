package tictactoe;
import java.util.Scanner;
import tictactoe.Tictactoe.GameState;
import tictactoe.Tictactoe.BoardLocation;
import tictactoe.Tictactoe.GameMode;
import tictactoe.Tictactoe.Player;
import tictactoe.Tictactoe.PlayerMode;
import tictactoe.Tictactoe.PlayerID;
import java.util.Random;

public class Main {
    public static char[][] board = new char[3][3];
    public static GameState state = GameState.START;
    public static PlayerMode playerMode = PlayerMode.AI_X_AI_O;
    public static Player playerOne;
    public static Player playerTwo;
    public static GameMode mode = GameMode.EASY;

    public static void handleInput(String input) {
        int x = 0;
        int y = 0;

        if (input.contains("o") || input.contains("e")) {
            System.out.println("You should enter numbers!");
            return;
        } else if (input.contains("1") || input.contains("2") || input.contains("3")) {
            char X = input.charAt(0);
            char Y = input.charAt(2);
            x = Integer.parseInt(String.valueOf(X));
            y = Integer.parseInt(String.valueOf(Y));
        } else {
            System.out.println("Bad parameters!");
            return;
        }

        if (x > 3 || x < 1 || y > 3 || y < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            return;
        }

        BoardLocation location = BoardLocation.getLocation(x, y);

        char valAtLocation = board[location.rowIndex()][location.columnIndex()];
        if (valAtLocation != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
        } else {
            switch (state) {
                case X_MOVE:
                    board[location.rowIndex()][location.columnIndex()] = 'X';
                    state = GameState.O_MOVE;
                    break;
                case O_MOVE:
                    board[location.rowIndex()][location.columnIndex()] = 'O';
                    state = GameState.X_MOVE;
                    break;
            }
            state = GameState.determineState(board, state);
        }
    }

    public static void generatePlayers(PlayerMode inputMode) {
        switch (inputMode) {
            case AI_X_AI_O:
                playerOne = new Player(PlayerID.PLAYER_X, PlayerMode.AI_X_AI_O.oneIsAI(), true);
                playerTwo = new Player(PlayerID.PLAYER_O, PlayerMode.AI_X_AI_O.twoIsAI(), false);
                break;
            case AI_X_PLAYER_O:
                playerOne = new Player(PlayerID.PLAYER_X, PlayerMode.AI_X_PLAYER_O.oneIsAI(), true);
                playerTwo = new Player(PlayerID.PLAYER_O, PlayerMode.AI_X_PLAYER_O.twoIsAI(), false);
                break;
            case PLAYER_X_PLAYER_O:
                playerOne = new Player(PlayerID.PLAYER_X, PlayerMode.PLAYER_X_PLAYER_O.oneIsAI(), true);
                playerTwo = new Player(PlayerID.PLAYER_O, PlayerMode.PLAYER_X_PLAYER_O.twoIsAI(), false);
                break;
            case PLAYER_X_AI_O:
                playerOne = new Player(PlayerID.PLAYER_X, PlayerMode.PLAYER_X_AI_O.oneIsAI(), true);
                playerTwo = new Player(PlayerID.PLAYER_O, PlayerMode.PLAYER_X_AI_O.twoIsAI(), false);
                break;
        }
    }

    public static boolean startGame(String command) {
        boolean restartLoop = false;

        switch (command) {
            case "start easy easy":
                playerMode = PlayerMode.AI_X_AI_O;
                mode = GameMode.EASY;
                break;
            case "start easy user":
                playerMode = PlayerMode.AI_X_PLAYER_O;
                mode = GameMode.EASY;
                break;
            case "start user user":
                playerMode = PlayerMode.PLAYER_X_PLAYER_O;
                mode = GameMode.EASY;
                break;
            case "start user easy":
                playerMode = PlayerMode.PLAYER_X_AI_O;
                mode = GameMode.EASY;
                break;
            default:
                System.out.println("Bad parameters!");
                restartLoop = true;
                break;
        }

        System.out.println(playerMode.name());
        generatePlayers(playerMode);
        return restartLoop;
    }

    //easy --> easy AI
    //player --> player

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Input command:");
            state = GameState.X_MOVE;
            board = Tictactoe.generateBoard();
            String command = scanner.nextLine();

            if (command.equals("exit")) {
                break;
            } else {
                boolean restartLoop = startGame(command);
                if (restartLoop) {
                    continue;
                }
            }

            while (true) {
                Tictactoe.printBoard(board);

                if (state.gameOver()) {
                    break;
                }

                switch (state) {
                    case X_MOVE:
                        if (playerMode.oneIsAI()) {
                            board = GameMode.makeEasyMove(board, true);
                            state = GameState.determineState(board, state);
                        } else {
                            System.out.println("Enter the coordinates:");
                            handleInput(scanner.nextLine());
                        }
                        break;
                    case O_MOVE:
                        if (playerMode.twoIsAI()) {
                            board = GameMode.makeEasyMove(board, false);
                            state = GameState.determineState(board, state);
                        } else {
                            System.out.println("Enter the coordinates:");
                            handleInput(scanner.nextLine());
                        }
                        break;
                    case X_WIN:
                    case O_WIN:
                    case DRAW:
                        System.out.println(state.sysOutput());
                        break;
                }
            }
        }
    }
}
