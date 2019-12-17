function RotateService() {
    /*
        Function init a 2D array
    */
    function create2DArray(numRows) {
        if (numRows == 0) {
            return 0;
        }
        let array = new Array(numRows);
        for (let i = 0; i < numRows; i++) {
            array[i] = new Array(numRows);
        }
        return array;
    }

    /*
        Function put value to array
    */
    function buildMatrix(matrixSize) {
        var r_matrix = create2DArray(matrixSize);
        var value = 0;
        for (var i = 0; i < matrixSize; i++) {
            for (var j = 0; j < matrixSize; j++) {
                r_matrix[i][j] = ++value;
            }
        }
        console.log("Matrix after initilize");
        console.log(r_matrix);
        return r_matrix;
    }

    /*
        Rotate Matrix with cycle
    */
    function rotatePicture(matrix, cycle) {
        if (cycle == 0) {
            return matrix;
        }
        var rotate_cycle = cycle % 4;
        var count = 0
        switch (rotate_cycle) {
            case 1:
                rotateClockWise_90Degree(matrix);
                break;
            case 2:
                rotateMatrix2D_180Degree(matrix);
                break;
            case 3:
                rotateCounterClockWise_90Degree(matrix);
                break;
            default:
                return matrix;
        }
        console.log("after rotate matrix with " + cycle + " cycle");
        console.log(matrix);
        return matrix;
    }

    /*
        Function Rotate 90 degree clockwise 
    */
    function rotateClockWise_90Degree(matrix) {
        swapRows(matrix);
        transpose(matrix);
    }

    /*
        Function Rotate 90 degree counter clockwise 
    */
    function rotateCounterClockWise_90Degree(matrix) {
        transpose(matrix);
        swapRows(matrix);
    }

    /*
        Function Rotate 180 degree
    */
    function rotateMatrix2D_180Degree(matrix) {
        var N = matrix.length;
        for (var i = 0; i < N / 2; i++) {
            for (var j = 0; j < N; j++) {
                var temp = matrix[i][j];
                matrix[i][j] = matrix[N - i - 1][N - j - 1];
                matrix[N - i - 1][N - j - 1] = temp;
            }
        }
        return matrix;
    }

    /*
        Function swap rows
    */
    function swapRows(m) {
        for (var  i = 0, k = m.length - 1; i < k; ++i, --k) {
            var x = m[i];
            m[i] = m[k];
            m[k] = x;
        }
        return m;
    }

    /*
        Function transpose matrix
    */
    function transpose(m) {
        for (var i = 0; i < m.length; i++) {
            for (var j = i; j < m[0].length; j++) {
                var x = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = x;
            }
        }
    }

    return {
        create2DArray,
        buildMatrix,
        rotatePicture,
        rotateMatrix2D_180Degree,
        rotateClockWise_90Degree,
        rotateCounterClockWise_90Degree
    }
}
module.exports = RotateService();