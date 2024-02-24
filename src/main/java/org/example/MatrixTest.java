package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MatrixTest {
    private Matrix matrix;
    private int N;
    @BeforeEach
    public void setUp(){

         N = 5;
        matrix = new Matrix(N);

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                matrix.set(i,j,i*j);

    }

    @Test
    public void setShouldReturnTheElementInThePositionijIfijAreValidInputs(){
        int value = matrix.get(3,2);
        Assertions.assertEquals(3 * 2, value);
    }
    //this test is not passed
    @Test
    public void setShouldThrowAnExceptionIfIorJAreGreaterThanN(){
         Assertions.assertThrows(IllegalArgumentException.class, ()-> matrix.set(10,2,20));
         Assertions.assertThrows(IllegalArgumentException.class, ()-> matrix.set(2,10,20));
    }


    @Test
    public void getShouldReturnTheValueInThePositionijIfijArevalidInputs(){
         Assertions.assertEquals(2 * 3, matrix.get(2,3));
    }

    //this test is not passed
    @Test
    public void getShouldThrowAnExceptionIfIorJAreGreaterThanN(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> matrix.get(10,2));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> matrix.get(2,10));
    }

    @Test
    public void addShouldThrowAnExceptionIfTheOtherMatrixIsNull(){
        Assertions.assertThrows(NullPointerException.class, ()->matrix.add(null));
    }

    @Test
    public void addShouldThrowAnExceptionIfTheOtherMatrixHasNotTheSameSizeThanTheMainMatrix(){
         Matrix anotherMatrix = new Matrix(10);
         Assertions.assertThrows(IllegalArgumentException.class, ()->matrix.add(anotherMatrix));
    }

    @Test
    public void addShouldAddTheOtherMatrixToTheCurrentMatrix(){
        // create a copy of the main matrix
        Matrix anotherMatrix = new Matrix(N);
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                anotherMatrix.set(i,j,i*j);

        matrix.add(anotherMatrix);
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                Assertions.assertEquals(i* j * 2, matrix.get(i,j));

    }

    @Test
    public void multiplyShouldThrowAnExceptionIfTheOtherMatrixIsNull(){
        Assertions.assertThrows(NullPointerException.class, ()->matrix.multiply(null));
    }

    @Test
    public void multiplyShouldThrowAnExceptionIfTheOtherMatrixHasNotTheSameSizeThanTheMainMatrix(){
        Matrix anotherMatrix = new Matrix(10);
        Assertions.assertThrows(IllegalArgumentException.class, ()->matrix.multiply(anotherMatrix));
    }

    @Test
    public void multiplyShouldMultiplyTheCurrentMatrixWithTheOtherMatrix(){
        // create a copy of the main matrix
        int N = 5;
        Matrix anotherMatrix = new Matrix(N);
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                anotherMatrix.set(i,j,i*j);

        matrix.multiply(anotherMatrix);
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for(int k = 0; k < N;k++) {
                    sum += anotherMatrix.get(i, k) * anotherMatrix.get(k, j);
                }
                Assertions.assertEquals(matrix.get(i,j), sum);
            }
        }

            }

    @Test
    public void TransposeShouldTranposeTheMatrix(){
         Matrix originalMatrix = new Matrix(N);
        for(int i = 0; i < N; i++ )
            for(int j = 0; j < N;j++)
                originalMatrix.set(i,j, matrix.get(i,j));
         matrix.transpose();
         for(int i = 0; i < N; i++ ){
              for(int j = 0; j < N;j++){
                   Assertions.assertEquals(originalMatrix.get(j,i),matrix.get(i,j));
              }
         }
    }

    @Test
    public void toStringShouldReturnStringRepresentationOfTheMatrix(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("[");
            for (int j = 0; j < N; j++) {
                sb.append(matrix.get(i,j));
                if (j < N - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]\n");
        }

        Assertions.assertEquals(sb.toString(), matrix.toString());
    }


    }




