
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
function rotateMatrix2D_90Degree(matrix, k, numRows) {
    // temporary array of size M 
    var temp = new Array(numRows);
          
    // within the size of matrix 
    k = k % numRows; 
      
    for (var i = 0; i < numRows; i++) 
    {     
        // copy first M-k elements  
        // to temporary array 
        for (var t = 0; t < numRows - k; t++) {
            temp[t] = matrix[i][t]; 
        }
        // copy the elements from k  
        // to end to starting 
        for (var j = numRows - k; j < numRows; j++) {
            matrix[i][j - numRows + k] = matrix[i][j]; 
        }
        // copy elements from  
        // temporary array to end 
        for (var j = k; j < numRows; j++) {
            matrix[i][j] = temp[j - k]; 
        }
    } 
    console.log("after rotate matrix with " + k + " cycle");
    console.log(matrix);
    return matrix;
}



if (process.argv[2] == null || process.argv[3] == null) {
    console.log("Please input params");
    return;
}
rotateMatrix2D_90Degree(buildMatrix(process.argv[2]), process.argv[3], process.argv[4]);
