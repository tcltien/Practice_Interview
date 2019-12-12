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
    function rotateMatrix2D_90Degree(matrix, cycle) {
        if (cycle == 0) {
            return matrix;
        }
        var rotate_cycle = cycle % 4;
        var count = 0
        while (count < rotate_cycle) {
            var length = matrix.length - 1;
            for (var i = 0; i < length / 2; i++) {
                for (var j = i; j < length - i; j++) {
                    var p1 = matrix[i][j];
                    //Coordinate 2
                    var p2 = matrix[j][length - i];
                    //Coordinate 3
                    var p3 = matrix[length - i][length - j];
                    //Coordinate 4
                    var p4 = matrix[length - j][i];
                    //Swap values of 4 coordinates
                    matrix[j][length - i] = p1; // right top
                    matrix[length - i][length - j] = p2; // right bottom
                    matrix[length - j][i] = p3; // left bottom
                    matrix[i][j] = p4; // left top
                }
            }
            count++;
        }
        console.log("after rotate matrix with " + cycle + " cycle");
        console.log(matrix);
        return matrix;
    }

    return {
        create2DArray,
        buildMatrix,
        rotateMatrix2D_90Degree
    }
}
module.exports = RotateService();