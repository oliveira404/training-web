const baseUrl = 'https://viacep.com.br/ws/01001000/json';

export const minhaApi = fetch(baseUrl).then(response => response.json());