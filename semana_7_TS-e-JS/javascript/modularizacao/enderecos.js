
export let cidade = {
  RIO: "rio"
}

export default function regiao(regiao) {
  var caixaBaixa = regiao.toLowerCase();
  switch(caixaBaixa) {
    case 'algeria':
      return 'Africa';
    case 'brazil':
      return 'South America';
    default: 
    return 'Error!';
  }  
}



