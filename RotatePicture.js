

function create2DArray(numRows) {
    let array = new Array(numRows); 
    for(let i = 0; i < numRows; i++) {
        array[i] = new Array(numRows); 
    }
    return array; 
}
function buildMatrix(matrixSize) {
    var r_matrix = create2DArray(matrixSize);
    var value = 0;
    for (var i = 0; i < matrixSize ; i++) {
        for (var j = 0 ; j < matrixSize; j++) {
            r_matrix[i][j] = ++value;
        }
    }
    console.log("Matrix after initilize");
    console.log(r_matrix);
    return r_matrix;
}

function rotateMatrix2D_90Degree(matrix, cycle) {
    var count = 0
    while (count < cycle){
        var length = matrix.length -1;
        for (var i = 0 ; i <  length/2; i++) {
            for(var j = i ; j < length - i; j++) {
                var p1 = matrix[i][j];
                //Coordinate 2
                var p2 = matrix[j][length-i];
                //Coordinate 3
                var p3 = matrix[length-i][length-j];
                //Coordinate 4
                var p4 = matrix[length-j][i];
                //Swap values of 4 coordinates
                matrix[j][length-i] = p1; // right top
                matrix[length-i][length-j] = p2; // right bottom
                matrix[length-j][i] = p3; // left bottom
                matrix[i][j] = p4; // left top
            }
        }
        count++;
    }
    console.log("after rotate matrix with " + cycle + " cycle");
    console.log(matrix);
}

//run function rotate matrix With time complexity is O(n^2)
if (process.argv[2] == null ||  process.argv[3] == null) {
    console.log("Please input params");
    return;
}
rotateMatrix2D_90Degree(buildMatrix(process.argv[2]), process.argv[3]);
