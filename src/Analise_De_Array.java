public class Analise_De_Array {

    public static String verificarOrdemdoArray(int[] array) {
        boolean crescente = true;
        boolean decrescente = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                decrescente = false;
            } else if (array[i] > array[i + 1]) {
                crescente = false;
            }
        }

        if (crescente) {
            return "O vetor informado está em ordem crescente!";
        } else if (decrescente) {
            return "O vetor informado está em ordem decrescente!";
        } else {
            return "O vetor informado está fora de ordem!";
        }
    }

    public static String verificarValoresDoArray(int[] array, int x) {
        int qntMaiorQueX = 0;
        int qntMenorQueX = 0;
        int qntIgualAx = 0;

        for (int value : array) {
            if (value == x) {
                qntIgualAx++;
            } else if (value < x) {
                qntMenorQueX++;
            } else {
                qntMaiorQueX++;
            }
        }

        return qntIgualAx + " Números são iguais a " + x + "\n" +
               qntMaiorQueX + " Números são maiores que " + x + "\n" +
               qntMenorQueX + " Números são menores que " + x;
    }
}
