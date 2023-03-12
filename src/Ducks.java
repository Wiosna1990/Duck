import java.util.Scanner;
class Ducks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int duckQuantity = scanner.nextInt(); // liczba kaczuszek
        int rowWidth = scanner.nextInt(); //szerokosc rzędu

        Duck[] duckTab = new Duck[duckQuantity];

        // pobranie danych kaczek
        for (int i = 0; i < duckQuantity; i++) {

            int height = scanner.nextInt();
            int width = scanner.nextInt();

            duckTab[i] = new Duck();
            duckTab[i].height = height;
            duckTab[i].width = width;
            duckTab[i].ratio = (float) height / (float) width;
        }

        // sortowanie wg. najlepszego stosunku wysokosci do szerokosci kaczki
        Duck tmp;
        for (int i = 0; i < duckQuantity-1; i++) {

            for (int j = 0; j < duckQuantity-i-1; j++ ) {
                if (duckTab[j].ratio < duckTab[j+1].ratio) {
                    tmp = duckTab[j];
                    duckTab[j] = duckTab[j+1];
                    duckTab[j+1] = tmp;
                }
            }
        }
        // wypisanie posortowanych kaczek
        for (Duck element : duckTab)
        {
            System.out.println("R=>" + element.ratio + " H->"+ element.height + " W->" + element.width);
        }

        int res = 0;
        int resHeight = 0;
        // wybranie najlepszych kaczek, których suma nie przekracza podanej szerokosci
        for (Duck element : duckTab) {
            if(res + element.width <= rowWidth)
            {
                res += element.width;
                resHeight += element.height;
            }
            else {
                break;
            }
        }

        System.out.println("Result=>" + resHeight);
    }
}

class Duck
{
    int height = 0;
    int width = 0;
    float ratio = 0;
}
