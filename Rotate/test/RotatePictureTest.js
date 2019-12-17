var assert = require('assert');
var rotateService = require('../RotatePicture');

describe('rotatePicture', function () {
    describe('create array', function () {
        it('should return right size of array', function () {
            var arr = rotateService.create2DArray(3);
            assert.equal(3, arr.length);
        });

        it('should return right size of 0', function () {
            var arr = rotateService.create2DArray(0);
            assert.equal(0, arr);
        });
    });

    describe('init value for array', function () {
        it('should return value at [0][1] position ', function () {
            var arr = rotateService.buildMatrix(3);
            assert.equal(2, arr[0][1]);
        })
        it('should return last value of array', function () {
            var arr = rotateService.buildMatrix(3);
            assert.equal(9, arr[2][2]);
        })
    })

    describe('rotate the matrix 90 degree with k cycle', function () {
        it('should be return right value at position [0,0] after rotate', function () {
            var arr = rotateService.buildMatrix(3);
            arr = rotateService.rotatePicture(arr, 0);
            assert.equal(1, arr[0][0]);
        })
        it('should be return right value at position [0,0] after rotate', function () {
            var arr = rotateService.buildMatrix(3);
            arr = rotateService.rotatePicture(arr, 1);
            assert.equal(7, arr[0][0]);
        })
        it('should be return right value at position [2,2] after rotate', function () {
            var arr = rotateService.buildMatrix(3);
            arr = rotateService.rotatePicture(arr, 1);
            assert.equal(3, arr[2][2]);
        })
    })
    

    describe('rotate the matrix 90 degree with 2 cycle', function () {
        it('should be return right value at position [0,0] after rotate', function () {
            var arr = rotateService.buildMatrix(3);
            arr = rotateService.rotatePicture(arr, 2);
            assert.equal(9, arr[0][0]);
        })
    })

    describe('rotate the matrix 90 counter clockwise', function () {
        it('should be return right value at position [0,0] after rotate', function () {
            var arr = rotateService.buildMatrix(3);
            arr = rotateService.rotatePicture(arr, 3);
            assert.equal(3, arr[0][0]);
        })
    })

    describe('rotate the matrix 90 counter clockwise', function () {
        it('should be return right value at position [0,0] after rotate', function () {
            var arr = rotateService.buildMatrix(3);
            arr = rotateService.rotatePicture(arr, -1);
            assert.equal(1, arr[0][0]);
        })
    })
});