let minhaVar: any;

type MeuTipo = {
  nome: string;
  idade: number;
}

(<string>minhaVar).toLowerCase();
// or
(minhaVar as MeuTipo).nome;