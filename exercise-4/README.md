# EXERCISE 4
W przygotowanym przez Ciebie pliku tekstowym w każdym wierszu umieść
po trzy liczby całkowite oddzielone średnikiem. Postać przykładowego
wiersza to: 32;56;10. Liczba wierszy jest dowolna. Należy przygotować
klasę Listy, która posiada w sobie trzy listy elementów typu
całkowitoliczbowego. Konstruktor klasy pobiera do list dane z pliku
tekstowego o nazwie podanej jako argument konstruktora. Pierwsza lista
przechowuje najmniejsze liczby z poszczególnych wierszy. Druga lista
przechowuje drugie co do wielkości liczby z poszczególnych wierszy.
Trzecia lista przechowuje największe liczby z poszczególnych wierszy.
Umawiamy się, że plik z Twoimi danymi nazywamy doskonałym, jeżeli
pierwsza lista ma wszystkie elementy mniejsze od listy drugiej,
natomiast druga lista ma wszystkie elementy mniejsze od listy trzeciej.
Napisz w klasie Listy metody, które rozwiążą następujące problemy:

- Sprawdź czy przygotowany przez Ciebie plik jest plikiem doskonałym?
- Które liczby z listy pierwszej oraz które liczby z listy drugiej
  należałoby usunąć, żeby zaszedł warunek na plik doskonały? Wykonaj
  zestawienie prezentujące te liczby.
- Wyznacz różnicę pomiędzy największym elementem pierwszej listy oraz
  najmniejszym elementem drugiej listy. Ile elementów w trzeciej
  liście dzieli się przez tak wyznaczoną różnicę, o ile nie jest ona
  zerowa?
- Wyznacz tą z trzech list w klasie Listy, która posiada w sobie
  najdłuższy ciąg niemalejący utworzony z jej elementów. Zwróć słownie
  numer wyznaczonej listy jako PIERWSZA, DRUGA lub TRZECIA.
- Posortuj trzy listy malejąco i sprawdź, dla jakiego indeksu
  elementów list różnica pomiędzy elementami trzech list jest
  najmniejsza, a dla jakiego indeksu różnica pomiędzy elementami
  trzech list jest największa.