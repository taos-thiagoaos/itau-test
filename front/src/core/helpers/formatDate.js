const date = new Intl.DateTimeFormat('pt-BR', {
  year: 'numeric',
  month: 'long',
  day: '2-digit'
});

export default date.format;
