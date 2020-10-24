

class Matrix {
    enum InputType {
        STRING_VALUE,
        NUMBERS,
        ARRAYS,
        MATRIX;

        InputType() {}
    }

    enum ArrayType {
        STRINGS,
        CHARACTERS,
        BOOLEANS,
        INTEGERS,
        LONGS,
        BYTES,
        FLOATS,
        DOUBLES;

        ArrayType() {}

        public void
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

    public int getRowIndex() { return rowIndex }

    public int getColumnIndex() { return columnIndex }

    public InputType getInType() { return inType }

    public ArrayType getArrType() { return arrType }

    public int[][] create
}