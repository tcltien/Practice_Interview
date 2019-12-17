
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

function buildMatrix2(matrixSize) {
    var r_matrix = create2DArray(matrixSize);
    var value = 0;
    for (var i = 0; i < matrixSize; i++) {
        for (var j = 0; j < matrixSize; j++) {
            r_matrix[i][j] = 0;
        }
    }
    console.log("Matrix after initilize");
    console.log(r_matrix);
    return r_matrix;
}

/*
    Rotate Matrix with cycle
*/
function rotateMatrix2D_90Degree(matrix) {
    // temporary array of size M 
    var length = matrix.length-1;
    for (var i = 0; i <= length/2; i++) {
        for (var j = i; j < length-i; j++) {
         //Coordinate 1
         var p1 = matrix[i][j];
         //Coordinate 2
         var p2 = matrix[j][length-i];
         //Coordinate 3
         var p3 = matrix[length-i][length-j];
         //Coordinate 4
         var p4 = matrix[length-j][i];
         //Swap values of 4 coordinates.
         matrix[j][length-i] = p1;
         matrix[length-i][length-j] = p2;
         matrix[length-j][i] = p3;
         matrix[i][j] = p4;
        }
    }
    return matrix;
}

function rotateMatrix180(matrix) {
    var N = matrix.length;
    for(var i=0;i<N/2;i++) { 
        for(var j=0;j<N;j++) { 
            var temp = matrix[i][j]; 
            matrix[i][j] = matrix[N-i-1][N-j-1]; 
            matrix[N-i-1][N-j-1] = temp; 
        }
    }
    return matrix; 
}

function rotateMatrix90Counter(matrix) {
    if (matrix.length == 0) {
        return;
    }
    for (var i = 0; i < matrix.length / 2; i++) {
        var top = i;
        var bottom = matrix.length - 1 - i;
        for (var j = top; j < bottom; j++) {
            var temp = matrix[top][j];
            matrix[top][j] = matrix[j][bottom];
            matrix[j][bottom] = matrix[bottom][bottom - (j - top)];
            matrix[bottom][bottom - (j - top)] = matrix[bottom - (j - top)][top];
            matrix[bottom - (j - top)][top] = temp;
        }
    }
    return matrix;
}

function swapRows(m) {
    for (var  i = 0, k = m.length - 1; i < k; ++i, --k) {
        var x = m[i];
        m[i] = m[k];
        m[k] = x;
    }
    transpose(m);
    console.log("aaaa");
    console.log(m);
    return m;
}

function transpose(m) {
    for (var i = 0; i < m.length; i++) {
        for (var j = i; j < m[0].length; j++) {
            var x = m[i][j];
            m[i][j] = m[j][i];
            m[j][i] = x;
        }
    }
}
swapRows(buildMatrix(4));
// rotateMatrix90Counter(buildMatrix(4))
// rotateMatrix180(buildMatrix(4));
// rotateMatrix2D_90Degree(buildMatrix(4), 4);
