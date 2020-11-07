class Matrix {
    enum InputType {
        STRING_LIST,
        SCAN,
        ARRAY_SET;

        InputType() {}

    }

    enum ArrayType {
        STRINGS,
        CHARS,
        BOOLEANS,
        INTS,
        LONGS,
        BYTES,
        FLOATS,
        DOUBLES;

        ArrayType() {}
    }

    private int rowIndex;
    private int columnIndex;
    private InputType inType;
    private ArrayType arrType;

    Matrix(int rowIndex, int columnIndex, InputType inType, ArrayType arrType) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.inType = inType;
        this.arrType = arrType;
    }

    public void setArrType(ArrayType type)
    {
        switch (type) {
            case STRINGS:
                this.arrType = ArrayType.STRINGS;
                break;
            case CHARS:
                this.arrType = ArrayType.CHARS;
                break;
            case BOOLEANS:
                this.arrType = ArrayType.BOOLEANS;
                break;
            case INTS:
                this.arrType = ArrayType.INTS;
                break;
            case LONGS:
                this.arrType = ArrayType.LONGS;
                break;
            case BYTES:
                this.arrType = ArrayType.BYTES;
                break;
            case FLOATS:
                this.arrType = ArrayType.FLOATS;
                break;
            case DOUBLES:
                this.arrType = ArrayType.DOUBLES;
                break;
        }
    }

    public void setInType(InputType type)
    {
        switch (type) {
            case STRING_LIST:
                this.inType = InputType.STRING_LIST;
                break;
            case SCAN:
                this.inType = InputType.SCAN;
                break;
            case ARRAY_SET:
                this.inType = InputType.ARRAY_SET;
                break;
        }
    }

    public int getRowIndex() { return rowIndex }

    public int getColumnIndex() { return columnIndex }

    public InputType getInType() { return inType }

    public ArrayType getArrType() { return arrType }

    public String[][] scanStringMatrix(Scanner scanner, int rows, int columns, boolean oneWordPerEntry)
    {
        String[][] matrix = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String line = "";

                if (oneWordPerEntry) {
                    line = scanner.next;
                } else {
                    line = scanner.nextLine;
                }

                matrix[i][j] = line;
            }
        }
    }

    public char[][] scanCharMatrix(Scanner scanner, int rows, int columns)
    {
        char[][] matrix = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextChar();
            }
        }
    }

    public boolean[][] scanBooleanMatrix(Scanner scanner, int rows, int columns)
    {
        boolean[][] matrix = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String line = scanner.nextLine;
                boolean trueOrFalse = false;

                if (line == "true" || line == "TRUE" || line == "True" || line == "t" || line == "T") {
                    trueOrFalse = true;
                }

                matrix[i][j] = trueOrFalse;
            }
        }
    }

    public int[][] scanIntMatrix(Scanner scanner, int rows, int columns)
    {
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public long[][] scanLongMatrix(Scanner scanner, int rows, int columns)
    {
        long[][] matrix = new long[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public byte[][] scanByteMatrix(Scanner scanner, int rows, int columns)
    {
        byte[][] matrix = new byte[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public float[][] scanFloatMatrix(Scanner scanner, int rows, int columns)
    {
        float[][] matrix = new float[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public double[][] scanDoubleMatrix(Scanner scanner, int rows, int columns)
    {
        double[][] matrix = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }
}