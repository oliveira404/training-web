let minhaLista: number[] = [1, 2, 3];

function pegaPrimeiroElemento<T>(lista: T[]): T {
  return lista[0];
}

pegaPrimeiroElemento<number>(minhaLista);

pegaPrimeiroElemento<string>(['a','b']);

//nao precisa passar ele é esperto para descobrir sozinho
pegaPrimeiroElemento(minhaLista);
