package tictactoe;
import java.util.Scanner;
import tictactoe.Tictactoe.GameState;
import tictactoe.Tictactoe.BoardLocation;
import tictactoe.Tictactoe.GameMode;
import tictactoe.Tictactoe.Player;
import tictactoe.Tictactoe.PlayerMode;
import tictactoe.Tictactoe.PlayerID;

public class Main {
    public static char[][] board = new char[3][3];
    public static GameState state = GameState.START;
    public static PlayerMode playerMode = PlayerMode.AI_X_AI_O;
    public static Player playerOne;
    public static Player playerTwo;
    public static GameMode mode = GameMode.EASY;
    public static boolean exitGame = false;

    public static void printGameInstructions()
    {
        System.out.println("Tic-tac-toe is a two-person game using X's and O's on a 3 by 3 board.");
        System.out.println("In this module, you can play with another player, play with an AI, or watch two AI's play.");
        System.out.println("To start the game, type \"start [easy/medium/hard/player] [easy/medium/hard/player].\".");
        System.out.println("The easy difficulty is an AI which generates random moves on the AI's turn.");
        System.out.println("The hard difficulty is programmed to play using algorithms to try and win.");
        System.out.println("The medium difficulty is somewhere in between.");
        System.out.println("You can play as many matches as you would like. To exit, simply type \"exit\" when asked for command input.");
        System.out.println("If you would like to access instructions at any time, simply type \"help.\"");
        System.out.println("Let's start!");
    }

    public static void printMoveInstructions()
    {
        System.out.println("To make a move, type two numbers, 0 to 3. The tic-tac-toe board's coordinates are as follows:");
        System.out.println("---------");
        System.out.println("| (1, 3) (2, 3) (3, 3) |");
        System.out.println("| (1, 2) (2, 2) (3, 2) |");
        System.out.println("| (1, 1) (2, 1) (3, 1) |");
        System.out.println("---------");
        System.out.println("To make a move, type \"[#] [#]\" with no spaces or brackets.");
    }

    public static void handleInput(String input)
    {
        int x = 0;
        int y = 0;

        if (input.contains("help")) {
            printMoveInstructions();
        } else if (input.contains("exit")) {
            exitGame = true;
            return;
        } else if (input.contains("o") || input.contains("e")) { //if input is not valid command, it must be numeric
            System.out.println("You should enter numbers instead of words!");
            return;
        } else if (input.contains("1") || input.contains("2") || input.contains("3")) {
            char X = input.charAt(0);
            char Y = input.charAt(2);
            x = Integer.parseInt(String.valueOf(X));
            y = Integer.parseInt(String.valueOf(Y));
            //INPUT: 1 1 OR help OR exit OR 2 3 OR 3 1
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

    public static void generatePlayers(PlayerMode inputMode)
    {
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

    public static boolean handleGameCommand(String command)
    {
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

        if (restartLoop == false) {
            generatePlayers(playerMode);
        }
        return restartLoop;
    }

    //easy --> easy AI
    //player --> player

    public static void playGame(Scanner scanner)
    {
        while (true) {

            Tictactoe.printBoard(board);

            if (state.gameOver() == true) {
                System.out.println(state.sysOutput());
                break;
            } else if (exitGame) {
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

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        printGameInstructions();
        printMoveInstructions();

        while (true) {
            state = GameState.X_MOVE;
            board = Tictactoe.generateBoard();
            System.out.println("Input command:");
            String command = scanner.nextLine();

            if (command.equals("exit")) {
                break;
            } else if (command.equals("help")) {
                printMoveInstructions();
            } else {
                boolean restartLoop = handleGameCommand(command);
                if (restartLoop) {
                    continue;
                }
            }

            playGame(scanner);
        }
    }
}
